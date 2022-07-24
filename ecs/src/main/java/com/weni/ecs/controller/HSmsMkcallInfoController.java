/**
 * HSmsMkcallInfo Entity Controller 클래스
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
import com.weni.ecs.domain.entity.HSmsMkcallInfo;
import com.weni.ecs.domain.repository.HSmsMkcallInfoRepository;

import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;


@RestController
@Tag(name = "HSmsMkcallInfo SMS 발신 이력(Table) Controller")
@Slf4j
public class HSmsMkcallInfoController {

    @Autowired
    HSmsMkcallInfoRepository repository;


    @Autowired
    ObjectMapper mapper;

    // @Operation(summary = "SMS 발신 이력(Table) 전체조회" , summary = "SMS 발신 이력(Table) 조회" )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the hsmsmkcallinfos", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = HSmsMkcallInfo.class)) }),
            @ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content) })
    @GetMapping("/hsmsmkcallinfos")
    public ResponseEntity<Page<HSmsMkcallInfo>> getAll(@PageableDefault Pageable pageable) {
        try {
			log.info("findAll");
            return ResponseEntity.ok().body(repository.findAll(pageable));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(null);
        }
    }

    
    // @Operation(summary = "SMS 발신 이력(Table) Key조회" , description = "SMS 발신 이력(Table) Primary Key로 조회" )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the HSmsMkcallInfo", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = HSmsMkcallInfo.class)) }),
            @ApiResponse(responseCode = "404", description = "HSmsMkcallInfo not found", content = @Content) })
    @GetMapping("/hsmsmkcallinfos/{mkcallSeqNum}")
    public ResponseEntity<HSmsMkcallInfo> getById(@PathVariable("mkcallSeqNum") Integer mkcallSeqNum) {
        Optional<HSmsMkcallInfo> data = repository.findById(mkcallSeqNum);

        if (data.isPresent()) {
            return ResponseEntity.ok().body(data.get());
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // @Operation(summary = "SMS 발신 이력(Table) 등록" , description = "SMS 발신 이력(Table) 신규 데이터 등록" )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Create the HSmsMkcallInfo", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = HSmsMkcallInfo.class)) }),
            @ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content) })
    @PostMapping("/hsmsmkcallinfos")
    ResponseEntity<HSmsMkcallInfo> postData(@RequestBody HSmsMkcallInfo newData) {
        try {
            newData = repository.save(newData);
            return new ResponseEntity<>(newData, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // @Operation(summary = "SMS 발신 이력(Table) 수정" , description = "SMS 발신 이력(Table) 데이터 수정" )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Update the HSmsMkcallInfo", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = HSmsMkcallInfo.class)) }),
            @ApiResponse(responseCode = "404", description = "HSmsMkcallInfo not found", content = @Content) })
    @PutMapping("/hsmsmkcallinfos/{mkcallSeqNum}")
    ResponseEntity<HSmsMkcallInfo> putData(@RequestBody HSmsMkcallInfo newData, @PathVariable("mkcallSeqNum") Integer mkcallSeqNum) {
        return repository.findById(mkcallSeqNum) //
                .map(oldData -> {
                    newData.setMkcallSeqNum(oldData.getMkcallSeqNum());
                    return new ResponseEntity<>(repository.save(newData), HttpStatus.OK);
                })
                .orElseGet(() -> {
                    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
                });

    }

    // @Operation(summary = "SMS 발신 이력(Table) 수정" , description = "SMS 발신 이력(Table) 데이터 수정" )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Update the HSmsMkcallInfo", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = HSmsMkcallInfo.class)) }),
            @ApiResponse(responseCode = "404", description = "HSmsMkcallInfo not found", content = @Content) })
	@PatchMapping("/hsmsmkcallinfos/{mkcallSeqNum}")
    ResponseEntity<HSmsMkcallInfo> patchData(@RequestBody Map<String, Object> newMap, @PathVariable("mkcallSeqNum") Integer mkcallSeqNum) {
        HSmsMkcallInfo newData = mapper.convertValue(newMap, HSmsMkcallInfo.class);
        return repository.findById(mkcallSeqNum) //
                .map(oldData -> {
                    newMap.forEach((strKey, strValue) -> {
						switch(strKey){
						    case "mdtDevId" : oldData.setMdtDevId(newData.getMdtDevId()); break;
						    case "msgNum" : oldData.setMsgNum(newData.getMsgNum()); break;
						    case "indicItm" : oldData.setIndicItm(newData.getIndicItm()); break;
						    case "callerId" : oldData.setCallerId(newData.getCallerId()); break;
						    case "recptTm" : oldData.setRecptTm(newData.getRecptTm()); break;
						    case "mkcallTm" : oldData.setMkcallTm(newData.getMkcallTm()); break;
						    case "recvTm" : oldData.setRecvTm(newData.getRecvTm()); break;
						    case "cfmTm" : oldData.setCfmTm(newData.getCfmTm()); break;
						    case "mkcallStt" : oldData.setMkcallStt(newData.getMkcallStt()); break;
						    case "sendRslt" : oldData.setSendRslt(newData.getSendRslt()); break;
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
	
    // @Operation(summary = "SMS 발신 이력(Table) 삭제" , description = "SMS 발신 이력(Table) Primary Key로 삭제" )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Delete the HSmsMkcallInfo", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = HSmsMkcallInfo.class)) }),
            @ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content) })
    @DeleteMapping("/hsmsmkcallinfos/{mkcallSeqNum}")
    public ResponseEntity<HttpStatus> deleteUser(@PathVariable("mkcallSeqNum") Integer mkcallSeqNum) {
        try {
            repository.deleteById(mkcallSeqNum);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
