package edu.dao.Impl;

import edu.dao.HibernateUtil;
import edu.dao.userDao;
import edu.pojo.UserEntity;
import java.util.List;
import org.hibernate.SessionFactory;


import org.hibernate.Query;


public class userDaoImpl implements userDao {

    private SessionFactory sessionFactory;

    public List<UserEntity> getAllUsers() {
        sessionFactory = HibernateUtil.getSessionFactory();
        String hql = "from UserEntity";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        return query.list();
    }
}
