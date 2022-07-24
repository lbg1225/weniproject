/**
 * MClssfyCodeGetNum Entity Controller 클래스
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
import com.weni.ecs.domain.entity.MClssfyCodeGetNum;
import com.weni.ecs.domain.repository.MClssfyCodeGetNumRepository;

import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;


@RestController
@Tag(name = "MClssfyCodeGetNum 분류 코드 채번(Table) Controller")
@Slf4j
public class MClssfyCodeGetNumController {

    @Autowired
    MClssfyCodeGetNumRepository repository;


    @Autowired
    ObjectMapper mapper;

    // @Operation(summary = "분류 코드 채번(Table) 전체조회" , summary = "분류 코드 채번(Table) 조회" )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the mclssfycodegetnums", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = MClssfyCodeGetNum.class)) }),
            @ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content) })
    @GetMapping("/mclssfycodegetnums")
    public ResponseEntity<Page<MClssfyCodeGetNum>> getAll(@PageableDefault Pageable pageable) {
        try {
			log.info("findAll");
            return ResponseEntity.ok().body(repository.findAll(pageable));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(null);
        }
    }

    
    // @Operation(summary = "분류 코드 채번(Table) Key조회" , description = "분류 코드 채번(Table) Primary Key로 조회" )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the MClssfyCodeGetNum", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = MClssfyCodeGetNum.class)) }),
            @ApiResponse(responseCode = "404", description = "MClssfyCodeGetNum not found", content = @Content) })
    @GetMapping("/mclssfycodegetnums/{getNumCode}")
    public ResponseEntity<MClssfyCodeGetNum> getById(@PathVariable("getNumCode") String getNumCode) {
        Optional<MClssfyCodeGetNum> data = repository.findById(getNumCode);

        if (data.isPresent()) {
            return ResponseEntity.ok().body(data.get());
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // @Operation(summary = "분류 코드 채번(Table) 등록" , description = "분류 코드 채번(Table) 신규 데이터 등록" )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Create the MClssfyCodeGetNum", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = MClssfyCodeGetNum.class)) }),
            @ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content) })
    @PostMapping("/mclssfycodegetnums")
    ResponseEntity<MClssfyCodeGetNum> postData(@RequestBody MClssfyCodeGetNum newData) {
        try {
            newData = repository.save(newData);
            return new ResponseEntity<>(newData, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // @Operation(summary = "분류 코드 채번(Table) 수정" , description = "분류 코드 채번(Table) 데이터 수정" )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Update the MClssfyCodeGetNum", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = MClssfyCodeGetNum.class)) }),
            @ApiResponse(responseCode = "404", description = "MClssfyCodeGetNum not found", content = @Content) })
    @PutMapping("/mclssfycodegetnums/{getNumCode}")
    ResponseEntity<MClssfyCodeGetNum> putData(@RequestBody MClssfyCodeGetNum newData, @PathVariable("getNumCode") String getNumCode) {
        return repository.findById(getNumCode) //
                .map(oldData -> {
                    newData.setGetNumCode(oldData.getGetNumCode());
                    return new ResponseEntity<>(repository.save(newData), HttpStatus.OK);
                })
                .orElseGet(() -> {
                    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
                });

    }

    // @Operation(summary = "분류 코드 채번(Table) 수정" , description = "분류 코드 채번(Table) 데이터 수정" )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Update the MClssfyCodeGetNum", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = MClssfyCodeGetNum.class)) }),
            @ApiResponse(responseCode = "404", description = "MClssfyCodeGetNum not found", content = @Content) })
	@PatchMapping("/mclssfycodegetnums/{getNumCode}")
    ResponseEntity<MClssfyCodeGetNum> patchData(@RequestBody Map<String, Object> newMap, @PathVariable("getNumCode") String getNumCode) {
        MClssfyCodeGetNum newData = mapper.convertValue(newMap, MClssfyCodeGetNum.class);
        return repository.findById(getNumCode) //
                .map(oldData -> {
                    newMap.forEach((strKey, strValue) -> {
						switch(strKey){
						    case "jurisMngCode" : oldData.setJurisMngCode(newData.getJurisMngCode()); break;
						    case "mngJnlClssfyCode" : oldData.setMngJnlClssfyCode(newData.getMngJnlClssfyCode()); break;
						    case "etcIncidMngCode" : oldData.setEtcIncidMngCode(newData.getEtcIncidMngCode()); break;
						    case "finalMngJnlNum" : oldData.setFinalMngJnlNum(newData.getFinalMngJnlNum()); break;
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
	
    // @Operation(summary = "분류 코드 채번(Table) 삭제" , description = "분류 코드 채번(Table) Primary Key로 삭제" )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Delete the MClssfyCodeGetNum", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = MClssfyCodeGetNum.class)) }),
            @ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content) })
    @DeleteMapping("/mclssfycodegetnums/{getNumCode}")
    public ResponseEntity<HttpStatus> deleteUser(@PathVariable("getNumCode") String getNumCode) {
        try {
            repository.deleteById(getNumCode);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
