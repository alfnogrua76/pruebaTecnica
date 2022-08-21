package com.rasysbox.spring.jpa.postgresql.dto;

import lombok.Data;

@Data
public class QuestionDTO {
    private Long id;
    private String question1;
    private String question2;
    private String date_test;
    private Long note;
}
