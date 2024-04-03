package br.com.socialfit.social_fit.entity;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.br.CPF;
import org.springframework.format.annotation.DateTimeFormat;


import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;

@Data
@Entity(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @NotBlank
    private String name;
    @NotBlank
    @Pattern(regexp = "^[a-zA-Z0-9]+$", message = "O campo [username] não deve conter espaço")
    private String username;
    @NotBlank
    @Length(min = 8, max = 100, message = "A senha deve ter entre 10 e 100 caracteres")
    private String password;
    @NotBlank
    @Email(message = "O campo [email] deve conter um e-mail válido")
    private String email;
    @NotBlank
    private String telephone;
    @CPF
    @NotBlank
    private String CPF;
    @NotBlank
    private String fullAddress;
    @NotBlank
    private String nationality;
    @NotBlank
    private String gender;
    @DateTimeFormat
    private Date birthDate;
    @NotNull
    private double weight;
    @CreationTimestamp
    private LocalDateTime createdAt;
}
