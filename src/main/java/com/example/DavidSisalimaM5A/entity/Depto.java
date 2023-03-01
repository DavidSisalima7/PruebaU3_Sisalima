package com.example.DavidSisalimaM5A.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@Document(collection = "depto")
@Data
public class Depto implements Serializable {

    private Long depto_id;
    private String nombre;

    private String direccion;

    private String director;

    private String descripcion;

    //Relaciones

    private List<Profesor> listProfesor;

}
