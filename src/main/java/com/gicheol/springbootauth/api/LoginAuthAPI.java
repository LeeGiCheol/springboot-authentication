package com.gicheol.springbootauth.api;

import com.gicheol.springbootauth.domain.User;
import com.gicheol.springbootauth.domain.UserRepository;
import com.gicheol.springbootauth.mail.AuthNumberSendMail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.Optional;

@RestController
public class LoginAuthAPI {

    @Autowired
    UserRepository userRepository;

    @Autowired
    AuthNumberSendMail authNumberSendMail;

    @Autowired
    HttpSession session;

    @PostMapping("/loginAjax")
    public String loginAjax(User inputUser) {
        Optional<User> userObject = userRepository.findById(inputUser.getId());

        if (userObject.isPresent()) {

            User user = userObject.get();

            if (user.getPassword().equals(inputUser.getPassword())) {
                session.setAttribute("user", user);

                try{
                    String authNumber = authNumberSendMail.sendMail(user.getEmail());

                    System.out.println("auth : " + authNumber);

                    session.setAttribute("authNumber", authNumber);
                } catch(Exception e) {
                    e.printStackTrace();
                }

                return "success";
            } else {
                return "fail";
            }
        }

        return "fail";
    }

    @PostMapping("/authAjax")
    public String authAjax(@RequestParam("clientAuthNumber") String clientAuthNumber) {
        String authNumber = (String) session.getAttribute("authNumber");

        if (authNumber.equals(clientAuthNumber)) {
            return "success";
        } else {
            return "fail";
        }
    }
}
