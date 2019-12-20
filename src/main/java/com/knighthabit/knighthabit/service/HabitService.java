package com.knighthabit.knighthabit.service;

import com.knighthabit.knighthabit.model.Habit;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface HabitService {

    Habit getHabitById(Long id);

    void deleteHabit(Long id);

    List<Habit> getAllHabits();

    Habit updateHabit(Habit changedHabit);

    Habit save(Habit habit);


}
