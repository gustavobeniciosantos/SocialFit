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
public class CreateUserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    EmailService emailService;
    public User executeRegister(User user){


        this.userRepository.findByUsernameOrEmailOrCPF(user.getUsername(), user.getEmail(), user.getCPF()).ifPresent((users) -> {
            throw new UserFoundExeption();
        });
        try {
            emailService.sendMailConfirm(user.getEmail());
        } catch (MessagingException | IOException e) {
            e.printStackTrace();
        }
        return this.userRepository.save(user);
    }

}
