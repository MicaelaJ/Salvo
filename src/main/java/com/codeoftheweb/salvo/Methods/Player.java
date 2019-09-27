package com.codeoftheweb.salvo.Methods;
import com.codeoftheweb.salvo.Methods.GamePlayer;
import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;
import java.util.Set;

//para el campo id: ya que la clase debe almacenarse en una base de datos!
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

    //CONSTRUCTOR
    public Player() {}

    public Player(String userName) {
        this.userName = userName;}

    //GETTERS
    public long getId() {
        return id;}

    public String getUserName() {
        return userName;}
}


