package com.codeoftheweb.salvo.Models;
import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;
import java.util.Date;

@Entity
public class Score {

    //ATRIBUTOS
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private long id;

    private double score;
    private Date finishDate;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "gamePlayer_id")
    private Game game;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "player_id")
    private Player player;

    //CONSTRUCTOR
    public Score(){}

    public Score(Game game, Player player, double score, Date finishDate){
        this.game = game;
        this.player = player;
        this.score = score;
        this.finishDate = new Date();
    }

    //GETTERS
    public long getId() { return id; }

    public double getScore() { return score; }

    public Date getFinishDate() {return finishDate;}

    public Game getGame(){
        return game;
    }

    public Player getPlayer() { return player; }

    //SETTERS
    public void setScore(float score) { this.score = score; }

    public void setGame(Game game) { this.game = game; }

    public void setFinishDate(Date finishDate) { this.finishDate = finishDate; }
}
