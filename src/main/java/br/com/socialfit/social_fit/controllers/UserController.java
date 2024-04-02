package br.com.socialfit.social_fit.controllers;



import br.com.socialfit.social_fit.entity.User;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @GetMapping("/getUser")
    public User getUser(){
        User user = new User();
        return user;
    }
    @PostMapping("/signin")
    public void createUser(@RequestBody @Valid User user){
        System.out.print("Candidato: ");
        System.out.println(user);

    }


}
