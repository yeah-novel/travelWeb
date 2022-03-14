package com.example.travel.service;

import com.example.travel.dao.SpotDao;
import com.example.travel.domain.Spot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SpotService {
    @Autowired
    private SpotDao spotDao;

    public List<Spot> getSpotByDetailAddress(String address){
        List<Spot> spotList = spotDao.getSpotByAddressDetail(address);
        return spotList;
    }

    public List<Spot> getSpotByAddress(String address){
        List<Spot> spotList = spotDao.getSpotByAddress(address);
        return spotList;
    }

    public List<Spot> getSpotByTheme(String theme){
        List<Spot> spotList = spotDao.getSpotByTheme(theme);
        return spotList;
    }

    public List<Spot> getSpotByPrice(double low, double up){
        List<Spot> spotList = spotDao.getSpotByPrice(low, up);
        return spotList;
    }

    public List<Spot> getAllSpot() {
        List<Spot> spotList = spotDao.getSpots();
        return spotList;
    }

    public Spot getOneSpot(int spotId) {
        Spot spot = spotDao.getSpotById(spotId);
        return spot;
    }

    public void saveAndFlush(Spot spot) {
        spotDao.updateSpot(spot);
    }
}
