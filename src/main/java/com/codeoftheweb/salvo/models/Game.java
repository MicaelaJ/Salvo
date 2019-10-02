package com.codeoftheweb.salvo.models;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.*;

@Entity
public class Game {

    //ATRIBUTOS
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private long id;

    private Date creationDate;
    private double score;

    @OneToMany(mappedBy = "game", fetch = FetchType.EAGER)
    private Set<GamePlayer> gamePlayers;

    @OneToMany(mappedBy = "game", fetch = FetchType.EAGER)
    private Set<Score> scores;

    //CONSTRUCTOR
    public Game() {
    }

    //declaracion de metodo
    public Game(Date creationDate) {
        this.creationDate = creationDate;
    }

    //GETTERS
    public long getId() {
        return id;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public Double getScore() {
        return score;
    }

    //SETTERS
    public Set<GamePlayer> getGamePlayers() {
        return gamePlayers;
    }

    public void setScores() {
        this.scores = scores;
    }

    public Set<Score> getScores() {
        return scores;
    }
}


