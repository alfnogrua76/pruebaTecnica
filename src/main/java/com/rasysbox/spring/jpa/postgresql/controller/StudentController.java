package com.rasysbox.spring.jpa.postgresql.controller;

import com.rasysbox.spring.jpa.postgresql.dto.StudentDTO;
import com.rasysbox.spring.jpa.postgresql.entity.Student;
import com.rasysbox.spring.jpa.postgresql.service.IStudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/v1/student")
@CrossOrigin(origins = "*")
@Slf4j
public class StudentController {

    @Autowired
    private IStudentService studentService;

    @GetMapping
    public List<Student> getAll(
            @RequestParam(value = "id", required = false)Long id
    ){
        if( id != null) {
            List<Student> response = new ArrayList<>();
            response.add(studentService.findById(id));
            return response;
        }
        return studentService.findAll();

    }


    @PostMapping
    public Long createStudent(@RequestBody StudentDTO studentDTO){
        return studentService.create(studentDTO);
    }

    @PutMapping
    public  Long updateStudent(@RequestBody StudentDTO studentDTO){
        return  studentService.update(studentDTO);
    }
}
