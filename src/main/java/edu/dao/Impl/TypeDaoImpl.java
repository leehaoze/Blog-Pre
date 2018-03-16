package edu.dao.Impl;

import edu.dao.TypeDao;
import edu.pojo.TypeEntity;
import edu.pojo.model.Type;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import util.HibernateUtil;

import java.util.ArrayList;
import java.util.List;

@Repository
public class TypeDaoImpl implements TypeDao{
    private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    /**
     *
     * @param query
     * FIXME 未处理异常
     * @return
     */
    private List commonQuery(String query){
        Session session = sessionFactory.openSession();
        List list = session.createQuery(query).list();
        session.close();
        return list;
    }

    @Override
    public ArrayList<String> getAllNames() {
        return (ArrayList<String>) commonQuery("select name from TypeEntity");
    }

    /**
     *
     * @param id
     * FIXME 存在查询为空的异常
     * @return
     */
    @Override
    public String getNameById(int id) {
        return (String)commonQuery("select name from TypeEntity where id = " + id).get(0);
    }

    @Override
    public ArrayList<TypeEntity> getAllTypes() {
        return (ArrayList<TypeEntity>)commonQuery("from TypeEntity");
    }
}
