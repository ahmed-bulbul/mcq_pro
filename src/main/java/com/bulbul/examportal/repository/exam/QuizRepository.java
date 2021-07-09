package com.bulbul.examportal.repository.exam;

import com.bulbul.examportal.entity.exam.Quiz;
import com.bulbul.examportal.entity.exam.SubCategory;
import com.bulbul.examportal.entity.exam.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuizRepository extends JpaRepository<Quiz,Long> {

    public List<Quiz> findBySubCategory(SubCategory subCategory);

    public List<Quiz> findByActive(Boolean b);

    public List<Quiz> findBySubCategoryAndActive(SubCategory c, Boolean b);

    public List<Quiz> findBySubjectAndSubCategory(Subject subject,SubCategory subCategory);
}
