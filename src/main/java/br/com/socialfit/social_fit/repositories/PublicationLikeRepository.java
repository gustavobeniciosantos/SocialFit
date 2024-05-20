package br.com.socialfit.social_fit.repositories;

import br.com.socialfit.social_fit.entity.PublicationLike;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface PublicationLikeRepository extends JpaRepository<PublicationLike, UUID> {

    List<PublicationLike> findAll();

    Optional<PublicationLike> findById(UUID id);

    PublicationLike save(PublicationLike publicationLike);

    void deleteById(UUID id);
}
