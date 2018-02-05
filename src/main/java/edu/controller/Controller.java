package edu.controller;

import edu.dao.Impl.userDaoImpl;
import edu.pojo.UserEntity;
import edu.service.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@org.springframework.stereotype.Controller

public class Controller {
//    @Autowired
//    private userService userservice;
    @Autowired
    private userDaoImpl userDao;
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
        info.put("head_pic_path","IMG/Head-Pic.jpg");
        info.put("bloger_name","Leehaoze");
        info.put("quoto","Code & Life");
        info.put("name_font","Cookie");
        info.put("quoto_font","Lato");
        return info;
    }
    @RequestMapping("/getUsers")
    @ResponseBody
    public List<UserEntity> getUsers(){
        return userDao.getAllUsers();
    }

}
