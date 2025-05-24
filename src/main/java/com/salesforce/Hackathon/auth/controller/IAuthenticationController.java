package com.salesforce.Hackathon.auth.controller;


import com.salesforce.Hackathon.auth.dto.request.LoginRequestDTO;
import com.salesforce.Hackathon.auth.dto.response.LoginResponseDTO;
import org.springframework.http.ResponseEntity;

public interface IAuthenticationController {

    ResponseEntity<LoginResponseDTO> login(LoginRequestDTO requestDTO );

}
