package com.example.travel.dao;

import com.example.travel.domain.Spot;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface SpotDao {

	public List<Spot> getSpotByPrice(@Param("low") double low, @Param("up") double up);//根据预算筛选
	
	public List<Spot> getSpotByTheme(@Param("theme") String theme);//根据主题筛选
	
	public List<Spot> getSpotByAddressDetail(@Param("address") String address);//根据位置筛选

	public List<Spot> getSpotByAddress(@Param("address") String address);//根据位置筛选

	public List<Spot> getSpots();

	public Spot getSpotById(int spotId);
	
	public int insertSpot(Spot spot); 
	
	public int deleteSpot(Long id);
	
	public int updateSpot(Spot spot);
}
