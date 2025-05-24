package com.salesforce.Hackathon.auth.feature.rooms.controller;

import com.salesforce.Hackathon.auth.feature.rooms.service.DataImportService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class DataImportController {

    private final DataImportService dataImportService;

    @GetMapping("/import-data")
    public String importData() {
        try {
            dataImportService.fetchAndSaveRoomsAndEquipment();
            return "Data imported successfully";
        } catch (Exception e) {
            e.printStackTrace();
            return "Import failed: " + e.getMessage();
        }
    }
}

