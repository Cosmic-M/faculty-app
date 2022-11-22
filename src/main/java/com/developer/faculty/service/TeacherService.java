package com.developer.faculty.service;

import com.developer.faculty.model.Teacher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import java.util.List;

public interface TeacherService {
    Teacher create(Teacher teacher);

    void update(Teacher teacher);

    Teacher get(Long id);

    void delete(Long teacherId);

    Page<Teacher> getAll(PageRequest pageRequest);

    List<Teacher> getAllByStudent(Long teacherId, PageRequest pageRequest);

    Teacher addStudent(Long teacherId, Long studentId);

    Teacher removeStudent(Long teacherId, Long studentId);
}
