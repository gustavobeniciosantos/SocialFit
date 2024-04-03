package br.com.socialfit.social_fit.exeption;

public class UserNotFoundExeption extends RuntimeException{
    public UserNotFoundExeption(){
        super("Usuário não encontrado");
    }
}
