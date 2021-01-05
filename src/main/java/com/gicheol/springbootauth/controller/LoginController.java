package com.gicheol.springbootauth.controller;

import com.gicheol.springbootauth.domain.User;
import com.gicheol.springbootauth.domain.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import java.util.Optional;

@Controller
public class LoginController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    HttpSession session;

    @PostMapping("/login")
    public String login(Model model) {

        if (session != null) {
            User user = (User) session.getAttribute("user");
            model.addAttribute("user", user);
            return "redirect:/";
        }

        return "user/login";
    }

    @GetMapping("/signUp")
    public String signUpPage() {
        return "user/signUp";
    }

    @PostMapping("/signUp")
    public String signUp(User user, Model model) {
        userRepository.save(user);

        return "redirect:/";
    }

}
