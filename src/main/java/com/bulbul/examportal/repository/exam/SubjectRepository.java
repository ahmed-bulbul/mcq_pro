package com.bulbul.examportal.repository.exam;

import com.bulbul.examportal.entity.exam.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubjectRepository extends JpaRepository<Subject,Long> {
}
