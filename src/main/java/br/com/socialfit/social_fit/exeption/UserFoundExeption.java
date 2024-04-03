package br.com.socialfit.social_fit.exeption;

public class UserFoundExeption extends RuntimeException{

    public UserFoundExeption(){
        super("Usuário já existe");

    }
}
