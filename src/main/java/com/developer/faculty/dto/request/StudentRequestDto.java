package com.developer.faculty.dto.request;

import com.developer.faculty.lib.ValidEmail;
import lombok.Getter;
import lombok.Setter;

import com.developer.faculty.model.Specialization;

import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

@Getter
@Setter
public class StudentRequestDto {
    @Size(min =3)
    private String name;
    @Size(min = 3)
    private String surname;
    @Min(19)
    private int age;
    @ValidEmail
    private String email;
    private Specialization specialization;
}
