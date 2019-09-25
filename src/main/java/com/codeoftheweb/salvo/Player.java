package com.codeoftheweb.salvo;
import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;
import java.util.Set;

@Entity
//atributos
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private long id;

    private String userName;

    //constructor por defecto
    public Player() {
    }
    //constructor personalizado
    public Player(String userName) {
        this.userName = userName;
    }

    //metodos
    public long getId() {
        return id;
    }
    public String getUserName() {
        return userName;
    }

    @OneToMany(mappedBy="player", fetch=FetchType.EAGER)
    Set<GamePlayer> gamePlayers;
}


