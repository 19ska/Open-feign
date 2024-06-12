package com.example.student.controller;

import com.example.student.dto.StudentDTO;
import com.example.student.entity.Student;
import com.example.student.response.ResponseDto;
import com.example.student.response.StudentResponse;
import com.example.student.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class StudentController {


    @Autowired
    private StudentService studentService;


    @PostMapping
    public ResponseEntity<Student> createStudent(@Valid @RequestBody Student student) {
        Student createdStudent = studentService.createStudent(student);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdStudent);
    }

//    @GetMapping("/{studentId}")
//    public Optional<Student> getStudentById(@PathVariable Long studentId) {
//        return studentService.findStudentById(studentId);
//    }
@GetMapping("/employees/{id}")
private ResponseEntity<ResponseDto> getStudentDetails(@PathVariable("id") Long id) {
//    StudentResponse student = studentService.getStudentById(id);
//    return ResponseEntity.status(HttpStatus.OK).body(student);
    ResponseDto responseDto=studentService.getStudentById(id);
    return ResponseEntity.ok(responseDto);
}

    @GetMapping
    public ResponseEntity<List<Student>> getAllStudents(){
        List<Student> students=studentService.getAllStudents();
        return ResponseEntity.ok(students);

    }


    @PutMapping
    public ResponseEntity<Long> updateStudent(@RequestParam Long studentId,@Valid @RequestBody Student student) {
       studentService.updateStudent(studentId, student);
        return new ResponseEntity<>(studentId,HttpStatus.OK);
    }

    @DeleteMapping("/deleteStudent")
    public ResponseEntity<Void> deleteStudent(@RequestParam Long studentId) {
        studentService.deleteStudent(studentId);
        return ResponseEntity.ok().build();
    }

}
