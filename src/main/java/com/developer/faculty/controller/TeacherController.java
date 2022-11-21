package com.developer.faculty.controller;

import com.developer.faculty.dto.request.TeacherRequestDto;
import com.developer.faculty.dto.response.TeacherResponseDto;
import com.developer.faculty.model.Teacher;
import com.developer.faculty.service.TeacherService;
import com.developer.faculty.service.mapper.TeacherMapper;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/teachers")
public class TeacherController {
    private final TeacherService teacherService;
    private final TeacherMapper teacherMapper;

    @GetMapping
    @ApiOperation(value = "get list of teachers")
    public List<TeacherResponseDto> getAll() {
        return teacherService.getAll().stream().map(teacherMapper::toDto).toList();
    }

    @PostMapping
    @ApiOperation(value = "create a new teacher")
    public TeacherResponseDto create(@RequestBody TeacherRequestDto requestDto) {
        Teacher teacher = teacherMapper.toModel(requestDto);
        return teacherMapper.toDto(teacherService.create(teacher));
    }

    @PatchMapping("/{id}")
    @ApiOperation(value = "update chosen fields at teacher specified by id")
    public void update(@PathVariable Long id, @RequestBody TeacherRequestDto requestDto) {
        Teacher fromDb = teacherService.get(id);
        Teacher updatedTeacher = teacherMapper.toModel(fromDb, requestDto);
        teacherService.update(updatedTeacher);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "delete teacher from DB by id")
    public void delete(@PathVariable Long id) {
        teacherService.delete(id);
    }

    @PatchMapping("/{teacherId}/add-students/{studentId}")
    @ApiOperation(value = "add student to teacher's list of students")
    public TeacherResponseDto addStudent(@PathVariable Long teacherId, @PathVariable Long studentId) {
        Teacher teacher = teacherService.addStudent(teacherId, studentId);
        return teacherMapper.toDto(teacher);
    }

    @PatchMapping("/{teacherId}/remove-students/{studentId}")
    @ApiOperation(value = "remove student from teacher's list of students")
    public TeacherResponseDto removeStudent(@PathVariable Long teacherId, @PathVariable Long studentId) {
        Teacher teacher = teacherService.removeStudent(teacherId, studentId);
        return teacherMapper.toDto(teacher);
    }
}
