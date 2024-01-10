package com.example.pruebatecnica.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.pruebatecnica.service.AsyncFileService;

@RestController
public class FileController {

    private final AsyncFileService asyncFileService;

    public FileController(AsyncFileService asyncFileService) {
        this.asyncFileService = asyncFileService;
    }

    @PostMapping("/api/copy")
    public ResponseEntity<?> handleFileUpload(@RequestParam("File") MultipartFile file) {
        asyncFileService.saveFile(file);
        return ResponseEntity.ok("File is being processed.");
    }
}

