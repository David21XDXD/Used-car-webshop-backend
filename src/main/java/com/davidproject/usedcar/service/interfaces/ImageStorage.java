package com.davidproject.usedcar.service.interfaces;

import org.springframework.web.multipart.MultipartFile;

public interface ImageStorage {
    String store(MultipartFile file);
}
