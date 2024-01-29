package com.uusudnd.api.entity;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "game")
public class Game {

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
    private Member dm;

//    @ManyToMany(fetch = FetchType.LAZY,
//            cascade = {
//                    CascadeType.PERSIST,
//                    CascadeType.MERGE
//            })
//    @JoinTable(name = "game_member",
//            joinColumns = { @JoinColumn(name = "game_id") },
//            inverseJoinColumns = { @JoinColumn(name = "member_id") })
//    private Set<Member> players = new HashSet<>();

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

    //    public Set<Member> getPlayers() {
//        return players;
//    }
//
//    public void setPlayers(Set<Member> players) {
//        this.players = players;
//    }

    public Game() {
        super();
    }

    public Game(Long game_id, String name, String system, int slots, String description, Member dm) {
        this.game_id = game_id;
        this.name = name;
        this.system = system;
        this.slots = slots;
        this.description = description;
        this.dm = dm;
    }

    public Game(String name, String system, int slots, String description, Member dm) {
        this.name = name;
        this.system = system;
        this.slots = slots;
        this.description = description;
        this.dm = dm;
    }

}
