package io.github.ctolavi.planningpoker.service;

import io.github.ctolavi.planningpoker.model.Room;
import io.github.ctolavi.planningpoker.model.User;
import io.github.ctolavi.planningpoker.model.UserStory;
import io.github.ctolavi.planningpoker.model.Vote;
import io.github.ctolavi.planningpoker.repository.UserRepository;
import io.github.ctolavi.planningpoker.repository.UserStoryRepository;
import io.github.ctolavi.planningpoker.repository.VoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;

@Service
public class VoteService {

    private VoteRepository voteRepository;

    private UserRepository userRepository;

    private UserStoryRepository userStoryRepository;

    @Autowired
    public VoteService(VoteRepository voteRepository, UserRepository userRepository, UserStoryRepository userStoryRepository) {
        this.voteRepository = voteRepository;
        this.userRepository = userRepository;
        this.userStoryRepository = userStoryRepository;
    }

    public Vote add(Long userId, Vote vote) {
        User user = userRepository.findById(userId).get();
        vote.setUser(user);
        UserStory userStory = userStoryRepository.findById(vote.getUserStory().getId()).get();
        vote.setUserStory(userStory);
        voteRepository.save(vote);
        return vote;
    }
}
