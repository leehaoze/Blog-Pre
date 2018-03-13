package edu.controller;

import edu.dao.Impl.ArticleDaoImpl;
import edu.dao.Impl.userDaoImpl;
import edu.dao.userDao;
import edu.pojo.UserEntity;
import edu.service.Impl.activityServiceImpl;
import edu.service.Impl.articleServiceImpl;
import edu.service.Impl.userServiceImpl;
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


}
