package com.example.travel.service;

import com.example.travel.dao.LoginDao;
import com.example.travel.domain.Login;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {
    @Autowired
    LoginDao loginDao;

    public Login doLogin(Login login){
        Login l = loginDao.selectLogin(login);
        return l;
    }

    public  String doRegister(Login login){
        Login l = loginDao.selectOne(login.getUserPhone());
        if(l==null){
            int flag = loginDao.insertOne(login);
            if(flag>0) {
                return "order";
            }
        }
        return "err";
    }
}
