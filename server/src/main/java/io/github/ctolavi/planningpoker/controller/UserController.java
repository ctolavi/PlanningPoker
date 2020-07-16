package io.github.ctolavi.planningpoker.controller;

import io.github.ctolavi.planningpoker.controller.dto.RoomDto;
import io.github.ctolavi.planningpoker.controller.dto.UserDto;
import io.github.ctolavi.planningpoker.controller.dto.UserStoryDto;
import io.github.ctolavi.planningpoker.controller.dto.VoteDto;
import io.github.ctolavi.planningpoker.model.Room;
import io.github.ctolavi.planningpoker.model.User;
import io.github.ctolavi.planningpoker.model.UserStory;
import io.github.ctolavi.planningpoker.model.Vote;
import io.github.ctolavi.planningpoker.service.UserService;
import io.github.ctolavi.planningpoker.service.UserStoryService;
import io.github.ctolavi.planningpoker.service.VoteService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/users")
public class UserController {

    private ModelMapper modelMapper;

    private UserService userService;

    private UserStoryService userStoryService;

    private VoteService voteService;

    @Autowired
    public UserController(ModelMapper modelMapper, UserService userService, UserStoryService userStoryService, VoteService voteService) {
        this.modelMapper = modelMapper;
        this.userService = userService;
        this.userStoryService = userStoryService;
        this.voteService = voteService;
    }

    @PostMapping
    public ResponseEntity<UserDto> addUser(@RequestBody User user) {
        return ResponseEntity.ok().body(modelMapper.map(userService.addUser(user), UserDto.class));
    }

    @GetMapping
    public ResponseEntity<List<UserDto>> listUsers() {
        return ResponseEntity.ok().body(userService.listUsers().stream().map(entity -> modelMapper.map(entity, UserDto.class)).collect(Collectors.toList()));
    }

    @PostMapping(value = "/{id}/rooms")
    public ResponseEntity<RoomDto> addUser(@PathVariable("id") Long userId, @RequestBody Room room) {
        userService.addRooms(userId, room);
        return ResponseEntity.ok().body(modelMapper.map(room, RoomDto.class));
    }

    @PostMapping(value = "/{userId}/votes")
    public ResponseEntity<VoteDto> addVote(@PathVariable("userId") Long userId, @RequestBody Vote vote) {
        voteService.add(userId, vote);
        return ResponseEntity.ok(modelMapper.map(vote, VoteDto.class));
    }

}
