package com.uusudnd.api.entity;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Entity
@Table(name = "member")
public class Member implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long member_id;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "student")
    private boolean student;

    @Column(name = "bcode")
    private String bcode;

    @ManyToMany(mappedBy = "players")
    @Column(name = "games")
    Set<Game> games;

    @OneToMany(mappedBy = "dm")
    private Set<Game> gamesDm;

    public Member() {
        super();
    }

    public Long getMember_id() {
        return member_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isStudent() {
        return student;
    }

    public void setStudent(boolean student) {
        this.student = student;
    }

    public String getBcode() {
        return bcode;
    }

    public void setBcode(String bcode) {
        this.bcode = bcode;
    }

    public Set<GameSummary> getGames(){
        return this.games.stream().map(Game::summary).collect(Collectors.toSet());
    }

    public Set<GameSummary> getGamesDm(){
        return this.gamesDm.stream().map(Game::summary).collect(Collectors.toSet());
    }

    public Member(Long member_id, String name, String email, boolean student, String bcode) {
        super();
        this.member_id = member_id;
        this.name = name;
        this.email = email;
        this.student = student;
        this.bcode = bcode;
        this.games = new HashSet<>();
    }

    public Member(String name, String email, boolean student, String bcode) {
        super();
        this.name = name;
        this.email = email;
        this.student = student;
        this.bcode = bcode;
        this.games = new HashSet<>();
    }
}
