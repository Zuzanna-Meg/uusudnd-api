package com.uusudnd.api.controller;

import com.uusudnd.api.entity.Member;
import com.uusudnd.api.exception.MemberNotFound;
import com.uusudnd.api.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

    // get one
    @GetMapping("/{id}")
    public ResponseEntity<Member> getMemberById (@PathVariable("id") Long id) {

        Optional<Member> memberData = memberRepository.findById(id);
        if (memberData.isPresent()) {
            return new ResponseEntity<>(memberData.get(), HttpStatus.OK);
        } else {
            throw new MemberNotFound("Invalid Member Id");
        }
    }

    // delete one
    @DeleteMapping("/{id}")
    public ResponseEntity<Member> deleteMember (@PathVariable("id") Long id) {

        Optional<Member> memberData = memberRepository.findById(id);
        if (memberData.isPresent()) {
            memberRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            throw new MemberNotFound("Invalid Member Id");
        }
    }

    // amend one
    @PutMapping("/{id}")
    public ResponseEntity<Member> updateMember(@PathVariable("id") Long id, @RequestBody Member newmember) {
        Optional<Member> memberData = memberRepository.findById(id);
        if (memberData.isPresent()) {
            Member member = memberData.get();
            member.setName(newmember.getName());
            member.setEmail(newmember.getEmail());
            member.setBcode(newmember.getBcode());
            member.setStudent(newmember.isStudent());
            memberRepository.save(member);
            return new ResponseEntity<>(member, HttpStatus.OK);
        } else {
            throw new MemberNotFound("Invalid Member Id");
        }
    }

}
