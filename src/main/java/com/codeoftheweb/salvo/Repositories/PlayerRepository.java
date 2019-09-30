package com.codeoftheweb.salvo.Repositories;

import com.codeoftheweb.salvo.Models.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import java.util.List;

//interface para metodos mas complejos, almacena conjuto de clases
//gestiona el almacenamiento y la recuperacion de instancias de clases en una base de datos

//crear un REST repository para que STRING agregue
//código para permitirle administrar sus datos en su navegador, ¡usando JSON!
@RepositoryRestResource
public interface PlayerRepository extends JpaRepository<Player, Long> {
    List<Player> findByUserName(String userName);
}
