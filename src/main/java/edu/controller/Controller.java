package edu.controller;

import edu.dao.Impl.ArticleDaoImpl;
import edu.dao.Impl.userDaoImpl;
import edu.dao.TypeDao;
import edu.dao.userDao;
import edu.pojo.ArticleEntity;
import edu.pojo.TypeEntity;
import edu.pojo.UserEntity;
import edu.service.Impl.activityServiceImpl;
import edu.service.Impl.articleServiceImpl;
import edu.service.Impl.userServiceImpl;
import edu.service.TypeService;
import edu.service.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@org.springframework.stereotype.Controller

public class Controller {
    @Autowired
    private userServiceImpl userService;

    @Autowired
    private articleServiceImpl articleService;

    @Autowired
    private activityServiceImpl activityService;

    @Autowired
    private TypeService typeService;

    @RequestMapping("/getIndexIMG")
    @ResponseBody
    public ArrayList<String> getIndexIMG(){
        return activityService.getIndexIMG();
    }

    @RequestMapping("/getInfo")
    @ResponseBody
    public HashMap<String,String> getInfo(){
        return activityService.getInfo();
    }

    @RequestMapping("/getDisplayArea")
    public String getDIsplayArea(){
        return "display-area";
    }

    @RequestMapping("/getArticleTitles")
    @ResponseBody
    public List getArticlesTitleAndId(){
        return articleService.getTitlesAndId();
    }



    @RequestMapping("/getUsers")
    @ResponseBody
    public List<UserEntity> getUsers(){
        return userService.getAllUser();
    }

    @RequestMapping(value = "/getUserById", produces = "application/json; charset=utf-8")
    @ResponseBody
    public ArrayList<UserEntity> getUserById(@RequestParam Integer id){
        System.out.println("Get one: "+ id);
        //int iid = Integer.parseInt(id);
        return userService.getUserById(id);
    }

    @RequestMapping("/getId")
    @ResponseBody
    public ArrayList<UserEntity> getId(){
        return userService.getUserById(1);
    }


    @RequestMapping("/getAllTypes")
    @ResponseBody
    public ArrayList<TypeEntity> getAllTypes(){
        return typeService.getAllTypes();
    }

    @RequestMapping("/getHeadPic")
    @ResponseBody
    public String getHeadPic(){
        return activityService.getHeadPic();
    }

    @RequestMapping("/getArticleList/{typeID}")
    @ResponseBody
    public ArrayList<ArticleEntity> getArticleList(@PathVariable("typeID") String typeID){
        return articleService.getArticleListById(Integer.parseInt(typeID));
    }

    @RequestMapping("/getArticle/{articleID}")
    @ResponseBody
    public ArticleEntity getArticleById(@PathVariable("articleID")int articleID){
        return articleService.getArticleById(articleID);
    }

}
