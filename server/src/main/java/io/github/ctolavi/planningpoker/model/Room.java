package io.github.ctolavi.planningpoker.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.List;


@Entity
@Data
@EqualsAndHashCode
public class Room {

    @Id
    private String id;

    private String name;

    private boolean archived;

    @ManyToOne
    private User user;

    @OneToMany(
            mappedBy = "room",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<UserStory> userStories;

    public void addUserStory(UserStory userStory) {
        userStories.add(userStory);
        userStory.setRoom(this);
    }

    public void removeUserStory(UserStory userStory) {
        userStories.remove(userStory);
        userStory.setRoom(null);
    }
}
