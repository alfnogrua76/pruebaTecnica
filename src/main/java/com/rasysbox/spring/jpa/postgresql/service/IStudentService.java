package com.rasysbox.spring.jpa.postgresql.service;

import com.rasysbox.spring.jpa.postgresql.dto.StudentDTO;
import com.rasysbox.spring.jpa.postgresql.entity.Student;
import com.rasysbox.spring.jpa.postgresql.model.StudentModel;

import java.util.List;

public interface IStudentService {
    List<Student> findAll();

    Student findById(long id);

    Long create(StudentDTO studentDTO);


    Long update(StudentDTO studentDTO);
}
