package com.Student_info.Service;

import com.Student_info.entity.Student;
import com.Student_info.repo.StudentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

    private static final Logger logger = LoggerFactory.getLogger(StudentServiceImpl.class);

    private final StudentRepository studentRepo;

    public StudentServiceImpl(StudentRepository studentRepo) {
        this.studentRepo = studentRepo;
    }

    @Override
    public Student createStudent(Student student) {
        Optional<Student> existingStudent = studentRepo.findByIndexNo(student.getIndex_no());
        if(existingStudent.isPresent()){
            throw new RuntimeException("A student with Index No :"+ student.getIndex_no() +" already exists");
        }
        return studentRepo.save(student);
    }

    @Override
    public List<Student> getAllStudentDetails() {
        return studentRepo.findAll();
    }

    @Override
    @Transactional
    public Optional<Student> deleteStudentByIndexNo(String indexNo) {
        return studentRepo.findByIndexNo(indexNo).map(student -> {
            studentRepo.delete(student);
            logger.info("Deleted Student with ID: {}", indexNo);
            return student;
        });
    }

    // New method: Search student by index_no
    @Override
    public Optional<Student> getStudentDetailsByIndexNo(String indexNo) {
        return studentRepo.findByIndexNo(indexNo);
    }

    // New method: Update student details by index_no
    @Override
    @Transactional
    public Student updateStudentByIndexNo(String indexNo, Student updatedStudent) {
        return studentRepo.findByIndexNo(indexNo).map(existingStudent -> {
            existingStudent.setFirst_Name(updatedStudent.getFirst_Name());
            existingStudent.setLast_Name(updatedStudent.getLast_Name());
            existingStudent.setGender(updatedStudent.getGender());
            existingStudent.setDateofbirth(updatedStudent.getDateofbirth());
            existingStudent.setGpa(updatedStudent.getGpa());
            return studentRepo.save(existingStudent);
        }).orElseThrow(() -> new RuntimeException("Student with Index No " + indexNo + " not found"));
    }
}
