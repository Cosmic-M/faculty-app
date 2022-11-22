package com.developer.faculty.dto.request;

import com.developer.faculty.lib.ValidEmail;
import com.developer.faculty.model.Specialization;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentRequestDto {
    @Size(min = 3, message = "name should have at least 3 characters")
    @Size(max = 20, message = "name should be up to 20 characters")
    private String name;
    @Size(min = 3, message = "surname should have at least 3 characters")
    @Size(max = 20, message = "surname should be up to 20 characters")
    private String surname;
    @Min(value = 19, message = "an age should be at least 19 years")
    private int age;
    @ValidEmail(message = "not valid e-mail, please check input data")
    private String email;
    @NotNull
    private Specialization specialization;
}
