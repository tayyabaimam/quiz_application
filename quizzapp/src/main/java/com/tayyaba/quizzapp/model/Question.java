package com.tayyaba.quizzapp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

//data creates all getters and setters thanks to lombok
//entity maps table with class
@Data
@Entity
public class Question {

    //this class represents the table question in db, this is called orm(object relational mapping)
    //each variable represents a column name and each object a row

    //id is primarykey and its values are generated uniquely
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String category;
    private String difficulty_level;
    private String option1;
    private String option2;
    private String option3;
    private String option4;
    private String question_title;
    private String right_answer;

}
