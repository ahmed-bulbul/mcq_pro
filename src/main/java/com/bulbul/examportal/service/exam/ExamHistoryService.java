package com.bulbul.examportal.service.exam;

import com.bulbul.examportal.entity.acl.User;
import com.bulbul.examportal.entity.exam.ExamHistory;
import com.bulbul.examportal.entity.exam.Question;

import java.util.List;

public interface ExamHistoryService {
    ExamHistory addExamHistory(ExamHistory examHistory);

    List<ExamHistory> getExamHistoryByUserAndQuiz(Long userId, Long quizId);

}
