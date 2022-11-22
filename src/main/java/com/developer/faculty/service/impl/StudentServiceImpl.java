package com.developer.faculty.service.impl;

import com.developer.faculty.model.Teacher;
import com.developer.faculty.repository.StudentRepository;
import com.developer.faculty.service.StudentService;
import com.developer.faculty.service.TeacherService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.developer.faculty.model.Student;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private TeacherService teacherService;

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
        Student student = get(studentId);
        Teacher teacher = teacherService.get(teacherId);
        List<Teacher> teachers = student.getTeachers();
        if (!teachers.contains(teacher)) {
            teachers.add(teacher);
            return studentRepository.save(student);
        }
        return student;
    }

    @Override
    public Student removeTeacher(Long studentId, Long teacherId) {
        Student student = get(studentId);
        Teacher teacher = teacherService.get(teacherId);
        List<Teacher> teachers = student.getTeachers();
        teachers.remove(teacher);
        student.setTeachers(teachers);
        return studentRepository.save(student);
    }
}
