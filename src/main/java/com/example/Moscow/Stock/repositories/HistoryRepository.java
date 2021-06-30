package com.example.Moscow.Stock.repositories;

import com.example.Moscow.Stock.entities.SecurityHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HistoryRepository  extends JpaRepository<SecurityHistory, Long> {
}
