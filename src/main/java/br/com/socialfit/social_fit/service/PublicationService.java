package br.com.socialfit.social_fit.service;

import br.com.socialfit.social_fit.entity.Publication;
import br.com.socialfit.social_fit.repositories.PublicationRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PublicationService {
    private PublicationRepository publicationRepository;

    public List<Publication> getAllPublications() {
        return publicationRepository.findAll();
    }

    public Optional<Publication> getPublicationById(UUID id) {
        return publicationRepository.findById(id);
    }

    public Publication savePublication(Publication publication) {
        return publicationRepository.save(publication);
    }

    public void deletePublication(UUID id) {
        publicationRepository.deleteById(id);
    }
}