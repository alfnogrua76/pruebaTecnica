package com.rasysbox.spring.jpa.postgresql.converter;

import com.rasysbox.spring.jpa.postgresql.entity.Student;
import com.rasysbox.spring.jpa.postgresql.model.StudentModel;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component("studentConverter")
public class StudentConverter {
    public List<StudentModel> listConverter(List<Student> list){
        List<StudentModel> listModels = new ArrayList<>();
        list.forEach(clien -> listModels.add(new StudentModel(clien)));
        return null;
    }
}
