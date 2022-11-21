package com.developer.faculty.dto.response;

import lombok.Getter;
import lombok.Setter;
import com.developer.faculty.model.Specialization;
import java.util.List;

@Getter
@Setter
public class StudentResponseDto {
    private long id;
    private String name;
    private String surname;
    private int age;
    private String email;
    private Specialization specialization;
    private List<Long> teacherIds;
}
