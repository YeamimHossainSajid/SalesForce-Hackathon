package com.salesforce.Hackathon.config.image.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;

public interface CloudneryImageService {
    public Map upload(MultipartFile file) throws IOException;

}
