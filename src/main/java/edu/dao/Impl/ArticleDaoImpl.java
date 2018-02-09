package edu.dao.Impl;

import com.sun.tools.corba.se.idl.constExpr.Not;
import edu.dao.ArticleDao;
import util.HibernateUtil;
import edu.pojo.ArticleEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ArticleDaoImpl implements ArticleDao{
    private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    /**
     * 不存在异常
     * FIXME 我不知道应不应该写在这里 先凑合一下
     */
    @ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "No Such Blog")//404 Not Found
    public class NotFoundException extends RuntimeException {
        public NotFoundException(String message) {
            super(message);
        }
    }
    /**
     * 通用查询函数,传入查询语句,返回查询结果
     * @param query 查询语句 HQL或者SQL
     * FIXME 如果查询结果为空 应该要处理一下
     * @return 查询结果
     */
    private List commonQuery(String query){
        Session session = sessionFactory.openSession();
        List list = session.createQuery(query).list();
        session.close();
        if(list.size() == 0)
            throw new NotFoundException("Not Found");
        return list;
    }


    /**
     * {@inheritDoc}
     * @return
     */
    @Override
    public ArrayList<ArticleEntity> getAllArticles() {
        return (ArrayList<ArticleEntity>) commonQuery("from ArticleEntity");
    }


    /**
     * {@inheritDoc}
     * @return
     */
    @Override
    public ArrayList<String> getAllArticlesTitle() {
        return (ArrayList<String>) commonQuery("select title from ArticleEntity");
    }

    /**
     * {@inheritDoc}
     * @param id 文章ID
     * @return
     * (FIXME 这一了方便前台测试 返回值是List 可以直接返回实体类; 也可以这里不做修改,有Service处理)
     */
    @Override
    public List getArticleById(Integer id) {
        return  commonQuery("from ArticleEntity where id = " + id.toString());
    }

    /**
     * {@inheritDoc}
     * @param id 文章ID
     * @return
     */
    @Override
    public List getTitleById(Integer id) {
        return commonQuery("select title from ArticleEntity where id = " + id.toString());
    }

    /**
     * {@inheritDoc}
     * @param id 文章ID
     * @return
     */
    @Override
    public List getDescription(Integer id) {
        return commonQuery("select description from ArticleEntity where id = " + id.toString());
    }

    /**
     *
     * @param id
     * @return
     */
    @Override
    public List getTitleAndDescription(Integer id) {
        return null;
    }

    /**
     *
     * @return
     */
    @Override
    public List getTitlesAndId() {
        return commonQuery("select id,title from ArticleEntity");
    }
}
