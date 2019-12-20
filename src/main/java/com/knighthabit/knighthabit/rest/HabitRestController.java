package com.knighthabit.knighthabit.rest;

import com.knighthabit.knighthabit.model.Habit;
import com.knighthabit.knighthabit.service.HabitService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotBlank;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/habits")
public class HabitRestController {

    final HabitService habitService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Habit> getHabit(@NotBlank @PathVariable Long id) {

        Habit habit = this.habitService.getHabitById(id);
        return new ResponseEntity<>(habit, HttpStatus.OK);
    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity<Habit> deleteHabit(@NotBlank @PathVariable Long id) {
        this.habitService.deleteHabit(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping()
    public ResponseEntity<List<Habit>> getAllHabits() {
        List<Habit> habits = this.habitService.getAllHabits();
        return new ResponseEntity<>(habits, HttpStatus.OK);
    }

    @PostMapping(value = "/add")
    public ResponseEntity<Habit> addHabit(@RequestBody Habit habit) {
        Habit responsehabit = this.habitService.save(habit);
        return new ResponseEntity<>(habit, HttpStatus.CREATED);
    }

    @PutMapping(value = "/edit")
    public ResponseEntity<Habit> editHabit(@RequestBody Habit habit) {

        return new ResponseEntity<>(this.habitService.updateHabit(habit), HttpStatus.OK);

    }

}
