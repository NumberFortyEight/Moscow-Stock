package com.example.Moscow.Stock.services;

import com.example.Moscow.Stock.entities.SecurityHistory;
import com.example.Moscow.Stock.entities.SecurityInfo;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ImportServiceImplTest {

    @Autowired
    private ObjectImportService objectImportService;

    @Test
    public void sout(){
        String URL_TO_XML = "src\\main\\resources\\xml\\history_1.xml";
        List<SecurityHistory> securityHistories = objectImportService.parseSecurityHistory(new File(URL_TO_XML));

    }

}