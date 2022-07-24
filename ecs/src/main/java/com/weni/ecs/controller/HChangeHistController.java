/**
 * HChangeHist Entity Controller 클래스
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
import com.weni.ecs.domain.entity.HChangeHist;
import com.weni.ecs.domain.repository.HChangeHistRepository;

import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;


@RestController
@Tag(name = "HChangeHist 콜 인터페이스 이력(Table) Controller")
@Slf4j
public class HChangeHistController {

    @Autowired
    HChangeHistRepository repository;


    @Autowired
    ObjectMapper mapper;

    // @Operation(summary = "콜 인터페이스 이력(Table) 전체조회" , summary = "콜 인터페이스 이력(Table) 조회" )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the hchangehists", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = HChangeHist.class)) }),
            @ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content) })
    @GetMapping("/hchangehists")
    public ResponseEntity<Page<HChangeHist>> getAll(@PageableDefault Pageable pageable) {
        try {
			log.info("findAll");
            return ResponseEntity.ok().body(repository.findAll(pageable));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(null);
        }
    }

    
    // @Operation(summary = "콜 인터페이스 이력(Table) Key조회" , description = "콜 인터페이스 이력(Table) Primary Key로 조회" )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the HChangeHist", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = HChangeHist.class)) }),
            @ApiResponse(responseCode = "404", description = "HChangeHist not found", content = @Content) })
    @GetMapping("/hchangehists/{changeSeqNum}")
    public ResponseEntity<HChangeHist> getById(@PathVariable("changeSeqNum") Integer changeSeqNum) {
        Optional<HChangeHist> data = repository.findById(changeSeqNum);

        if (data.isPresent()) {
            return ResponseEntity.ok().body(data.get());
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // @Operation(summary = "콜 인터페이스 이력(Table) 등록" , description = "콜 인터페이스 이력(Table) 신규 데이터 등록" )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Create the HChangeHist", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = HChangeHist.class)) }),
            @ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content) })
    @PostMapping("/hchangehists")
    ResponseEntity<HChangeHist> postData(@RequestBody HChangeHist newData) {
        try {
            newData = repository.save(newData);
            return new ResponseEntity<>(newData, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // @Operation(summary = "콜 인터페이스 이력(Table) 수정" , description = "콜 인터페이스 이력(Table) 데이터 수정" )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Update the HChangeHist", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = HChangeHist.class)) }),
            @ApiResponse(responseCode = "404", description = "HChangeHist not found", content = @Content) })
    @PutMapping("/hchangehists/{changeSeqNum}")
    ResponseEntity<HChangeHist> putData(@RequestBody HChangeHist newData, @PathVariable("changeSeqNum") Integer changeSeqNum) {
        return repository.findById(changeSeqNum) //
                .map(oldData -> {
                    newData.setChangeSeqNum(oldData.getChangeSeqNum());
                    return new ResponseEntity<>(repository.save(newData), HttpStatus.OK);
                })
                .orElseGet(() -> {
                    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
                });

    }

    // @Operation(summary = "콜 인터페이스 이력(Table) 수정" , description = "콜 인터페이스 이력(Table) 데이터 수정" )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Update the HChangeHist", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = HChangeHist.class)) }),
            @ApiResponse(responseCode = "404", description = "HChangeHist not found", content = @Content) })
	@PatchMapping("/hchangehists/{changeSeqNum}")
    ResponseEntity<HChangeHist> patchData(@RequestBody Map<String, Object> newMap, @PathVariable("changeSeqNum") Integer changeSeqNum) {
        HChangeHist newData = mapper.convertValue(newMap, HChangeHist.class);
        return repository.findById(changeSeqNum) //
                .map(oldData -> {
                    newMap.forEach((strKey, strValue) -> {
						switch(strKey){
						    case "recptNum" : oldData.setRecptNum(newData.getRecptNum()); break;
						    case "usrId" : oldData.setUsrId(newData.getUsrId()); break;
						    case "changeDiv" : oldData.setChangeDiv(newData.getChangeDiv()); break;
						    case "changeItem" : oldData.setChangeItem(newData.getChangeItem()); break;
						    case "preData" : oldData.setPreData(newData.getPreData()); break;
						    case "afterData" : oldData.setAfterData(newData.getAfterData()); break;
						    case "changepersnId" : oldData.setChangepersnId(newData.getChangepersnId()); break;
						    case "changeTm" : oldData.setChangeTm(newData.getChangeTm()); break;
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
	
    // @Operation(summary = "콜 인터페이스 이력(Table) 삭제" , description = "콜 인터페이스 이력(Table) Primary Key로 삭제" )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Delete the HChangeHist", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = HChangeHist.class)) }),
            @ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content) })
    @DeleteMapping("/hchangehists/{changeSeqNum}")
    public ResponseEntity<HttpStatus> deleteUser(@PathVariable("changeSeqNum") Integer changeSeqNum) {
        try {
            repository.deleteById(changeSeqNum);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
