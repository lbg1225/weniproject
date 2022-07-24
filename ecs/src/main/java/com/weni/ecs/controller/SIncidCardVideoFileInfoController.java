/**
 * SIncidCardVideoFileInfo Entity Controller 클래스
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
import com.weni.ecs.domain.entity.SIncidCardVideoFileInfo;
import com.weni.ecs.domain.entity.SIncidCardVideoFileInfoPK;
import com.weni.ecs.domain.repository.SIncidCardVideoFileInfoRepository;

import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;


@RestController
@Tag(name = "SIncidCardVideoFileInfo 사건 카드 영상 파일 정보(Table) Controller")
@Slf4j
public class SIncidCardVideoFileInfoController {

    @Autowired
    SIncidCardVideoFileInfoRepository repository;


    @Autowired
    ObjectMapper mapper;

    // @Operation(summary = "사건 카드 영상 파일 정보(Table) 전체조회" , summary = "사건 카드 영상 파일 정보(Table) 조회" )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the sincidcardvideofileinfos", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = SIncidCardVideoFileInfo.class)) }),
            @ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content) })
    @GetMapping("/sincidcardvideofileinfos")
    public ResponseEntity<Page<SIncidCardVideoFileInfo>> getAll(@PageableDefault Pageable pageable) {
        try {
			log.info("findAll");
            return ResponseEntity.ok().body(repository.findAll(pageable));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(null);
        }
    }

    
    // @Operation(summary = "사건 카드 영상 파일 정보(Table) Key조회" , description = "사건 카드 영상 파일 정보(Table) Primary Key로 조회" )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the SIncidCardVideoFileInfo", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = SIncidCardVideoFileInfo.class)) }),
            @ApiResponse(responseCode = "404", description = "SIncidCardVideoFileInfo not found", content = @Content) })
    @GetMapping("/sincidcardvideofileinfos/{recptNum}/{dtlSeqNum}")
    public ResponseEntity<SIncidCardVideoFileInfo> getById(@PathVariable("recptNum") Integer recptNum, @PathVariable("dtlSeqNum") Integer dtlSeqNum) {
        Optional<SIncidCardVideoFileInfo> data = repository.findById(new SIncidCardVideoFileInfoPK(recptNum, dtlSeqNum));

        if (data.isPresent()) {
            return ResponseEntity.ok().body(data.get());
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // @Operation(summary = "사건 카드 영상 파일 정보(Table) 등록" , description = "사건 카드 영상 파일 정보(Table) 신규 데이터 등록" )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Create the SIncidCardVideoFileInfo", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = SIncidCardVideoFileInfo.class)) }),
            @ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content) })
    @PostMapping("/sincidcardvideofileinfos")
    ResponseEntity<SIncidCardVideoFileInfo> postData(@RequestBody SIncidCardVideoFileInfo newData) {
        try {
            newData = repository.save(newData);
            return new ResponseEntity<>(newData, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // @Operation(summary = "사건 카드 영상 파일 정보(Table) 수정" , description = "사건 카드 영상 파일 정보(Table) 데이터 수정" )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Update the SIncidCardVideoFileInfo", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = SIncidCardVideoFileInfo.class)) }),
            @ApiResponse(responseCode = "404", description = "SIncidCardVideoFileInfo not found", content = @Content) })
    @PutMapping("/sincidcardvideofileinfos/{recptNum}/{dtlSeqNum}")
    ResponseEntity<SIncidCardVideoFileInfo> putData(@RequestBody SIncidCardVideoFileInfo newData, @PathVariable("recptNum") Integer recptNum, @PathVariable("dtlSeqNum") Integer dtlSeqNum) {
        return repository.findById(new SIncidCardVideoFileInfoPK(recptNum, dtlSeqNum)) //
                .map(oldData -> {
                    newData.setRecptNum(oldData.getRecptNum());
                    newData.setDtlSeqNum(oldData.getDtlSeqNum());
                    return new ResponseEntity<>(repository.save(newData), HttpStatus.OK);
                })
                .orElseGet(() -> {
                    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
                });

    }

    // @Operation(summary = "사건 카드 영상 파일 정보(Table) 수정" , description = "사건 카드 영상 파일 정보(Table) 데이터 수정" )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Update the SIncidCardVideoFileInfo", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = SIncidCardVideoFileInfo.class)) }),
            @ApiResponse(responseCode = "404", description = "SIncidCardVideoFileInfo not found", content = @Content) })
	@PatchMapping("/sincidcardvideofileinfos/{recptNum}/{dtlSeqNum}")
    ResponseEntity<SIncidCardVideoFileInfo> patchData(@RequestBody Map<String, Object> newMap, @PathVariable("recptNum") Integer recptNum, @PathVariable("dtlSeqNum") Integer dtlSeqNum) {
        SIncidCardVideoFileInfo newData = mapper.convertValue(newMap, SIncidCardVideoFileInfo.class);
        return repository.findById(new SIncidCardVideoFileInfoPK(recptNum, dtlSeqNum)) //
                .map(oldData -> {
                    newMap.forEach((strKey, strValue) -> {
						switch(strKey){
						    case "videoFileFold" : oldData.setVideoFileFold(newData.getVideoFileFold()); break;
						    case "videoFileNm" : oldData.setVideoFileNm(newData.getVideoFileNm()); break;
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
	
    // @Operation(summary = "사건 카드 영상 파일 정보(Table) 삭제" , description = "사건 카드 영상 파일 정보(Table) Primary Key로 삭제" )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Delete the SIncidCardVideoFileInfo", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = SIncidCardVideoFileInfo.class)) }),
            @ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content) })
    @DeleteMapping("/sincidcardvideofileinfos/{recptNum}/{dtlSeqNum}")
    public ResponseEntity<HttpStatus> deleteUser(@PathVariable("recptNum") Integer recptNum, @PathVariable("dtlSeqNum") Integer dtlSeqNum) {
        try {
            repository.deleteById(new SIncidCardVideoFileInfoPK(recptNum, dtlSeqNum));
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
