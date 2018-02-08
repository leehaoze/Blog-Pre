package edu.dao;

import edu.pojo.ArticleEntity;

import java.util.ArrayList;
import java.util.List;

public interface ArticleDao {
    /**
     * 查询所有的文章
     * @return 文章实体类的List
     */
    public ArrayList<ArticleEntity> getAllArticles();

    /**
     * 查询所有文章的标题
     * @return 标题的集合
     */
    public ArrayList<String> getAllArticlesTitle();

    /**
     * 根据ID查询文章
     * @param id 文章ID
     * @return 包含被查询文章的List
     */
    public List getArticleById(Integer id);

    /**
     * 根据ID查询文章题目
     * @param id 文章ID
     * @return 文章题目
     */
    public List getTitleById(Integer id);

    /**
     * 根据ID查询文章描述
     * @param id 文章ID
     * @return 文章描述
     */
    public List getDescription(Integer id);

    /**
     * 根据ID获取标题和描述
     * @param id
     * @return
     */
    public List getTitleAndDescription(Integer id);


    public List getTitlesAndId();
}
