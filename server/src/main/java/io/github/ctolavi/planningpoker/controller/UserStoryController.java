package io.github.ctolavi.planningpoker.controller;


import io.github.ctolavi.planningpoker.controller.dto.UserStoryDto;
import io.github.ctolavi.planningpoker.model.UserStory;
import io.github.ctolavi.planningpoker.model.Vote;
import io.github.ctolavi.planningpoker.repository.UserStoryRepository;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserStoryController {

    private ModelMapper modelMapper;

    private UserStoryRepository userStoryRepository;

    public UserStoryController(UserStoryRepository userStoryRepository, ModelMapper modelMapper) {
        this.userStoryRepository = userStoryRepository;
        this.modelMapper = modelMapper;
    }

    @PutMapping(value = "/user-stories/{userStoryId}")
    public ResponseEntity<UserStoryDto> getRooms(@PathVariable("userStoryId") Long userStoryId, @RequestBody UserStory newUserStory) {
        UserStory userStory = userStoryRepository.findById(userStoryId).get();
        userStory.setPoints(newUserStory.getPoints());
        userStoryRepository.save(userStory);
        return ResponseEntity.ok().body(modelMapper.map(userStory, UserStoryDto.class));
    }
}
