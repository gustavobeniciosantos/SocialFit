package br.com.socialfit.social_fit.entity;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {

    Optional<User> findByUsernameOrEmailOrCPF(String username, String email, String CPF);

    Optional<User> findUserByUsernameAndPassword(String username, String password);
}
