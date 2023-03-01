package com.example.DavidSisalimaM5A.service;

import com.example.DavidSisalimaM5A.entity.Depto;
import com.example.DavidSisalimaM5A.repository.IDeptoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class IDeptoServiceImp extends  GenericServiceImpl<Depto,Long> implements  IDeptoService {

    @Autowired
    private IDeptoRepository deptoRepository;
    @Override
    public CrudRepository<Depto, Long> getDao() {
        return deptoRepository;
    }

}
