/**
 * MJurisInfo Entity Controller 클래스
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
import com.weni.ecs.domain.entity.MJurisInfo;
import com.weni.ecs.domain.repository.MJurisInfoRepository;

import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;


@RestController
@Tag(name = "MJurisInfo 관할 정보(Table) Controller")
@Slf4j
public class MJurisInfoController {

    @Autowired
    MJurisInfoRepository repository;


    @Autowired
    ObjectMapper mapper;

    // @Operation(summary = "관할 정보(Table) 전체조회" , summary = "관할 정보(Table) 조회" )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the mjurisinfos", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = MJurisInfo.class)) }),
            @ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content) })
    @GetMapping("/mjurisinfos")
    public ResponseEntity<Page<MJurisInfo>> getAll(@PageableDefault Pageable pageable) {
        try {
			log.info("findAll");
            return ResponseEntity.ok().body(repository.findAll(pageable));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(null);
        }
    }

    
    // @Operation(summary = "관할 정보(Table) Key조회" , description = "관할 정보(Table) Primary Key로 조회" )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the MJurisInfo", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = MJurisInfo.class)) }),
            @ApiResponse(responseCode = "404", description = "MJurisInfo not found", content = @Content) })
    @GetMapping("/mjurisinfos/{jurisCode}")
    public ResponseEntity<MJurisInfo> getById(@PathVariable("jurisCode") String jurisCode) {
        Optional<MJurisInfo> data = repository.findById(jurisCode);

        if (data.isPresent()) {
            return ResponseEntity.ok().body(data.get());
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // @Operation(summary = "관할 정보(Table) 등록" , description = "관할 정보(Table) 신규 데이터 등록" )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Create the MJurisInfo", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = MJurisInfo.class)) }),
            @ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content) })
    @PostMapping("/mjurisinfos")
    ResponseEntity<MJurisInfo> postData(@RequestBody MJurisInfo newData) {
        try {
            newData = repository.save(newData);
            return new ResponseEntity<>(newData, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // @Operation(summary = "관할 정보(Table) 수정" , description = "관할 정보(Table) 데이터 수정" )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Update the MJurisInfo", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = MJurisInfo.class)) }),
            @ApiResponse(responseCode = "404", description = "MJurisInfo not found", content = @Content) })
    @PutMapping("/mjurisinfos/{jurisCode}")
    ResponseEntity<MJurisInfo> putData(@RequestBody MJurisInfo newData, @PathVariable("jurisCode") String jurisCode) {
        return repository.findById(jurisCode) //
                .map(oldData -> {
                    newData.setJurisCode(oldData.getJurisCode());
                    return new ResponseEntity<>(repository.save(newData), HttpStatus.OK);
                })
                .orElseGet(() -> {
                    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
                });

    }

    // @Operation(summary = "관할 정보(Table) 수정" , description = "관할 정보(Table) 데이터 수정" )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Update the MJurisInfo", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = MJurisInfo.class)) }),
            @ApiResponse(responseCode = "404", description = "MJurisInfo not found", content = @Content) })
	@PatchMapping("/mjurisinfos/{jurisCode}")
    ResponseEntity<MJurisInfo> patchData(@RequestBody Map<String, Object> newMap, @PathVariable("jurisCode") String jurisCode) {
        MJurisInfo newData = mapper.convertValue(newMap, MJurisInfo.class);
        return repository.findById(jurisCode) //
                .map(oldData -> {
                    newMap.forEach((strKey, strValue) -> {
						switch(strKey){
						    case "jurisNm" : oldData.setJurisNm(newData.getJurisNm()); break;
						    case "busn" : oldData.setBusn(newData.getBusn()); break;
						    case "fstRegpersnId" : oldData.setFstRegpersnId(newData.getFstRegpersnId()); break;
						    case "finalUptpersnId" : oldData.setFinalUptpersnId(newData.getFinalUptpersnId()); break;
						    case "fstRegTm" : oldData.setFstRegTm(newData.getFstRegTm()); break;
						    case "finalUptTm" : oldData.setFinalUptTm(newData.getFinalUptTm()); break;
						    case "jurisNmKor" : oldData.setJurisNmKor(newData.getJurisNmKor()); break;
						    case "jurisNmRus" : oldData.setJurisNmRus(newData.getJurisNmRus()); break;
						    case "lgt" : oldData.setLgt(newData.getLgt()); break;
						    case "ltt" : oldData.setLtt(newData.getLtt()); break;
						}
                    });
                    return new ResponseEntity<>(repository.save(oldData), HttpStatus.OK);
                })
                .orElseGet(() -> {
                    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
                });
    }
	
    // @Operation(summary = "관할 정보(Table) 삭제" , description = "관할 정보(Table) Primary Key로 삭제" )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Delete the MJurisInfo", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = MJurisInfo.class)) }),
            @ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content) })
    @DeleteMapping("/mjurisinfos/{jurisCode}")
    public ResponseEntity<HttpStatus> deleteUser(@PathVariable("jurisCode") String jurisCode) {
        try {
            repository.deleteById(jurisCode);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
