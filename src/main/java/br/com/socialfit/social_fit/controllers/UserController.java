package br.com.socialfit.social_fit.controllers;



import br.com.socialfit.social_fit.entity.User;
import br.com.socialfit.social_fit.entity.UserRepository;
import br.com.socialfit.social_fit.exeption.UserFoundExeption;
import br.com.socialfit.social_fit.useCases.CreateUser;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private CreateUser createUser;
    @PostMapping("/signup")
    public ResponseEntity<Object> createUser(@RequestBody @Valid User user){

        try {
           var result = this.createUser.execute(user);
           return ResponseEntity.ok().body(result);
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }


}
