package com.example.travel.dao;

import com.example.travel.domain.UserLog;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserLogDao {

    public int insert(UserLog log); //添加用户心得分享
}
