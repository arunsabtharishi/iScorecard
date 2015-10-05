package com.dragonfly.iscorecard.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dragonfly.iscorecard.domain.Game;

@Repository
public interface GameJpaRepository extends JpaRepository<Game, Long> {

}
