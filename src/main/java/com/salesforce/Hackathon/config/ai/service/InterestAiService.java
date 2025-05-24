package com.salesforce.Hackathon.config.ai.service;

import com.salesforce.Hackathon.auth.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InterestAiService {
    @Autowired
    UserRepo userRepo;
    @Autowired
    CohereService cohereService;
//   @Autowired
//  OpenRouterService openRouterService;


    public String interest(String question) {
//        String interest = Optional.ofNullable(user)
//                .map(User::getStudent)
//                .map(student -> {
//                    String interests = student.getInterests() != null ? student.getInterests() : "";
//                    String futurePlans = student.getFuturePlans() != null ? student.getFuturePlans() : "";
//                    return interests + futurePlans + futurePlans;
//                })
//                .orElse("");
        String answer = cohereService.interest(question+" in short ");
        return answer;
    }

}