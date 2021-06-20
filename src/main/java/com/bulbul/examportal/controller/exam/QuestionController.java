package com.bulbul.examportal.controller.exam;

import com.bulbul.examportal.entity.exam.Question;
import com.bulbul.examportal.entity.exam.Quiz;
import com.bulbul.examportal.service.exam.QuestionService;
import com.bulbul.examportal.service.exam.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/question")
@CrossOrigin("*")
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    @Autowired
    private QuizService quizService;

    //add question
    @PostMapping("/")
    public ResponseEntity<Question> add(@RequestBody Question question){
        return ResponseEntity.ok(this.questionService.addQuestion(question));
    }

    //update question
    @PutMapping("/")
    public ResponseEntity<Question> update(@RequestBody Question  question){
        return ResponseEntity.ok(this.questionService.updateQuestion(question));
    }

    //get all question of any quid
    /**
     *
     * here find quiz id . qid means quiz id
     * getting all question by quiz id
     * the commented part is also a way to get List of question collection by quiz id
     *
     **/
    @GetMapping("/quiz/{qid}")
    public ResponseEntity<?> getQuestionOfQuiz(@PathVariable("qid") Long qid){
       /* Quiz quiz = new Quiz();
        quiz.setQId(qid);
        Set<Question> questionOfQuiz = this.questionService.getQuestionsOfQuiz(quiz);
        return ResponseEntity.ok(questionOfQuiz);*/

        Quiz quiz = this.quizService.getQuiz(qid);
        Set<Question> questions= quiz.getQuestions();
        List list = new ArrayList(questions);
        if (list.size()>Integer.parseInt(quiz.getNumberOfQuestions())){
            list=list.subList(0,Integer.parseInt(quiz.getNumberOfQuestions()+1));
        }
        Collections.shuffle(list);
        return ResponseEntity.ok(list);
    }

    /** for getting all question for admin*/
    @GetMapping("/quiz/all/{qid}")
    public ResponseEntity<?> getQuestionOfAdmin(@PathVariable("qid") Long qid){

        Quiz quiz = new Quiz();
        quiz.setqId(qid);
        Set<Question> questionOfQuiz = this.questionService.getQuestionsOfQuiz(quiz);
        return ResponseEntity.ok(questionOfQuiz);
    }


    //get single question
    @GetMapping("/{quesId}")
    public Question get(@PathVariable("quesId") Long quesId){
        return this.questionService.getQuestion(quesId);
    }


    //delete question
    @DeleteMapping("/{quesId}")
    public void delete(@PathVariable("quesId") Long quesId){
        this.questionService.deleteQuestion(quesId);
    }


}
