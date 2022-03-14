package com.example.travel.dao;

import com.example.travel.domain.Image;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ImageDao {

	public List<Image> getImageBySpotId(Long spotId);
	
	public int deleteImageBySpotId(Long spotid);//根据景点编号删除图片
	
	public int updateImage(Image image);
}
