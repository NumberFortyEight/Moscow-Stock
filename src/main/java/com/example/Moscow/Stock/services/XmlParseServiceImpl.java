package com.example.Moscow.Stock.services;

import com.example.Moscow.Stock.entities.SecurityHistory;
import com.example.Moscow.Stock.entities.SecurityInfo;
import lombok.SneakyThrows;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class XmlParseServiceImpl implements XmlParseService {

    private List<Element> getRows(File file) {
        try {
            SAXBuilder saxBuilder = new SAXBuilder();
            Document document = saxBuilder.build(file);
            return document.getRootElement().getChild("data")
                    .getChild("rows")
                    .getChildren("row");
        } catch (JDOMException | IOException e) {
            throw new IllegalArgumentException("Incorrect file");
        }
    }

    @SneakyThrows
    @Override
    public String getDataId(File file) {
        SAXBuilder saxBuilder = new SAXBuilder();
        Document document = saxBuilder.build(file);
        return document.getRootElement().getChild("data").getAttributeValue("id");
    }

    @Override
    public List<SecurityInfo> parseSecurities(File securitiesFile) {
        return getRows(securitiesFile)
                .stream()
                .map(row -> SecurityInfo.builder()
                        .id(Integer.parseInt(row.getAttributeValue("id")))
                        .secId(row.getAttributeValue("secid"))
                        .name(row.getAttributeValue("name"))
                        .emitentTitle(row.getAttributeValue("emitent_title"))
                        .build())
                .collect(Collectors.toList());
    }

    @Override
    public List<SecurityHistory> parseSecurityHistory(File historyFile) {
        return getRows(historyFile)
                .stream()
                .map(row -> {
                    String secId = row.getAttributeValue("SECID");
                    LocalDate tradeDate = LocalDate.parse(row.getAttributeValue("TRADEDATE"));
                    String numTrades = row.getAttributeValue("NUMTRADES");
                    String open = row.getAttributeValue("OPEN");

                    SecurityHistory securityHistory = new SecurityHistory();
                    securityHistory.setSecId(secId);
                    securityHistory.setTradeDate(tradeDate);

                    if (!open.equals("")) {
                        securityHistory.setOpen(Double.parseDouble(open));
                    }
                    if (!numTrades.equals("")) {
                        securityHistory.setNumTrades(Double.parseDouble(numTrades));
                    }
                    return securityHistory;
                })
                .collect(Collectors.toList());
    }
}
