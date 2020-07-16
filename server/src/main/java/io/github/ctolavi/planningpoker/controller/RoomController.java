package io.github.ctolavi.planningpoker.controller;


import io.github.ctolavi.planningpoker.controller.dto.RoomDto;
import io.github.ctolavi.planningpoker.controller.dto.UserStoryDto;
import io.github.ctolavi.planningpoker.model.Room;
import io.github.ctolavi.planningpoker.model.UserStory;
import io.github.ctolavi.planningpoker.service.RoomService;
import io.github.ctolavi.planningpoker.service.UserStoryService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/rooms")
public class RoomController {

    private RoomService roomService;

    private UserStoryService userStoryService;

    private ModelMapper modelMapper;

    @Autowired
    public RoomController(RoomService roomService, UserStoryService userStoryService, ModelMapper modelMapper) {
        this.roomService = roomService;
        this.userStoryService = userStoryService;
        this.modelMapper = modelMapper;
    }

    @GetMapping
    public ResponseEntity<List<RoomDto>> getRooms() {
        return ResponseEntity.ok().body(roomService.listRooms().stream().map(entity -> modelMapper.map(entity, RoomDto.class)).collect(Collectors.toList()));
    }

    @GetMapping(value = "/{idRoom}/user-stories")
    public ResponseEntity<List<UserStoryDto>> getUserStories(@PathVariable("idRoom") String idRoom) {
        List<UserStory> userStories = userStoryService.getByRoomId(idRoom);
//        return ResponseEntity.ok().body(userStories);
        userStories.get(0).getId();
        userStories.get(0).getName();
        userStories.get(0).getPoints();
        return ResponseEntity.ok().body(userStories.stream().map(entity -> modelMapper.map(entity, UserStoryDto.class)).collect(Collectors.toList()));
    }

    @PostMapping(value = "/{idRoom}/user-stories")
    public ResponseEntity<UserStoryDto> addUser(@PathVariable("idRoom") String idRoom, @RequestBody UserStory userStory) {
        roomService.addUserStory(idRoom, userStory);
        return ResponseEntity.ok().body(modelMapper.map(userStory, UserStoryDto.class));
    }

}
