package com.example.pruebatecnica.util;

import com.example.pruebatecnica.model.User;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

@Component
public class FileGenerator {

    private final ResourceLoader resourceLoader;

    public FileGenerator(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }

    public Resource generateCsvFile(List<User> users) {
        try {
            Path tempFile = Files.createTempFile("users", ".csv");
            try (PrintWriter writer = new PrintWriter(Files.newBufferedWriter(tempFile))) {
                writer.println("Fullname,Phone,Address");
                for (User user : users) {
                    writer.println(user.getFullname() + "," + user.getPhone() + "," + user.getAddress());
                }
            }
            return resourceLoader.getResource("file:" + tempFile.toAbsolutePath().toString());
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to generate file", e);
        }
    }
}