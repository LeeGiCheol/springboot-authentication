package com.gicheol.springbootauth.controller;

import com.gicheol.springbootauth.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

@Controller
public class MainPageController {

    @Autowired
    HttpSession session;

    @GetMapping("/")
    public String MainPage(Model model) {
        User user = new User();
        if (session != null) {
            user = (User) session.getAttribute("user");
        }
        if (user != null) {
            model.addAttribute("user", user);
        }

        return "main";
    }
}
