package br.com.socialfit.social_fit.useCases;

import br.com.socialfit.social_fit.entity.User;
import br.com.socialfit.social_fit.entity.UserRepository;
import br.com.socialfit.social_fit.exeption.UserFoundExeption;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//Serve para realizar a regra de negócio para criação de um novo usuário
@Service
public class CreateUser {
    @Autowired
    private UserRepository userRepository;
    public User execute(User user){

        System.out.println(user);
        this.userRepository.findByUsernameOrEmail(user.getUsername(), user.getEmail()).ifPresent((users) -> {
            throw new UserFoundExeption();
        });
        return this.userRepository.save(user);

    }
}
