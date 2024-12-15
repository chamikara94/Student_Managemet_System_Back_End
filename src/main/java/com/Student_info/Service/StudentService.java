package com.Student_info.Service;

import com.Student_info.entity.Student;
import java.util.List;
import java.util.Optional;

public interface StudentService {

    public Student createStudent(Student student);
    public Student getStudentDetailsByid(Long id);
    public List<Student> getAllStudentDetails();
    public boolean deleteStudentDetails(Long id);

}
