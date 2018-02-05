package edu.dao.Impl;

import edu.dao.HibernateUtil;
import edu.dao.userDao;
import edu.pojo.UserEntity;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;


import org.hibernate.Query;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

@Repository
public class userDaoImpl implements userDao {

    private SessionFactory sessionFactory;

    public List<UserEntity> getAllUsers() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List list = session.createQuery("from UserEntity").list();
        return list;
    }
}
