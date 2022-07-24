/**
 * SDispInfoTmp Entity Controller 클래스
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
import com.weni.ecs.domain.entity.SDispInfoTmp;
import com.weni.ecs.domain.entity.SDispInfoTmpPK;
import com.weni.ecs.domain.repository.SDispInfoTmpRepository;

import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;


@RestController
@Tag(name = "SDispInfoTmp 출동 정보 TMP(Table) Controller")
@Slf4j
public class SDispInfoTmpController {

    @Autowired
    SDispInfoTmpRepository repository;


    @Autowired
    ObjectMapper mapper;

    // @Operation(summary = "출동 정보 TMP(Table) 전체조회" , summary = "출동 정보 TMP(Table) 조회" )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the sdispinfotmps", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = SDispInfoTmp.class)) }),
            @ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content) })
    @GetMapping("/sdispinfotmps")
    public ResponseEntity<Page<SDispInfoTmp>> getAll(@PageableDefault Pageable pageable) {
        try {
			log.info("findAll");
            return ResponseEntity.ok().body(repository.findAll(pageable));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(null);
        }
    }

    
    // @Operation(summary = "출동 정보 TMP(Table) Key조회" , description = "출동 정보 TMP(Table) Primary Key로 조회" )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the SDispInfoTmp", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = SDispInfoTmp.class)) }),
            @ApiResponse(responseCode = "404", description = "SDispInfoTmp not found", content = @Content) })
    @GetMapping("/sdispinfotmps/{recptNum}/{dtlSeqNum}")
    public ResponseEntity<SDispInfoTmp> getById(@PathVariable("recptNum") Integer recptNum, @PathVariable("dtlSeqNum") Integer dtlSeqNum) {
        Optional<SDispInfoTmp> data = repository.findById(new SDispInfoTmpPK(recptNum, dtlSeqNum));

        if (data.isPresent()) {
            return ResponseEntity.ok().body(data.get());
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // @Operation(summary = "출동 정보 TMP(Table) 등록" , description = "출동 정보 TMP(Table) 신규 데이터 등록" )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Create the SDispInfoTmp", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = SDispInfoTmp.class)) }),
            @ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content) })
    @PostMapping("/sdispinfotmps")
    ResponseEntity<SDispInfoTmp> postData(@RequestBody SDispInfoTmp newData) {
        try {
            newData = repository.save(newData);
            return new ResponseEntity<>(newData, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // @Operation(summary = "출동 정보 TMP(Table) 수정" , description = "출동 정보 TMP(Table) 데이터 수정" )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Update the SDispInfoTmp", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = SDispInfoTmp.class)) }),
            @ApiResponse(responseCode = "404", description = "SDispInfoTmp not found", content = @Content) })
    @PutMapping("/sdispinfotmps/{recptNum}/{dtlSeqNum}")
    ResponseEntity<SDispInfoTmp> putData(@RequestBody SDispInfoTmp newData, @PathVariable("recptNum") Integer recptNum, @PathVariable("dtlSeqNum") Integer dtlSeqNum) {
        return repository.findById(new SDispInfoTmpPK(recptNum, dtlSeqNum)) //
                .map(oldData -> {
                    newData.setRecptNum(oldData.getRecptNum());
                    newData.setDtlSeqNum(oldData.getDtlSeqNum());
                    return new ResponseEntity<>(repository.save(newData), HttpStatus.OK);
                })
                .orElseGet(() -> {
                    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
                });

    }

    // @Operation(summary = "출동 정보 TMP(Table) 수정" , description = "출동 정보 TMP(Table) 데이터 수정" )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Update the SDispInfoTmp", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = SDispInfoTmp.class)) }),
            @ApiResponse(responseCode = "404", description = "SDispInfoTmp not found", content = @Content) })
	@PatchMapping("/sdispinfotmps/{recptNum}/{dtlSeqNum}")
    ResponseEntity<SDispInfoTmp> patchData(@RequestBody Map<String, Object> newMap, @PathVariable("recptNum") Integer recptNum, @PathVariable("dtlSeqNum") Integer dtlSeqNum) {
        SDispInfoTmp newData = mapper.convertValue(newMap, SDispInfoTmp.class);
        return repository.findById(new SDispInfoTmpPK(recptNum, dtlSeqNum)) //
                .map(oldData -> {
                    newMap.forEach((strKey, strValue) -> {
						switch(strKey){
						    case "dispCmdTm" : oldData.setDispCmdTm(newData.getDispCmdTm()); break;
						    case "dispStrtTm" : oldData.setDispStrtTm(newData.getDispStrtTm()); break;
						    case "dispCloseTm" : oldData.setDispCloseTm(newData.getDispCloseTm()); break;
						    case "mdtDevId" : oldData.setMdtDevId(newData.getMdtDevId()); break;
						    case "dispPrcsInspId" : oldData.setDispPrcsInspId(newData.getDispPrcsInspId()); break;
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
	
    // @Operation(summary = "출동 정보 TMP(Table) 삭제" , description = "출동 정보 TMP(Table) Primary Key로 삭제" )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Delete the SDispInfoTmp", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = SDispInfoTmp.class)) }),
            @ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content) })
    @DeleteMapping("/sdispinfotmps/{recptNum}/{dtlSeqNum}")
    public ResponseEntity<HttpStatus> deleteUser(@PathVariable("recptNum") Integer recptNum, @PathVariable("dtlSeqNum") Integer dtlSeqNum) {
        try {
            repository.deleteById(new SDispInfoTmpPK(recptNum, dtlSeqNum));
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
