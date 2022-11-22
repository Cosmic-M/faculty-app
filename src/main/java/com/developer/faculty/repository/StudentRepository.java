package com.developer.faculty.repository;

import com.developer.faculty.model.Student;
import com.developer.faculty.model.Teacher;
import java.util.List;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    List<Student> getStudentsByTeachersContaining(Teacher teacher, PageRequest pageRequest);

    List<Student> getStudentsByNameAndSurname(String name, String surname);
}
