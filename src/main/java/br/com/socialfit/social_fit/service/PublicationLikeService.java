package br.com.socialfit.social_fit.service;


import br.com.socialfit.social_fit.entity.PublicationLike;
import br.com.socialfit.social_fit.repositories.PublicationLikeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PublicationLikeService {

    private PublicationLikeRepository publicationLikeRepository;

    public List<PublicationLike> getAllPublicationLikes() {
        return publicationLikeRepository.findAll();
    }

    public Optional<PublicationLike> getPublicationLikeById(UUID id) {
        return publicationLikeRepository.findById(id);
    }

    public PublicationLike savePublicationLike(PublicationLike publicationLike) {
        return publicationLikeRepository.save(publicationLike);
    }

    public void deletePublicationLike(UUID id) {
        publicationLikeRepository.deleteById(id);
    }
}