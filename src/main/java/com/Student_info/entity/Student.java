package com.Student_info.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;



@Entity
@Table
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="index_no")
    private String index_no;

    @Column(name="first_name")
    private String first_Name;

    @Column(name="last_name")
    private String last_Name;

    @Column(name="date_of_birth")
    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "yyyy-MM-dd")
    private LocalDate dateofbirth;

    @Column(name="gpa")
    private float gpa;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIndex_no() {
        return index_no;
    }

    public void setIndex_no(String index_no) {
        this.index_no = index_no;
    }

    public String getFirst_Name() {
        return first_Name;
    }

    public void setFirst_Name(String first_Name) {
        this.first_Name = first_Name;
    }

    public String getLast_Name() {
        return last_Name;
    }

    public void setLast_Name(String last_Name) {
        this.last_Name = last_Name;
    }

    public LocalDate getDateOfBirth() {
        return dateofbirth;
    }

    public void setDateOfBirth(LocalDate dateofbirth) {
        this.dateofbirth = dateofbirth;
    }


    public String getFormattedDateOfBirth(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return dateofbirth !=null ? dateofbirth.format(formatter) : null;
    }

    public float getGpa() {
        return gpa;
    }

    public void setGpa(float gpa) {
        this.gpa = gpa;
    }

    public Student() {
    }

    public Student(Long id, String index_no, String first_Name, String last_Name, LocalDate dateOfBirth, float gpa) {
        this.id = id;
        this.index_no = index_no;
        this.first_Name = first_Name;
        this.last_Name = last_Name;
        this.dateofbirth = dateOfBirth;
        this.gpa = gpa;
    }

    @Override
    public String toString() {
        return "Student{" +
                "Id=" + id +
                ", Index_no='" + index_no + '\'' +
                ", First_Name='" + first_Name + '\'' +
                ", Last_Name='" + last_Name + '\'' +
                ", Date_Of_Birth=" + getFormattedDateOfBirth() +
                ", GPA=" + gpa +
                '}';
    }
}
