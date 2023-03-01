package com.example.DavidSisalimaM5A.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Getter
@Setter
@Document(collection = "curso")
@Data
public class Curso implements Serializable {

    private Long curso_id;
    private String nombre;

    private String nivel;

    private String descripcion;

    //Relaciones
   //private Profesor depto;


}
