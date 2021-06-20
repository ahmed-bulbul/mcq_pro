package com.bulbul.examportal.service.exam;

import com.bulbul.examportal.entity.exam.Subject;

import java.util.List;

public interface SubjectService {

    Subject addSubject(Subject subject);

    List<Subject> getAllSubjects();
}
