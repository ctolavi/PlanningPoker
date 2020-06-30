package io.github.ctolavi.planningpoker.controller;

import io.github.ctolavi.planningpoker.model.Room;
import io.github.ctolavi.planningpoker.model.User;
import io.github.ctolavi.planningpoker.repository.RoomRepository;
import io.github.ctolavi.planningpoker.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoomRepository roomRepository;

    @PostMapping(value = "/users")
    public ResponseEntity<User> addUser(@RequestBody User user) {
        return ResponseEntity.ok().body(userRepository.save(user));
    }

    @GetMapping(value = "/users")
    public ResponseEntity<List<User>> listUsers() {
        return ResponseEntity.ok().body(userRepository.findAll());
    }

    @PostMapping(value = "/users/{id}/rooms")
    public ResponseEntity<Room> addUser(@PathVariable("id") Long userId, @RequestBody Room room) {
        room.setUser(userRepository.findById(userId).get());
        room.setId(UUID.randomUUID().toString());
        return ResponseEntity.ok().body(roomRepository.save(room));
    }

}
