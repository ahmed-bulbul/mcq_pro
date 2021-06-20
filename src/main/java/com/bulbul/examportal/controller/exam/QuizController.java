package com.bulbul.examportal.controller.exam;


import com.bulbul.examportal.entity.exam.Quiz;
import com.bulbul.examportal.entity.exam.SubCategory;
import com.bulbul.examportal.service.exam.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/quiz")
@CrossOrigin("*")
public class QuizController {

    @Autowired
    QuizService quizService;

    /** Add Quiz */
    @PostMapping("/")
    public ResponseEntity<Quiz> add(@RequestBody Quiz quiz){
        return ResponseEntity.ok(this.quizService.addQuiz(quiz));
    }

    //update quiz
    @PutMapping("/")
    public ResponseEntity<Quiz> update(@RequestBody Quiz quiz){
        return ResponseEntity.ok(this.quizService.updateQuiz(quiz));
    }

    //get quizzes
    @GetMapping("/")
    public ResponseEntity<?> quizzes(){
        return ResponseEntity.ok(this.quizService.getQuizzes());
    }

    //get quiz
    @GetMapping("/{qid}")
    public Quiz quiz(@PathVariable("qid") Long qid){
        return this.quizService.getQuiz(qid);
    }

    //delete quiz
    @DeleteMapping("/{qid}")
    public void delete(@PathVariable("qid") Long qid){
        this.quizService.deleteQuiz(qid);
    }

    @GetMapping("/subCategory/{sid}")
    public List<Quiz> getQuizzesOfSubCategory(@PathVariable("sid") Long sid){
        SubCategory subCategory = new SubCategory();
        subCategory.setSid(sid);
        System.out.println("Pass"+subCategory);
        return this.quizService.getQuizzesOfSubCategory(subCategory);
    }

    //get Active quizzes
    @GetMapping("/active")
    public List<Quiz> getActiveQuizzes(){
        return this.quizService.getActiveQuizzes();
    }

    //get Active quizzes of category
    @GetMapping("/subCategory/active/{sid}")
    public List<Quiz> getActiveQuizzesOfSubCategory(@PathVariable("sid") Long sid){

        SubCategory subCategory = new SubCategory();
        subCategory.setSid(sid);
        return this.quizService.getActiveQuizzesOfSubCategory(subCategory);
    }

}
