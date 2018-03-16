package edu.service;

import edu.pojo.TypeEntity;

import java.util.ArrayList;


public interface TypeService {
    public ArrayList<String> getAllTypesName();

    public ArrayList<TypeEntity> getAllTypes();

}
