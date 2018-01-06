import edu.dao.HibernateUtil;
import edu.pojo.ArticleEntity;
import edu.pojo.TagEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class hibernateTest {
    private Session session;
    private Transaction transaction;

    private static final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();


    @Before
    public void init() {
        // 会话对象
        session = sessionFactory.openSession();
        //开启事务
        transaction = session.beginTransaction();
    }

    @After
    public void destory() {
        transaction.commit(); //提交事务
        session.close(); //关闭会话
        sessionFactory.close(); //关闭会话工厂
    }

    @Test
    public void testSaveTag() {
        TagEntity tagEntity = new TagEntity();
        tagEntity.setName("1");
        tagEntity.setNum(0);
        session.save(tagEntity); //保存对象进入数据库
    }

    @Test
    public void testSaveArticle(){
        ArticleEntity articleEntity=new ArticleEntity();
        articleEntity.setTitle("TEST ARTICLE");
        articleEntity.setFrom(true);
        articleEntity.setAuthorId(0);
        articleEntity.setCount(0);
        session.save(articleEntity);
    }

}
