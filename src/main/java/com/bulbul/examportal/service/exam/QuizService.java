package com.bulbul.examportal.service.exam;

import com.bulbul.examportal.entity.exam.Quiz;
import com.bulbul.examportal.entity.exam.SubCategory;

import java.util.List;
import java.util.Set;

public interface QuizService {

    public Quiz addQuiz(Quiz quiz);

    public Quiz updateQuiz(Quiz quiz);

    public Set<Quiz> getQuizzes();

    public Quiz getQuiz(Long quizId);

    public void deleteQuiz(Long quizId);

    public List<Quiz> getActiveQuizzes();

    List<Quiz> getQuizzesOfSubCategory(SubCategory subCategory);

    public List<Quiz> getActiveQuizzesOfSubCategory(SubCategory subCategory);
}
