package edu.dao.Impl;

import util.HibernateUtil;
import edu.dao.activityDao;

import edu.pojo.UserEntity;
import org.springframework.stereotype.Repository;
import org.hibernate.Session;
import java.util.ArrayList;
import java.util.List;

@Repository
public class activityDaoImpl implements activityDao {
    private Session session;
    @Override
    public boolean Login(String name, String pwd){
        boolean isUser = false;

        ArrayList<UserEntity> users = (ArrayList)getAllUsers();
        for(UserEntity u : users){
            if (u.getName().equals(name) && u.getPassword().equals(pwd)){
                isUser =  true;
                break;
            }
            else
                return false;
        }
        return isUser;
    }
    public List<UserEntity> getAllUsers() {
        session = HibernateUtil.getSessionFactory().openSession();
        List list = session.createQuery("from UserEntity").list();
        session.close();

        return list;
    }
}
