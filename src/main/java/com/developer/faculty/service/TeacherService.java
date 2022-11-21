package com.developer.faculty.service;

import com.developer.faculty.model.Teacher;
import java.util.List;

public interface TeacherService {
    Teacher create(Teacher teacher);

    void update(Teacher teacher);

    Teacher get(Long id);

    void delete(Long teacherId);

    List<Teacher> getAll();

    Teacher addStudent(Long teacherId, Long studentId);

    Teacher removeStudent(Long teacherId, Long studentId);
}
