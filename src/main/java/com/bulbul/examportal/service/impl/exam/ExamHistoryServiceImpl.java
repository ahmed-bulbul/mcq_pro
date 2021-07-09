package com.bulbul.examportal.service.impl.exam;


import com.bulbul.examportal.entity.acl.User;
import com.bulbul.examportal.entity.exam.ExamHistory;
import com.bulbul.examportal.entity.exam.Question;
import com.bulbul.examportal.entity.exam.Quiz;
import com.bulbul.examportal.repository.acl.UserRepository;
import com.bulbul.examportal.repository.exam.ExamHistoryRepository;
import com.bulbul.examportal.repository.exam.QuizRepository;
import com.bulbul.examportal.service.exam.ExamHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExamHistoryServiceImpl implements ExamHistoryService {

    @Autowired
    private ExamHistoryRepository examHistoryRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private QuizRepository quizRepository;

    @Override
    public ExamHistory addExamHistory(ExamHistory examHistory) {
        return examHistoryRepository.save(examHistory);
    }

    @Override
    public List<ExamHistory> getExamHistoryByUserAndQuiz(Long userId, Long quizId) {
        User user=userRepository.findById(userId).get();
        Quiz quiz = quizRepository.findById(quizId).get();
        return examHistoryRepository.findByUserAndQuiz(user,quiz);
    }


}
