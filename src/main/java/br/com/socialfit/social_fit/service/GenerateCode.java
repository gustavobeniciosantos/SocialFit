package br.com.socialfit.social_fit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;
@Service
public class GenerateCode {
    Random random = new Random();
    static int code;

    public void generateNewCode(){

        code = 100000 + random.nextInt(900000);

        System.out.println("1 codigo "+ code);

    }

    public static int generatedCode(){
        return code;
    }

}
