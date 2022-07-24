/**
 * MCmncodeDtl Entity Controller 클래스
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
import com.weni.ecs.domain.entity.MCmncodeDtl;
import com.weni.ecs.domain.repository.MCmncodeDtlRepository;

import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;


@RestController
@Tag(name = "MCmncodeDtl 공통 코드 상세(Table) Controller")
@Slf4j
public class MCmncodeDtlController {

    @Autowired
    MCmncodeDtlRepository repository;


    @Autowired
    ObjectMapper mapper;

    // @Operation(summary = "공통 코드 상세(Table) 전체조회" , summary = "공통 코드 상세(Table) 조회" )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the mcmncodedtls", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = MCmncodeDtl.class)) }),
            @ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content) })
    @GetMapping("/mcmncodedtls")
    public ResponseEntity<Page<MCmncodeDtl>> getAll(@PageableDefault Pageable pageable) {
        try {
			log.info("findAll");
            return ResponseEntity.ok().body(repository.findAll(pageable));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(null);
        }
    }

    
    // @Operation(summary = "공통 코드 상세(Table) Key조회" , description = "공통 코드 상세(Table) Primary Key로 조회" )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the MCmncodeDtl", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = MCmncodeDtl.class)) }),
            @ApiResponse(responseCode = "404", description = "MCmncodeDtl not found", content = @Content) })
    @GetMapping("/mcmncodedtls/{clssfyDtlCode}")
    public ResponseEntity<MCmncodeDtl> getById(@PathVariable("clssfyDtlCode") String clssfyDtlCode) {
        Optional<MCmncodeDtl> data = repository.findById(clssfyDtlCode);

        if (data.isPresent()) {
            return ResponseEntity.ok().body(data.get());
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // @Operation(summary = "공통 코드 상세(Table) 등록" , description = "공통 코드 상세(Table) 신규 데이터 등록" )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Create the MCmncodeDtl", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = MCmncodeDtl.class)) }),
            @ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content) })
    @PostMapping("/mcmncodedtls")
    ResponseEntity<MCmncodeDtl> postData(@RequestBody MCmncodeDtl newData) {
        try {
            newData = repository.save(newData);
            return new ResponseEntity<>(newData, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // @Operation(summary = "공통 코드 상세(Table) 수정" , description = "공통 코드 상세(Table) 데이터 수정" )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Update the MCmncodeDtl", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = MCmncodeDtl.class)) }),
            @ApiResponse(responseCode = "404", description = "MCmncodeDtl not found", content = @Content) })
    @PutMapping("/mcmncodedtls/{clssfyDtlCode}")
    ResponseEntity<MCmncodeDtl> putData(@RequestBody MCmncodeDtl newData, @PathVariable("clssfyDtlCode") String clssfyDtlCode) {
        return repository.findById(clssfyDtlCode) //
                .map(oldData -> {
                    newData.setClssfyDtlCode(oldData.getClssfyDtlCode());
                    return new ResponseEntity<>(repository.save(newData), HttpStatus.OK);
                })
                .orElseGet(() -> {
                    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
                });

    }

    // @Operation(summary = "공통 코드 상세(Table) 수정" , description = "공통 코드 상세(Table) 데이터 수정" )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Update the MCmncodeDtl", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = MCmncodeDtl.class)) }),
            @ApiResponse(responseCode = "404", description = "MCmncodeDtl not found", content = @Content) })
	@PatchMapping("/mcmncodedtls/{clssfyDtlCode}")
    ResponseEntity<MCmncodeDtl> patchData(@RequestBody Map<String, Object> newMap, @PathVariable("clssfyDtlCode") String clssfyDtlCode) {
        MCmncodeDtl newData = mapper.convertValue(newMap, MCmncodeDtl.class);
        return repository.findById(clssfyDtlCode) //
                .map(oldData -> {
                    newMap.forEach((strKey, strValue) -> {
						switch(strKey){
						    case "clssfyCode" : oldData.setClssfyCode(newData.getClssfyCode()); break;
						    case "clssfyDtlNm" : oldData.setClssfyDtlNm(newData.getClssfyDtlNm()); break;
						    case "clssfy1" : oldData.setClssfy1(newData.getClssfy1()); break;
						    case "clssfy2" : oldData.setClssfy2(newData.getClssfy2()); break;
						    case "clssfy3" : oldData.setClssfy3(newData.getClssfy3()); break;
						    case "fstRegpersnId" : oldData.setFstRegpersnId(newData.getFstRegpersnId()); break;
						    case "finalUptpersnId" : oldData.setFinalUptpersnId(newData.getFinalUptpersnId()); break;
						    case "fstRegTm" : oldData.setFstRegTm(newData.getFstRegTm()); break;
						    case "finalUptTm" : oldData.setFinalUptTm(newData.getFinalUptTm()); break;
						    case "clssfyDtlNmKor" : oldData.setClssfyDtlNmKor(newData.getClssfyDtlNmKor()); break;
						    case "clssfyDtlNmRus" : oldData.setClssfyDtlNmRus(newData.getClssfyDtlNmRus()); break;
						    case "clssfyDtlExp" : oldData.setClssfyDtlExp(newData.getClssfyDtlExp()); break;
						}
                    });
                    return new ResponseEntity<>(repository.save(oldData), HttpStatus.OK);
                })
                .orElseGet(() -> {
                    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
                });
    }
	
    // @Operation(summary = "공통 코드 상세(Table) 삭제" , description = "공통 코드 상세(Table) Primary Key로 삭제" )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Delete the MCmncodeDtl", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = MCmncodeDtl.class)) }),
            @ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content) })
    @DeleteMapping("/mcmncodedtls/{clssfyDtlCode}")
    public ResponseEntity<HttpStatus> deleteUser(@PathVariable("clssfyDtlCode") String clssfyDtlCode) {
        try {
            repository.deleteById(clssfyDtlCode);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
