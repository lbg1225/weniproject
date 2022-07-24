/**
 * MAddrInfo Entity Controller 클래스
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
import com.weni.ecs.domain.entity.MAddrInfo;
import com.weni.ecs.domain.repository.MAddrInfoRepository;

import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;


@RestController
@Tag(name = "MAddrInfo 주소 정보(Table) Controller")
@Slf4j
public class MAddrInfoController {

    @Autowired
    MAddrInfoRepository repository;


    @Autowired
    ObjectMapper mapper;

    // @Operation(summary = "주소 정보(Table) 전체조회" , summary = "주소 정보(Table) 조회" )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the maddrinfos", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = MAddrInfo.class)) }),
            @ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content) })
    @GetMapping("/maddrinfos")
    public ResponseEntity<Page<MAddrInfo>> getAll(@PageableDefault Pageable pageable) {
        try {
			log.info("findAll");
            return ResponseEntity.ok().body(repository.findAll(pageable));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(null);
        }
    }

    
    // @Operation(summary = "주소 정보(Table) Key조회" , description = "주소 정보(Table) Primary Key로 조회" )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the MAddrInfo", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = MAddrInfo.class)) }),
            @ApiResponse(responseCode = "404", description = "MAddrInfo not found", content = @Content) })
    @GetMapping("/maddrinfos/{addrAllCode}")
    public ResponseEntity<MAddrInfo> getById(@PathVariable("addrAllCode") String addrAllCode) {
        Optional<MAddrInfo> data = repository.findById(addrAllCode);

        if (data.isPresent()) {
            return ResponseEntity.ok().body(data.get());
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // @Operation(summary = "주소 정보(Table) 등록" , description = "주소 정보(Table) 신규 데이터 등록" )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Create the MAddrInfo", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = MAddrInfo.class)) }),
            @ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content) })
    @PostMapping("/maddrinfos")
    ResponseEntity<MAddrInfo> postData(@RequestBody MAddrInfo newData) {
        try {
            newData = repository.save(newData);
            return new ResponseEntity<>(newData, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // @Operation(summary = "주소 정보(Table) 수정" , description = "주소 정보(Table) 데이터 수정" )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Update the MAddrInfo", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = MAddrInfo.class)) }),
            @ApiResponse(responseCode = "404", description = "MAddrInfo not found", content = @Content) })
    @PutMapping("/maddrinfos/{addrAllCode}")
    ResponseEntity<MAddrInfo> putData(@RequestBody MAddrInfo newData, @PathVariable("addrAllCode") String addrAllCode) {
        return repository.findById(addrAllCode) //
                .map(oldData -> {
                    newData.setAddrAllCode(oldData.getAddrAllCode());
                    return new ResponseEntity<>(repository.save(newData), HttpStatus.OK);
                })
                .orElseGet(() -> {
                    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
                });

    }

    // @Operation(summary = "주소 정보(Table) 수정" , description = "주소 정보(Table) 데이터 수정" )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Update the MAddrInfo", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = MAddrInfo.class)) }),
            @ApiResponse(responseCode = "404", description = "MAddrInfo not found", content = @Content) })
	@PatchMapping("/maddrinfos/{addrAllCode}")
    ResponseEntity<MAddrInfo> patchData(@RequestBody Map<String, Object> newMap, @PathVariable("addrAllCode") String addrAllCode) {
        MAddrInfo newData = mapper.convertValue(newMap, MAddrInfo.class);
        return repository.findById(addrAllCode) //
                .map(oldData -> {
                    newMap.forEach((strKey, strValue) -> {
						switch(strKey){
						    case "lvl" : oldData.setLvl(newData.getLvl()); break;
						    case "addrStateCode" : oldData.setAddrStateCode(newData.getAddrStateCode()); break;
						    case "addrCityCode" : oldData.setAddrCityCode(newData.getAddrCityCode()); break;
						    case "addrDistrictCode" : oldData.setAddrDistrictCode(newData.getAddrDistrictCode()); break;
						    case "addrAllNm" : oldData.setAddrAllNm(newData.getAddrAllNm()); break;
						    case "addrStateNm" : oldData.setAddrStateNm(newData.getAddrStateNm()); break;
						    case "addrCityNm" : oldData.setAddrCityNm(newData.getAddrCityNm()); break;
						    case "addrDistrictNm" : oldData.setAddrDistrictNm(newData.getAddrDistrictNm()); break;
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
	
    // @Operation(summary = "주소 정보(Table) 삭제" , description = "주소 정보(Table) Primary Key로 삭제" )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Delete the MAddrInfo", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = MAddrInfo.class)) }),
            @ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content) })
    @DeleteMapping("/maddrinfos/{addrAllCode}")
    public ResponseEntity<HttpStatus> deleteUser(@PathVariable("addrAllCode") String addrAllCode) {
        try {
            repository.deleteById(addrAllCode);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
