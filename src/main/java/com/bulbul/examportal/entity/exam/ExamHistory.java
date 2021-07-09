package com.bulbul.examportal.entity.exam;

import com.bulbul.examportal.entity.acl.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
//@Data
//@AllArgsConstructor
//@NoArgsConstructor
public class ExamHistory {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long examHistoryId;

    private String givenAnswer;
    private String correctAnswer;

    @CreationTimestamp
    @Column(name = "created_at",updatable = false)
    private LocalDate createDate;


    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updateDateTime;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn (name = "question_id")
    private Question question;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn (name = "quiz_id")
    private Quiz quiz;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn (name = "user_id")
    private User user;



    public ExamHistory() {
    }

    public ExamHistory(Long examHistoryId, String givenAnswer, String correctAnswer, LocalDate createDate, LocalDateTime updateDateTime, Question question, Quiz quiz, User user) {
        this.examHistoryId = examHistoryId;
        this.givenAnswer = givenAnswer;
        this.correctAnswer = correctAnswer;
        this.createDate = createDate;
        this.updateDateTime = updateDateTime;
        this.question = question;
        this.quiz = quiz;
        this.user = user;
    }

    public Long getExamHistoryId() {
        return examHistoryId;
    }

    public void setExamHistoryId(Long examHistoryId) {
        this.examHistoryId = examHistoryId;
    }

    public String getGivenAnswer() {
        return givenAnswer;
    }

    public void setGivenAnswer(String givenAnswer) {
        this.givenAnswer = givenAnswer;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    public LocalDate getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDate createDate) {
        this.createDate = createDate;
    }

    public LocalDateTime getUpdateDateTime() {
        return updateDateTime;
    }

    public void setUpdateDateTime(LocalDateTime updateDateTime) {
        this.updateDateTime = updateDateTime;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public Quiz getQuiz() {
        return quiz;
    }

    public void setQuiz(Quiz quiz) {
        this.quiz = quiz;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
