package com.Student_info.Service;

import com.Student_info.entity.Student;
import com.Student_info.repo.StudentRepository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService{

    @Autowired
    StudentRepository studentRepo;

    @Override
    public Student createStudent(Student student) {
        System.out.println("Implementation Obj : " +student.toString());
        return studentRepo.save(student);
    }

    @Override
    public Student getStudentDetailsByid(Long id) {
        Optional<Student> student = studentRepo.findById(id);
        if(student.isEmpty()){
            throw new RuntimeException("Student Not Found");
        }
        return student.get();
    }

    @Override
    public List<Student> getAllStudentDetails() {
        return studentRepo.findAll();
    }

    @Override
    public boolean deleteStudentDetails(Long id) {
        if(studentRepo.existsById(id)) {
            studentRepo.deleteById(id);
            return true;
        }
        return false;
    }
}
