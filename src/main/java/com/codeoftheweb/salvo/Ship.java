package com.codeoftheweb.salvo;

import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Ship {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private long id;

    //2
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "gamePlayer_id")
    private GamePlayer gamePlayer;

    //4 para usar una list se hace element collection
    @ElementCollection
    @Column(name="shipLocations")
    private Set<String> shipLocations = new HashSet<>();

    //1
    private String type;

    public Ship() {}

    public Ship(GamePlayer gamePlayer, String type, Set<String> shipLocations) {
        this.gamePlayer = gamePlayer;
        this.shipLocations = shipLocations;
        this.type = type;
    }

    public long getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public GamePlayer getGamePlayer() {
        return gamePlayer;
    }

    public void setGamePlayer(GamePlayer gamePlayer) {
        this.gamePlayer = gamePlayer;
    }
    //ship locations relacion envevida
    public Set<String> getShipLocations() {
        return shipLocations;
    }

    public void setShipLocations(Set<String> shipLocations) {
        this.shipLocations = shipLocations;
    }

    public GamePlayer getShipPlayer() {
        return this.getGamePlayer();
    }
}
