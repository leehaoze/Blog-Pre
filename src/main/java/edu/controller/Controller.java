package edu.controller;

import edu.dao.Impl.userDaoImpl;
import edu.dao.userDao;
import edu.pojo.UserEntity;
import edu.service.Impl.userServiceImpl;
import edu.service.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@org.springframework.stereotype.Controller

public class Controller {
//    @Autowired
//    private userService userservice;
    @Autowired
    private userServiceImpl userService;

    @RequestMapping("/getIndexIMG")
    @ResponseBody
    public ArrayList<String> getIndexIMG(){
        ArrayList<String> img = new ArrayList<String>();
        img.add("IMG/ShangHai01.jpg");
        img.add("IMG/ShangHai02.jpg");
        return img;
    }

    @RequestMapping("/getInfo")
    @ResponseBody
    public HashMap<String,String> getInfo(){
        HashMap<String,String> info = new HashMap<String, String>();
        info.put("head_pic_path","IMG/Head-pic.jpg");
        info.put("bloger_name","Leehaoze");
        info.put("quoto","Code & Life");
        info.put("name_font","Cookie");
        info.put("quoto_font","Lato");

        info.put("qq","http://wpa.qq.com/msgrd?v=3&uin=986989635&site=qq&menu=yes");
        info.put("wechat","none");
        info.put("github","https://github.com/leehaoze");
        info.put("email","Mailto:leehaoze@outlook.com");
        info.put("blog","#");

        info.put("qq_img","/IMG/QQ-Logo");

        return info;
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
