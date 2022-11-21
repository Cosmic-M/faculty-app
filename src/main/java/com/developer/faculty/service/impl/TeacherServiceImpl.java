package com.developer.faculty.service.impl;

import com.developer.faculty.model.Teacher;
import com.developer.faculty.repository.StudentRepository;
import com.developer.faculty.service.TeacherService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import com.developer.faculty.model.Student;
import com.developer.faculty.repository.TeacherRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TeacherServiceImpl implements TeacherService {
    private final TeacherRepository teacherRepository;
    private final StudentRepository studentRepository;

    @Override
    public Teacher create(Teacher teacher) {
        return teacherRepository.save(teacher);
    }

    @Override
    public void update(Teacher teacher) {
        teacherRepository.save(teacher);
    }

    @Override
    public Teacher get(Long id) {
        return teacherRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Cannot find teacher by id" + id));
    }

    @Override
    public void delete(Long teacherId) {
        teacherRepository.deleteById(teacherId);
    }

    @Override
    public List<Teacher> getAll() {
        return teacherRepository.findAll();
    }

    @Override
    public Teacher addStudent(Long teacherId, Long studentId) {
        Teacher teacher = teacherRepository.findById(teacherId).orElseThrow(
                () -> new RuntimeException("Cannot find teacher by id" + teacherId));
        Student student = studentRepository.findById(studentId).orElseThrow(
                () -> new RuntimeException("Cannot find student by id" + studentId));
        List<Teacher> teachers = student.getTeachers();
        teachers.add(teacher);
        student.setTeachers(teachers);
        studentRepository.save(student);
        return teacherRepository.findById(teacherId).get();
    }

    @Override
    public Teacher removeStudent(Long teacherId, Long studentId) {
        Teacher teacher = teacherRepository.findById(teacherId).orElseThrow(
                () -> new RuntimeException("Cannot find teacher by id" + teacherId));
        Student student = studentRepository.findById(studentId).orElseThrow(
                () -> new RuntimeException("Cannot find student by id" + studentId));

        List<Teacher> teachers = student.getTeachers();
        teachers.remove(teacher);
        student.setTeachers(teachers);
        studentRepository.save(student);
        return teacherRepository.findById(teacherId).get();
    }
}
