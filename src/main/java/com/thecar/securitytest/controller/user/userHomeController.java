package com.thecar.securitytest.controller.user;

import com.thecar.securitytest.security.UserInfo;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/user")
public class userHomeController {

    @RequestMapping("/main.do")
    public String main (HttpServletRequest request, HttpServletResponse response, @AuthenticationPrincipal UserInfo user) {
        System.err.println("@@@성공기원 user main.do");
        return "/user/userMain";
    }
}
