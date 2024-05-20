package br.com.socialfit.social_fit.service;

import br.com.socialfit.social_fit.entity.User;
import br.com.socialfit.social_fit.exeption.UserFoundExeption;
import br.com.socialfit.social_fit.repositories.UserRepository;
import jakarta.mail.MessagingException;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.UUID;


@Service
public class UserService {
    @Autowired
    private EmailService emailService;
    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(UUID id) {
        return userRepository.findById(id).orElse(null);
    }

    public User createUser(@NotNull User user) {

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


    public void deleteUser(UUID id) {
        userRepository.deleteById(id);
    }
}