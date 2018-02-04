package edu.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;

@org.springframework.stereotype.Controller

public class Controller {
    @RequestMapping("/getIndexIMG")
    @ResponseBody
    public ArrayList<String> getIndexIMG(){
        ArrayList<String> img = new ArrayList<String>();
        img.add("ShangHai01.jpg");
        img.add("ShangHai02.jpg");
        return img;
    }
}
