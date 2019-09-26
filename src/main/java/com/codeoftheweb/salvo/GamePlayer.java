package com.codeoftheweb.salvo;
import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
public class GamePlayer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private long id;
    private Date joinDate;

    public GamePlayer() {
    }

    public GamePlayer(Date joinDate) {
        this.joinDate = joinDate;
    }

    long getId() {
        return id;
    }

    public Date getCreationDate() {
        return joinDate;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "player_id")
    private Player player;

    Player getPlayer() {
        return player;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "game_id")
    private Game game;

    public Game getGame() {
        return game;
    }

    GamePlayer(Date joinDate, Game game, Player player) {
        this.joinDate = joinDate;
        this.game = game;
        this.player = player;
    }

    //3
    @OneToMany(mappedBy = "gamePlayer", fetch = FetchType.EAGER)
    private Set<Ship> ships;

    public Set<Ship> getShips() {
        return this.ships;
    }

    public void setShips(Set<Ship> ships) {
        this.ships = ships;
    }
}







