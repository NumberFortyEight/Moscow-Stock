package com.example.Moscow.Stock.controllers;

import com.example.Moscow.Stock.services.ImportService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequiredArgsConstructor
public class UploadController {

    @NonNull
    private final ImportService importService;

    @PostMapping("/upload")
    @ResponseStatus(HttpStatus.OK)
    public void uploadFile(@RequestParam("file") MultipartFile file) {
        importService.importFromFile(file);
    }
}
