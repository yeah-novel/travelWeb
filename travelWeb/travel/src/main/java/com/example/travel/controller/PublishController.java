package com.example.travel.controller;

import com.example.travel.domain.Spot;
import com.example.travel.domain.UserLog;
import com.example.travel.service.PublishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PublishController {
    @Autowired
    private PublishService pubishService;

    @GetMapping("/toPublishPhotoPage")
    public String toPublishPhotoPage() {
        return "publishPhoto";
    }

    @PostMapping("/PublishPhoto")
    public String publishPhoto(Spot spot, Model model){
        int result = pubishService.PublishPhoto(spot);
        System.out.println(result);
        return "publishPhoto";
    }

    @GetMapping("/toPublishLogPage")
    public String toPublishLogPage() {
        return "publishLog";
    }

    @PostMapping("/PublishLog")
    public  String publishLog(UserLog log){
        return pubishService.PublishLog(log);
    }
}
