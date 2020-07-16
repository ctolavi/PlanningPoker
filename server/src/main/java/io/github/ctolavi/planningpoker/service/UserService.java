package io.github.ctolavi.planningpoker.service;

import io.github.ctolavi.planningpoker.model.Room;
import io.github.ctolavi.planningpoker.model.User;
import io.github.ctolavi.planningpoker.model.UserStory;
import io.github.ctolavi.planningpoker.model.Vote;
import io.github.ctolavi.planningpoker.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;

@Service
public class UserService {

    private UserRepository userRepository;

    private UserStoryService userStoryService;

    @Autowired
    public UserService(UserRepository userRepository, UserStoryService userStoryService) {
        this.userRepository = userRepository;
        this.userStoryService = userStoryService;
    }

    public List<User> listUsers(){
        return userRepository.findAll();
    }

    public User addUser(User user){
        return userRepository.save(user);
    }

    public User getUser(Long userId){
        return userRepository.findById(userId).get();
    }

    @Transactional
    public void addRooms(Long userId, Room room){
        room.setId(UUID.randomUUID().toString());
        User user =  userRepository.findById(userId).get();
        user.addRoom(room);
        userRepository.save(user);
    }
}
