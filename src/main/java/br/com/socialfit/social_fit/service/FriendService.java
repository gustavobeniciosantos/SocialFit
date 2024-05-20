package br.com.socialfit.social_fit.service;


import br.com.socialfit.social_fit.entity.Friend;
import br.com.socialfit.social_fit.repositories.FriendRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
@Service
public class FriendService {

    private FriendRepository friendRepository;

    public List<Friend> getAllFriends() {
        return friendRepository.findAll();
    }

    public Optional<Friend> getFriendById(UUID id) {
       return friendRepository.findById(id);
    }

    public Friend saveFriend(Friend friend) {
        return friendRepository.save(friend);
    }

    public void deleteFriend(UUID id) {
        friendRepository.deleteById(id);
    }
}