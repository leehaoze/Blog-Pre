package edu.service.Impl;

import edu.dao.ArticleDao;
import edu.dao.Impl.ArticleDaoImpl;
import edu.service.articleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;

@Service
public class articleServiceImpl implements articleService {
    @Autowired
    ArticleDaoImpl articleDao = new ArticleDaoImpl();




    /**
     * {@inheritDoc}
     */
    @Override
    public List<String> getAllTitles() {
        return articleDao.getAllArticlesTitle();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getTitleById(Integer id) {
        List result = articleDao.getTitleById(id);
        return (String)result.get(0);
    }

    /**
     * {@inheritDoc}
     * @param id 文章id
     * @return
     */
    @Override
    public String getDescription(Integer id) {
        List result = articleDao.getDescription(id);
        return (String) result.get(0);
    }

    @Override
    public List getTitlesAndId() {
        return articleDao.getTitlesAndId();
    }
}
