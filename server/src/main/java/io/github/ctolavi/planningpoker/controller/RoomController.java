package io.github.ctolavi.planningpoker.controller;


import io.github.ctolavi.planningpoker.model.Room;
import io.github.ctolavi.planningpoker.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RoomController {

    @Autowired
    private RoomRepository roomRepository;

    @GetMapping(value = "/rooms")
    public ResponseEntity<List<Room>> getRooms() {
        return ResponseEntity.ok().body(roomRepository.findAll());
    }

//    @PostMapping(value = "/rooms") // or use json
//    public Mono<ResponseEntity<String>> create(@RequestBody String room){
//        return Mono.just(ResponseEntity.ok(room));
//    }


}
