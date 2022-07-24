/**
 * HCallIfHist Entity Controller 클래스
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
import com.weni.ecs.domain.entity.HCallIfHist;
import com.weni.ecs.domain.repository.HCallIfHistRepository;

import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;


@RestController
@Tag(name = "HCallIfHist 변경 이력(Table) Controller")
@Slf4j
public class HCallIfHistController {

    @Autowired
    HCallIfHistRepository repository;


    @Autowired
    ObjectMapper mapper;

    // @Operation(summary = "변경 이력(Table) 전체조회" , summary = "변경 이력(Table) 조회" )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the hcallifhists", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = HCallIfHist.class)) }),
            @ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content) })
    @GetMapping("/hcallifhists")
    public ResponseEntity<Page<HCallIfHist>> getAll(@PageableDefault Pageable pageable) {
        try {
			log.info("findAll");
            return ResponseEntity.ok().body(repository.findAll(pageable));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(null);
        }
    }

    
    // @Operation(summary = "변경 이력(Table) Key조회" , description = "변경 이력(Table) Primary Key로 조회" )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the HCallIfHist", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = HCallIfHist.class)) }),
            @ApiResponse(responseCode = "404", description = "HCallIfHist not found", content = @Content) })
    @GetMapping("/hcallifhists/{histSeqNum}")
    public ResponseEntity<HCallIfHist> getById(@PathVariable("histSeqNum") Integer histSeqNum) {
        Optional<HCallIfHist> data = repository.findById(histSeqNum);

        if (data.isPresent()) {
            return ResponseEntity.ok().body(data.get());
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // @Operation(summary = "변경 이력(Table) 등록" , description = "변경 이력(Table) 신규 데이터 등록" )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Create the HCallIfHist", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = HCallIfHist.class)) }),
            @ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content) })
    @PostMapping("/hcallifhists")
    ResponseEntity<HCallIfHist> postData(@RequestBody HCallIfHist newData) {
        try {
            newData = repository.save(newData);
            return new ResponseEntity<>(newData, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // @Operation(summary = "변경 이력(Table) 수정" , description = "변경 이력(Table) 데이터 수정" )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Update the HCallIfHist", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = HCallIfHist.class)) }),
            @ApiResponse(responseCode = "404", description = "HCallIfHist not found", content = @Content) })
    @PutMapping("/hcallifhists/{histSeqNum}")
    ResponseEntity<HCallIfHist> putData(@RequestBody HCallIfHist newData, @PathVariable("histSeqNum") Integer histSeqNum) {
        return repository.findById(histSeqNum) //
                .map(oldData -> {
                    newData.setHistSeqNum(oldData.getHistSeqNum());
                    return new ResponseEntity<>(repository.save(newData), HttpStatus.OK);
                })
                .orElseGet(() -> {
                    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
                });

    }

    // @Operation(summary = "변경 이력(Table) 수정" , description = "변경 이력(Table) 데이터 수정" )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Update the HCallIfHist", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = HCallIfHist.class)) }),
            @ApiResponse(responseCode = "404", description = "HCallIfHist not found", content = @Content) })
	@PatchMapping("/hcallifhists/{histSeqNum}")
    ResponseEntity<HCallIfHist> patchData(@RequestBody Map<String, Object> newMap, @PathVariable("histSeqNum") Integer histSeqNum) {
        HCallIfHist newData = mapper.convertValue(newMap, HCallIfHist.class);
        return repository.findById(histSeqNum) //
                .map(oldData -> {
                    newMap.forEach((strKey, strValue) -> {
						switch(strKey){
						    case "pcallStrtDaytime" : oldData.setPcallStrtDaytime(newData.getPcallStrtDaytime()); break;
						    case "pcallCloseDaytime" : oldData.setPcallCloseDaytime(newData.getPcallCloseDaytime()); break;
						    case "pcallLen" : oldData.setPcallLen(newData.getPcallLen()); break;
						    case "numbmkcallYn" : oldData.setNumbmkcallYn(newData.getNumbmkcallYn()); break;
						    case "famNm" : oldData.setFamNm(newData.getFamNm()); break;
						    case "givNm" : oldData.setGivNm(newData.getGivNm()); break;
						    case "ctiUsrId" : oldData.setCtiUsrId(newData.getCtiUsrId()); break;
						    case "callId" : oldData.setCallId(newData.getCallId()); break;
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
	
    // @Operation(summary = "변경 이력(Table) 삭제" , description = "변경 이력(Table) Primary Key로 삭제" )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Delete the HCallIfHist", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = HCallIfHist.class)) }),
            @ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content) })
    @DeleteMapping("/hcallifhists/{histSeqNum}")
    public ResponseEntity<HttpStatus> deleteUser(@PathVariable("histSeqNum") Integer histSeqNum) {
        try {
            repository.deleteById(histSeqNum);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
