package edu.controller;

import edu.service.Impl.activityServiceImpl;
import edu.service.Impl.userServiceImpl;
import edu.service.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ActivityController {
    @Autowired
    private activityServiceImpl activityService;
    @RequestMapping("/Login")
    public String test(){
        return "Login";
    }
    @RequestMapping("/userLogin")
    public String Login(@RequestParam String username, @RequestParam String password){
//        System.out.println("username:" + username);
//        System.out.println("password:"  + password);
//        if (activityService.Login(username, password) == true){
//            return "index";
//        }
//        else
//            return "fail";
        return "none";
    }
}
