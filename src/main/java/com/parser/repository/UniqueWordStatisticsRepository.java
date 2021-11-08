package com.parser.repository;

import com.parser.entity.UniqueWordStatistics;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UniqueWordStatisticsRepository extends JpaRepository<UniqueWordStatistics,Long> {
}
