package com.knighthabit.knighthabit.factories;

import com.knighthabit.knighthabit.model.Habit;
import com.knighthabit.knighthabit.model.Hardness;
import com.knighthabit.knighthabit.model.Scaryness;

import javax.persistence.Column;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HabitFactory {
    public static final Long HABIT_ID = 1L;
    public static final String HABIT_NAME = "hard working";
    public static final String HABIT_DESCRIPTION = "hard working";
    public static final Hardness HABIT_HARDNESS = Hardness.fromText("EXTRAORDINARY");
    public static final Scaryness HABIT_SCARYNESS = Scaryness.fromText("NOT_SCARY");
    public static final String HABIT_STARTING_DATE= "hard working";
    public static final String HABIT_SUCCESSFUL_DATETES= "hard working";
    public static final String HABIT_SKIPPED_DATETES= "hard working";
    public static final String HABIT_SUCCESS_STREAM= "hard working";

    private HabitFactory() {
    }

    public static Habit firstHabit() {
        return Habit
                .builder()
                .id(HABIT_ID)
                .name(HABIT_NAME)
                .description(HABIT_DESCRIPTION)
                .hardness(HABIT_HARDNESS)
                .scaryness(HABIT_SCARYNESS)
                .build();
    }

    public static Habit updateHabit() {
        return Habit
                .builder()
                .id(HABIT_ID)
                .name(HABIT_NAME)
                .description(HABIT_DESCRIPTION)
                .hardness(HABIT_HARDNESS)
                .scaryness(HABIT_SCARYNESS)
                .build();
    }
}


