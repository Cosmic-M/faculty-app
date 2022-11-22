package com.developer.faculty.controller;

import com.developer.faculty.dto.request.StudentRequestDto;
import com.developer.faculty.dto.response.StudentResponseDto;
import com.developer.faculty.model.Student;
import com.developer.faculty.service.StudentService;
import com.developer.faculty.service.mapper.StudentMapper;
import com.developer.faculty.util.SortPeopleUtil;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import java.util.List;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/students")
public class StudentController {
    private final StudentService studentService;
    private final StudentMapper studentMapper;

    @GetMapping
    @ApiOperation(value = "get list of students")
    public List<StudentResponseDto> getAll(@RequestParam(defaultValue = "20")
                                               @ApiParam(value = "default value is 20")
                                               Integer count,
                                           @RequestParam(defaultValue = "0")
                                               @ApiParam(value = "default value is 0")
                                               Integer page,
                                           @RequestParam(defaultValue = "id")
                                               @ApiParam(value = "default value is id")
                                               String sortBy) {
        Sort sort = SortPeopleUtil.getSortProperty(sortBy);
        Page<Student> students = studentService
                .getAll(PageRequest.of(page, count, sort));
        return students.stream()
                .map(studentMapper::toDto)
                .toList();
    }

    @GetMapping("/by-teacher")
    @ApiOperation(value = "get list of students by teacher's id")
    public List<StudentResponseDto> getAllByTeacher(@RequestParam Long teacherId,
                                           @RequestParam(defaultValue = "20")
                                           @ApiParam(value = "default value is 20")
                                           Integer count,
                                           @RequestParam(defaultValue = "0")
                                           @ApiParam(value = "default value is 0")
                                           Integer page,
                                           @RequestParam(defaultValue = "id")
                                           @ApiParam(value = "default value is id")
                                           String sortBy) {
        Sort sort = SortPeopleUtil.getSortProperty(sortBy);
        List<Student> students = studentService
                .getAllByTeacher(teacherId, PageRequest.of(page, count, sort));
        return students.stream()
                .map(studentMapper::toDto)
                .toList();
    }

    @PostMapping
    @ApiOperation(value = "create a new student")
    public StudentResponseDto create(@RequestBody @Valid StudentRequestDto requestDto) {
        Student student = studentMapper.toModel(requestDto);
        return studentMapper.toDto(studentService.create(student));
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "update student with specific id")
    public void update(@PathVariable Long id, @RequestBody @Valid StudentRequestDto requestDto) {
        Student student = studentMapper.toModel(requestDto);
        student.setId(id);
        studentService.update(student);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "delete student from DB by id")
    public void delete(@PathVariable Long id) {
        studentService.delete(id);
    }

    @PutMapping("/add-teacher")
    @ApiOperation(value = "add teacher to student's list of teachers")
    public StudentResponseDto addTeacher(@RequestParam Long studentId,
                                         @RequestParam Long teacherId) {
        Student student = studentService.addTeacher(studentId, teacherId);
        return studentMapper.toDto(student);
    }

    @PutMapping("/remove-teacher")
    @ApiOperation(value = "remove teacher from student's list of teachers")
    public StudentResponseDto removeTeacher(@RequestParam Long studentId,
                                            @RequestParam Long teacherId) {
        Student student = studentService.removeTeacher(studentId, teacherId);
        return studentMapper.toDto(student);
    }

    @GetMapping("/search")
    @ApiOperation(value = "search students by name and surname or by one of these two params")
    public List<StudentResponseDto> search(@RequestParam String name,
                                           @RequestParam String surname) {
        List<Student> students = studentService.find(name, surname);
        return students.stream()
                .map(studentMapper::toDto)
                .toList();
    }
}
