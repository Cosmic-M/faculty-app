package com.developer.faculty.service;

import com.developer.faculty.model.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import java.util.List;

public interface StudentService {
    Student create(Student student);

    void update(Student student);

    Student get(Long id);

    void delete(Long id);

    Page<Student> getAll(PageRequest pageRequest);

    List<Student> getAllByTeacher(Long teacherId, PageRequest pageRequest);

    Student addTeacher(Long studentId, Long teacherId);

    Student removeTeacher(Long studentId, Long teacherId);
}
