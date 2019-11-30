package com.knighthabit.knighthabit.service;

import com.knighthabit.knighthabit.model.Habit;
import com.knighthabit.knighthabit.repository.HabitRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class HabitServiceImpl implements HabitService{

    final HabitRepository habitRepository;

    @Override
    public Habit getHabitById(Long id) {
        return habitRepository.getOne(id);
    }

    @Override
    public void deleteHabit(Long id) {
        habitRepository.deleteById(id);
    }

    @Override
    public List<Habit> getAllHabits() {
        return habitRepository.findAll();
    }
}
