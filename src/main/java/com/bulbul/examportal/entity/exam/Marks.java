package com.bulbul.examportal.entity.exam;


import com.bulbul.examportal.entity.acl.User;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
public class Marks {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long marksId;

    private String totalMarks;
    private String correctAnswer;
    private String wrongAnswer;
    private String attempted;


    @CreationTimestamp
    @Column(name = "created_at",updatable = false)
    private LocalDate createDate;


    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updateDateTime;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn (name = "quiz_id")
    private Quiz quiz;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn (name = "user_id")
    private User user;

    public Marks() {
    }

    public Marks(Long marksId, String totalMarks, String correctAnswer, String wrongAnswer, String attempted, LocalDate createDate, LocalDateTime updateDateTime, Quiz quiz, User user) {
        this.marksId = marksId;
        this.totalMarks = totalMarks;
        this.correctAnswer = correctAnswer;
        this.wrongAnswer = wrongAnswer;
        this.attempted = attempted;
        this.createDate = createDate;
        this.updateDateTime = updateDateTime;
        this.quiz = quiz;
        this.user = user;
    }

    public Long getMarksId() {
        return marksId;
    }

    public void setMarksId(Long marksId) {
        this.marksId = marksId;
    }

    public String getTotalMarks() {
        return totalMarks;
    }

    public void setTotalMarks(String totalMarks) {
        this.totalMarks = totalMarks;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    public String getWrongAnswer() {
        return wrongAnswer;
    }

    public void setWrongAnswer(String wrongAnswer) {
        this.wrongAnswer = wrongAnswer;
    }

    public String getAttempted() {
        return attempted;
    }

    public void setAttempted(String attempted) {
        this.attempted = attempted;
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
