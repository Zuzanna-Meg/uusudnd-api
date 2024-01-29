package com.uusudnd.api.controller;

import com.uusudnd.api.entity.Game;
import com.uusudnd.api.entity.Member;
import com.uusudnd.api.exception.MemberNotFound;
import com.uusudnd.api.repository.GameRepository;
import com.uusudnd.api.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/game")
public class GameController {

    @Autowired
    GameRepository gameRepository;
    @Autowired
    MemberRepository memberRepository;

    // get all
    @GetMapping
    public ResponseEntity<List<Game>> getAllGames() {
        List<Game> games = new ArrayList<>();
        gameRepository.findAll().forEach(games::add);
        return new ResponseEntity<>(games, HttpStatus.OK);
    }

    // create
    @PostMapping
    public ResponseEntity<Game> createGame(@RequestBody Game game) {
        Optional<Member> memberData = memberRepository.findById(game.getDm().getMember_id());
        if (memberData.isPresent()) {
            Game newGame = new Game(game.getName(), game.getSystem(), game.getSlots(), game.getDescription(), game.getDm());
            gameRepository.save(newGame);
            return new ResponseEntity<>(newGame, HttpStatus.CREATED);
        } else {
            throw new MemberNotFound("Invalid Member Id");
        }
    }
}
