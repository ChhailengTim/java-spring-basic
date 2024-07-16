package com.example.customers.friend;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/friends")
public class FriendController {

    private final FriendService friendService;


    @Autowired
    public FriendController(FriendService friendService) {
        this.friendService = friendService;
    }

    @GetMapping()
    public List<FriendModel> getAllFriend(){
        return friendService.getFriend();
    }

    @PostMapping()
    public void addNewFriend(@RequestBody FriendModel friendModel){
        friendService.addFriend(friendModel);
    }

    @DeleteMapping(path = "{friendId}")
    public void deleteFriend(@PathVariable("friendId") Long friendId) {
        friendService.deleteFriend(friendId);
    }

    @PutMapping(path = "{friendId}")
    public ResponseEntity<FriendModel> updateFriend(
            @PathVariable("friendId") Long friendId,
            @RequestBody FriendModel friendDetails
    ){
        return friendService.updateFriend(friendId, friendDetails);
    }

}
