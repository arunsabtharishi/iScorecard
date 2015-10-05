package com.dragonfly.iscorecard.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.dragonfly.iscorecard.domain.BowlingStats;

@Repository
public interface BowlingStatsJpaRepository extends JpaRepository<BowlingStats, Long> {

}
