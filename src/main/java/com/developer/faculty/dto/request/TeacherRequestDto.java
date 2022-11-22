package com.developer.faculty.dto.request;

import com.developer.faculty.lib.ValidEmail;
import com.developer.faculty.model.Subject;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

@Getter
@Setter
public class TeacherRequestDto {
    @Size(min =3)
    private String name;
    @Size(min =3)
    private String surname;
    @Min(19)
    private int age;
    @ValidEmail
    private String email;
    private Subject subject;
}
