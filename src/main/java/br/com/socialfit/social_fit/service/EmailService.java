package br.com.socialfit.social_fit.service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.util.StreamUtils;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring6.SpringTemplateEngine;

import java.io.IOException;
import java.nio.charset.Charset;

@Service

public class EmailService {

    @Autowired
    private JavaMailSender javaMailSender;
    @Autowired
    private SpringTemplateEngine templateEngine;

    public void sendMailConfirm(String mailTo) throws MessagingException, IOException {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);

        helper.setTo(mailTo);
        helper.setSubject("Cadastro realizado");

        ClassPathResource resource = new ClassPathResource("templates/confirmation.html");
        String htmlContent = StreamUtils.copyToString(resource.getInputStream(), Charset.defaultCharset());


        helper.setText(htmlContent, true);

        javaMailSender.send(mimeMessage);
    }

    public void sendMailAuth(String mailTo, String name, int code) throws MessagingException {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);

        Context context = new Context();
        context.setVariable("name", name);
        context.setVariable("code", code);
        String htmlContent = templateEngine.process("sendedCode.html", context);

        helper.setTo(mailTo);
        helper.setSubject("Autenticação de 2 fatores");
        helper.setText(htmlContent, true);

        javaMailSender.send(mimeMessage);
    }




}
