package com.example.Moscow.Stock.entities;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class SecurityInfo {
    private int id;
    private String secId;
    private String name;
    private String emitentTitle;
}


