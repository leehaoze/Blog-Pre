package edu.service.Impl;

import edu.dao.Impl.activityDaoImpl;
import edu.dao.userDao;
import edu.service.activityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class activityServiceImpl implements activityService {
    @Autowired
    private activityDaoImpl activityDao;
    public boolean Login(String name, String pwd){
        return activityDao.Login(name, pwd);
    }
}
