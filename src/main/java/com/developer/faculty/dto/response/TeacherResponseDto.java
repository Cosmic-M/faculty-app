package com.developer.faculty.dto.response;

import com.developer.faculty.model.Subject;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TeacherResponseDto {
    private long id;
    private String name;
    private String surname;
    private int age;
    private String email;
    private Subject subject;
    private List<Long> studentIds;
}
