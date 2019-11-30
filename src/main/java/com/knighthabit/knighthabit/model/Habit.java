package com.knighthabit.knighthabit.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name="habit")
@Getter
@Setter
@ToString
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
    private Hardness hardness;
    @Column(name = "scaryness")
    private Scaryness scaryness;
    private LocalDate starting_date;
    private String successfuldates;
    @Column(name = "skippeddates")
    private String skippeddates;
    @Column(name = "successstream")
    private int successstream;


}
