package com.rasysbox.spring.jpa.postgresql.model;

import com.rasysbox.spring.jpa.postgresql.entity.Question;
import com.rasysbox.spring.jpa.postgresql.entity.Student;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Optional;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentModel {

    private Long id;
    private String names;
    private String age;
    private String city;
    private String time_zone;
    private Question question;

    public StudentModel(Student student){
        this.id = student.getId();
        this.names = student.getNames();
        this.age = student.getAge();
        this.city = student.getCity();
        this.time_zone = student.getTime_zone();
        this.question = student.getQuestion();
    }


}
