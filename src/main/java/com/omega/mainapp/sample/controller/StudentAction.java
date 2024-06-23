package com.omega.mainapp.sample.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.omega.mainapp.sample.service.StudentService;
import com.omega.mainapp.sample.model.Student;
import com.omega.mainapp.utils.TimeUtils;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/student")
public class StudentAction {

    @Autowired
    StudentService studentService;

    @PostMapping("/addStudent")
    public Student addStudent(@RequestBody Student student) {
        student.setCreatedTime(TimeUtils.getCurrentTime());
        return studentService.addStudent(student);
    }

    @GetMapping("/getStudent")
    public Student getStudent(@RequestParam long id) {
        return studentService.getStudent(id);
    }

    @GetMapping("/getAllStudents")
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }
}
