package com.knighthabit.knighthabit.model;

import javafx.scene.control.PopupControlBuilder;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name="habit")
@Getter
@Setter
@Builder
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
    @Enumerated (EnumType.STRING)
    private Hardness hardness;

    @Column(name = "scaryness")
    @Enumerated (EnumType.STRING)
    private Scaryness scaryness;

    private LocalDate starting_date;

    private String successFulDates;

    @Column(name = "skipped_dates")
   //private List<LocalDate> skippedDates;
    private String skippedDates;

    @Column(name = "success_stream")
    private int successStream;



}



