package io.github.ctolavi.planningpoker.service;

import io.github.ctolavi.planningpoker.model.Room;
import io.github.ctolavi.planningpoker.model.User;
import io.github.ctolavi.planningpoker.model.UserStory;
import io.github.ctolavi.planningpoker.repository.RoomRepository;
import io.github.ctolavi.planningpoker.repository.UserRepository;
import io.github.ctolavi.planningpoker.repository.UserStoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;

@Service
public class UserStoryService {

    private UserStoryRepository userStoryRepository;

    private RoomRepository roomRepository;

    @Autowired
    public UserStoryService(UserStoryRepository userStoryRepository, RoomRepository roomRepository) {
        this.userStoryRepository = userStoryRepository;
        this.roomRepository = roomRepository;
    }

    public UserStory get(Long id){
        return userStoryRepository.findById(id).get();
    }

    @Transactional
    public List<UserStory> getByRoomId(String roomId){
        return userStoryRepository.findByRoomId(roomId);
//        List<UserStory> userStories = roomRepository.findById(roomId).get().getUserStories();
//        return userStories;
    }

    public List<UserStory> listUserStories(){
        return userStoryRepository.findAll();
    }

}
