package com.salesforce.Hackathon.auth.feature.salesforce.controller;

import com.salesforce.Hackathon.auth.feature.salesforce.response.SalesforceAuthResponse;
import com.salesforce.Hackathon.auth.feature.salesforce.service.SalesforceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/salesforce")
public class SalesforceController {

    @Autowired
    private SalesforceService salesforceService;

    @GetMapping("/auth")
    public SalesforceAuthResponse authenticate() {
        return salesforceService.authenticate();
    }

    @GetMapping("/accounts")
    public String getAccounts() {
        return salesforceService.getAccounts();
    }

    @GetMapping("/resources")
    public String getRoomsAndEquipments() {
        return salesforceService.getRoomsAndEquipments();
    }
}
