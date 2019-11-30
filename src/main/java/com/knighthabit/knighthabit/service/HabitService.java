package com.knighthabit.knighthabit.service;

import com.knighthabit.knighthabit.model.Habit;
import java.util.List;

public interface HabitService {

    Habit getHabitById(Long id);
    void deleteHabit(Long id);
    List<Habit> getAllHabits();
}
