package br.com.socialfit.social_fit.repositories;

import br.com.socialfit.social_fit.entity.Friend;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
@Repository
public interface FriendRepository extends JpaRepository<Friend,UUID>{
    List<Friend> findAll();


    Friend save(Friend friend);

    void deleteById(UUID id);

    Optional<Friend> findById(UUID id);
}
