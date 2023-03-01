package com.example.DavidSisalimaM5A.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@Document(collection = "profesor")
@Data
public class Profesor implements Serializable {

    @Id
    private Long prof_id;

    private String nombre;

    private String direccion;

    private String telefono;

    //Relaciones
    private List<Curso> listCurso;

}
