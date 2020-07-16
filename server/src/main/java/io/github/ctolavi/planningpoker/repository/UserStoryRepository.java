package io.github.ctolavi.planningpoker.repository;

import io.github.ctolavi.planningpoker.model.User;
import io.github.ctolavi.planningpoker.model.UserStory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserStoryRepository extends JpaRepository<UserStory,Long> {

    List<UserStory> findByRoomId(String roomId);
}
