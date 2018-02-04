package edu.dao.Impl;

import edu.dao.HibernateUtil;
import edu.dao.UserDao;
import edu.pojo.UserEntity;
import java.util.List;

import org.springframework.orm.hibernate4.HibernateCallback;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import javax.management.Query;

public class UserDaoImpl extends HibernateDaoSupport implements UserDao {


    public UserEntity getUserById(int id) {
        return null;
    }






}
