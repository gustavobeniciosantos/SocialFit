package br.com.socialfit.social_fit.entity;

import jakarta.persistence.*;
import lombok.Data;

import org.hibernate.validator.constraints.UUID;
@Data
@Entity
@Table(name = "publication_table")
public class Publication {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "userID", nullable = false)
    private User user;

    private String publicationText;
}