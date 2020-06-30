package io.github.ctolavi.planningpoker.repository;

import io.github.ctolavi.planningpoker.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomRepository extends JpaRepository<Room,Long> {
}
