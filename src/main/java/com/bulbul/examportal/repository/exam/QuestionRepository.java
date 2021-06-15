package com.bulbul.examportal.repository.exam;

import com.bulbul.examportal.entity.exam.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<Question,Long> {
}
