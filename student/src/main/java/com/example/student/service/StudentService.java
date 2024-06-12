package com.example.student.service;

import com.example.student.entity.Student;
import com.example.student.exception.StudentNotFoundException;
import com.example.student.feignclient.CourseClient;
import com.example.student.repository.StudentRepository;
import com.example.student.response.CourseResponse;
import com.example.student.response.ResponseDto;
import com.example.student.response.StudentResponse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private ModelMapper mapper;

    @Autowired
    private CourseClient addressClient;

    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

//    public Optional<Student> findStudentById(Long id) {
//        return Optional.ofNullable(studentRepository.findById(id).orElseThrow(() -> new StudentNotFoundException("Student not exist with id: " + id)));
//    }

//    public StudentResponse getStudentById(Long id) {
//
//        Optional<Student> employee = studentRepository.findById(id);
//        StudentResponse employeeResponse = mapper.map(employee, StudentResponse.class);
//
//        // Using FeignClient
//        ResponseEntity<AddressResponse> addressResponse = addressClient.getAddressByEmployeeId(Math.toIntExact(id));
//        employeeResponse.setAddressResponse(addressResponse.getBody());
//
//        return employeeResponse;
//    }

    public ResponseDto getStudentById(Long id){
        ResponseDto responseDto= new ResponseDto();
        Student student=studentRepository.findById(id).get();
        StudentResponse studentResponse=mapper.map(student,StudentResponse.class);
        CourseResponse courseResponse= addressClient.getCourseByStudentId(Math.toIntExact(student.getId())).getBody();
        responseDto.setStudent(studentResponse);
        responseDto.setCourse(courseResponse);

        return responseDto;


    }

    public void deleteStudent(Long studentId) {
        studentRepository.deleteById(studentId);
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public ResponseEntity<Void> updateStudent(Long studentId, Student student) {
        Student updateStudent=studentRepository.findById(studentId).orElseThrow(() -> new StudentNotFoundException("Student not exist with id: " + studentId));
        updateStudent.setFirstName(student.getFirstName());
        updateStudent.setLastName(student.getLastName());
        updateStudent.setEmailId(student.getEmailId());
        updateStudent.setPhoneNumber(student.getEmailId());
        //updateStudent.setCourse(student.getCourse());

        studentRepository.save(updateStudent);


        return null;
    }
}
