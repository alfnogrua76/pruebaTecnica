package com.rasysbox.spring.jpa.postgresql.service;

import com.rasysbox.spring.jpa.postgresql.dto.QuestionDTO;
import com.rasysbox.spring.jpa.postgresql.entity.Question;

import java.util.List;

public interface IQuestionService {
    List<Question> findAll();

    Question findById(long id);

    Long create(QuestionDTO questionDTO);

    Long update(QuestionDTO questionDTO);
}
