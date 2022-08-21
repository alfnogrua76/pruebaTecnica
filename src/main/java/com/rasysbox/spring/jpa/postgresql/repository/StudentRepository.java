package com.rasysbox.spring.jpa.postgresql.repository;

import com.rasysbox.spring.jpa.postgresql.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("studentRepository")
public interface StudentRepository extends JpaRepository<Student, Long> {
}
