package com.rasysbox.spring.jpa.postgresql.service.imp;

import com.rasysbox.spring.jpa.postgresql.converter.QuestionConverter;
import com.rasysbox.spring.jpa.postgresql.dto.QuestionDTO;
import com.rasysbox.spring.jpa.postgresql.entity.Question;
import com.rasysbox.spring.jpa.postgresql.entity.Student;
import com.rasysbox.spring.jpa.postgresql.repository.QuestionRepository;
import com.rasysbox.spring.jpa.postgresql.repository.StudentRepository;
import com.rasysbox.spring.jpa.postgresql.service.IQuestionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("questionService")
@Slf4j
public class QuestionService implements IQuestionService{

    @Autowired
    @Qualifier("questionConverter")
    private QuestionConverter questionConverter;

    @Autowired
    @Qualifier("questionRepository")
    private QuestionRepository questionRepository;

    @Autowired
    @Qualifier("studentRepository")
    private StudentRepository studentRepository;

    @Autowired
    @Qualifier("studentService")
    private StudentService studentService;

    @Override
    public List<Question> findAll(){
        List<Question> ques = this.questionRepository.findAll();
        return ques;
    }

    @Override
    public Question findById(long id){
        Optional<Question> qst = this.questionRepository.findById(id);
        if(qst.isEmpty()){
            log.error("No hay datos de consulta");
        }
        return qst.get();
    }

    @Override
    public Long create(QuestionDTO questionDTO){
        Student estudiante = studentService.findById(questionDTO.getId());
        if(estudiante.getId() != null) {
            Question qst = fillQuestion(new Question(), questionDTO);
            qst = questionRepository.save(qst);
            //Student student = this.studentService.findById(questionDTO.getId());
            //student.setQuestion(questionDTO.getId());
            return qst.getId();
        }
        log.error("No se pudo crear");
        return null;
    }

    @Override
    public Long update(QuestionDTO questionDTO){
        Question qst = questionRepository.getById(questionDTO.getId());
        qst = questionRepository.save(fillQuestion(qst, questionDTO));
        return qst.getId();
    }
    public Question fillQuestion(Question question, QuestionDTO questionDTO){
        question.setId(questionDTO.getId());
        question.setQuestion1(questionDTO.getQuestion1());
        question.setQuestion2(questionDTO.getQuestion2());
        question.setDate_test(questionDTO.getDate_test());
        int note1 = 0;
        int note2 = 0;
        if(questionDTO.getQuestion1().equals("A")){
            note1 = 50;
        }
        if(questionDTO.getQuestion2().equals("D")){
            note2 = 50;
        }
        question.setNote((long) (note1 + note2));
        return question;
    }
}
