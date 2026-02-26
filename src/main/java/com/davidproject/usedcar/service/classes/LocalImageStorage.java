package com.davidproject.usedcar.service.classes;

import com.davidproject.usedcar.service.interfaces.ImageStorage;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Optional;
import java.util.UUID;

@Service
public class LocalImageStorage implements ImageStorage {

    private final Path root = Paths.get("uploads");

    @Override
    public String store(MultipartFile file) {
        try {
            Files.createDirectories(root);
            String safeName = UUID.randomUUID() + "_" +
                    Optional.ofNullable(file.getOriginalFilename()).orElse("image");

            Path target = root.resolve(safeName).normalize();
            try (InputStream in = file.getInputStream()) {
                Files.copy(in, target, StandardCopyOption.REPLACE_EXISTING);
            }

            return "/uploads/" + safeName;
        } catch (IOException e) {
            throw new RuntimeException("Image upload failed", e);
        }
    }
}