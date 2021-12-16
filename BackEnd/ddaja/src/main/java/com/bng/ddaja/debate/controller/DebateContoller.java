package com.bng.ddaja.debate.controller;

import com.bng.ddaja.common.dto.CommonResponse;

import com.bng.ddaja.debate.dto.DebateSearch;
import com.bng.ddaja.common.hateoas.debate.DebateHateoas;
import com.bng.ddaja.debate.service.DebateService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@RequestMapping("/debate")
@AllArgsConstructor
@RestController
public class DebateContoller {

    private DebateService debateService;

    @GetMapping("")
    public ResponseEntity<CommonResponse> getAllDebateByDebateSearch(DebateSearch debateSearch){
        return ResponseEntity.ok().body(
            new CommonResponse(
                debateService.getAllDebateByDebateSearch(debateSearch)
                , DebateHateoas.values()
            )
        );
    }
    
}
