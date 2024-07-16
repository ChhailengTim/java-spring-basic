package com.example.customers.friend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class FriendService {
    private final FriendRepository friendRepository;

    @Autowired
    public FriendService(FriendRepository friendRepository) {
        this.friendRepository = friendRepository;
    }

    public List<FriendModel> getFriend() {
        return friendRepository.findAll();
    }

    public void addFriend(FriendModel friendModel) {
        friendRepository.save(friendModel);
    }

    public void deleteFriend(Long friendId) {
        boolean exists = friendRepository.existsById(friendId);
        if (!exists) {
            throw new IllegalStateException("Friend with id " + friendId + " does not exist");
        }
        friendRepository.deleteById(friendId);
    }

    @Transactional
    public ResponseEntity<FriendModel> updateFriend(Long friendId, FriendModel friendDetails) {
        Optional<FriendModel> optionalFriend = friendRepository.findById(friendId);

        if(optionalFriend.isPresent()){
            FriendModel friendModel = optionalFriend.get();
            friendModel.setName(friendDetails.getName());
            friendModel.setEmail(friendDetails.getEmail());
            friendModel.setAge(friendDetails.getAge());
            FriendModel updateFriend = friendRepository.save(friendModel);
            return ResponseEntity.ok(updateFriend);
        }else {
            return ResponseEntity.notFound().build();
        }
    }
}
