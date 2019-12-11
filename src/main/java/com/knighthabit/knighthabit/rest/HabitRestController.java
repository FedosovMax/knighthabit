package com.knighthabit.knighthabit.rest;

import com.knighthabit.knighthabit.model.Habit;
import com.knighthabit.knighthabit.service.HabitService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotBlank;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/habits/")
public class HabitRestController {

    final HabitService habitService;
    @GetMapping(value = "/{id}")
    public ResponseEntity <Habit> getHabit(@NotBlank Long habitId){

        Habit habit = this.habitService.getHabitById(habitId);
        return new ResponseEntity<>(habit,HttpStatus.OK);

    }

    @DeleteMapping(value = "{Id}")
    public ResponseEntity <Habit> deleteHabit(@NotBlank Long habitId){
        this.habitService.deleteHabit(habitId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }

    @GetMapping()
    public ResponseEntity <List<Habit>>getAllHabits(){
        List<Habit> habits = this.habitService.getAllHabits();
        return new ResponseEntity<>(habits,HttpStatus.OK);
    }

}
