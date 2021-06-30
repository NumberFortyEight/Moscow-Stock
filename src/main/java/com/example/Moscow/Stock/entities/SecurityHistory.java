package com.example.Moscow.Stock.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class SecurityHistory {
    @Id
    private Long id;
    private String secId;
    private LocalDate tradeDate;
    private double numTrades;
    private double open;
}
