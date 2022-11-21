package com.developer.faculty.service.mapper;

import com.developer.faculty.dto.response.StudentResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import com.developer.faculty.dto.request.StudentRequestDto;
import com.developer.faculty.model.Student;
import com.developer.faculty.model.Teacher;

import java.util.Collections;

@Component
@RequiredArgsConstructor
public class StudentMapper {
    public Student toModel(StudentRequestDto requestDto) {
        Student student = new Student();
        student.setName(requestDto.getName());
        student.setSurname(requestDto.getSurname());
        student.setAge(requestDto.getAge());
        student.setEmail(requestDto.getEmail());
        student.setSpecialization(requestDto.getSpecialization());
        student.setTeachers(Collections.emptyList());
        return student;
    }

    public StudentResponseDto toDto(Student student) {
        StudentResponseDto studentResponseDto = new StudentResponseDto();
        studentResponseDto.setId(student.getId());
        studentResponseDto.setName(student.getName());
        studentResponseDto.setSurname(student.getSurname());
        studentResponseDto.setAge(student.getAge());
        studentResponseDto.setEmail(student.getEmail());
        studentResponseDto.setSpecialization(student.getSpecialization());
        studentResponseDto.setTeacherIds(student.getTeachers().stream()
                .map(Teacher::getId)
                .toList());
        return studentResponseDto;
    }

    public Student toModel(Student student, StudentRequestDto requestDto) {
        if (requestDto.getName() != null) {
            student.setName(requestDto.getName());
        }
        if (requestDto.getSurname() != null) {
            student.setSurname(requestDto.getSurname());
        }
        if (requestDto.getAge() != 0) {
            student.setAge(requestDto.getAge());
        }
        if (requestDto.getEmail() != null) {
            student.setEmail(requestDto.getEmail());
        }
        if (requestDto.getSpecialization() != null) {
            student.setSpecialization(requestDto.getSpecialization());
        }
        return student;
    }
}
