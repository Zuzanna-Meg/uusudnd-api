package com.uusudnd.api.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "budget")
public class Budget {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "funds")
    private BigDecimal funds;

    @Column(name = "grants")
    private BigDecimal grants;

    @Column(name = "comment")
    private String comment;

    @Column(name = "date")
    private LocalDate date;

    @Column(name = "author")
    private String author;

    public Long getId() {
        return id;
    }

    public BigDecimal getFunds() {
        return funds;
    }

    public void setFunds(BigDecimal funds) {
        this.funds = funds;
    }

    public BigDecimal getGrants() {
        return grants;
    }

    public void setGrants(BigDecimal grants) {
        this.grants = grants;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Budget(){
        super();
    }

    public Budget(Long id, BigDecimal funds, BigDecimal grants, String comment, LocalDate date, String author) {
        this.id = id;
        this.funds = funds;
        this.grants = grants;
        this.comment = comment;
        this.date = date;
        this.author = author;
    }

    public Budget(BigDecimal funds, BigDecimal grants, String comment, LocalDate date, String author) {
        this.funds = funds;
        this.grants = grants;
        this.comment = comment;
        this.date = date;
        this.author = author;
    }
}
