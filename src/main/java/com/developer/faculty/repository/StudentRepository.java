package com.developer.faculty.repository;

import com.developer.faculty.model.Teacher;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.developer.faculty.model.Student;
import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    List<Student> getStudentsByTeachersContaining(Teacher teacher, PageRequest pageRequest);
}
