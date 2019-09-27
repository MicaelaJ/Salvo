package com.codeoftheweb.salvo.Methods;
import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
public class GamePlayer {

    //ATRIBUTOS
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private long id;

    private Date joinDate;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "player_id")
    private Player player;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "game_id")
    private Game game;

    @OneToMany(mappedBy = "gamePlayer", fetch = FetchType.EAGER)
    private Set<Ship> ships;

    @OneToMany(mappedBy = "gamePlayer", fetch = FetchType.EAGER)
    private Set<Salvo> salvos;

    //CONSTRUCTOR
    public GamePlayer() {}

    public GamePlayer(Date joinDate, Game game, Player player) {
        this.joinDate = joinDate;
        this.game = game;
        this.player = player;
    }

    //GETTERS
    public long getId() {
        return id;
    }

    public Player getPlayer() {
        return player;
    }

    public Date getJoinDate() { return joinDate;}

    public Game getGame() {
        return game;
    }

    public Set<Ship> getShips() {
        return this.ships;
    }

    public Set<Salvo> getSalvos()
    { return this.salvos; }
}







