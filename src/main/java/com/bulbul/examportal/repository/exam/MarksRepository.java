package com.bulbul.examportal.repository.exam;

import com.bulbul.examportal.entity.exam.Marks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MarksRepository extends JpaRepository<Marks,Long> {
}
