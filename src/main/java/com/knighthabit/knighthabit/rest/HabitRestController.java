package com.knighthabit.knighthabit.rest;

import com.knighthabit.knighthabit.model.Habit;
import com.knighthabit.knighthabit.service.HabitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/habits/")
public class HabitRestController {

    @Autowired
    private HabitService habitService;
    @RequestMapping(value = "{id}",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity <Habit> getHabit(@PathVariable("id") Long habitId){
        if (habitId == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        Habit habit = this.habitService.getHabit(habitId);

        if (habit == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(habit,HttpStatus.OK);

    }

    @RequestMapping(value = "{id}",method = RequestMethod.DELETE,produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity <Habit> deleteHabit(Long habitId){
        Habit habit = this.habitService.getHabit(habitId);
        if (habit == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        this.habitService.getHabit(habitId);
        return new ResponseEntity<>(habit,HttpStatus.NO_CONTENT);

    }

    @RequestMapping(value = "",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity <List<Habit>>getAllHabits(){
        List<Habit> habits = this.habitService.getAllHabits();

        if (habits.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(habits,HttpStatus.OK);
    }

}
