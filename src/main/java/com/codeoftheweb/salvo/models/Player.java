package com.codeoftheweb.salvo.models;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

@Entity
public class Player {

    //ATRIBUTOS
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private long id;

    private String userName;
    private String password;

    @OneToMany(mappedBy = "player", fetch = FetchType.EAGER)
    Set<GamePlayer> gamePlayers;

    @OneToMany(mappedBy = "player", fetch = FetchType.EAGER)
    Set<Score> scores;

    public Map<String, Object> getPlayerDTO() {
        Map<String, Object> dto = new LinkedHashMap<String, Object>();
        dto.put("id", this.getId());
        dto.put("email", this.getUserName());
        return dto;
    }

    //CONSTRUCTOR
    public Player() {
    }

    public Player(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    //GETTERS
    public long getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }

    public Set<GamePlayer> getGamePlayers() {
        return gamePlayers;
    }

    public Set<Score> getScores() {
        return (Set<Score>) scores;
    }

    public String getPassword() {
        return password;
    }

    //SETTERS
    public void setScores() {
        this.scores = scores;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    // win 1 tied 0.5 lost 0
    public long getWinScore() {
        return this.getScores().stream()
                .filter(score -> score.getScore() == 1.0D)
                .count();
    }

    public double getTiedScore() {
        return this.getScores().stream()
                .filter(score -> score.getScore() == 0.5D)
                .count();
    }

    public long getLostScore() {
        return this.getScores().stream()
                .filter(score -> score.getScore() == 0D)
                .count();
    }

    public double getTotalScore() {
        return this.getWinScore() + this.getTiedScore() * 0.5;
    }
}


