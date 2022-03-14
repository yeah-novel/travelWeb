package com.example.travel.controller;

import com.example.travel.domain.Login;
import com.example.travel.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@Controller
public class LoginController {
    @Autowired
    private LoginService loginService;

    /**
     * 获取并封装当前年份跳转到登录页login.html
     *
     * @param model
     * @return
     */

    @PostMapping("/toLogin")
    public String toLogin(Login login, Model model, HttpSession session, HttpServletRequest request, HttpServletResponse response) {
        Login l = loginService.doLogin(login);
        if(l!=null){
//            // 将登录用户信息保存到session中
            session.setAttribute("user", l);
//            // 保存cookie，实现自动登录
//            Cookie cookie_username = new Cookie("cookie_username", l.getUserPhone());
//            // 设置cookie的持久化时间，30天
//            cookie_username.setMaxAge(30 * 24 * 60 * 60);
//            // 设置为当前项目下都携带这个cookie
//            cookie_username.setPath(request.getContextPath());
//            // 向客户端发送cookie
//            response.addCookie(cookie_username);
            return "forward:/AllSpots";
        }
        session.setAttribute("user", null);
        return "order";
    }
    @GetMapping("/toLoginPage")
    public String toLoginPage() {
        return "order";
    }

    @GetMapping("/toRegisterPage")
    public String toRegisterPage() {
        return "register";
    }

    @PostMapping("/toRegister")
    public String toRegister(Login login, Model model) {
        System.err.println("login=" + login);
        return loginService.doRegister(login);
    }

    @RequestMapping("/toLoginOut")
    public String toLoginOut(Model model,HttpSession session, HttpServletRequest request, HttpServletResponse response) {
        if(session.getAttribute("user")!=null)
            session.setAttribute("user",null);
        return "redirect:/AllSpots";
    }
}
