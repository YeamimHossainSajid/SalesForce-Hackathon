package com.salesforce.Hackathon.auth.feature.rooms.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.salesforce.Hackathon.auth.feature.rooms.dto.response.ExternalApiResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ExternalApiService {

    private final RestTemplate restTemplate;
    private final ObjectMapper objectMapper;

    public ExternalApiService(RestTemplate restTemplate, ObjectMapper objectMapper) {
        this.restTemplate = restTemplate;
        this.objectMapper = objectMapper;
    }

    public ExternalApiResponseDto fetchExternalData() {
        String url = "https://raw.githubusercontent.com/twentyTwo/sf-hackathon-bd-2025/refs/heads/main/data.json";

        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);

        if (response.getStatusCode().is2xxSuccessful() && response.getBody() != null) {
            try {

                return objectMapper.readValue(response.getBody(), ExternalApiResponseDto.class);
            } catch (Exception e) {
                throw new RuntimeException("Failed to parse JSON response", e);
            }
        }
        throw new RuntimeException("Failed to fetch external data");
    }
}


