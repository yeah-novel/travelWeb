package com.example.travel.service;

import com.example.travel.dao.SpotDao;
import com.example.travel.dao.UserLogDao;
import com.example.travel.domain.Spot;
import com.example.travel.domain.UserLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PublishService {

    @Autowired
    private UserLogDao userLogDao;
    @Autowired
    private SpotDao spotDao;

    public int PublishPhoto(Spot spot) {
        spot.setStatus(0);
        spot.setGreatNum(0);
        int flag= spotDao.insertSpot(spot);
        return flag;
    }

    public String PublishLog(UserLog log) {
        int flag = userLogDao.insert(log);
        if(flag>0) return "succ";
        return "err";
    }
}
