package com.bulbul.examportal.repository.exam;

import com.bulbul.examportal.entity.exam.Question;
import com.bulbul.examportal.entity.exam.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface QuestionRepository extends JpaRepository<Question,Long> {
    Set<Question> findByQuiz(Quiz quiz);

}
