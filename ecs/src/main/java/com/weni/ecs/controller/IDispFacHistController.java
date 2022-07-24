/**
 * IDispFacHist Entity Controller 클래스
 *
 *  @author  Lee Byoung Gwan
 *  @version 1.0
**/
package com.weni.ecs.controller;

import java.sql.Date;
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
import com.weni.ecs.domain.entity.IDispFacHist;
import com.weni.ecs.domain.entity.IDispFacHistPK;
import com.weni.ecs.domain.repository.IDispFacHistRepository;

import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;


@RestController
@Tag(name = "IDispFacHist 출동 요소 이력(Table) Controller")
@Slf4j
public class IDispFacHistController {

    @Autowired
    IDispFacHistRepository repository;


    @Autowired
    ObjectMapper mapper;

    // @Operation(summary = "출동 요소 이력(Table) 전체조회" , summary = "출동 요소 이력(Table) 조회" )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the idispfachists", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = IDispFacHist.class)) }),
            @ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content) })
    @GetMapping("/idispfachists")
    public ResponseEntity<Page<IDispFacHist>> getAll(@PageableDefault Pageable pageable) {
        try {
			log.info("findAll");
            return ResponseEntity.ok().body(repository.findAll(pageable));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(null);
        }
    }

    
    // @Operation(summary = "출동 요소 이력(Table) Key조회" , description = "출동 요소 이력(Table) Primary Key로 조회" )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the IDispFacHist", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = IDispFacHist.class)) }),
            @ApiResponse(responseCode = "404", description = "IDispFacHist not found", content = @Content) })
    @GetMapping("/idispfachists/{mdtDevId}/{collTm}")
    public ResponseEntity<IDispFacHist> getById(@PathVariable("mdtDevId") Integer mdtDevId, @PathVariable("collTm") Date collTm) {
        Optional<IDispFacHist> data = repository.findById(new IDispFacHistPK(mdtDevId, collTm));

        if (data.isPresent()) {
            return ResponseEntity.ok().body(data.get());
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // @Operation(summary = "출동 요소 이력(Table) 등록" , description = "출동 요소 이력(Table) 신규 데이터 등록" )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Create the IDispFacHist", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = IDispFacHist.class)) }),
            @ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content) })
    @PostMapping("/idispfachists")
    ResponseEntity<IDispFacHist> postData(@RequestBody IDispFacHist newData) {
        try {
            newData = repository.save(newData);
            return new ResponseEntity<>(newData, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // @Operation(summary = "출동 요소 이력(Table) 수정" , description = "출동 요소 이력(Table) 데이터 수정" )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Update the IDispFacHist", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = IDispFacHist.class)) }),
            @ApiResponse(responseCode = "404", description = "IDispFacHist not found", content = @Content) })
    @PutMapping("/idispfachists/{mdtDevId}/{collTm}")
    ResponseEntity<IDispFacHist> putData(@RequestBody IDispFacHist newData, @PathVariable("mdtDevId") Integer mdtDevId, @PathVariable("collTm") Date collTm) {
        return repository.findById(new IDispFacHistPK(mdtDevId, collTm)) //
                .map(oldData -> {
                    newData.setMdtDevId(oldData.getMdtDevId());
                    newData.setCollTm(oldData.getCollTm());
                    return new ResponseEntity<>(repository.save(newData), HttpStatus.OK);
                })
                .orElseGet(() -> {
                    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
                });

    }

    // @Operation(summary = "출동 요소 이력(Table) 수정" , description = "출동 요소 이력(Table) 데이터 수정" )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Update the IDispFacHist", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = IDispFacHist.class)) }),
            @ApiResponse(responseCode = "404", description = "IDispFacHist not found", content = @Content) })
	@PatchMapping("/idispfachists/{mdtDevId}/{collTm}")
    ResponseEntity<IDispFacHist> patchData(@RequestBody Map<String, Object> newMap, @PathVariable("mdtDevId") Integer mdtDevId, @PathVariable("collTm") Date collTm) {
        IDispFacHist newData = mapper.convertValue(newMap, IDispFacHist.class);
        return repository.findById(new IDispFacHistPK(mdtDevId, collTm)) //
                .map(oldData -> {
                    newMap.forEach((strKey, strValue) -> {
						switch(strKey){
						    case "lgt" : oldData.setLgt(newData.getLgt()); break;
						    case "ltt" : oldData.setLtt(newData.getLtt()); break;
						    case "stt" : oldData.setStt(newData.getStt()); break;
						    case "transmitPrd" : oldData.setTransmitPrd(newData.getTransmitPrd()); break;
						    case "jurisCode" : oldData.setJurisCode(newData.getJurisCode()); break;
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
	
    // @Operation(summary = "출동 요소 이력(Table) 삭제" , description = "출동 요소 이력(Table) Primary Key로 삭제" )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Delete the IDispFacHist", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = IDispFacHist.class)) }),
            @ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content) })
    @DeleteMapping("/idispfachists/{mdtDevId}/{collTm}")
    public ResponseEntity<HttpStatus> deleteUser(@PathVariable("mdtDevId") Integer mdtDevId, @PathVariable("collTm") Date collTm) {
        try {
            repository.deleteById(new IDispFacHistPK(mdtDevId, collTm));
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
