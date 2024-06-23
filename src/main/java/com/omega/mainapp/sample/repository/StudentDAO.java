package com.omega.mainapp.sample.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.omega.mainapp.sample.model.Student;

@Repository
public interface StudentDAO extends JpaRepository<Student, Long> {
}
