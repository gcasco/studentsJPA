package com.example.demo_jpa.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;
import javax.websocket.server.ServerEndpoint;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name ="subjects")
public class Subjects {
    private Course course;
    @Pattern(regexp = "REGULAR|APROBADA|LIBRE|ENCURSO",message = "El estado de la materia es inválido")
    private String status;

}
