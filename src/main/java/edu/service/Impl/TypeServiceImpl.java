package edu.service.Impl;

import edu.dao.Impl.TypeDaoImpl;
import edu.pojo.TypeEntity;
import edu.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
@Service
public class TypeServiceImpl implements TypeService{
    @Autowired
    private TypeDaoImpl dao;

    @Override
    public ArrayList<String> getAllTypesName() {
        return dao.getAllNames();
    }

    @Override
    public ArrayList<TypeEntity> getAllTypes() {
        return dao.getAllTypes();
    }
}
