package com.bulbul.examportal.repository.exam;

import com.bulbul.examportal.entity.exam.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuizRepository extends JpaRepository<Quiz,Long> {
}
