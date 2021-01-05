package com.gicheol.springbootauth.mail;

import com.gicheol.springbootauth.util.AuthNumber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.thymeleaf.spring5.SpringTemplateEngine;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import org.thymeleaf.context.Context;

@Component
public class AuthNumberSendMail {

    @Autowired
    JavaMailSender javaMailSender;

    @Autowired
    SpringTemplateEngine templateEngine;

    public String sendMail(String email) throws MessagingException {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);

        mimeMessageHelper.setSubject("인증번호 발송합니다.");
        mimeMessageHelper.setTo(email);

        Context context = new Context();
        int authNumber = AuthNumber.generateAuthNumber();


        String authMail = "안녕하세요. 2차 인증 테스트 페이지입니다. 인증번호는 " + authNumber + " 입니다.";

        context.setVariable("authMail", authMail);

        String html = templateEngine.process("mail/sendMail", context);

        mimeMessageHelper.setText(html, true);

        javaMailSender.send(mimeMessage);


        return Integer.toString(authNumber);
    }
}
