package com.developer.faculty.controller;

import com.developer.faculty.dto.response.StudentResponseDto;
import com.developer.faculty.service.StudentService;
import com.developer.faculty.service.mapper.StudentMapper;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import com.developer.faculty.dto.request.StudentRequestDto;
import com.developer.faculty.model.Student;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/students")
public class StudentController {
    private final StudentService studentService;
    private final StudentMapper studentMapper;

    @GetMapping
    @ApiOperation(value = "get list of students")
    public List<StudentResponseDto> getAll() {
        return studentService.getAll().stream().map(studentMapper::toDto).toList();
    }

    @PostMapping
    @ApiOperation(value = "create a new student")
    public StudentResponseDto create(@RequestBody StudentRequestDto requestDto) {
        Student student = studentMapper.toModel(requestDto);
        return studentMapper.toDto(studentService.create(student));
    }

    @PatchMapping("/{id}")
    @ApiOperation(value = "update chosen fields at student specified by id")
    public void update(@PathVariable Long id, @RequestBody StudentRequestDto requestDto) {
        Student fromDB = studentService.get(id);
        Student updatedStudent = studentMapper.toModel(fromDB, requestDto);
        studentService.update(updatedStudent);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "delete student from DB by id")
    public void delete(@PathVariable Long id) {
        studentService.delete(id);
    }

    @PatchMapping("/{studentId}/add-teacher/{teacherId}")
    @ApiOperation(value = "add teacher to student's list of teachers")
    public StudentResponseDto addTeacher(@PathVariable Long studentId, @PathVariable Long teacherId) {
        Student student = studentService.addTeacher(studentId, teacherId);
        return studentMapper.toDto(student);
    }

    @PatchMapping("/{studentId}/remove-teacher/{teacherId}")
    @ApiOperation(value = "remove teacher from student's list of teachers")
    public StudentResponseDto removeTeacher(@PathVariable Long studentId, @PathVariable Long teacherId) {
        Student student = studentService.addTeacher(studentId, teacherId);
        return studentMapper.toDto(student);
    }
}
