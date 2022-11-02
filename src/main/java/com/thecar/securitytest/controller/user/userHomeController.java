package com.thecar.securitytest.controller.user;

import com.thecar.securitytest.security.UserInfo;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/user")
public class userHomeController {

    @RequestMapping("/main.do")
    public String main (HttpServletRequest request, HttpServletResponse response, Model model , @AuthenticationPrincipal UserInfo user) {
        System.err.println(user.getPhoneNumber());
        System.err.println("@@@성공기원 user main.do");
        model.addAttribute("number", user.getPhoneNumber());
        model.addAttribute("name", user.getName());
        model.addAttribute("gender", user.getGender());
        model.addAttribute("address", user.getAddress());
        model.addAttribute("user", user);
        return "/user/userMain";
    }
}
