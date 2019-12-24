package com.knighthabit.knighthabit.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.knighthabit.knighthabit.factories.HabitFactory;
import com.knighthabit.knighthabit.model.Habit;
import com.knighthabit.knighthabit.repository.HabitRepository;
import com.knighthabit.knighthabit.service.HabitService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
class HabitRestControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private HabitRepository habitRepository;

    @Autowired
    private HabitService habitService;

    @Autowired
    private ObjectMapper objectMapper;


    @Test
    void getHabit() throws Exception {
        Habit savedHabit = habitRepository.save(HabitFactory.firstHabit());

        mockMvc.perform(
                get("/api/habits/" + savedHabit.getId())
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

        assertThat(habitRepository.findById(savedHabit.getId()).get().getId())
                .isEqualTo(savedHabit.getId());
    }

    @Test
    void getAllHabits() throws Exception {
        Habit habitFirst = HabitFactory.firstHabit();
        habitRepository.save(habitFirst);

        mockMvc.perform(
                get("/api/habits/")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

        assertThat(habitRepository.count()).isEqualTo(1);
    }

    @Test
    void deleteHabit() throws Exception {
        Habit habitFirst = HabitFactory.firstHabit();
        habitRepository.save(habitFirst);

        mockMvc.perform(
                delete("/api/habits/" + habitFirst.getId())
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isNoContent());

        assertThat(habitRepository.count()).isEqualTo(0);
    }

    @Test
    void updateHabit() throws Exception {
        Habit habitFirst = HabitFactory.firstHabit();
        habitRepository.save(habitFirst);

        when(habitService.updateHabit(eq(HabitFactory.updateHabit())))
                .thenReturn(HabitFactory.updateHabit());

        mockMvc.perform(
                put("/api/habits/edit")
                        .content(objectMapper.writeValueAsBytes(habitFirst))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").exists());
    }

    @Test
    void addHabit() throws Exception {

        mockMvc.perform(
                post("/api/habits/add")
                        .content(objectMapper.writeValueAsString(HabitFactory.firstHabit()))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").exists());
    }
}