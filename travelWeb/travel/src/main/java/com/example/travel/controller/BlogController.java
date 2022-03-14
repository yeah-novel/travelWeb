package com.example.travel.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BlogController {
    @GetMapping("/toBlogPage")
    public String toLoginPage() {
        return "blog";
    }
    @GetMapping("/toBlogDetailPage")
    public String toBlogDetailPage() {
        return "blogdetails";
    }
}
