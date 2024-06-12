package com.example.student.response;


import lombok.*;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CourseResponse {
    private int id;
    private String courseName;
    private String hours;
    private String classRoom;




}
