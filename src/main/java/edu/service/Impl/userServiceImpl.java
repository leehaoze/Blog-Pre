package edu.service.Impl;

import edu.dao.Impl.userDaoImpl;
import edu.pojo.UserEntity;
import edu.service.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class userServiceImpl implements userService {
    @Autowired
    private userDaoImpl userDao;
    @Override
    public List<UserEntity> getAllUser() {
        return userDao.getAllUsers();
    }
    @Override
    public ArrayList<UserEntity> getUserById(Integer id){
        return userDao.getUserById(id);
    }

}
