package com.developer.faculty.repository;

import com.developer.faculty.model.Student;
import com.developer.faculty.model.Teacher;
import java.util.List;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Long> {
    List<Teacher> getTeachersByStudentsContaining(Student student, PageRequest pageRequest);

    List<Teacher> getTeachersByNameAndSurname(String name, String surname);
}
