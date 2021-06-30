package com.example.Moscow.Stock.services;

import com.example.Moscow.Stock.entities.SecurityHistory;
import com.example.Moscow.Stock.entities.SecurityInfo;

import java.io.File;
import java.util.List;

public interface XmlParseService {
    String getDataId(File file);
    List<SecurityInfo> parseSecurities(File securitiesFile);
    List<SecurityHistory> parseSecurityHistory(File historyFile);
}
