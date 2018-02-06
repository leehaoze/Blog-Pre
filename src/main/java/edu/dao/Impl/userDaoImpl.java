package edu.dao.Impl;

import edu.dao.HibernateUtil;
import edu.dao.userDao;
import edu.pojo.UserEntity;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;


import org.hibernate.Query;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

@Repository
public class userDaoImpl implements userDao {

    private SessionFactory sessionFactory;
    private Session session;

    public List<UserEntity> getAllUsers() {
        session = HibernateUtil.getSessionFactory().openSession();
        List list = session.createQuery("from UserEntity").list();
        session.close();

        return list;
    }
    public ArrayList<UserEntity> getUserById(Integer id){
        session = HibernateUtil.getSessionFactory().openSession();
        UserEntity userEntity = (UserEntity)session.get(UserEntity.class, id);
        ArrayList<UserEntity> list = new ArrayList<UserEntity>();
        list.add(userEntity);

        return list;
    }
}
