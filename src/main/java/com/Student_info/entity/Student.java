package com.Student_info.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Entity
@Table
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="index_no",unique = true,nullable = false)
    private String indexNo;

    @Column(name="first_name")
    private String first_Name;

    @Column(name="last_name")
    private String last_Name;

    @Column(name="gender")
    private String gender;

    @Column(name="date_of_birth")
    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "yyyy-MM-dd")
    private LocalDate dateofbirth;

    @Column(name="gpa")
    private float gpa;

    public String getIndex_no() {
        return indexNo;
    }

    public void setIndex_no(String index_no) {
        this.indexNo = index_no;
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public LocalDate getDateofbirth() {
        return dateofbirth;
    }

    public void setDateofbirth(LocalDate dateofbirth) {
        this.dateofbirth = dateofbirth;
    }

    @JsonIgnore
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

    @Override
    public String toString() {
        return "Student{" +
                ", Index_no='" + indexNo + '\'' +
                ", First_Name='" + first_Name + '\'' +
                ", Last_Name='" + last_Name + '\'' +
                ", Gender='" + gender + '\'' +
                ", Date_Of_Birth=" + getFormattedDateOfBirth() +
                ", GPA=" + gpa +
                '}';
    }
}