package com.example.Moscow.Stock.services;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;

public interface ImportService {
    void importFromFile(MultipartFile file);
}
