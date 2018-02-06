package edu.dao.Impl;

import edu.dao.ArticleDao;
import edu.dao.HibernateUtil;
import edu.pojo.ArticleEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ArticleDaoImpl implements ArticleDao{
    private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    public List commonQuery(String query){
        Session session = sessionFactory.openSession();
        List list = (ArrayList) session.createQuery(query).list();
        session.close();
        return list;
    }

    @Override
    public ArrayList<ArticleEntity> getAllArticles() {
        return (ArrayList<ArticleEntity>) commonQuery("From ArticleEntity");
    }


    @Override
    public ArrayList<String> getAllArticlesTitle() {
        return null;
    }
}
