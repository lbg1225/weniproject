/**
 * MCmncode Entity Controller 클래스
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
import com.weni.ecs.domain.entity.MCmncode;
import com.weni.ecs.domain.repository.MCmncodeRepository;

import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;


@RestController
@Tag(name = "MCmncode 공통 코드(Table) Controller")
@Slf4j
public class MCmncodeController {

    @Autowired
    MCmncodeRepository repository;


    @Autowired
    ObjectMapper mapper;

    // @Operation(summary = "공통 코드(Table) 전체조회" , summary = "공통 코드(Table) 조회" )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the mcmncodes", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = MCmncode.class)) }),
            @ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content) })
    @GetMapping("/mcmncodes")
    public ResponseEntity<Page<MCmncode>> getAll(@PageableDefault Pageable pageable) {
        try {
			log.info("findAll");
            return ResponseEntity.ok().body(repository.findAll(pageable));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(null);
        }
    }

    
    // @Operation(summary = "공통 코드(Table) Key조회" , description = "공통 코드(Table) Primary Key로 조회" )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the MCmncode", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = MCmncode.class)) }),
            @ApiResponse(responseCode = "404", description = "MCmncode not found", content = @Content) })
    @GetMapping("/mcmncodes/{clssfyCode}")
    public ResponseEntity<MCmncode> getById(@PathVariable("clssfyCode") String clssfyCode) {
        Optional<MCmncode> data = repository.findById(clssfyCode);

        if (data.isPresent()) {
            return ResponseEntity.ok().body(data.get());
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // @Operation(summary = "공통 코드(Table) 등록" , description = "공통 코드(Table) 신규 데이터 등록" )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Create the MCmncode", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = MCmncode.class)) }),
            @ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content) })
    @PostMapping("/mcmncodes")
    ResponseEntity<MCmncode> postData(@RequestBody MCmncode newData) {
        try {
            newData = repository.save(newData);
            return new ResponseEntity<>(newData, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // @Operation(summary = "공통 코드(Table) 수정" , description = "공통 코드(Table) 데이터 수정" )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Update the MCmncode", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = MCmncode.class)) }),
            @ApiResponse(responseCode = "404", description = "MCmncode not found", content = @Content) })
    @PutMapping("/mcmncodes/{clssfyCode}")
    ResponseEntity<MCmncode> putData(@RequestBody MCmncode newData, @PathVariable("clssfyCode") String clssfyCode) {
        return repository.findById(clssfyCode) //
                .map(oldData -> {
                    newData.setClssfyCode(oldData.getClssfyCode());
                    return new ResponseEntity<>(repository.save(newData), HttpStatus.OK);
                })
                .orElseGet(() -> {
                    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
                });

    }

    // @Operation(summary = "공통 코드(Table) 수정" , description = "공통 코드(Table) 데이터 수정" )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Update the MCmncode", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = MCmncode.class)) }),
            @ApiResponse(responseCode = "404", description = "MCmncode not found", content = @Content) })
	@PatchMapping("/mcmncodes/{clssfyCode}")
    ResponseEntity<MCmncode> patchData(@RequestBody Map<String, Object> newMap, @PathVariable("clssfyCode") String clssfyCode) {
        MCmncode newData = mapper.convertValue(newMap, MCmncode.class);
        return repository.findById(clssfyCode) //
                .map(oldData -> {
                    newMap.forEach((strKey, strValue) -> {
						switch(strKey){
						    case "clssfyNm" : oldData.setClssfyNm(newData.getClssfyNm()); break;
						    case "fstRegpersnId" : oldData.setFstRegpersnId(newData.getFstRegpersnId()); break;
						    case "finalUptpersnId" : oldData.setFinalUptpersnId(newData.getFinalUptpersnId()); break;
						    case "fstRegTm" : oldData.setFstRegTm(newData.getFstRegTm()); break;
						    case "finalUptTm" : oldData.setFinalUptTm(newData.getFinalUptTm()); break;
						    case "clssfyNmKor" : oldData.setClssfyNmKor(newData.getClssfyNmKor()); break;
						    case "clssfyNmRus" : oldData.setClssfyNmRus(newData.getClssfyNmRus()); break;
						}
                    });
                    return new ResponseEntity<>(repository.save(oldData), HttpStatus.OK);
                })
                .orElseGet(() -> {
                    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
                });
    }
	
    // @Operation(summary = "공통 코드(Table) 삭제" , description = "공통 코드(Table) Primary Key로 삭제" )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Delete the MCmncode", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = MCmncode.class)) }),
            @ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content) })
    @DeleteMapping("/mcmncodes/{clssfyCode}")
    public ResponseEntity<HttpStatus> deleteUser(@PathVariable("clssfyCode") String clssfyCode) {
        try {
            repository.deleteById(clssfyCode);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
