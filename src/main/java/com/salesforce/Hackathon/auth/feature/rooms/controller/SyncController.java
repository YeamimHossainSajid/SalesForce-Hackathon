package com.salesforce.Hackathon.auth.feature.rooms.controller;

import com.salesforce.Hackathon.auth.feature.rooms.service.DataSyncService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/sync")
public class SyncController {
    private final DataSyncService dataSyncService;

    public SyncController(DataSyncService dataSyncService) {
        this.dataSyncService = dataSyncService;
    }

    @PostMapping
    public ResponseEntity<Void> sync() {
        dataSyncService.syncExternalData();
        return ResponseEntity.ok().build();
    }
}

