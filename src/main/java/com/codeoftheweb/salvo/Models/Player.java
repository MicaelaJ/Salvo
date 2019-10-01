package com.codeoftheweb.salvo.Models;
import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;
import java.util.Set;

@Entity
public class Player {

    //ATRIBUTOS
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private long id;

    private String userName;

    @OneToMany(mappedBy="player", fetch=FetchType.EAGER)
    Set<GamePlayer> gamePlayers;

    @OneToMany(mappedBy = "player", fetch = FetchType.EAGER)
    Set<Score> scores;

    //CONSTRUCTOR
    public Player() {}
    public Player(String userName) {
        this.userName = userName; }

    //GETTERS
    public long getId() {
        return id; }

    public String getUserName() {
        return userName; }

    public Set<GamePlayer> getGamePlayers() {
        return gamePlayers;
    }

    public Set<Score> getScores() {
        return (Set<Score>) scores;
    }

    //SETTERS
    public void setScores() {
        this.scores = scores;
    }

  // win 1 tied 0.5 lost 0
    public long getWinScore() {
        return this.getScores().stream()
            .filter(score -> score.getScore() == 1.0D)
            .count(); }

    public double getTiedScore() {
        return this.getScores().stream()
            .filter(score -> score.getScore() == 0.5D)
            .count(); }

    public long getLostScore() {
        return this.getScores().stream()
                .filter(score -> score.getScore() == 0D)
                .count(); }

    public double getTotalScore() {
        return this.getWinScore() + this.getTiedScore() * 0.5; }
}


