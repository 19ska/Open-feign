package com.example.student.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentDTO {

    private Long id;
    private String firstName;
    private String lastName;
    private String course;
}
