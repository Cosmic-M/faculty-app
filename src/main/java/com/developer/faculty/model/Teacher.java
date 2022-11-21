package com.developer.faculty.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "teachers")
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String surname;
    private int age;
    private String email;
    @Enumerated(EnumType.STRING)
    private Subject subject;
    @ManyToMany(mappedBy = "teachers")
    private List<Student> students;
}
