package com.Student_info.controller;

import com.Student_info.Service.StudentService;
import com.Student_info.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
     StudentService service;

    //Add the new student
    @PostMapping("/add")
    public ResponseEntity<Student> addStudent(@RequestBody Student student) {
        Student addStudent = service.createStudent(student);
        return ResponseEntity.status(HttpStatus.CREATED).body(addStudent);
    }

    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable Long id) {
        Student student = service.getStudentDetailsByid(id);
        return student;
    }


    @GetMapping("/getallstudents")
    public List<Student> getAllStudentDetails() {
        List<Student> allStudentDetails = service.getAllStudentDetails();
        return allStudentDetails;
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable Long id) {
        if (service.deleteStudentDetails(id)) {
            return ResponseEntity.ok("Deleted successfully");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Student not found");
        }
    }

}
