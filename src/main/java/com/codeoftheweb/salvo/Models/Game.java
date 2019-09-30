package com.codeoftheweb.salvo.Models;
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

    @OneToMany(mappedBy = "game", fetch = FetchType.EAGER)
    private Set<GamePlayer> gamePlayers;

    //CONSTRUCTOR
    public Game() {}

    public Game(Date creationDate) {
        this.creationDate = creationDate;}

    //GETTERS
    public Date getCreationDate() {
        return creationDate;}

    public long getId() {
        return id;}

    //SETTERS
    public Set<GamePlayer> getGamePlayers() {
        return gamePlayers;}
}


