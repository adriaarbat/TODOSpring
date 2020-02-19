package org.udg.pds.springtodo.entity;

import com.fasterxml.jackson.annotation.JsonView;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "usergroup")
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String name;
    String description;

    @ManyToOne(fetch = FetchType.EAGER)
    private User owner;

    public Group() {
    }

    public Group(String name, String description, User owner) {
        this.description = description;
        this.name = name;
        this.owner = owner;
    }

    @JsonView(Views.Private.class)
    public Long getId(){
        return id;
    }

    @JsonView(Views.Private.class)
    public String getName(){
        return name;
    }

    @JsonView(Views.Private.class)
    public String getDescription(){
        return description;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isOwner(Long userId) {
        System.out.println("owner = " + this.owner.getId() + " userId = " + userId + " equals = " + this.owner.getId().equals(userId));
        return this.owner.getId().equals(userId);
    }
}
