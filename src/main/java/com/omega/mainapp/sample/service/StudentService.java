package com.omega.mainapp.sample.service;

import com.omega.mainapp.sample.repository.StudentDAO;
import com.omega.mainapp.sample.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    StudentDAO studentDao;

    public Student addStudent(Student student) {
        return studentDao.save(student);
    }

    public Student getStudent(long id) {
        Optional<Student> student = studentDao.findById(id);
        if (student.isEmpty()) {
            throw new IllegalArgumentException("Student not found - Id - " + id);
        }
        return student.get();
    }

    public List<Student> getAllStudents() {
        return studentDao.findAll();
    }
}
