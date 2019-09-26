package com.codeoftheweb.salvo;
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

    @Autowired
    private GameRepository gameRepository;

    @Autowired
    private GamePlayerRepository gamePlayerRepository;

    @Autowired
    private ShipRepository shipRepository;

    //game_view___________________________________________________________________
    @RequestMapping("/game_view/{gamePlayer_Id}")
     public Map<String, Object> getGameView (@PathVariable Long gamePlayer_Id){
         GamePlayer gamePlayer = gamePlayerRepository
                 .findById(gamePlayer_Id)
                 .get();
         return getGameViewDTO(gamePlayer.getGame(), gamePlayer);
     }

    public Map<String, Object> getGameViewDTO (Game game, GamePlayer gamePlayer){
        Map<String, Object> dto = new LinkedHashMap<>();
        Set<Ship> ships = gamePlayer.getShips();
        dto.put("id", game.getId());
        dto.put("created", game.getCreationDate());
        dto.put("gamePlayers", getAllGamePlayers(game.getGamePlayers()));
        dto.put("ships", getAllShips(ships));
        return dto;
    }

    //lista games___________________________________________________________________
    @RequestMapping("/games")
    public List<Map<String, Object>> getAllGames() {
        return gameRepository.findAll()
                .stream()
                .map(game -> makeGameDTO(game))
                .collect(toList());
    }

    //GamePlayer___________________________
    public List<Map<String, Object>> getAllGamePlayers(Set<GamePlayer> gamePlayers) {
        return gamePlayers
                .stream()
                .map(gamePlayer -> makeGamePlayerDTO(gamePlayer))
                .collect(toList());
    }

    public Map<String, Object> makeGameDTO(Game game) {
        Map<String, Object> dto = new LinkedHashMap<String, Object>();
        dto.put("id", game.getId());
        dto.put("created", game.getCreationDate());
        dto.put("gamePlayers", getAllGamePlayers(game.getGamePlayers()));
        return dto;
    }

    public Map<String, Object> makeGamePlayerDTO(GamePlayer gamePlayer) {
        Map<String, Object> dto = new LinkedHashMap<String, Object>();
        dto.put("id", gamePlayer.getId());
        dto.put("player", makePlayerDTO(gamePlayer.getPlayer()));

        return dto;
    }

    public Map<String, Object> makePlayerDTO(Player player) {
        Map<String, Object> dto = new LinkedHashMap<String, Object>();
        dto.put("id", player.getId());
        dto.put("userName", player.getUserName());
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
          dto.put("shipType", ship.getType());
          dto.put("locations", ship.getShipLocations());
        return dto;
    }
}

