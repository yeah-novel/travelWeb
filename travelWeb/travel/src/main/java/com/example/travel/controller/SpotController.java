package com.example.travel.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.example.travel.domain.Spot;
import com.example.travel.service.SpotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class SpotController {
    @Autowired
    private SpotService spotService;

    @GetMapping("/toPortfolioPage")
    public String toPortfolioPage() {
        return "portfolio";
    }

    @GetMapping("/toPositionPage")
    public String toPositionPage() {
        return "portfolio_position";
    }

    @GetMapping("/toThemePage")
    public String toThemePage() {
        return "portfolio_theme";
    }

    @RequestMapping("/AllSpots")
    public String AllSpots(Model model, @RequestParam(defaultValue = "Budget")String pageName, @RequestParam(defaultValue = "1")String page) {
        int pageNum = Integer.parseInt(page);
        PageHelper.startPage(pageNum,12);
        //System.out.println("开始查询");
        List<Spot> list = spotService.getAllSpot();
        PageInfo<Spot> pageInfo = new PageInfo<>(list);
        //System.out.println(pageInfo.getSize());
        model.addAttribute("pageInfo",pageInfo);
        if(pageName.equals("Budget"))
            return "portfolio";
        else if(pageName.equals("Position"))
            return "portfolio_position";
        return "portfolio_theme";

    }

    @RequestMapping ("/getSpotByDetailAddress")
    public String getSpotByDetailAddress(Model model, @RequestParam(defaultValue = "BeiJing") String address, @RequestParam(defaultValue = "1")String page) {
        int pageNum = Integer.parseInt(page);
        PageHelper.startPage(pageNum,12);
        List<Spot> list = spotService.getSpotByAddress(address);
        PageInfo<Spot> pageInfo = new PageInfo<>(list);
        model.addAttribute("pageInfo",pageInfo);
        model.addAttribute("address", address);
        return "portfolio_position";
    }

    @RequestMapping ("/getSpotByAddress")
    public String getSpotByAddress(Model model, String address, @RequestParam(defaultValue = "1")String page) {
        int pageNum = Integer.parseInt(page);
        PageHelper.startPage(pageNum,12);
        //System.out.println("开始查询");
        List<Spot> list = spotService.getSpotByAddress(address);
        PageInfo<Spot> pageInfo = new PageInfo<>(list);
       // System.out.println(pageInfo.getSize());
        model.addAttribute("pageInfo",pageInfo);
        model.addAttribute("address", address);
        return "portfolio_position";
    }

    @RequestMapping ("/getSpotByPrice")
    public String getSpotByPrice(Model model, String low, String up, @RequestParam(defaultValue = "1")String page) {
        double l = Double.parseDouble(low);
        double p = Double.parseDouble(up);
        int pageNum = Integer.parseInt(page);
        PageHelper.startPage(pageNum,12);
        List<Spot> list = spotService.getSpotByPrice(l, p);
        PageInfo<Spot> pageInfo = new PageInfo<>(list);
        model.addAttribute("pageInfo",pageInfo);
        return "portfolio";
    }

    @RequestMapping ("/getSpotByTheme")
    public String getSpotByTheme(Model model, String theme, @RequestParam(defaultValue = "1")String page) {
        int pageNum = Integer.parseInt(page);
        PageHelper.startPage(pageNum,12);
        //System.out.println("开始查询");
        List<Spot> list = spotService.getSpotByTheme(theme);
        PageInfo<Spot> pageInfo = new PageInfo<>(list);
        model.addAttribute("pageInfo",pageInfo);
        return "portfolio_theme";
    }
    @RequestMapping("/toSpotDetail")
    public String toSpotDetail(Model model, @RequestParam(defaultValue = "1")String spotId){
        int id = Integer.parseInt(spotId);
        //System.out.println(id);
        Spot spot = spotService.getOneSpot(id);
        model.addAttribute("spot",spot);
        //System.out.println(spot.getImages());
        return "portfolio_details";
    }
}
