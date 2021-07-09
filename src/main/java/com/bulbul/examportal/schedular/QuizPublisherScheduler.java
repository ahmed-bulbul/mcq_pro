package com.bulbul.examportal.schedular;


import com.bulbul.examportal.entity.exam.Quiz;
import com.bulbul.examportal.error.NotFoundException;
import com.bulbul.examportal.repository.exam.QuizRepository;
import com.bulbul.examportal.utils.CustomDate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@Component
public class QuizPublisherScheduler {

    @Autowired
    private QuizRepository quizRepository;

    private final Logger LOGGER =
            LoggerFactory.getLogger(QuizPublisherScheduler.class);


    @Scheduled(fixedRate = 60000)
    public void startQuiz() throws NotFoundException {
        List<Quiz> quizzes =quizRepository.findAll();
        if (quizzes!=null) {
            LocalDate localDate = LocalDate.now();
            List<Quiz> quizList = new ArrayList<>();
            for (Quiz quiz : quizzes) {

                int diff = CustomDate.differenceTwoDate(localDate, quiz.getStartDate());

                if (diff == 0) {
                    Quiz quiz1 = quizRepository.findById(quiz.getqId()).get();
                    if (quiz1.isActive() == false) {
                        quiz1.setActive(true);
                        quizList.add(quiz1);
                        LOGGER.info("Quiz Publisher Scheduler:: Quiz Activated ");
                    }

                } else if (diff >= 1) {
                    Quiz quiz1 = quizRepository.findById(quiz.getqId()).get();
                    if (quiz1.isArchive() == false) {
                        quiz1.setArchive(true);
                        quizList.add(quiz1);
                        LOGGER.info("Quiz Publisher Scheduler:: Quiz Archived ");
                    }
                }
                quizRepository.saveAll(quizList);
            }
        }else {
            throw new NotFoundException("Quiz Not Found");
        }
    }


}
