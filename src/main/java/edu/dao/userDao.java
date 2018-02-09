package edu.dao;

import edu.pojo.UserEntity;

import java.util.ArrayList;
import java.util.List;
public interface userDao {
    //前n条数据
   public List<UserEntity> getAllUsers();
   public  ArrayList<UserEntity> getUserById(Integer id);
   //public boolean Register(String name, String pwd);
}
