package com.weni.ecs.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.weni.ecs.domain.service.SampleService;
import com.weni.ecs.dto.SIncidCardSIncidCardFire;

@RestController
public class SampleController {
    private SampleService sampleService;

    public SampleController(SampleService sampleService) {
        this.sampleService = sampleService;
    }

    @GetMapping(path = "test")
    public ResponseEntity getByIncidNum(SIncidCardSIncidCardFire sIncidCardSIncidCardFire) {
        System.out.println(sIncidCardSIncidCardFire.toString());
        return new ResponseEntity(sampleService.getByIncidNum(sIncidCardSIncidCardFire), HttpStatus.OK);
    }  

}
