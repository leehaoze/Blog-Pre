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
}
