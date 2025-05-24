package com.salesforce.Hackathon.auth.service;

import com.salesforce.Hackathon.auth.dto.response.CustomRoleResponseDTO;

public interface RoleService {

    public CustomRoleResponseDTO readOne(Long id );
    public String delete( Long id );

}
