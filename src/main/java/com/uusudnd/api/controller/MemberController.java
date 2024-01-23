package com.uusudnd.api.controller;

import com.uusudnd.api.entity.Member;
import com.uusudnd.api.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/member")
public class MemberController {

    @Autowired
    MemberRepository memberRepository;

    // get all
    @GetMapping
    public ResponseEntity<List<Member>> getAllMembers() {
        List<Member> members = new ArrayList<>();
        memberRepository.findAll().forEach(members::add);
        return new ResponseEntity<>(members, HttpStatus.OK);
    }

    // create
    @PostMapping
    public ResponseEntity<Member> createMember(@RequestBody Member member) {
        Member newMember = new Member(member.getName(), member.getEmail(), member.isStudent(), member.getBcode());
        memberRepository.save(newMember);
        return new ResponseEntity<>(newMember, HttpStatus.CREATED);
    }

}
