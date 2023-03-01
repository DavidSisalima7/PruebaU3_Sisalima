package com.example.DavidSisalimaM5A.service;

import com.example.DavidSisalimaM5A.entity.Curso;
import com.example.DavidSisalimaM5A.repository.ICursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class ICursoImp extends GenericServiceImpl<Curso,Long> implements ICursoService {

   @Autowired
   private ICursoRepository cursoRepository;
    @Override
    public CrudRepository<Curso, Long> getDao() {
        return cursoRepository;
    }
}
