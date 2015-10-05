package com.dragonfly.iscorecard.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dragonfly.iscorecard.domain.Player;

@Repository
public interface PlayerJpaRepository extends JpaRepository<Player, Long> {

}
