package io.github.ctolavi.planningpoker.model;

import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Data
public class UserStory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private int points;

    @ManyToOne
    private Room room;

    @OneToMany(
            mappedBy = "userStory",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Vote> votes;

    public void addVote(Vote vote) {
        votes.add(vote);
        vote.setUserStory(this);
    }

    public void removeVote(Vote vote) {
        votes.remove(vote);
        vote.setUserStory(null);
    }

}
