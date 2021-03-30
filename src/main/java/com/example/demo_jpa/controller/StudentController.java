package com.example.demo_jpa.controller;

import com.example.demo_jpa.exception.GenericException;
import com.example.demo_jpa.exception.StudenNotFoundException;
import com.example.demo_jpa.model.Student;
import com.example.demo_jpa.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import javax.websocket.server.PathParam;


@RestController
public class StudentController {
    @Autowired
    private IStudentService service;

    @GetMapping("/students")
    public List<Student> getStudentList(){
        List<Student> students = service.getStudents();
        return students;
    }
    
    @PostMapping(value="/create")
    public String createStudent(@RequestBody Student student ) {
        service.saveStudent(student);
        return "El estudiante fue guardado correctamente";
    }

    @PostMapping(value="/delete/{id}")
    public String createStudent(@PathVariable long id ) throws StudenNotFoundException {
        service.deleteStudent(id);

        return "El estudiante fue eliminado correctamente";
    }

    @PostMapping(value="/edit/{id}")
    public String editStudent(@PathVariable long id,@RequestParam ("name") String newName,@RequestParam ("lastName") String newLastName ) throws StudenNotFoundException {
        service.editStudent(id,newName,newLastName);
        return "El estudiante fue editado correctamente";
    }

    @ExceptionHandler(GenericException.class)
    public ResponseEntity<String> handleException(GenericException ex){
        return  new ResponseEntity<String>(ex.getMessage(), HttpStatus.valueOf(ex.getCode()));
    }
    
}
