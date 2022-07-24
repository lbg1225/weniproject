/**
 * HNotfcMkcallHist Entity Controller 클래스
 *
 *  @author  Lee Byoung Gwan
 *  @version 1.0
**/
package com.weni.ecs.controller;

import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.weni.ecs.domain.entity.HNotfcMkcallHist;
import com.weni.ecs.domain.repository.HNotfcMkcallHistRepository;

import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;


@RestController
@Tag(name = "HNotfcMkcallHist 알림 발신 이력(Table) Controller")
@Slf4j
public class HNotfcMkcallHistController {

    @Autowired
    HNotfcMkcallHistRepository repository;


    @Autowired
    ObjectMapper mapper;

    // @Operation(summary = "알림 발신 이력(Table) 전체조회" , summary = "알림 발신 이력(Table) 조회" )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the hnotfcmkcallhists", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = HNotfcMkcallHist.class)) }),
            @ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content) })
    @GetMapping("/hnotfcmkcallhists")
    public ResponseEntity<Page<HNotfcMkcallHist>> getAll(@PageableDefault Pageable pageable) {
        try {
			log.info("findAll");
            return ResponseEntity.ok().body(repository.findAll(pageable));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(null);
        }
    }

    
    // @Operation(summary = "알림 발신 이력(Table) Key조회" , description = "알림 발신 이력(Table) Primary Key로 조회" )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the HNotfcMkcallHist", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = HNotfcMkcallHist.class)) }),
            @ApiResponse(responseCode = "404", description = "HNotfcMkcallHist not found", content = @Content) })
    @GetMapping("/hnotfcmkcallhists/{mkcallSeqNum}")
    public ResponseEntity<HNotfcMkcallHist> getById(@PathVariable("mkcallSeqNum") Integer mkcallSeqNum) {
        Optional<HNotfcMkcallHist> data = repository.findById(mkcallSeqNum);

        if (data.isPresent()) {
            return ResponseEntity.ok().body(data.get());
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // @Operation(summary = "알림 발신 이력(Table) 등록" , description = "알림 발신 이력(Table) 신규 데이터 등록" )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Create the HNotfcMkcallHist", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = HNotfcMkcallHist.class)) }),
            @ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content) })
    @PostMapping("/hnotfcmkcallhists")
    ResponseEntity<HNotfcMkcallHist> postData(@RequestBody HNotfcMkcallHist newData) {
        try {
            newData = repository.save(newData);
            return new ResponseEntity<>(newData, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // @Operation(summary = "알림 발신 이력(Table) 수정" , description = "알림 발신 이력(Table) 데이터 수정" )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Update the HNotfcMkcallHist", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = HNotfcMkcallHist.class)) }),
            @ApiResponse(responseCode = "404", description = "HNotfcMkcallHist not found", content = @Content) })
    @PutMapping("/hnotfcmkcallhists/{mkcallSeqNum}")
    ResponseEntity<HNotfcMkcallHist> putData(@RequestBody HNotfcMkcallHist newData, @PathVariable("mkcallSeqNum") Integer mkcallSeqNum) {
        return repository.findById(mkcallSeqNum) //
                .map(oldData -> {
                    newData.setMkcallSeqNum(oldData.getMkcallSeqNum());
                    return new ResponseEntity<>(repository.save(newData), HttpStatus.OK);
                })
                .orElseGet(() -> {
                    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
                });

    }

    // @Operation(summary = "알림 발신 이력(Table) 수정" , description = "알림 발신 이력(Table) 데이터 수정" )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Update the HNotfcMkcallHist", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = HNotfcMkcallHist.class)) }),
            @ApiResponse(responseCode = "404", description = "HNotfcMkcallHist not found", content = @Content) })
	@PatchMapping("/hnotfcmkcallhists/{mkcallSeqNum}")
    ResponseEntity<HNotfcMkcallHist> patchData(@RequestBody Map<String, Object> newMap, @PathVariable("mkcallSeqNum") Integer mkcallSeqNum) {
        HNotfcMkcallHist newData = mapper.convertValue(newMap, HNotfcMkcallHist.class);
        return repository.findById(mkcallSeqNum) //
                .map(oldData -> {
                    newMap.forEach((strKey, strValue) -> {
						switch(strKey){
						    case "sendpersnId" : oldData.setSendpersnId(newData.getSendpersnId()); break;
						    case "incidNum" : oldData.setIncidNum(newData.getIncidNum()); break;
						    case "incidOview" : oldData.setIncidOview(newData.getIncidOview()); break;
						    case "indicItm" : oldData.setIndicItm(newData.getIndicItm()); break;
						    case "sendTm" : oldData.setSendTm(newData.getSendTm()); break;
						    case "fstRegpersnId" : oldData.setFstRegpersnId(newData.getFstRegpersnId()); break;
						    case "finalUptpersnId" : oldData.setFinalUptpersnId(newData.getFinalUptpersnId()); break;
						    case "fstRegTm" : oldData.setFstRegTm(newData.getFstRegTm()); break;
						    case "finalUptTm" : oldData.setFinalUptTm(newData.getFinalUptTm()); break;
						}
                    });
                    return new ResponseEntity<>(repository.save(oldData), HttpStatus.OK);
                })
                .orElseGet(() -> {
                    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
                });
    }
	
    // @Operation(summary = "알림 발신 이력(Table) 삭제" , description = "알림 발신 이력(Table) Primary Key로 삭제" )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Delete the HNotfcMkcallHist", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = HNotfcMkcallHist.class)) }),
            @ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content) })
    @DeleteMapping("/hnotfcmkcallhists/{mkcallSeqNum}")
    public ResponseEntity<HttpStatus> deleteUser(@PathVariable("mkcallSeqNum") Integer mkcallSeqNum) {
        try {
            repository.deleteById(mkcallSeqNum);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
