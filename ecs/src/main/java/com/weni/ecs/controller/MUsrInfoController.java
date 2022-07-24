/**
 * MUsrInfo Entity Controller 클래스
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
import com.weni.ecs.domain.entity.MUsrInfo;
import com.weni.ecs.domain.repository.MUsrInfoRepository;

import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;


@RestController
@Tag(name = "MUsrInfo 사용자 정보(Table) Controller")
@Slf4j
public class MUsrInfoController {

    @Autowired
    MUsrInfoRepository repository;


    @Autowired
    ObjectMapper mapper;

    // @Operation(summary = "사용자 정보(Table) 전체조회" , summary = "사용자 정보(Table) 조회" )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the musrinfos", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = MUsrInfo.class)) }),
            @ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content) })
    @GetMapping("/musrinfos")
    public ResponseEntity<Page<MUsrInfo>> getAll(@PageableDefault Pageable pageable) {
        try {
			log.info("findAll");
            return ResponseEntity.ok().body(repository.findAll(pageable));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(null);
        }
    }

    
    // @Operation(summary = "사용자 정보(Table) Key조회" , description = "사용자 정보(Table) Primary Key로 조회" )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the MUsrInfo", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = MUsrInfo.class)) }),
            @ApiResponse(responseCode = "404", description = "MUsrInfo not found", content = @Content) })
    @GetMapping("/musrinfos/{usrId}")
    public ResponseEntity<MUsrInfo> getById(@PathVariable("usrId") String usrId) {
        Optional<MUsrInfo> data = repository.findById(usrId);

        if (data.isPresent()) {
            return ResponseEntity.ok().body(data.get());
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // @Operation(summary = "사용자 정보(Table) 등록" , description = "사용자 정보(Table) 신규 데이터 등록" )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Create the MUsrInfo", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = MUsrInfo.class)) }),
            @ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content) })
    @PostMapping("/musrinfos")
    ResponseEntity<MUsrInfo> postData(@RequestBody MUsrInfo newData) {
        try {
            newData = repository.save(newData);
            return new ResponseEntity<>(newData, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // @Operation(summary = "사용자 정보(Table) 수정" , description = "사용자 정보(Table) 데이터 수정" )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Update the MUsrInfo", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = MUsrInfo.class)) }),
            @ApiResponse(responseCode = "404", description = "MUsrInfo not found", content = @Content) })
    @PutMapping("/musrinfos/{usrId}")
    ResponseEntity<MUsrInfo> putData(@RequestBody MUsrInfo newData, @PathVariable("usrId") String usrId) {
        return repository.findById(usrId) //
                .map(oldData -> {
                    newData.setUsrId(oldData.getUsrId());
                    return new ResponseEntity<>(repository.save(newData), HttpStatus.OK);
                })
                .orElseGet(() -> {
                    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
                });

    }

    // @Operation(summary = "사용자 정보(Table) 수정" , description = "사용자 정보(Table) 데이터 수정" )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Update the MUsrInfo", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = MUsrInfo.class)) }),
            @ApiResponse(responseCode = "404", description = "MUsrInfo not found", content = @Content) })
	@PatchMapping("/musrinfos/{usrId}")
    ResponseEntity<MUsrInfo> patchData(@RequestBody Map<String, Object> newMap, @PathVariable("usrId") String usrId) {
        MUsrInfo newData = mapper.convertValue(newMap, MUsrInfo.class);
        return repository.findById(usrId) //
                .map(oldData -> {
                    newMap.forEach((strKey, strValue) -> {
						switch(strKey){
						    case "jurisCode" : oldData.setJurisCode(newData.getJurisCode()); break;
						    case "offRankCode" : oldData.setOffRankCode(newData.getOffRankCode()); break;
						    case "famNm" : oldData.setFamNm(newData.getFamNm()); break;
						    case "givNm" : oldData.setGivNm(newData.getGivNm()); break;
						    case "midNm" : oldData.setMidNm(newData.getMidNm()); break;
						    case "pwd" : oldData.setPwd(newData.getPwd()); break;
						    case "fstRegpersnId" : oldData.setFstRegpersnId(newData.getFstRegpersnId()); break;
						    case "finalUptpersnId" : oldData.setFinalUptpersnId(newData.getFinalUptpersnId()); break;
						    case "fstRegTm" : oldData.setFstRegTm(newData.getFstRegTm()); break;
						    case "finalUptTm" : oldData.setFinalUptTm(newData.getFinalUptTm()); break;
						    case "localeCode" : oldData.setLocaleCode(newData.getLocaleCode()); break;
						    case "currExistStt" : oldData.setCurrExistStt(newData.getCurrExistStt()); break;
						    case "softphoneNum" : oldData.setSoftphoneNum(newData.getSoftphoneNum()); break;
						    case "loginKeepTm" : oldData.setLoginKeepTm(newData.getLoginKeepTm()); break;
						    case "gisUsrGrp" : oldData.setGisUsrGrp(newData.getGisUsrGrp()); break;
						}
                    });
                    return new ResponseEntity<>(repository.save(oldData), HttpStatus.OK);
                })
                .orElseGet(() -> {
                    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
                });
    }
	
    // @Operation(summary = "사용자 정보(Table) 삭제" , description = "사용자 정보(Table) Primary Key로 삭제" )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Delete the MUsrInfo", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = MUsrInfo.class)) }),
            @ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content) })
    @DeleteMapping("/musrinfos/{usrId}")
    public ResponseEntity<HttpStatus> deleteUser(@PathVariable("usrId") String usrId) {
        try {
            repository.deleteById(usrId);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
