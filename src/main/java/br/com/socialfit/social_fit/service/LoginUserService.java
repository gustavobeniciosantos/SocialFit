package br.com.socialfit.social_fit.service;

import br.com.socialfit.social_fit.entity.User;
import br.com.socialfit.social_fit.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class LoginUserService {

    @Autowired
    private UserRepository userRepository;

    public Optional<User> loginUser(String username, String password){

        return userRepository.findUserByUsernameAndPassword(username, password);
  }


}