package com.example.travel.service;


import com.example.travel.dao.GreatDao;
import com.example.travel.domain.Great;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GreatService {
    @Autowired
    GreatDao greatDao;

    public List<Great> findByAidAndUid(int aid, int uid) {
        return greatDao.find(aid,uid);
    }

    public void delete(int id) {
        greatDao.delete(id);
    }

    public void saveAndFlush(Great great) {
        greatDao.add(great);
    }
}
