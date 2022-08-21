package com.rasysbox.spring.jpa.postgresql.dto;

import com.rasysbox.spring.jpa.postgresql.entity.Question;
import lombok.Data;

@Data
public class StudentDTO {
    private Long id;
    private String names;
    private String age;
    private String city;
    private String time_zone;
    private Question question;
}
