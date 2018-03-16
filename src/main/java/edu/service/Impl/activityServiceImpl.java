package edu.service.Impl;

import edu.dao.Impl.ActivityDaoImpl;
import edu.service.activityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;

@Service
public class activityServiceImpl implements activityService {
    @Autowired
    private ActivityDaoImpl dao;

    @Override
    public ArrayList<String> getIndexIMG() {
        return dao.getIndexIMG();
    }

    @Override
    public HashMap<String, String> getInfo() {
        HashMap<String,String> result = new HashMap<>();
        result.put("head_pic_path",dao.getHeadPicPath());
        result.put("bloger_name",dao.getBlogerName());
        result.put("quoto",dao.getQuoto());
        result.put("name_font",dao.getNameFont());
        result.put("quoto_font",dao.getQuotoFont());
        result.put("qq",dao.getQQ());
        result.put("wechat",dao.getWeChat());
        result.put("github",dao.getGitHub());
        result.put("email",dao.getEmail());
        result.put("blog","");
        return result;
    }

    @Override
    public String getHeadPic() {
        return dao.getHeadPicPath();
    }
}
