package com.developer.faculty.service;

import com.developer.faculty.model.Student;
import java.util.List;

public interface StudentService {
    Student create(Student student);

    void update(Student student);

    Student get(Long id);

    void delete(Long id);

    List<Student> getAll();

    Student addTeacher(Long studentId, Long teacherId);

    Student removeTeacher(Long studentId, Long teacherId);
}
