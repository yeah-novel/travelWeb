package com.example.travel.dao;

import com.example.travel.domain.Great;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface GreatDao {

    public List<Great> find(int aid, int uid);

    public void delete(int id);

    public void add(Great great);
}
