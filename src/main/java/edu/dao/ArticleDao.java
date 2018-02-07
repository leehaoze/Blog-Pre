package edu.dao;

import edu.pojo.ArticleEntity;

import java.util.ArrayList;

public interface ArticleDao {
    //获取所有文章
    public ArrayList<ArticleEntity> getAllArticles();

    //获取所有文章标题
    public ArrayList<String> getAllArticlesTitle();

    //根据ID获取某一特定文章
    public ArticleEntity getArticleById(Integer id);

}
