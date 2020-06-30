package io.github.ctolavi.planningpoker.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Room {

    @Id
    private String id;

    private String name;

    private boolean archived;

    @ManyToOne
    @JoinColumn(name = "user_id", insertable = false, updatable = false)
    private User user;
}
