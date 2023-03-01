package com.example.DavidSisalimaM5A.service;

import com.example.DavidSisalimaM5A.entity.Profesor;
import com.example.DavidSisalimaM5A.repository.IProfesorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class IProfesorServiceImp extends GenericServiceImpl<Profesor,Long> implements IProfesorService {

    @Autowired
    private IProfesorRepository personaRepository;

    @Override
    public CrudRepository<Profesor, Long> getDao() {
        return personaRepository;
    }
}
