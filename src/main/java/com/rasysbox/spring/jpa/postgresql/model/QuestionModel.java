package com.rasysbox.spring.jpa.postgresql.model;

import com.rasysbox.spring.jpa.postgresql.entity.Question;
import lombok.Data;


@Data
public class QuestionModel {

    private Long id;
    private String question1;
    private String question2;
    private String date_test;
    private Long note;

    public QuestionModel(Question question){
        this.id = question.getId();
        this.question1 = question.getQuestion1();
        this.question2 = question.getQuestion2();
        this.date_test = question.getDate_test();
        this.note = question.getNote();
    }

}
