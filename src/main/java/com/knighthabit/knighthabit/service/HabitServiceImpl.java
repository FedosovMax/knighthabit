package com.knighthabit.knighthabit.service;

import com.knighthabit.knighthabit.exeption.HabitNotFoundExeption;
import com.knighthabit.knighthabit.model.Habit;
import com.knighthabit.knighthabit.repository.HabitRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class HabitServiceImpl implements HabitService{

    final HabitRepository habitRepository;

    @Override
    public Habit getHabitById(Long id) {
        return habitRepository.findById(id).orElseThrow(HabitNotFoundExeption::new);
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
