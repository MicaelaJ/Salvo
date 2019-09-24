package com.codeoftheweb.salvo;

import javafx.beans.binding.ObjectExpression;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.Id;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RequestMapping("/api")
@RestController
public class SalvoController {

    @Autowired
    private GameRepository gameRepository;

    @RequestMapping("/games")
    public List<Long> getAllGames(){
        return gameRepository.findAll()
                             .stream()
                             .map(game -> game.getId())
                             .collect(Collectors.toList());
    }
    //ver
    Map<String, javax.persistence.Id> created = new HashMap<>();

}
