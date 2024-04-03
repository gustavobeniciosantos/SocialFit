package br.com.socialfit.social_fit.service;

import br.com.socialfit.social_fit.entity.User;
import br.com.socialfit.social_fit.entity.UserRepository;
import br.com.socialfit.social_fit.exeption.UserFoundExeption;
import jakarta.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

//Serve para realizar a regra de negócio para criação de um novo usuário
@Service
public class CreateUser {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    EmailService emailService;
    public User executeRegister(User user){

        this.userRepository.findByUsernameOrEmailOrCPF(user.getUsername(), user.getEmail(), user.getCPF()).ifPresent((users) -> {
            throw new UserFoundExeption();
        });
        try {
            emailService.enviarEmailConfirmacao(user.getEmail());
        } catch (MessagingException | IOException e) {
            // Trate exceções de envio de e-mail aqui
            e.printStackTrace();
        }
        return this.userRepository.save(user);
    }

}
