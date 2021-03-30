package com.example.demo_jpa.service;

import com.example.demo_jpa.exception.StudenNotFoundException;
import com.example.demo_jpa.model.Student;
import com.example.demo_jpa.repository.StudentRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class StudentService implements IStudentService{
    private final StudentRepository repoStudent;
    public StudentService(StudentRepository repo){
        this.repoStudent=repo;
    }

    @Override
    @Transactional
    public void saveStudent(Student student) {
        repoStudent.save(student);
    }

    @Override
    @Transactional
    public void deleteStudent(long idStudent) throws StudenNotFoundException {
        if(repoStudent.existsById(idStudent)){
            repoStudent.deleteById(idStudent);
        }else{
            throw new StudenNotFoundException(idStudent);
        }
    }

    @Override
    public void editStudent(long id, String newName, String newLastName) throws StudenNotFoundException {
        Student newStudent = repoStudent.findById(id).orElse(null);
        if(newStudent!=null){
            newStudent.setName(newName);
            newStudent.setLastName(newLastName);
            repoStudent.save(newStudent);
        }else{
            throw new StudenNotFoundException(id);
        }

    }

    @Override
    @Transactional(readOnly=true)
    public Student findStudent(long idStudent) throws StudenNotFoundException {
        Student student=repoStudent.findById(idStudent).orElse(null);
        if(student!=null){
            return student;
        }else{
            throw new StudenNotFoundException(idStudent);
        }
    }

    @Override
    @Transactional(readOnly=true)
    public List<Student> getStudents() {
        List<Student> students = repoStudent.findAll();
        return students;
    }
}
