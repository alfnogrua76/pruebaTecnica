package com.rasysbox.spring.jpa.postgresql.converter;

import com.rasysbox.spring.jpa.postgresql.entity.Question;
import com.rasysbox.spring.jpa.postgresql.model.QuestionModel;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component("questionConverter")
public class QuestionConverter {
    public List<QuestionModel> listConverter(List<Question> list){
        List<QuestionModel> listModels = new ArrayList<>();
        list.forEach(quest -> listModels.add(new QuestionModel(quest)));
        return null;
    }
}
