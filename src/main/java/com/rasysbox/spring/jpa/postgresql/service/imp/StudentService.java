package com.rasysbox.spring.jpa.postgresql.service.imp;

import com.rasysbox.spring.jpa.postgresql.converter.StudentConverter;
import com.rasysbox.spring.jpa.postgresql.dto.StudentDTO;
import com.rasysbox.spring.jpa.postgresql.entity.Student;
import com.rasysbox.spring.jpa.postgresql.model.StudentModel;
import com.rasysbox.spring.jpa.postgresql.repository.StudentRepository;
import com.rasysbox.spring.jpa.postgresql.service.IStudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("studentService")
@Slf4j
public class StudentService implements IStudentService {

    @Autowired
    @Qualifier("studentConverter")
    private StudentConverter studentConverter;

    @Autowired
    @Qualifier("studentRepository")
    private StudentRepository studentRepository;

    @Override
    public List<Student> findAll(){
        List<Student> stu = this.studentRepository.findAll();
        return stu;
    }

    @Override
    public Student findById(long id){
        Optional<Student> std = this.studentRepository.findById(id);
        if(std.isEmpty()){
            log.error("No hay datos de consulta");
        }

    return std.get();
    }

    @Override
    public Long create(StudentDTO studentDTO){
        Student stu = fillStudent(new Student(), studentDTO);
        stu = studentRepository.save(stu);
        return stu.getId();
    }

    @Override
    public Long update(StudentDTO studentDTO){
        Student stu = studentRepository.getById(studentDTO.getId());
        stu = studentRepository.save(fillStudent(stu, studentDTO));
        return stu.getId();
    }

    public Student fillStudent(Student student, StudentDTO studentDTO){
        student.setId(studentDTO.getId());
        student.setNames(studentDTO.getNames());
        student.setTime_zone(studentDTO.getTime_zone());
        student.setAge(studentDTO.getAge());
        student.setCity(studentDTO.getCity());
        student.setQuestion(studentDTO.getQuestion());
        return student;
    }
}
