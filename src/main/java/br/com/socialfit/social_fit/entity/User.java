package br.com.socialfit.social_fit.entity;



import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;
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
import com.fasterxml.jackson.annotation.JsonFormat;


import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;

@Data
@Entity(name = "users")
public class User {

    public interface WithoutPasswordView {};
    public interface WithPasswordView extends WithoutPasswordView {};

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @JsonView(WithoutPasswordView.class)
    private UUID id;
    @NotBlank
    @JsonView(WithoutPasswordView.class)
    private String name;
    @JsonView(WithoutPasswordView.class)
    @NotBlank
    @Pattern(regexp = "^[a-zA-Z0-9]+$", message = "O campo [username] não deve conter espaço")
    private String username;
    @JsonView(WithPasswordView.class)
    @NotBlank
    @Length(min = 8, max = 100, message = "A senha deve ter entre 10 e 100 caracteres")
    private String password;
    @JsonView(WithoutPasswordView.class)
    @NotBlank
    @Email(message = "O campo [email] deve conter um e-mail válido")
    private String email;
    @JsonView(WithoutPasswordView.class)
    @NotBlank
    private String telephone;
    @JsonView(WithoutPasswordView.class)
    @CPF
    @NotBlank
    private String CPF;
    @JsonView(WithoutPasswordView.class)
    @NotBlank
    private String fullAddress;
    @JsonView(WithoutPasswordView.class)
    @NotBlank
    private String nationality;
    @JsonView(WithoutPasswordView.class)
    @NotBlank
    private String gender;
    @JsonView(WithoutPasswordView.class)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private Date birthDate;
    @JsonView(WithoutPasswordView.class)
    @NotNull
    private double weight;
    @JsonView(WithPasswordView.class)
    @CreationTimestamp
    private LocalDateTime createdAt;

}
