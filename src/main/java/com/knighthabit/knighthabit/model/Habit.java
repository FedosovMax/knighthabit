package com.knighthabit.knighthabit.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="habit")
@Getter
@Setter
@ToString
public class Habit extends BaseEntity{

    @Column(name = "name")
    private String name;
    @Column(name = "description")
    private String description;
    @Column(name = "hardness")
    private String hardness;
    @Column(name = "scaryness")
    private String scaryness;
    @Column(name = "startingdate")
    private String startingdate;    //instance
    @Column(name = "name")
    private String successfuldates; //list:date
    @Column(name = "skipped_dates")
    private String skippeddates;    //list:date
    @Column(name = "success_stream")
    private int successstream;


}
