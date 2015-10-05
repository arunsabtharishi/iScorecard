package com.dragonfly.iscorecard.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.dragonfly.iscorecard.domain.FieldingStats;

@Repository
public interface FieldingStatsJpaRepository extends JpaRepository<FieldingStats, Long> {

}
