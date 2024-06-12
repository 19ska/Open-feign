package com.example.student.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.*;
import lombok.*;

@Data
@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @Size(min=4, message="Name should have 4 characters atleast")
    private String firstName;

    private String lastName;

    @Email
    private String emailId;

    @Pattern(regexp = "\\d+", message="Phone number mut be numeric")
    private String phoneNumber;
   // private String course;

    private String courseId;
}
