package com.Student_info.Service;

import com.Student_info.entity.Student;

import java.util.List;
import java.util.Optional;

public interface StudentService {

    Student createStudent(Student student);

    List<Student> getAllStudentDetails();

    Optional<Student> deleteStudentByIndexNo(String indexNo);

    // New methods
    Optional<Student> getStudentDetailsByIndexNo(String indexNo);

    Student updateStudentByIndexNo(String indexNo, Student updatedStudent);
}
