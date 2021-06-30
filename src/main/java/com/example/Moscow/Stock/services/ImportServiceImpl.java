package com.example.Moscow.Stock.services;

import com.example.Moscow.Stock.repositories.HistoryRepository;
import com.example.Moscow.Stock.repositories.SecurityInfoRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

@Service
@RequiredArgsConstructor
public class ImportServiceImpl implements ImportService {

    @Value("${upload.path}")
    private String UPLOAD_FILE_PATH;

    private final SecurityInfoRepository securityInfoRepository;
    private final HistoryRepository historyRepository;
    private final XmlParseService xmlParseService;

    @SneakyThrows
    @Override
    public void importFromFile(MultipartFile multipartFile) {
        File file = new File(UPLOAD_FILE_PATH + "/" + multipartFile.getOriginalFilename());
        multipartFile.transferTo(file);
        switch (xmlParseService.getDataId(file)) {
            case "securities":
                securityInfoRepository.saveAll(xmlParseService.parseSecurities(file));
                break;
            case "history":
                historyRepository.saveAll(xmlParseService.parseSecurityHistory(file));
                break;
        }
    }
}
