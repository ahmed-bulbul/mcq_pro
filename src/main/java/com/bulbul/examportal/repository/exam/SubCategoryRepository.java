package com.bulbul.examportal.repository.exam;

import com.bulbul.examportal.entity.exam.Category;
import com.bulbul.examportal.entity.exam.SubCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SubCategoryRepository extends JpaRepository<SubCategory,Long> {
    List<SubCategory> findByCategory(Category category);
}
