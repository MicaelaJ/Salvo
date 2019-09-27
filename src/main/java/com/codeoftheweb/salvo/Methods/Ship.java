package com.codeoftheweb.salvo.Methods;

import com.codeoftheweb.salvo.Methods.GamePlayer;
import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Ship {

    //ATRIBUTOS
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "gamePlayer_id")
    private GamePlayer gamePlayer;

    private String type;

    @ElementCollection
    @Column(name="shipLocations")
    private Set<String> shipLocations = new HashSet<>();

    //CONSTRUCTOR

    public Ship() {}

    public Ship(GamePlayer gamePlayer, String type, Set<String> shipLocations) {
        this.gamePlayer = gamePlayer;
        this.shipLocations = shipLocations;
        this.type = type;
    }

    //GETTERS

    public long getId() {
        return id;
    }

    public String getType() {
        return type;}

    public GamePlayer getGamePlayer() {
        return gamePlayer;}

    public GamePlayer getShipPlayer() {
        return this.getGamePlayer();}

    //SETTERS

    public void setType(String type) {
        this.type = type;
    }

    public void setGamePlayer(GamePlayer gamePlayer) {
        this.gamePlayer = gamePlayer;
    }

    public Set<String> getShipLocations() {
        return shipLocations;}

    public void setShipLocations(Set<String> shipLocations) {
        this.shipLocations = shipLocations;
    }
}
