package com.developer.faculty.controller;

import com.developer.faculty.dto.request.TeacherRequestDto;
import com.developer.faculty.dto.response.TeacherResponseDto;
import com.developer.faculty.model.Teacher;
import com.developer.faculty.service.TeacherService;
import com.developer.faculty.service.mapper.TeacherMapper;
import com.developer.faculty.util.SortPeopleUtil;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/teachers")
public class TeacherController {
    private final TeacherService teacherService;
    private final TeacherMapper teacherMapper;

    @GetMapping
    @ApiOperation(value = "get list of teachers")
    public List<TeacherResponseDto> getAll(@RequestParam(defaultValue = "20")
                                           @ApiParam(value = "default value is 20")
                                           Integer count,
                                           @RequestParam(defaultValue = "0")
                                           @ApiParam(value = "default value is 0")
                                           Integer page,
                                           @RequestParam(defaultValue = "id")
                                           @ApiParam(value = "default value is id")
                                           String sortBy) {
        Sort sort = SortPeopleUtil.getSortProperty(sortBy);
        Page<Teacher> teachers = teacherService
                .getAll(PageRequest.of(page, count, sort));
        return teachers.stream()
                .map(teacherMapper::toDto)
                .toList();
    }

    @GetMapping("/by-student")
    @ApiOperation(value = "get list of teachers by student's id")
    public List<TeacherResponseDto> getAllByStudent(@RequestParam Long studentId,
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
        List<Teacher> teachers = teacherService
                .getAllByStudent(studentId, PageRequest.of(page, count, sort));
        return teachers.stream()
                .map(teacherMapper::toDto)
                .toList();
    }

    @PostMapping
    @ApiOperation(value = "create a new teacher")
    public TeacherResponseDto create(@RequestBody @Valid TeacherRequestDto requestDto) {
        Teacher teacher = teacherMapper.toModel(requestDto);
        return teacherMapper.toDto(teacherService.create(teacher));
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "update teacher with specific id")
    public void update(@PathVariable Long id, @RequestBody @Valid TeacherRequestDto requestDto) {
        Teacher teacher = teacherMapper.toModel(requestDto);
        teacher.setId(id);
        teacherService.update(teacher);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "delete teacher from DB by id")
    public void delete(@PathVariable Long id) {
        teacherService.delete(id);
    }

    @PutMapping("/add-students")
    @ApiOperation(value = "add student to teacher's list of students")
    public TeacherResponseDto addStudent(@RequestParam Long teacherId, @RequestParam Long studentId) {
        Teacher teacher = teacherService.addStudent(teacherId, studentId);
        return teacherMapper.toDto(teacher);
    }

    @PutMapping("/remove-students")
    @ApiOperation(value = "remove student from teacher's list of students")
    public TeacherResponseDto removeStudent(@RequestParam Long teacherId, @RequestParam Long studentId) {
        Teacher teacher = teacherService.removeStudent(teacherId, studentId);
        return teacherMapper.toDto(teacher);
    }
}
