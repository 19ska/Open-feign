package com.example.student.response;


import lombok.*;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ResponseDto {

    private StudentResponse student;
    private CourseResponse course;
}
