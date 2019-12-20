package com.knighthabit.knighthabit.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "habit")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Habit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "hardness")
    @Enumerated(EnumType.STRING)
    private Hardness hardness;

    @Column(name = "scaryness")
    @Enumerated(EnumType.STRING)
    private Scaryness scaryness;

    private LocalDate starting_date;

    private String successFulDates;

    @Column(name = "skipped_dates")
    //private List<LocalDate> skippedDates;
    private String skippedDates;

    @Column(name = "success_stream")
    private int successStream;


}



