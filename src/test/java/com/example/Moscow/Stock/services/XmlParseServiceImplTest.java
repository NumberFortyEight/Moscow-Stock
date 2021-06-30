package com.example.Moscow.Stock.services;

import com.example.Moscow.Stock.entities.SecurityHistory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;
import java.util.List;

@SpringBootTest
class XmlParseServiceImplTest {

    @Autowired
    private XmlParseService xmlParseService;

    @Test
    public void sout(){
        String URL_TO_XML = "src\\main\\resources\\xml\\history_1.xml";
        List<SecurityHistory> securityHistories = xmlParseService.parseSecurityHistory(new File(URL_TO_XML));

    }

}