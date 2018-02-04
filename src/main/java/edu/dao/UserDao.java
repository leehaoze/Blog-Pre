package edu.dao;

import edu.pojo.UserEntity;
import java.util.List;
public interface UserDao {
    //前n条数据
    public UserEntity getUserById(int id);
}
