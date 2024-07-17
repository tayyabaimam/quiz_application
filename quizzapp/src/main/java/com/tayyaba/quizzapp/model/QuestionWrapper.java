package com.tayyaba.quizzapp.model;

import lombok.Data;

@Data
public class QuestionWrapper {

    private Integer id;
    private String category;
    private String option1;
    private String option2;
    private String option3;
    private String option4;

    public QuestionWrapper(String category, Integer id, String option1, String option2, String option3, String option4) {
        this.category = category;
        this.id = id;
        this.option1 = option1;
        this.option2 = option2;
        this.option3 = option3;
        this.option4 = option4;
    }
}
