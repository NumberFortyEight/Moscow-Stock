package com.example.Moscow.Stock.repositories;

import com.example.Moscow.Stock.entities.SecurityInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SecurityInfoRepository extends JpaRepository<SecurityInfo, Integer> {
}
