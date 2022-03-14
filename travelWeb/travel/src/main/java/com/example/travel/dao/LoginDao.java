package com.example.travel.dao;

import com.example.travel.domain.Login;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LoginDao {
    public Login selectOne(String name);
    public Login selectLogin(Login login);
    public int insertOne(Login login);
}
