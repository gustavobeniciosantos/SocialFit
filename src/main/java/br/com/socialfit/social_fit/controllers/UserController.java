package br.com.socialfit.social_fit.controllers;


import br.com.socialfit.social_fit.service.*;
import com.fasterxml.jackson.annotation.JsonView;
import br.com.socialfit.social_fit.entity.User;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.Optional;



@Controller
@RequestMapping("/")
public class UserController {

    @Autowired
    private CreateUser createUser;

    @Autowired
    private LoginUser loginUser;

    @Autowired
    GetUserService getUserService;

    @Autowired
    GenerateCode generateCode;
    AuthCodeService authCodeService = new AuthCodeService();

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

    @RequestMapping("/signin/auth")
    public String authScreen(){
        generateCode.generateNewCode();
        return "authCode";
    }

    @PostMapping("/signin/verify")
    public ResponseEntity<Object> authCode(@RequestBody VerificationCode verificationCode){

        if(authCodeService.isHim(GenerateCode.generatedCode(),verificationCode.getCode())){

            return ResponseEntity.ok().body("Corrigo correto");
        }

        return ResponseEntity.badRequest().body("Código incorreto");
    }
    @GetMapping("/user/{username}")
    public ResponseEntity<Object> getUser(@PathVariable String username){
        Optional<User> userOptional = getUserService.getUserRepository(username);

        if(userOptional.isPresent()){
            User user = userOptional.get();
            return ResponseEntity.ok().body(user);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
        }
    }


}
