package com.salesforce.Hackathon.auth.feature.salesforce.service;

import com.salesforce.Hackathon.auth.feature.salesforce.response.SalesforceAuthResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

@Service
public class SalesforceService {

    private static final Logger logger = LoggerFactory.getLogger(SalesforceService.class);

    private final RestTemplate restTemplate = new RestTemplate();

    // Salesforce credentials
    private final String clientId = "3MVG9fe4g9fhX0E5kgEO_FkTC4.S.o6gJin9.rPob_W9FRNAXNjui8wvwBSI.UKnJJk160mI5liMy0sEcZCTH";
    private final String clientSecret = "63A1AF62D661AA1F18E68FA8D86B3C04B4620023FDB51A6BACF142083B5F6B28";
    private final String username = "sfhackathonbd@2025.com";
    private final String password = "jP9kEs95ruw4Wm2@zOG4B7td7oJd7Ljw5AXAf5pG7LDQ7FixV5PCfF5uyyPehwOK6"; // Password + Security Token
    private final String tokenUrl = "https://login.salesforce.com/services/oauth2/token";

    public SalesforceAuthResponse authenticate() {
        try {
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

            MultiValueMap<String, String> body = new LinkedMultiValueMap<>();
            body.add("grant_type", "password");
            body.add("client_id", clientId);
            body.add("client_secret", clientSecret);
            body.add("username", username);
            body.add("password", password); // password + token concatenated

            HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(body, headers);

            ResponseEntity<SalesforceAuthResponse> response = restTemplate.postForEntity(
                    tokenUrl,
                    request,
                    SalesforceAuthResponse.class
            );

            return response.getBody();
        } catch (Exception e) {
            logger.error("Failed to authenticate with Salesforce", e);
            throw new RuntimeException("Salesforce authentication failed", e);
        }
    }

    public String getAccounts() {
        SalesforceAuthResponse auth = authenticate();

        if (auth == null || auth.getAccessToken() == null) {
            throw new RuntimeException("Salesforce authentication failed, access token is null");
        }

        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(auth.getAccessToken());

        String query = "/services/data/v58.0/query?q=SELECT+Id,+Name+FROM+Account";
        HttpEntity<Void> request = new HttpEntity<>(headers);

        try {
            ResponseEntity<String> response = restTemplate.exchange(
                    auth.getInstanceUrl() + query,
                    HttpMethod.GET,
                    request,
                    String.class
            );

            return response.getBody();
        } catch (Exception e) {
            logger.error("Failed to fetch accounts from Salesforce", e);
            throw new RuntimeException("Salesforce getAccounts failed", e);
        }
    }

    public String getRoomsAndEquipments() {
        SalesforceAuthResponse auth = authenticate();

        if (auth == null || auth.getAccessToken() == null) {
            throw new RuntimeException("Salesforce authentication failed, access token is null");
        }

        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(auth.getAccessToken());

        String apiEndpoint = "/services/apexrest/resources";
        HttpEntity<Void> request = new HttpEntity<>(headers);

        try {
            ResponseEntity<String> response = restTemplate.exchange(
                    auth.getInstanceUrl() + apiEndpoint,
                    HttpMethod.GET,
                    request,
                    String.class
            );

            return response.getBody();
        } catch (Exception e) {
            logger.error("Failed to fetch rooms and equipments from Salesforce", e);
            throw new RuntimeException("Salesforce getRoomsAndEquipments failed", e);
        }
    }
}
