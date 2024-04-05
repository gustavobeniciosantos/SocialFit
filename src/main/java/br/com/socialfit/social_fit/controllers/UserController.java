package br.com.socialfit.social_fit.controllers;


import com.fasterxml.jackson.annotation.JsonView;
import br.com.socialfit.social_fit.entity.User;
import br.com.socialfit.social_fit.service.CreateUser;
import br.com.socialfit.social_fit.service.LoginUser;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.Optional;


@RestController
@RequestMapping("/")
public class UserController {

    @Autowired
    private CreateUser createUser;

    @Autowired
    private LoginUser loginUser;
    
    @JsonView(User.WithoutPasswordView.class)
    @PostMapping("/signup")
    public ResponseEntity<Object> createUser(@RequestBody @Valid User user ){

        try {
           this.createUser.executeRegister(user);
           return ResponseEntity.created(URI.create("/"+user.getId())).body(user);
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }//registrar



    @PostMapping("/signin")
    public ResponseEntity<Object> login(@RequestBody User user)  {

        Optional<User> foundUser = loginUser.loginUser(user.getUsername(), user.getPassword());

        if (foundUser.isPresent()) {

            return ResponseEntity.ok().body(user);
        } else {
            return ResponseEntity.badRequest().body("Username or Passsword invalid");
        }


    }



}
