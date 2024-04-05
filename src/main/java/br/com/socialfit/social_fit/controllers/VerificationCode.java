package br.com.socialfit.social_fit.controllers;

import br.com.socialfit.social_fit.service.GenerateCode;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


public class VerificationCode {
    private int code;
    public int getCode() {

        return this.code = GenerateCode.generatedCode();
    }
}

