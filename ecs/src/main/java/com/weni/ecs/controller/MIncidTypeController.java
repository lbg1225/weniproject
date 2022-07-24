/**
 * MIncidType Entity Controller 클래스
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
import com.weni.ecs.domain.entity.MIncidType;
import com.weni.ecs.domain.entity.MIncidTypePK;
import com.weni.ecs.domain.repository.MIncidTypeRepository;

import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;


@RestController
@Tag(name = "MIncidType 사건 유형(Table) Controller")
@Slf4j
public class MIncidTypeController {

    @Autowired
    MIncidTypeRepository repository;


    @Autowired
    ObjectMapper mapper;

    // @Operation(summary = "사건 유형(Table) 전체조회" , summary = "사건 유형(Table) 조회" )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the mincidtypes", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = MIncidType.class)) }),
            @ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content) })
    @GetMapping("/mincidtypes")
    public ResponseEntity<Page<MIncidType>> getAll(@PageableDefault Pageable pageable) {
        try {
			log.info("findAll");
            return ResponseEntity.ok().body(repository.findAll(pageable));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(null);
        }
    }

    
    // @Operation(summary = "사건 유형(Table) Key조회" , description = "사건 유형(Table) Primary Key로 조회" )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the MIncidType", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = MIncidType.class)) }),
            @ApiResponse(responseCode = "404", description = "MIncidType not found", content = @Content) })
    @GetMapping("/mincidtypes/{incidtypeBigclssfyCode}/{incidtypeMedclssfyCode}/{incidtypeSmallclssfyCode}")
    public ResponseEntity<MIncidType> getById(@PathVariable("incidtypeBigclssfyCode") String incidtypeBigclssfyCode, @PathVariable("incidtypeMedclssfyCode") String incidtypeMedclssfyCode, @PathVariable("incidtypeSmallclssfyCode") String incidtypeSmallclssfyCode) {
        Optional<MIncidType> data = repository.findById(new MIncidTypePK(incidtypeBigclssfyCode, incidtypeMedclssfyCode, incidtypeSmallclssfyCode));

        if (data.isPresent()) {
            return ResponseEntity.ok().body(data.get());
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // @Operation(summary = "사건 유형(Table) 등록" , description = "사건 유형(Table) 신규 데이터 등록" )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Create the MIncidType", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = MIncidType.class)) }),
            @ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content) })
    @PostMapping("/mincidtypes")
    ResponseEntity<MIncidType> postData(@RequestBody MIncidType newData) {
        try {
            newData = repository.save(newData);
            return new ResponseEntity<>(newData, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // @Operation(summary = "사건 유형(Table) 수정" , description = "사건 유형(Table) 데이터 수정" )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Update the MIncidType", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = MIncidType.class)) }),
            @ApiResponse(responseCode = "404", description = "MIncidType not found", content = @Content) })
    @PutMapping("/mincidtypes/{incidtypeBigclssfyCode}/{incidtypeMedclssfyCode}/{incidtypeSmallclssfyCode}")
    ResponseEntity<MIncidType> putData(@RequestBody MIncidType newData, @PathVariable("incidtypeBigclssfyCode") String incidtypeBigclssfyCode, @PathVariable("incidtypeMedclssfyCode") String incidtypeMedclssfyCode, @PathVariable("incidtypeSmallclssfyCode") String incidtypeSmallclssfyCode) {
        return repository.findById(new MIncidTypePK(incidtypeBigclssfyCode, incidtypeMedclssfyCode, incidtypeSmallclssfyCode)) //
                .map(oldData -> {
                    newData.setIncidtypeBigclssfyCode(oldData.getIncidtypeBigclssfyCode());
                    newData.setIncidtypeMedclssfyCode(oldData.getIncidtypeMedclssfyCode());
                    newData.setIncidtypeSmallclssfyCode(oldData.getIncidtypeSmallclssfyCode());
                    return new ResponseEntity<>(repository.save(newData), HttpStatus.OK);
                })
                .orElseGet(() -> {
                    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
                });

    }

    // @Operation(summary = "사건 유형(Table) 수정" , description = "사건 유형(Table) 데이터 수정" )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Update the MIncidType", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = MIncidType.class)) }),
            @ApiResponse(responseCode = "404", description = "MIncidType not found", content = @Content) })
	@PatchMapping("/mincidtypes/{incidtypeBigclssfyCode}/{incidtypeMedclssfyCode}/{incidtypeSmallclssfyCode}")
    ResponseEntity<MIncidType> patchData(@RequestBody Map<String, Object> newMap, @PathVariable("incidtypeBigclssfyCode") String incidtypeBigclssfyCode, @PathVariable("incidtypeMedclssfyCode") String incidtypeMedclssfyCode, @PathVariable("incidtypeSmallclssfyCode") String incidtypeSmallclssfyCode) {
        MIncidType newData = mapper.convertValue(newMap, MIncidType.class);
        return repository.findById(new MIncidTypePK(incidtypeBigclssfyCode, incidtypeMedclssfyCode, incidtypeSmallclssfyCode)) //
                .map(oldData -> {
                    newMap.forEach((strKey, strValue) -> {
						switch(strKey){
						    case "clssfyLvl" : oldData.setClssfyLvl(newData.getClssfyLvl()); break;
						    case "incidtypeBigclssfyNm" : oldData.setIncidtypeBigclssfyNm(newData.getIncidtypeBigclssfyNm()); break;
						    case "incidtypeMedclssfyNm" : oldData.setIncidtypeMedclssfyNm(newData.getIncidtypeMedclssfyNm()); break;
						    case "incidtypeSmallclssfyNm" : oldData.setIncidtypeSmallclssfyNm(newData.getIncidtypeSmallclssfyNm()); break;
						    case "fstRegpersnId" : oldData.setFstRegpersnId(newData.getFstRegpersnId()); break;
						    case "finalUptpersnId" : oldData.setFinalUptpersnId(newData.getFinalUptpersnId()); break;
						    case "fstRegTm" : oldData.setFstRegTm(newData.getFstRegTm()); break;
						    case "finalUptTm" : oldData.setFinalUptTm(newData.getFinalUptTm()); break;
						    case "incidtypeBigclssfyNmKor" : oldData.setIncidtypeBigclssfyNmKor(newData.getIncidtypeBigclssfyNmKor()); break;
						    case "incidtypeMedclssfyNmKor" : oldData.setIncidtypeMedclssfyNmKor(newData.getIncidtypeMedclssfyNmKor()); break;
						    case "incidtypeSmallclssfyNmKor" : oldData.setIncidtypeSmallclssfyNmKor(newData.getIncidtypeSmallclssfyNmKor()); break;
						    case "incidtypeBigclssfyNmRus" : oldData.setIncidtypeBigclssfyNmRus(newData.getIncidtypeBigclssfyNmRus()); break;
						    case "incidtypeMedclssfyNmRus" : oldData.setIncidtypeMedclssfyNmRus(newData.getIncidtypeMedclssfyNmRus()); break;
						    case "incidtypeSmallclssfyNmRus" : oldData.setIncidtypeSmallclssfyNmRus(newData.getIncidtypeSmallclssfyNmRus()); break;
						    case "incidtypeExp" : oldData.setIncidtypeExp(newData.getIncidtypeExp()); break;
						    case "incidtypeBgColor" : oldData.setIncidtypeBgColor(newData.getIncidtypeBgColor()); break;
						}
                    });
                    return new ResponseEntity<>(repository.save(oldData), HttpStatus.OK);
                })
                .orElseGet(() -> {
                    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
                });
    }
	
    // @Operation(summary = "사건 유형(Table) 삭제" , description = "사건 유형(Table) Primary Key로 삭제" )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Delete the MIncidType", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = MIncidType.class)) }),
            @ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content) })
    @DeleteMapping("/mincidtypes/{incidtypeBigclssfyCode}/{incidtypeMedclssfyCode}/{incidtypeSmallclssfyCode}")
    public ResponseEntity<HttpStatus> deleteUser(@PathVariable("incidtypeBigclssfyCode") String incidtypeBigclssfyCode, @PathVariable("incidtypeMedclssfyCode") String incidtypeMedclssfyCode, @PathVariable("incidtypeSmallclssfyCode") String incidtypeSmallclssfyCode) {
        try {
            repository.deleteById(new MIncidTypePK(incidtypeBigclssfyCode, incidtypeMedclssfyCode, incidtypeSmallclssfyCode));
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
