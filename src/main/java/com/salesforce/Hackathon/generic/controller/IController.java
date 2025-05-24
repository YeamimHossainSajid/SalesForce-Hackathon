package com.salesforce.Hackathon.generic.controller;

import com.salesforce.Hackathon.generic.payload.request.GenericIdsDto;
import com.salesforce.Hackathon.generic.payload.request.IDto;
import com.salesforce.Hackathon.generic.payload.response.BaseResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

import java.io.IOException;
import java.util.List;

public interface IController<D extends IDto> {

//    PageData getAll(Boolean isActive, Pageable pageable);

    <T extends BaseResponseDto>T getSingle(Long id);

    ResponseEntity<List<Object>> getAll();

    ResponseEntity<String> create(D d) throws IOException;

    ResponseEntity<String> update(D d, Long id) throws IOException;

    ResponseEntity<String> updateActiveStatus(@PathVariable Long id, Boolean isActive);
    ResponseEntity<String> batchActiveStatus(GenericIdsDto ids);
}