package com.example.demo_jpa.service;

import com.example.demo_jpa.exception.StudenNotFoundException;
import com.example.demo_jpa.model.Student;

import java.util.List;

public interface IStudentService {
    public void saveStudent(Student student);
    public void deleteStudent(long idStudent) throws StudenNotFoundException;
    public void editStudent(long id, String newName, String newLastName) throws StudenNotFoundException;
    public Student findStudent(long idStudent) throws StudenNotFoundException;
    public List<Student> getStudents();

}
