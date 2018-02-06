package edu.controller;

import edu.dao.Impl.ArticleDaoImpl;
import edu.pojo.ArticleEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;

@Controller
public class testController {
    @Autowired
    ArticleDaoImpl articleDao;

    @RequestMapping("/testGetAllArticles")
    @ResponseBody
    public ArrayList<ArticleEntity> getAllArticles(){
        return articleDao.getAllArticles();
    }
}
