package com.salesforce.Hackathon.config.ai.controller;

import com.salesforce.Hackathon.config.ai.service.InterestAiService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("ai")
public class interestAiController {
    public InterestAiService interestAi;

    public interestAiController(InterestAiService InterestAiService) {
        this.interestAi = InterestAiService;
    }
    @GetMapping("interest/question/{text}")
    public ResponseEntity<String> interests(@PathVariable String text) {
        return ResponseEntity.ok(interestAi.interest(text));
    }
}