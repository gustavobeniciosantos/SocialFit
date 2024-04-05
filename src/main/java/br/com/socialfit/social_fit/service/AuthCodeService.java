package br.com.socialfit.social_fit.service;

import org.springframework.stereotype.Service;

@Service
public class AuthCodeService {

    public boolean isHim(int generatedCode, int code) {

        return generatedCode == code;

    }
}
