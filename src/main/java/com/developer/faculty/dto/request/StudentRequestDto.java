package com.developer.faculty.dto.request;

import lombok.Getter;
import lombok.Setter;

import com.developer.faculty.model.Specialization;

@Getter
@Setter
public class StudentRequestDto {
    private String name;
    private String surname;
    private int age;
    private String email;
    private Specialization specialization;
}
