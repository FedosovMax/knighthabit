package com.knighthabit.knighthabit.service;

import com.knighthabit.knighthabit.exeption.HabitNotFoundExeption;
import com.knighthabit.knighthabit.model.Habit;
import com.knighthabit.knighthabit.repository.HabitRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class HabitServiceImpl implements HabitService {

    final HabitRepository habitRepository;

    @Override
    public Habit save(Habit habit) {
        return habitRepository.save(habit);
    }

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

    @Override
    public Habit updateHabit(Habit changedHabit) {
        final Habit habit = this.habitRepository.findById(changedHabit.getId()).
                orElseThrow(HabitNotFoundExeption::new);

        habit.setId(changedHabit.getId());
        habit.setName(changedHabit.getName());
        habit.setDescription(changedHabit.getDescription());
        habit.setScaryness(changedHabit.getScaryness());
        habit.setHardness(changedHabit.getHardness());
        habit.setSkippedDates(changedHabit.getSkippedDates());
        habit.setSuccessFulDates(changedHabit.getSuccessFulDates());
        habit.setStarting_date(changedHabit.getStarting_date());
        habit.setSuccessStream(changedHabit.getSuccessStream());
        return changedHabit;
    }
}