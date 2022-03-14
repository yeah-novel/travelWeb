package com.example.travel.controller;

import com.example.travel.domain.Great;
import com.example.travel.domain.Spot;
import com.example.travel.service.GreatService;
import com.example.travel.service.SpotService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.transaction.Transactional;
import java.util.List;

@Controller
public class DiggController {
    @Autowired
    private GreatService greatService;

    @Autowired
    private SpotService spotService;

    @Autowired
    public DiggController(GreatService greatService) {
        this.greatService = greatService;
    }
    @RequestMapping({"/","/index"})
    public String index(){
        return "index";
    }

    //添加事务支持
    @Transactional
    @RequestMapping("/great")
    public String great(@Param("aid") int aid, @Param("uid") int uid, Model model){

        //查询是否有该用户对该文章的点赞记录
        List<Great> list=greatService.findByAidAndUid(aid,uid);
        if (list!=null && list.size()>0){
            //如果找到了这条记录，则删除该记录，同时文章的点赞数减1
            Great great=list.get(0);
            //删除记录
            greatService.delete(great.getId());
            //文章点赞数减1
            Spot spot=spotService.getOneSpot(aid);
            spot.setGreatNum(spot.getGreatNum()-1);
            spotService.saveAndFlush(spot);
        }else {
            //如果没有找到这条记录，则添加这条记录，同时文章点赞数加1
            Great great=new Great();
            great.setAid(aid);
            great.setUid(uid);
            //添加记录
            greatService.saveAndFlush(great);
            //文章点赞数加1
            Spot spot=spotService.getOneSpot(aid);
            spot.setGreatNum(spot.getGreatNum()+1);
            spotService.saveAndFlush(spot);
        }
        return "detail";
    }
}
