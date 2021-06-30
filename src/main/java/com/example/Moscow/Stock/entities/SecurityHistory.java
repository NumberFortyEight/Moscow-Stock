package com.example.Moscow.Stock.entities;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class SecurityHistory {
    private String secId;
    private LocalDate tradeDate;
    private double numTrades;
    private double open;
}
