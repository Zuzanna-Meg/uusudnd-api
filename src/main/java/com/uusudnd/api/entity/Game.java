package com.uusudnd.api.entity;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "game")
public class Game implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long game_id;

    @Column(name = "name")
    private String name;

    @Column(name = "system")
    private String system;

    @Column(name = "slots")
    private int slots;

    @Column(name = "description")
    private String description;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member dm;

    @ManyToMany
    @JoinTable(name = "game_member")
    private Set<Member> players;

    public Long getGame_id() {
        return game_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSystem() {
        return system;
    }

    public void setSystem(String system) {
        this.system = system;
    }

    public int getSlots() {
        return slots;
    }

    public void setSlots(int slots) {
        this.slots = slots;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Member getDm() {
        return dm;
    }

    public void setDm(Member dm) {
        this.dm = dm;
    }

    public Set<Member> getPlayers() {
        return players;
    }

    public void setPlayers(Set<Member> players) {
        this.players = players;
    }

    public Game() {
        super();
    }

    public Game(Long game_id, String name, String system, int slots, String description, Member dm, Set<Member> players) {
        super();
        this.game_id = game_id;
        this.name = name;
        this.system = system;
        this.slots = slots;
        this.description = description;
        this.dm = dm;
        this.players = players;
    }

    public Game(String name, String system, int slots, String description, Member dm, Set<Member> players) {
        super();
        this.name = name;
        this.system = system;
        this.slots = slots;
        this.description = description;
        this.dm = dm;
        this.players = players;
    }

    public GameSummary summary(){
        return new GameSummary(this);
    }

    @Override
    public String toString() {
        return "Game{" +
                "game_id=" + game_id +
                ", name='" + name + '\'' +
                ", system='" + system + '\'' +
                ", slots=" + slots +
                ", description='" + description + '\'' +
                ", dm=" + dm +
                ", players=" + players +
                '}';
    }
}
