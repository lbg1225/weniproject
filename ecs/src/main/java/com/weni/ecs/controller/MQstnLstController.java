/**
 * MQstnLst Entity Controller 클래스
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
import com.weni.ecs.domain.entity.MQstnLst;
import com.weni.ecs.domain.repository.MQstnLstRepository;

import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;


@RestController
@Tag(name = "MQstnLst 질문 목록(Table) Controller")
@Slf4j
public class MQstnLstController {

    @Autowired
    MQstnLstRepository repository;


    @Autowired
    ObjectMapper mapper;

    // @Operation(summary = "질문 목록(Table) 전체조회" , summary = "질문 목록(Table) 조회" )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the mqstnlsts", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = MQstnLst.class)) }),
            @ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content) })
    @GetMapping("/mqstnlsts")
    public ResponseEntity<Page<MQstnLst>> getAll(@PageableDefault Pageable pageable) {
        try {
			log.info("findAll");
            return ResponseEntity.ok().body(repository.findAll(pageable));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(null);
        }
    }

    
    // @Operation(summary = "질문 목록(Table) Key조회" , description = "질문 목록(Table) Primary Key로 조회" )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the MQstnLst", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = MQstnLst.class)) }),
            @ApiResponse(responseCode = "404", description = "MQstnLst not found", content = @Content) })
    @GetMapping("/mqstnlsts/{qstnId}")
    public ResponseEntity<MQstnLst> getById(@PathVariable("qstnId") String qstnId) {
        Optional<MQstnLst> data = repository.findById(qstnId);

        if (data.isPresent()) {
            return ResponseEntity.ok().body(data.get());
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // @Operation(summary = "질문 목록(Table) 등록" , description = "질문 목록(Table) 신규 데이터 등록" )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Create the MQstnLst", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = MQstnLst.class)) }),
            @ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content) })
    @PostMapping("/mqstnlsts")
    ResponseEntity<MQstnLst> postData(@RequestBody MQstnLst newData) {
        try {
            newData = repository.save(newData);
            return new ResponseEntity<>(newData, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // @Operation(summary = "질문 목록(Table) 수정" , description = "질문 목록(Table) 데이터 수정" )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Update the MQstnLst", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = MQstnLst.class)) }),
            @ApiResponse(responseCode = "404", description = "MQstnLst not found", content = @Content) })
    @PutMapping("/mqstnlsts/{qstnId}")
    ResponseEntity<MQstnLst> putData(@RequestBody MQstnLst newData, @PathVariable("qstnId") String qstnId) {
        return repository.findById(qstnId) //
                .map(oldData -> {
                    newData.setQstnId(oldData.getQstnId());
                    return new ResponseEntity<>(repository.save(newData), HttpStatus.OK);
                })
                .orElseGet(() -> {
                    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
                });

    }

    // @Operation(summary = "질문 목록(Table) 수정" , description = "질문 목록(Table) 데이터 수정" )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Update the MQstnLst", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = MQstnLst.class)) }),
            @ApiResponse(responseCode = "404", description = "MQstnLst not found", content = @Content) })
	@PatchMapping("/mqstnlsts/{qstnId}")
    ResponseEntity<MQstnLst> patchData(@RequestBody Map<String, Object> newMap, @PathVariable("qstnId") String qstnId) {
        MQstnLst newData = mapper.convertValue(newMap, MQstnLst.class);
        return repository.findById(qstnId) //
                .map(oldData -> {
                    newMap.forEach((strKey, strValue) -> {
						switch(strKey){
						    case "incidtypeBigclssfyCode" : oldData.setIncidtypeBigclssfyCode(newData.getIncidtypeBigclssfyCode()); break;
						    case "incidtypeMedclssfyCode" : oldData.setIncidtypeMedclssfyCode(newData.getIncidtypeMedclssfyCode()); break;
						    case "incidtypeSmallclssfyCode" : oldData.setIncidtypeSmallclssfyCode(newData.getIncidtypeSmallclssfyCode()); break;
						    case "qstnCont" : oldData.setQstnCont(newData.getQstnCont()); break;
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
	
    // @Operation(summary = "질문 목록(Table) 삭제" , description = "질문 목록(Table) Primary Key로 삭제" )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Delete the MQstnLst", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = MQstnLst.class)) }),
            @ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content) })
    @DeleteMapping("/mqstnlsts/{qstnId}")
    public ResponseEntity<HttpStatus> deleteUser(@PathVariable("qstnId") String qstnId) {
        try {
            repository.deleteById(qstnId);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
