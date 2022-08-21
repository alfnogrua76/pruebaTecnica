package com.rasysbox.spring.jpa.postgresql.repository;

import com.rasysbox.spring.jpa.postgresql.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("questionRepository")
public interface QuestionRepository extends JpaRepository<Question, Long> {
}
