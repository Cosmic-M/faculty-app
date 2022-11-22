package com.developer.faculty.service;

import com.developer.faculty.model.Student;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

public interface StudentService {
    Student create(Student student);

    void update(Student student);

    Student get(Long id);

    void delete(Long id);

    Page<Student> getAll(PageRequest pageRequest);

    List<Student> getAllByTeacher(Long teacherId, PageRequest pageRequest);

    Student addTeacher(Long studentId, Long teacherId);

    Student removeTeacher(Long studentId, Long teacherId);

    List<Student> find(String name, String surname);
}
