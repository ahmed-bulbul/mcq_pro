package com.bulbul.examportal.repository.exam;

import com.bulbul.examportal.entity.acl.User;
import com.bulbul.examportal.entity.exam.ExamHistory;
import com.bulbul.examportal.entity.exam.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExamHistoryRepository extends JpaRepository<ExamHistory,Long> {
    List<ExamHistory> findByUserAndQuiz(User user, Quiz quiz);

/*    @Query(value = "SELECT count(id) FROM ExamHistory where user = :userId AND quiz=:quizId")
    int countExamHistoryByUserAndQuiz(User userId, Quiz quizId);*/
}
