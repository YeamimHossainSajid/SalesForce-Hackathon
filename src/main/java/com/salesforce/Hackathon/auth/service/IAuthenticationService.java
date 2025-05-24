package com.salesforce.Hackathon.auth.service;


import com.salesforce.Hackathon.auth.dto.request.LoginRequestDTO;
import com.salesforce.Hackathon.auth.dto.response.LoginResponseDTO;

public interface IAuthenticationService {
    LoginResponseDTO login(LoginRequestDTO requestDTO );
}
