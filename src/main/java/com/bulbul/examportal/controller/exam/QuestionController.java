package com.bulbul.examportal.controller.exam;

import com.bulbul.examportal.entity.exam.Question;
import com.bulbul.examportal.entity.exam.Quiz;
import com.bulbul.examportal.service.exam.QuestionService;
import com.bulbul.examportal.service.exam.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

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
        Quiz quiz = new Quiz();
        quiz.setqId(qid);
        Set<Question> questionOfQuiz = this.questionService.getQuestionsOfQuiz(quiz);
        return ResponseEntity.ok(questionOfQuiz);

/*        Quiz quiz = this.quizService.getQuiz(qid);
        Set<Question> questions= quiz.getQuestions();
        List list = new ArrayList(questions);
        if (list.size()>Integer.parseInt(quiz.getNumberOfQuestions())){
            list=list.subList(0,Integer.parseInt(quiz.getNumberOfQuestions()+1));
        }
        Collections.shuffle(list);
        return ResponseEntity.ok(list);*/
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

    //eval quiz
/*    @PostMapping("/eval-quiz")
    public ResponseEntity<?> evalQuiz(@RequestBody List<Question> questions){

        System.out.println(questions);
        int marksGot=0;
        int correctAnswer=0;
        int attempted=0;
        for(Question q:questions){
            //single questions
            Question question=this.questionService.get(q.getQuesId());
            if (question.getAnswer().trim().equals(q.getGivenAnswer().trim())){
                //correct
                correctAnswer++;
                double marksSingle=Double.parseDouble(questions.get(0).getQuiz().getMaxMarks())/questions.size();
                marksGot+=marksSingle;

            }

            if (q.getGivenAnswer()!=null || !q.getGivenAnswer().trim().equals("") ){
                attempted++;
            }

        }
        Map<String,Object> map=Map.of("marksGot",marksGot,"correctAnswers",correctAnswer,"attempted",attempted);
        return ResponseEntity.ok(map);
    }*/


}
