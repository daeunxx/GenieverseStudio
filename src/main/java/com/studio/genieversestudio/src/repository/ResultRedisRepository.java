package com.studio.genieversestudio.src.repository;

import com.studio.genieversestudio.src.dto.ResultHistory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ResultRedisRepository extends JpaRepository<ResultHistory, String> {
    Optional<List<ResultHistory>> findByIpOrderByCreateDateTimeAsc(String ip);
}