package com.bulbul.examportal.schedular;


import com.bulbul.examportal.entity.exam.Quiz;
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
            LoggerFactory.getLogger(AttendanceScheduler.class);


    @Scheduled(fixedRate = 10000)
    public void startQuiz(){
        LocalDate localDate=LocalDate.now();
        List<Quiz> quizzes =quizRepository.findAll();

        List<Quiz> quizList = new ArrayList<>();
        for (Quiz quiz:quizzes){


            int diff = CustomDate.differenceTwoDate(localDate,quiz.getStartDate());

            if (diff==0){
                Quiz quiz1 = quizRepository.findById(quiz.getqId()).get();
                if (quiz1.isActive()==false){
                    quiz1.setActive(true);
                    quizList.add(quiz1);
                    LOGGER.info("Quiz Publisher Scheduler:: Quiz Activated ");
                }


            }else if(diff>=1) {

                Quiz quiz1 = quizRepository.findById(quiz.getqId()).get();
                if (quiz1.isArchive()==false){
                    quiz1.setArchive(true);
                    quizList.add(quiz1);
                    LOGGER.info("Quiz Publisher Scheduler:: Quiz Archived ");
                }

            }
            quizRepository.saveAll(quizList);
        }



    }


}
