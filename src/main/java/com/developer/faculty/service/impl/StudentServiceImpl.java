package com.developer.faculty.service.impl;

import com.developer.faculty.model.Teacher;
import com.developer.faculty.repository.StudentRepository;
import com.developer.faculty.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import com.developer.faculty.model.Student;
import com.developer.faculty.repository.TeacherRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;
    private final TeacherRepository teacherRepository;

    @Override
    public Student create(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public void update(Student student) {
        studentRepository.save(student);
    }

    @Override
    public Student get(Long id) {
        return studentRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Cannot find student by id=" + id));
    }

    @Override
    public void delete(Long id) {
        studentRepository.deleteById(id);
    }

    @Override
    public List<Student> getAll() {
        return studentRepository.findAll();
    }

    @Override
    public Student addTeacher(Long studentId, Long teacherId) {
        Student student = studentRepository.findById(studentId).orElseThrow(
                () -> new RuntimeException("Cannot find student by id=" + studentId));
        Teacher teacher = teacherRepository.findById(teacherId).orElseThrow(
                () -> new RuntimeException("Cannot find teacher by id" + teacherId));
        List<Teacher> teachers = student.getTeachers();
        teachers.add(teacher);
        return studentRepository.save(student);
    }

    @Override
    public Student removeTeacher(Long studentId, Long teacherId) {
        Student student = studentRepository.findById(studentId).orElseThrow(
                () -> new RuntimeException("Cannot find student by id=" + studentId));
        Teacher teacher = teacherRepository.findById(teacherId).orElseThrow(
                () -> new RuntimeException("Cannot find teacher by id" + teacherId));
        List<Teacher> teachers = student.getTeachers();
        teachers.remove(teacher);
        return studentRepository.save(student);
    }
}
