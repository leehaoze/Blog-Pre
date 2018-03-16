package edu.dao.Impl;

import org.hibernate.SessionFactory;
import util.HibernateUtil;
import edu.dao.ActivityDao;

import org.springframework.stereotype.Repository;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class ActivityDaoImpl implements ActivityDao {
    private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    private List commonQuery(String query) {
        Session session = sessionFactory.openSession();
        List list = session.createQuery(query).list();
        session.close();
        if (list.size() == 0)
            return null;
        return list;
    }

    /**
     * 获取图片路径并整理成ArrayList
     * FIXME 缺少一个异常处理 处理返回值为null
     */
    public ArrayList<String> getIndexIMG() {
        String result = (String)commonQuery("select indexPic from SiteConfEntity").get(0);
        ArrayList<String> list;
        list = new ArrayList<String>(Arrays.asList(result.split(",")));
        return list;
    }

    @Override
    public String getHeadPicPath() {
        return (String)commonQuery("select headPic from SiteConfEntity").get(0);
    }

    @Override
    public String getBlogerName() {
        return (String)commonQuery("select blogerName from SiteConfEntity").get(0);
    }

    @Override
    public String getQuoto() {
        return (String)commonQuery("select quoto from SiteConfEntity").get(0);
    }

    @Override
    public String getNameFont() {
        return (String)commonQuery("select nameFont from SiteConfEntity").get(0);
    }

    @Override
    public String getQuotoFont() {
        return (String)commonQuery("select quotoFont from SiteConfEntity").get(0);
    }

    @Override
    public String getQQ() {
        return (String)commonQuery("select qq from SiteConfEntity").get(0);
    }

    @Override
    public String getWeChat() {
        return (String)commonQuery("select wechat from SiteConfEntity").get(0);
    }

    @Override
    public String getGitHub() {
        return (String)commonQuery("select github from SiteConfEntity").get(0);
    }

    @Override
    public String getEmail() {
        return (String)commonQuery("select email from SiteConfEntity").get(0);
    }


//    @Override
//    public boolean Login(String name, String pwd){
//        boolean isUser = false;
//
//        ArrayList<UserEntity> users = (ArrayList)getAllUsers();
//        for(UserEntity u : users){
//            if (u.getName().equals(name) && u.getPassword().equals(pwd)){
//                isUser =  true;
//                break;
//            }
//            else
//                return false;
//        }
//        return isUser;
//    }
}
