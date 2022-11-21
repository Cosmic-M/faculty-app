package com.developer.faculty.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.developer.faculty.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
}
