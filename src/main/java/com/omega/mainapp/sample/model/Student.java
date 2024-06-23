package com.omega.mainapp.sample.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Id;
    private Long jobId;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String createdTime;

    public Student() {

    }

    public Student(Long jobId, String name, String createdTime) {
        this.name = name;
        this.jobId = jobId;
        this.createdTime = createdTime;
    }
}
