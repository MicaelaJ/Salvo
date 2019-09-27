package com.codeoftheweb.salvo.Repositories;

import com.codeoftheweb.salvo.Methods.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface GameRepository extends JpaRepository<Game, Long> {
}
//no es necesario el finby...
