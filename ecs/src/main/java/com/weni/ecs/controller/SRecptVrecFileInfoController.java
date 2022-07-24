/**
 * SRecptVrecFileInfo Entity Controller 클래스
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
import com.weni.ecs.domain.entity.SRecptVrecFileInfo;
import com.weni.ecs.domain.repository.SRecptVrecFileInfoRepository;

import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;


@RestController
@Tag(name = "SRecptVrecFileInfo 접속 녹취 파일 정보(Table) Controller")
@Slf4j
public class SRecptVrecFileInfoController {

    @Autowired
    SRecptVrecFileInfoRepository repository;


    @Autowired
    ObjectMapper mapper;

    // @Operation(summary = "접속 녹취 파일 정보(Table) 전체조회" , summary = "접속 녹취 파일 정보(Table) 조회" )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the srecptvrecfileinfos", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = SRecptVrecFileInfo.class)) }),
            @ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content) })
    @GetMapping("/srecptvrecfileinfos")
    public ResponseEntity<Page<SRecptVrecFileInfo>> getAll(@PageableDefault Pageable pageable) {
        try {
			log.info("findAll");
            return ResponseEntity.ok().body(repository.findAll(pageable));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(null);
        }
    }

    
    // @Operation(summary = "접속 녹취 파일 정보(Table) Key조회" , description = "접속 녹취 파일 정보(Table) Primary Key로 조회" )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the SRecptVrecFileInfo", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = SRecptVrecFileInfo.class)) }),
            @ApiResponse(responseCode = "404", description = "SRecptVrecFileInfo not found", content = @Content) })
    @GetMapping("/srecptvrecfileinfos/{recptVrecId}")
    public ResponseEntity<SRecptVrecFileInfo> getById(@PathVariable("recptVrecId") String recptVrecId) {
        Optional<SRecptVrecFileInfo> data = repository.findById(recptVrecId);

        if (data.isPresent()) {
            return ResponseEntity.ok().body(data.get());
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // @Operation(summary = "접속 녹취 파일 정보(Table) 등록" , description = "접속 녹취 파일 정보(Table) 신규 데이터 등록" )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Create the SRecptVrecFileInfo", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = SRecptVrecFileInfo.class)) }),
            @ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content) })
    @PostMapping("/srecptvrecfileinfos")
    ResponseEntity<SRecptVrecFileInfo> postData(@RequestBody SRecptVrecFileInfo newData) {
        try {
            newData = repository.save(newData);
            return new ResponseEntity<>(newData, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // @Operation(summary = "접속 녹취 파일 정보(Table) 수정" , description = "접속 녹취 파일 정보(Table) 데이터 수정" )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Update the SRecptVrecFileInfo", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = SRecptVrecFileInfo.class)) }),
            @ApiResponse(responseCode = "404", description = "SRecptVrecFileInfo not found", content = @Content) })
    @PutMapping("/srecptvrecfileinfos/{recptVrecId}")
    ResponseEntity<SRecptVrecFileInfo> putData(@RequestBody SRecptVrecFileInfo newData, @PathVariable("recptVrecId") String recptVrecId) {
        return repository.findById(recptVrecId) //
                .map(oldData -> {
                    newData.setRecptVrecId(oldData.getRecptVrecId());
                    return new ResponseEntity<>(repository.save(newData), HttpStatus.OK);
                })
                .orElseGet(() -> {
                    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
                });

    }

    // @Operation(summary = "접속 녹취 파일 정보(Table) 수정" , description = "접속 녹취 파일 정보(Table) 데이터 수정" )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Update the SRecptVrecFileInfo", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = SRecptVrecFileInfo.class)) }),
            @ApiResponse(responseCode = "404", description = "SRecptVrecFileInfo not found", content = @Content) })
	@PatchMapping("/srecptvrecfileinfos/{recptVrecId}")
    ResponseEntity<SRecptVrecFileInfo> patchData(@RequestBody Map<String, Object> newMap, @PathVariable("recptVrecId") String recptVrecId) {
        SRecptVrecFileInfo newData = mapper.convertValue(newMap, SRecptVrecFileInfo.class);
        return repository.findById(recptVrecId) //
                .map(oldData -> {
                    newMap.forEach((strKey, strValue) -> {
						switch(strKey){
						    case "recptNum" : oldData.setRecptNum(newData.getRecptNum()); break;
						    case "recptVrecFileFold" : oldData.setRecptVrecFileFold(newData.getRecptVrecFileFold()); break;
						    case "recptVrecFileNm" : oldData.setRecptVrecFileNm(newData.getRecptVrecFileNm()); break;
						    case "callRecvpersnId" : oldData.setCallRecvpersnId(newData.getCallRecvpersnId()); break;
						    case "callId" : oldData.setCallId(newData.getCallId()); break;
						    case "workstId" : oldData.setWorkstId(newData.getWorkstId()); break;
						    case "connId" : oldData.setConnId(newData.getConnId()); break;
						    case "connTm" : oldData.setConnTm(newData.getConnTm()); break;
						    case "dnis" : oldData.setDnis(newData.getDnis()); break;
						    case "thisDn" : oldData.setThisDn(newData.getThisDn()); break;
						    case "othrDn" : oldData.setOthrDn(newData.getOthrDn()); break;
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
	
    // @Operation(summary = "접속 녹취 파일 정보(Table) 삭제" , description = "접속 녹취 파일 정보(Table) Primary Key로 삭제" )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Delete the SRecptVrecFileInfo", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = SRecptVrecFileInfo.class)) }),
            @ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content) })
    @DeleteMapping("/srecptvrecfileinfos/{recptVrecId}")
    public ResponseEntity<HttpStatus> deleteUser(@PathVariable("recptVrecId") String recptVrecId) {
        try {
            repository.deleteById(recptVrecId);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
