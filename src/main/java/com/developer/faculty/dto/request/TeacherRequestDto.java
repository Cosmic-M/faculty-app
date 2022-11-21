package com.developer.faculty.dto.request;

import com.developer.faculty.model.Subject;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TeacherRequestDto {
    private String name;
    private String surname;
    private int age;
    private String email;
    private Subject subject;
}
