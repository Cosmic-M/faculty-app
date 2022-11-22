package com.developer.faculty.service.impl;

import com.developer.faculty.model.Student;
import com.developer.faculty.model.Teacher;
import com.developer.faculty.repository.StudentRepository;
import com.developer.faculty.service.StudentService;
import com.developer.faculty.service.TeacherService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

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
    public Page<Student> getAll(PageRequest pageRequest) {
        return studentRepository.findAll(pageRequest);
    }

    @Override
    public List<Student> getAllByTeacher(Long teacherId, PageRequest pageRequest) {
        Teacher teacher = teacherService.get(teacherId);
        return studentRepository.getStudentsByTeachersContaining(teacher, pageRequest);
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

    @Override
    public List<Student> find(String name, String surname) {
        return studentRepository.getStudentsByNameAndSurname(name, surname);
    }
}
