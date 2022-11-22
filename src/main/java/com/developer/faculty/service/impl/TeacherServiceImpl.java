package com.developer.faculty.service.impl;

import com.developer.faculty.model.Teacher;
import com.developer.faculty.repository.StudentRepository;
import com.developer.faculty.service.StudentService;
import com.developer.faculty.service.TeacherService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.developer.faculty.model.Student;
import com.developer.faculty.repository.TeacherRepository;

import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherService {
    @Autowired
    private TeacherRepository teacherRepository;
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private StudentService studentService;

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
        Teacher teacher = get(teacherId);
        Student student = studentService.get(studentId);
        List<Teacher> teachers = student.getTeachers();
        if (! teachers.contains(teacher)) {
            teachers.add(teacher);
            student.setTeachers(teachers);
            studentRepository.save(student);
            return teacherRepository.findById(teacherId).get();
        }
        return teacher;
    }

    @Override
    public Teacher removeStudent(Long teacherId, Long studentId) {
        Teacher teacher = get(teacherId);
        Student student = studentService.get(studentId);
        List<Teacher> teachers = student.getTeachers();
        teachers.remove(teacher);
        student.setTeachers(teachers);
        studentRepository.save(student);
        return teacherRepository.findById(teacherId).get();
    }
}
