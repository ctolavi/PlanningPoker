package io.github.ctolavi.planningpoker.service;

import io.github.ctolavi.planningpoker.model.Room;
import io.github.ctolavi.planningpoker.model.UserStory;
import io.github.ctolavi.planningpoker.repository.RoomRepository;
import io.github.ctolavi.planningpoker.repository.UserStoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class RoomService {

    private RoomRepository roomRepository;

    private UserStoryRepository userStoryRepository;

    @Autowired
    public RoomService(RoomRepository roomRepository, UserStoryRepository userStoryRepository) {
        this.roomRepository = roomRepository;
        this.userStoryRepository = userStoryRepository;
    }

    public List<Room> listRooms() {
        return roomRepository.findAll();
    }

    @Transactional
    public void addUserStory(String roomId, UserStory userStory) {
        Room room = roomRepository.findById(roomId).get();
        userStoryRepository.save(userStory);
        room.addUserStory(userStory);
        roomRepository.save(room);
    }
}
