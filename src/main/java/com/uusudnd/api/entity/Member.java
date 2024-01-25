package com.uusudnd.api.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "member")
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "student")
    private boolean student;

    @Column(name = "bcode")
    private String bcode;

    public Member() {
        super();
    }

    public Long getId() {
        return id;
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

    public Member(Long id, String name, String email, boolean student, String bcode) {
        super();
        this.id = id;
        this.name = name;
        this.email = email;
        this.student = student;
        this.bcode = bcode;
    }

    public Member(String name, String email, boolean student, String bcode) {
        super();
        this.name = name;
        this.email = email;
        this.student = student;
        this.bcode = bcode;
    }
}
