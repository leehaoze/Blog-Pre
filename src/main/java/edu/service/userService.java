package edu.service;

import edu.pojo.UserEntity;

import java.util.ArrayList;
import java.util.List;

public interface userService {
    public List<UserEntity> getAllUser();
    public ArrayList<UserEntity> getUserById(Integer id);
}
