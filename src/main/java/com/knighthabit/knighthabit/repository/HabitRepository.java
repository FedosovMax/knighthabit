package com.knighthabit.knighthabit.repository;

import com.knighthabit.knighthabit.model.Habit;
import org.springframework.data.jpa.repository.JpaRepository;

public  interface HabitRepository extends JpaRepository<Habit, Long> {

}
