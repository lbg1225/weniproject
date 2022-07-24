/**
 * MDispFac Entity Controller 클래스
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
import com.weni.ecs.domain.entity.MDispFac;
import com.weni.ecs.domain.repository.MDispFacRepository;

import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;


@RestController
@Tag(name = "MDispFac 출동 요소(Table) Controller")
@Slf4j
public class MDispFacController {

    @Autowired
    MDispFacRepository repository;


    @Autowired
    ObjectMapper mapper;

    // @Operation(summary = "출동 요소(Table) 전체조회" , summary = "출동 요소(Table) 조회" )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the mdispfacs", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = MDispFac.class)) }),
            @ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content) })
    @GetMapping("/mdispfacs")
    public ResponseEntity<Page<MDispFac>> getAll(@PageableDefault Pageable pageable) {
        try {
			log.info("findAll");
            return ResponseEntity.ok().body(repository.findAll(pageable));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(null);
        }
    }

    
    // @Operation(summary = "출동 요소(Table) Key조회" , description = "출동 요소(Table) Primary Key로 조회" )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the MDispFac", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = MDispFac.class)) }),
            @ApiResponse(responseCode = "404", description = "MDispFac not found", content = @Content) })
    @GetMapping("/mdispfacs/{mdtDevId}")
    public ResponseEntity<MDispFac> getById(@PathVariable("mdtDevId") Integer mdtDevId) {
        Optional<MDispFac> data = repository.findById(mdtDevId);

        if (data.isPresent()) {
            return ResponseEntity.ok().body(data.get());
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // @Operation(summary = "출동 요소(Table) 등록" , description = "출동 요소(Table) 신규 데이터 등록" )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Create the MDispFac", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = MDispFac.class)) }),
            @ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content) })
    @PostMapping("/mdispfacs")
    ResponseEntity<MDispFac> postData(@RequestBody MDispFac newData) {
        try {
            newData = repository.save(newData);
            return new ResponseEntity<>(newData, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // @Operation(summary = "출동 요소(Table) 수정" , description = "출동 요소(Table) 데이터 수정" )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Update the MDispFac", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = MDispFac.class)) }),
            @ApiResponse(responseCode = "404", description = "MDispFac not found", content = @Content) })
    @PutMapping("/mdispfacs/{mdtDevId}")
    ResponseEntity<MDispFac> putData(@RequestBody MDispFac newData, @PathVariable("mdtDevId") Integer mdtDevId) {
        return repository.findById(mdtDevId) //
                .map(oldData -> {
                    newData.setMdtDevId(oldData.getMdtDevId());
                    return new ResponseEntity<>(repository.save(newData), HttpStatus.OK);
                })
                .orElseGet(() -> {
                    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
                });

    }

    // @Operation(summary = "출동 요소(Table) 수정" , description = "출동 요소(Table) 데이터 수정" )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Update the MDispFac", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = MDispFac.class)) }),
            @ApiResponse(responseCode = "404", description = "MDispFac not found", content = @Content) })
	@PatchMapping("/mdispfacs/{mdtDevId}")
    ResponseEntity<MDispFac> patchData(@RequestBody Map<String, Object> newMap, @PathVariable("mdtDevId") Integer mdtDevId) {
        MDispFac newData = mapper.convertValue(newMap, MDispFac.class);
        return repository.findById(mdtDevId) //
                .map(oldData -> {
                    newMap.forEach((strKey, strValue) -> {
						switch(strKey){
						    case "jurisCode" : oldData.setJurisCode(newData.getJurisCode()); break;
						    case "icon" : oldData.setIcon(newData.getIcon()); break;
						    case "mdtDevNm" : oldData.setMdtDevNm(newData.getMdtDevNm()); break;
						    case "transmitPrd" : oldData.setTransmitPrd(newData.getTransmitPrd()); break;
						    case "currExistStt" : oldData.setCurrExistStt(newData.getCurrExistStt()); break;
						    case "delFlag" : oldData.setDelFlag(newData.getDelFlag()); break;
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
	
    // @Operation(summary = "출동 요소(Table) 삭제" , description = "출동 요소(Table) Primary Key로 삭제" )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Delete the MDispFac", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = MDispFac.class)) }),
            @ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content) })
    @DeleteMapping("/mdispfacs/{mdtDevId}")
    public ResponseEntity<HttpStatus> deleteUser(@PathVariable("mdtDevId") Integer mdtDevId) {
        try {
            repository.deleteById(mdtDevId);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
