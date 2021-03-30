package com.example.demo_jpa.exception;

import org.springframework.http.HttpStatus;

public class StudenNotFoundException extends GenericException{
    public StudenNotFoundException(long id){
        super("No se pudo hallar al estudiante "+id, HttpStatus.BAD_REQUEST.value());
    }
}
