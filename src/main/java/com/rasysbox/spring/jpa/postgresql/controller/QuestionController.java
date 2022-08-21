package com.rasysbox.spring.jpa.postgresql.controller;

import com.rasysbox.spring.jpa.postgresql.dto.QuestionDTO;
import com.rasysbox.spring.jpa.postgresql.entity.Question;
import com.rasysbox.spring.jpa.postgresql.service.IQuestionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/v1/question")
@CrossOrigin(origins = "*")
@Slf4j
public class QuestionController {
    @Autowired
    private IQuestionService questionService;

    @GetMapping
    public List<Question> getAll(
            @RequestParam(value = "id", required = false)Long id
    ){
        if( id != null) {
            List<Question> response = new ArrayList<>();
            response.add(questionService.findById(id));
            return response;
        }
        return questionService.findAll();
    }

    @PostMapping
    public Long createQuestion(@RequestBody QuestionDTO questionDTO){
        return questionService.create(questionDTO);
    }

    @PutMapping
    public  Long updateQuestion(@RequestBody QuestionDTO questionDTO){
        return  questionService.update(questionDTO);
    }
}
