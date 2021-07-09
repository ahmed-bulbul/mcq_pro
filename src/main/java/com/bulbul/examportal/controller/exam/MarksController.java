package com.bulbul.examportal.controller.exam;


import com.bulbul.examportal.entity.exam.ExamHistory;
import com.bulbul.examportal.entity.exam.Marks;
import com.bulbul.examportal.service.exam.MarksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/marks")
@CrossOrigin(origins = "*", maxAge = 3600)
public class MarksController {

    @Autowired
    private MarksService marksService;

    //Add Exam history
    @PostMapping("/")
    public ResponseEntity<Marks> add(@RequestBody Marks marks){
        return ResponseEntity.ok(this.marksService.addMarks(marks));
    }
}
