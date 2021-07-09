package com.bulbul.examportal.service.impl.exam;


import com.bulbul.examportal.entity.exam.Marks;
import com.bulbul.examportal.repository.exam.MarksRepository;
import com.bulbul.examportal.service.exam.MarksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MarksServiceImpl implements MarksService {

    @Autowired
    private MarksRepository marksRepository;

    @Override
    public Marks addMarks(Marks marks) {
        return marksRepository.save(marks);
    }
}
