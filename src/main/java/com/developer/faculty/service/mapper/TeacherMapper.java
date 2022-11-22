package com.developer.faculty.service.mapper;

import com.developer.faculty.dto.response.TeacherResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import com.developer.faculty.dto.request.TeacherRequestDto;
import com.developer.faculty.model.Student;
import com.developer.faculty.model.Teacher;

import java.util.Collections;

@Component
@RequiredArgsConstructor
public class TeacherMapper {
    public Teacher toModel(TeacherRequestDto requestDto) {
        Teacher teacher = new Teacher();
        teacher.setName(requestDto.getName());
        teacher.setSurname(requestDto.getSurname());
        teacher.setAge(requestDto.getAge());
        teacher.setEmail(requestDto.getEmail());
        teacher.setSubject(requestDto.getSubject());
        teacher.setStudents(Collections.emptyList());
        return teacher;
    }

    public TeacherResponseDto toDto(Teacher teacher) {
        TeacherResponseDto responseDto = new TeacherResponseDto();
        responseDto.setId(teacher.getId());
        responseDto.setName(teacher.getName());
        responseDto.setSurname(teacher.getSurname());
        responseDto.setAge(teacher.getAge());
        responseDto.setEmail(teacher.getEmail());
        responseDto.setSubject(teacher.getSubject());
        responseDto.setStudentIds(teacher.getStudents().stream()
                .map(Student::getId)
                .toList());
        return responseDto;
    }
}
