package com.example.DavidSisalimaM5A.repository;

import com.example.DavidSisalimaM5A.entity.Curso;
import com.example.DavidSisalimaM5A.service.IGenericService;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ICursoRepository extends MongoRepository<Curso,Long> {
}
