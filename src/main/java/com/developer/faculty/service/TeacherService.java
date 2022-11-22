package com.developer.faculty.service;

import com.developer.faculty.model.Teacher;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

public interface TeacherService {
    Teacher create(Teacher teacher);

    void update(Teacher teacher);

    Teacher get(Long id);

    void delete(Long teacherId);

    Page<Teacher> getAll(PageRequest pageRequest);

    List<Teacher> getAllByStudent(Long teacherId, PageRequest pageRequest);

    Teacher addStudent(Long teacherId, Long studentId);

    Teacher removeStudent(Long teacherId, Long studentId);

    List<Teacher> find(String name, String surname);
}
