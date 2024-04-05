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

import java.io.IOException;
import java.nio.charset.Charset;

@Service

public class EmailService {

    @Autowired
    private JavaMailSender javaMailSender;
    public void sendMailConfirm(String emailDestinatario) throws MessagingException, IOException {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);

        helper.setTo(emailDestinatario);
        helper.setSubject("Confirmação de Conta");

        ClassPathResource resource = new ClassPathResource("templates/confirmation.html");
        String htmlContent = StreamUtils.copyToString(resource.getInputStream(), Charset.defaultCharset());


        helper.setText(htmlContent, true);

        javaMailSender.send(mimeMessage);
    }
}
