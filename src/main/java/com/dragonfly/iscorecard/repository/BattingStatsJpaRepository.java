package com.dragonfly.iscorecard.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.dragonfly.iscorecard.domain.BattingStats;

@Repository
public interface BattingStatsJpaRepository extends JpaRepository<BattingStats, Long> {
	List<BattingStats> findByGameId(String gameId);
}
