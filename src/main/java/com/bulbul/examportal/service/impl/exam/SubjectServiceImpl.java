package com.bulbul.examportal.service.impl.exam;

import com.bulbul.examportal.entity.exam.Subject;
import com.bulbul.examportal.repository.exam.SubjectRepository;
import com.bulbul.examportal.service.exam.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubjectServiceImpl implements SubjectService {

    @Autowired
    private SubjectRepository subjectRepository;
    @Override
    public Subject addSubject(Subject subject) {
        return this.subjectRepository.save(subject);
    }

    @Override
    public List<Subject> getAllSubjects() {
        return this.subjectRepository.findAll();
    }
}
