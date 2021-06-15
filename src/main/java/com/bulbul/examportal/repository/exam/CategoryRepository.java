package com.bulbul.examportal.repository.exam;

import com.bulbul.examportal.entity.exam.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category,Long> {
}
