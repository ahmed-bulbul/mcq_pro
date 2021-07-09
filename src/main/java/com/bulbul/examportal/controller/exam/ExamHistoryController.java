package com.bulbul.examportal.controller.exam;

import com.bulbul.examportal.entity.exam.ExamHistory;
import com.bulbul.examportal.entity.exam.Question;
import com.bulbul.examportal.service.exam.ExamHistoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/examHistory")
@CrossOrigin(origins = "*", maxAge = 3600)
public class ExamHistoryController {

    private final Logger LOGGER =
            LoggerFactory.getLogger(ExamHistoryController.class);

    @Autowired
    private ExamHistoryService examHistoryService;

    //Add Exam history
    @PostMapping("/")
    public ResponseEntity<ExamHistory> add(@RequestBody ExamHistory examHistory){
        return ResponseEntity.ok(this.examHistoryService.addExamHistory(examHistory));
    }

    //get exam by userId and quiz id
    @GetMapping("/{userId}/{quizId}")
    public List<ExamHistory> getExamHistoryList(@PathVariable("userId") Long userId,@PathVariable("quizId") Long quizId){

        return examHistoryService.getExamHistoryByUserAndQuiz(userId,quizId);
    }

}
