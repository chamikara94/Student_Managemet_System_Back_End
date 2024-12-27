package com.Student_info.controller;

import com.Student_info.Service.StudentService;
import com.Student_info.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200/")
@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService service;

    @PostMapping("/add")
    public ResponseEntity<?> addStudent(@RequestBody Student student) {
        try{
            Student addedstudent = service.createStudent(student);
            return ResponseEntity.status(HttpStatus.CREATED).body(addedstudent);
        }catch (RuntimeException ex){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        }
    }

    // Get all students
    @GetMapping("/getallstudents")
    public List<Student> getAllStudentDetails() {
        return service.getAllStudentDetails();
    }

    // New endpoint: Get student by index_no
    @GetMapping("/index/{indexNo}")
    public ResponseEntity<Student> getStudentByIndexNo(@PathVariable String indexNo) {
        return service.getStudentDetailsByIndexNo(indexNo)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    // New endpoint: Update student by index_no
    @PutMapping("/update/index/{indexNo}")
    public ResponseEntity<Student> updateStudentByIndexNo(
            @PathVariable String indexNo,
            @RequestBody Student updatedStudent) {
        try {
            Student updated = service.updateStudentByIndexNo(indexNo, updatedStudent);
            return ResponseEntity.ok(updated);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }
    // Delete a student by ID
    @DeleteMapping("/delete/index/{indexNo}")
    public ResponseEntity<String> deleteStudentByIndexNo(@PathVariable String indexNo) {
        Optional<Student> student = service.deleteStudentByIndexNo(indexNo);
        if (student.isPresent()) {
            return ResponseEntity.ok("Deleted successfully");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Student with index_no " + indexNo + " not found");
        }
    }
}