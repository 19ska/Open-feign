package com.example.student.response;


import lombok.*;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StudentResponse {
    private Long id;
    private String firstName;
    private String lastName;
    private String emailId;
    private String phoneNumber;


    public void setAddressResponse(CourseResponse body) {
    }
}
