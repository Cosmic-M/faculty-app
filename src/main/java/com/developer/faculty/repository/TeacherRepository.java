package com.developer.faculty.repository;

import com.developer.faculty.model.Student;
import com.developer.faculty.model.Teacher;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Long> {
    List<Teacher> getTeachersByStudentsContaining(Student student, PageRequest pageRequest);
}
