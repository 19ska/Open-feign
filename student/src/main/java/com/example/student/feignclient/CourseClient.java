package com.example.student.feignclient;

import com.example.student.response.CourseResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "COURSE-SERVICE", url = "http://localhost:8085")
public interface CourseClient {
    @GetMapping(value="/api/{id}")
    public ResponseEntity<CourseResponse> getCourseByStudentId(@PathVariable("id") int id);

}
