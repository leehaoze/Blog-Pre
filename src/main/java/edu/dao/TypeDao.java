package edu.dao;

import edu.pojo.TypeEntity;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;


public interface TypeDao {
    public ArrayList<String> getAllNames();

    public String getNameById(int id);

    public ArrayList<TypeEntity> getAllTypes();

}
