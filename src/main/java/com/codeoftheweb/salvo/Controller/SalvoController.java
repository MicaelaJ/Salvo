package com.codeoftheweb.salvo.Controller;
import com.codeoftheweb.salvo.Models.*;
import com.codeoftheweb.salvo.Repositories.GamePlayerRepository;
import com.codeoftheweb.salvo.Repositories.GameRepository;
import com.codeoftheweb.salvo.Repositories.SalvoRepository;
import com.codeoftheweb.salvo.Repositories.ShipRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import static java.util.stream.Collectors.toList;

@RestController
@RequestMapping("/api")

public class SalvoController {

    //permite que los objetos sean compartidos y administrados por el framework
    @Autowired
    private GameRepository gameRepository;

    @Autowired
    private GamePlayerRepository gamePlayerRepository;

    @Autowired
    private ShipRepository shipRepository;

    @Autowired
    private SalvoRepository salvoRepository;

    //lista /api/games___________________________________________________________________
    @RequestMapping("/games")
    public List<Map<String, Object>> getAllGames() {
        return gameRepository.findAll()
                .stream()
                .map(game -> getGameDTO(game))
                .collect(toList());
    }

    //Game____________________________________________________________
    public Map<String, Object> getGameDTO(Game game) {
        Map<String, Object> dto = new LinkedHashMap<String, Object>();
        dto.put("id", game.getId());
        dto.put("created", game.getCreationDate());
        dto.put("gamePlayers", getAllGamePlayers(game.getGamePlayers()));
        return dto;
    }

    //GamePlayer___________________________
    public List<Map<String, Object>> getAllGamePlayers(Set<GamePlayer> gamePlayers) {
        return gamePlayers
                .stream()
                .map(gamePlayer -> getGamePlayerDTO(gamePlayer))
                .collect(toList());
    }

    //GamePlayer________________________________________
    public Map<String, Object> getGamePlayerDTO(GamePlayer gamePlayer) {
        Map<String, Object> dto = new LinkedHashMap<String, Object>();
        dto.put("id", gamePlayer.getId());
        dto.put("player", getPlayerDTO(gamePlayer.getPlayer()));
        return dto;
    }

    //Player______________________________________________
    public Map<String, Object> getPlayerDTO(Player player) {
        Map<String, Object> dto = new LinkedHashMap<String, Object>();
        dto.put("id", player.getId());
        dto.put("userName", player.getUserName());
        return dto;
    }

    //game_view___________________________________________________________________
    //dto.put para salvos
    @RequestMapping("/game_view/{gamePlayer_Id}")
     public Map<String, Object> getGameView (@PathVariable Long gamePlayer_Id){
         GamePlayer gamePlayer = gamePlayerRepository
                 .findById(gamePlayer_Id)
                 .get();
         return getGameViewDTO(gamePlayer.getGame(), gamePlayer);
     }

    public Map<String, Object> getGameViewDTO(Game game, GamePlayer gamePlayer){
        Map<String, Object> dto = new LinkedHashMap<>();
        Set<Ship> ships = gamePlayer.getShips();
        Set<Salvo> salvos = gamePlayer.getSalvos();
        dto.put("id", game.getId());
        dto.put("created", game.getCreationDate());
        dto.put("gamePlayers", getAllGamePlayers(game.getGamePlayers()));
        dto.put("ships", getAllShips(ships));
        dto.put("salvoes", getAllSalvos(game.getGamePlayers().stream().flatMap(gamePlayer1 -> gamePlayer1.getSalvos().stream()).collect(Collectors.toSet())));
        return dto;
    }


    // Location Ships
    public List<Map<String, Object>> getAllShips(Set<Ship> ships){
        return ships
                .stream()
                .map(ship -> shipDTO(ship))
               .collect(Collectors.toList());
    }

     public Map<String, Object> shipDTO(Ship ship){
       Map<String, Object> dto = new LinkedHashMap<>();
          dto.put("type", ship.getType());
          dto.put("locations", ship.getShipLocations());
        return dto;
    }

    //Location Salvos
    public List<Map<String, Object>> getAllSalvos(Set<Salvo> salvos) {
          return salvos
                  .stream()
                  .map(salvo -> salvoDTO(salvo))
                  .collect(Collectors.toList());
}

    public Map<String, Object> salvoDTO(Salvo salvo){
        Map<String, Object> dto = new LinkedHashMap<>();
        dto.put("turn", salvo.getTurn());
        dto.put("player", salvo.getGamePlayer().getPlayer().getId());
        dto.put("locations", salvo.getSalvoLocations());
        return dto;
    }
}

