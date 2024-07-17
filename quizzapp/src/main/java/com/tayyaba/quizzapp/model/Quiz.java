package com.tayyaba.quizzapp.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Quiz {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;

    //you have to include mapping here too
    @ManyToMany
    private List<Question> questions;
}
