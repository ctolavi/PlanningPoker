package io.github.ctolavi.planningpoker.repository;

import io.github.ctolavi.planningpoker.model.Vote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VoteRepository extends JpaRepository<Vote, Long> {
}
