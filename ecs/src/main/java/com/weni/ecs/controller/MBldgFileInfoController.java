/**
 * MBldgFileInfo Entity Controller 클래스
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
import com.weni.ecs.domain.entity.MBldgFileInfo;
import com.weni.ecs.domain.entity.MBldgFileInfoPK;
import com.weni.ecs.domain.repository.MBldgFileInfoRepository;

import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;


@RestController
@Tag(name = "MBldgFileInfo 건물 파일 정보(Table) Controller")
@Slf4j
public class MBldgFileInfoController {

    @Autowired
    MBldgFileInfoRepository repository;


    @Autowired
    ObjectMapper mapper;

    // @Operation(summary = "건물 파일 정보(Table) 전체조회" , summary = "건물 파일 정보(Table) 조회" )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the mbldgfileinfos", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = MBldgFileInfo.class)) }),
            @ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content) })
    @GetMapping("/mbldgfileinfos")
    public ResponseEntity<Page<MBldgFileInfo>> getAll(@PageableDefault Pageable pageable) {
        try {
			log.info("findAll");
            return ResponseEntity.ok().body(repository.findAll(pageable));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(null);
        }
    }

    
    // @Operation(summary = "건물 파일 정보(Table) Key조회" , description = "건물 파일 정보(Table) Primary Key로 조회" )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the MBldgFileInfo", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = MBldgFileInfo.class)) }),
            @ApiResponse(responseCode = "404", description = "MBldgFileInfo not found", content = @Content) })
    @GetMapping("/mbldgfileinfos/{dtlSeqNum}/{bldgCode}")
    public ResponseEntity<MBldgFileInfo> getById(@PathVariable("dtlSeqNum") Integer dtlSeqNum, @PathVariable("bldgCode") String bldgCode) {
        Optional<MBldgFileInfo> data = repository.findById(new MBldgFileInfoPK(dtlSeqNum, bldgCode));

        if (data.isPresent()) {
            return ResponseEntity.ok().body(data.get());
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // @Operation(summary = "건물 파일 정보(Table) 등록" , description = "건물 파일 정보(Table) 신규 데이터 등록" )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Create the MBldgFileInfo", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = MBldgFileInfo.class)) }),
            @ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content) })
    @PostMapping("/mbldgfileinfos")
    ResponseEntity<MBldgFileInfo> postData(@RequestBody MBldgFileInfo newData) {
        try {
            newData = repository.save(newData);
            return new ResponseEntity<>(newData, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // @Operation(summary = "건물 파일 정보(Table) 수정" , description = "건물 파일 정보(Table) 데이터 수정" )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Update the MBldgFileInfo", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = MBldgFileInfo.class)) }),
            @ApiResponse(responseCode = "404", description = "MBldgFileInfo not found", content = @Content) })
    @PutMapping("/mbldgfileinfos/{dtlSeqNum}/{bldgCode}")
    ResponseEntity<MBldgFileInfo> putData(@RequestBody MBldgFileInfo newData, @PathVariable("dtlSeqNum") Integer dtlSeqNum, @PathVariable("bldgCode") String bldgCode) {
        return repository.findById(new MBldgFileInfoPK(dtlSeqNum, bldgCode)) //
                .map(oldData -> {
                    newData.setDtlSeqNum(oldData.getDtlSeqNum());
                    newData.setBldgCode(oldData.getBldgCode());
                    return new ResponseEntity<>(repository.save(newData), HttpStatus.OK);
                })
                .orElseGet(() -> {
                    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
                });

    }

    // @Operation(summary = "건물 파일 정보(Table) 수정" , description = "건물 파일 정보(Table) 데이터 수정" )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Update the MBldgFileInfo", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = MBldgFileInfo.class)) }),
            @ApiResponse(responseCode = "404", description = "MBldgFileInfo not found", content = @Content) })
	@PatchMapping("/mbldgfileinfos/{dtlSeqNum}/{bldgCode}")
    ResponseEntity<MBldgFileInfo> patchData(@RequestBody Map<String, Object> newMap, @PathVariable("dtlSeqNum") Integer dtlSeqNum, @PathVariable("bldgCode") String bldgCode) {
        MBldgFileInfo newData = mapper.convertValue(newMap, MBldgFileInfo.class);
        return repository.findById(new MBldgFileInfoPK(dtlSeqNum, bldgCode)) //
                .map(oldData -> {
                    newMap.forEach((strKey, strValue) -> {
						switch(strKey){
						    case "bldgFileFold" : oldData.setBldgFileFold(newData.getBldgFileFold()); break;
						    case "fstRegpersnId" : oldData.setFstRegpersnId(newData.getFstRegpersnId()); break;
						    case "finalUptpersnId" : oldData.setFinalUptpersnId(newData.getFinalUptpersnId()); break;
						    case "fstRegTm" : oldData.setFstRegTm(newData.getFstRegTm()); break;
						    case "finalUptTm" : oldData.setFinalUptTm(newData.getFinalUptTm()); break;
						    case "dtlDivCode" : oldData.setDtlDivCode(newData.getDtlDivCode()); break;
						    case "bldgFileNm" : oldData.setBldgFileNm(newData.getBldgFileNm()); break;
						    case "bldgFileTypeCode" : oldData.setBldgFileTypeCode(newData.getBldgFileTypeCode()); break;
						    case "bldgFileFloorCode" : oldData.setBldgFileFloorCode(newData.getBldgFileFloorCode()); break;
						}
                    });
                    return new ResponseEntity<>(repository.save(oldData), HttpStatus.OK);
                })
                .orElseGet(() -> {
                    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
                });
    }
	
    // @Operation(summary = "건물 파일 정보(Table) 삭제" , description = "건물 파일 정보(Table) Primary Key로 삭제" )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Delete the MBldgFileInfo", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = MBldgFileInfo.class)) }),
            @ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content) })
    @DeleteMapping("/mbldgfileinfos/{dtlSeqNum}/{bldgCode}")
    public ResponseEntity<HttpStatus> deleteUser(@PathVariable("dtlSeqNum") Integer dtlSeqNum, @PathVariable("bldgCode") String bldgCode) {
        try {
            repository.deleteById(new MBldgFileInfoPK(dtlSeqNum, bldgCode));
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
