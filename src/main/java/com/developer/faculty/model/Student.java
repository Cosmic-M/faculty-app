package com.developer.faculty.model;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String surname;
    private int age;
    private String email;
    @Enumerated(EnumType.STRING)
    private Specialization specialization;
    @ManyToMany
    @JoinTable(name="students_teachers",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "teacher_id"))
    private List<Teacher> teachers;
}
