package br.com.socialfit.social_fit.repositories;

import br.com.socialfit.social_fit.entity.Publication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface PublicationRepository extends JpaRepository<Publication,UUID> {
    List<Publication> findAll();

    Optional<Publication> findById(UUID id);

    Publication save(Publication publication);

    void deleteById(UUID id);
}
