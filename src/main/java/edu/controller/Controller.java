package edu.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@org.springframework.stereotype.Controller

public class Controller {
    @RequestMapping("/getIndexIMG")
    @ResponseBody
    public ArrayList<String> getIndexIMG(){
        ArrayList<String> img = new ArrayList<String>();
        img.add("/IMG/ShangHai01.jpg");
        img.add("/IMG/ShangHai02.jpg");
        return img;
    }

    @RequestMapping("/getInfo")
    @ResponseBody
    public HashMap<String,String> getInfo(){
        HashMap<String,String> info = new HashMap<String, String>();
        info.put("head_pic_path","/IMG/Head-Pic.jpg");
        info.put("bloger_name","Leehaoze");
        info.put("quoto","Code & Life");
        info.put("na" +
                "me_font","Cookie");
        info.put("quoto_font","Lato");
        return info;
    }

}
