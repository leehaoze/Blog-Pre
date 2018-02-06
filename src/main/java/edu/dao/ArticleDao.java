package edu.dao;

import edu.pojo.ArticleEntity;

import java.util.ArrayList;

public interface ArticleDao {
    //获取所有文章
    public ArrayList<ArticleEntity> getAllArticles();

    //获取所有文章标题
    public ArrayList<String> getAllArticlesTitle();

}
