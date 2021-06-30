package com.example.Moscow.Stock.entities;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "securities")
public class SecurityInfo {
    @Id
    private int id;
    private String secId;
    private String name;
    private String emitentTitle;
}



