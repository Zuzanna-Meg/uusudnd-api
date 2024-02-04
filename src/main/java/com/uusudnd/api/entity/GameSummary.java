package com.uusudnd.api.entity;

public class GameSummary {

    private Long game_id;
    private String name;

    public Long getGame_id() {
        return game_id;
    }

    public void setGame_id(Long game_id) {
        this.game_id = game_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public GameSummary(Game game){
        this.game_id = game.getGame_id();
        this.name = game.getName();
    }
}
