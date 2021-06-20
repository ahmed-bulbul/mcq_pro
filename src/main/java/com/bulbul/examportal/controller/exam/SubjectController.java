package com.bulbul.examportal.controller.exam;



import com.bulbul.examportal.entity.exam.Subject;
import com.bulbul.examportal.service.exam.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/subject")
@CrossOrigin("*")
public class SubjectController {

    @Autowired
    private SubjectService subjectService;

    @PostMapping("/")
    public ResponseEntity<Subject> add(@RequestBody Subject subject){
        return ResponseEntity.ok(this.subjectService.addSubject(subject));
    }

    @GetMapping("/")
    public List<Subject> getSubjectList(){
        return this.subjectService.getAllSubjects();
    }
}
