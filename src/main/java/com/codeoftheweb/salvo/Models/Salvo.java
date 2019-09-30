package com.codeoftheweb.salvo.Models;
import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Salvo {

    //ATRIBUTOS
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "gamePlayer_id")
    private GamePlayer gamePlayer;

    private int turn;

    @ElementCollection
    @Column(name="salvoLocations")
    public Set<String> salvoLocations = new HashSet<>();

    //CONSTRUCTOR
    public Salvo(){}

    public Salvo(int turn, GamePlayer gameplayer, Set<String> salvoLocations) {
        this.turn = turn;
        this.gamePlayer = gameplayer;
        this.salvoLocations = salvoLocations;
    }

    //GETTERS
    public long getId() {
        return id; }

    public int getTurn() {
        return turn;}

    public GamePlayer getGamePlayer() {
        return gamePlayer;}

    public GamePlayer getSalvoPlayer() {
        return this.getGamePlayer();}

        //SETTERS
    public void setTurn(int turn) {
        this.turn = turn;
    }

    public void setGamePlayer(GamePlayer gamePlayer) {
            this.gamePlayer = gamePlayer;
        }

    public void SetSalvoLocations(Set<String> salvoLocations) {
         this.salvoLocations = salvoLocations;}

    public Set<String> getSalvoLocations() {
        return salvoLocations;
    }
}
