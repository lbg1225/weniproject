/**
 * MUsrGrp Entity Controller 클래스
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
import com.weni.ecs.domain.entity.MUsrGrp;
import com.weni.ecs.domain.repository.MUsrGrpRepository;

import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;


@RestController
@Tag(name = "MUsrGrp 사용자 그룹(Table) Controller")
@Slf4j
public class MUsrGrpController {

    @Autowired
    MUsrGrpRepository repository;


    @Autowired
    ObjectMapper mapper;

    // @Operation(summary = "사용자 그룹(Table) 전체조회" , summary = "사용자 그룹(Table) 조회" )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the musrgrps", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = MUsrGrp.class)) }),
            @ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content) })
    @GetMapping("/musrgrps")
    public ResponseEntity<Page<MUsrGrp>> getAll(@PageableDefault Pageable pageable) {
        try {
			log.info("findAll");
            return ResponseEntity.ok().body(repository.findAll(pageable));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(null);
        }
    }

    
    // @Operation(summary = "사용자 그룹(Table) Key조회" , description = "사용자 그룹(Table) Primary Key로 조회" )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the MUsrGrp", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = MUsrGrp.class)) }),
            @ApiResponse(responseCode = "404", description = "MUsrGrp not found", content = @Content) })
    @GetMapping("/musrgrps/{usrGrpId}")
    public ResponseEntity<MUsrGrp> getById(@PathVariable("usrGrpId") String usrGrpId) {
        Optional<MUsrGrp> data = repository.findById(usrGrpId);

        if (data.isPresent()) {
            return ResponseEntity.ok().body(data.get());
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // @Operation(summary = "사용자 그룹(Table) 등록" , description = "사용자 그룹(Table) 신규 데이터 등록" )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Create the MUsrGrp", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = MUsrGrp.class)) }),
            @ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content) })
    @PostMapping("/musrgrps")
    ResponseEntity<MUsrGrp> postData(@RequestBody MUsrGrp newData) {
        try {
            newData = repository.save(newData);
            return new ResponseEntity<>(newData, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // @Operation(summary = "사용자 그룹(Table) 수정" , description = "사용자 그룹(Table) 데이터 수정" )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Update the MUsrGrp", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = MUsrGrp.class)) }),
            @ApiResponse(responseCode = "404", description = "MUsrGrp not found", content = @Content) })
    @PutMapping("/musrgrps/{usrGrpId}")
    ResponseEntity<MUsrGrp> putData(@RequestBody MUsrGrp newData, @PathVariable("usrGrpId") String usrGrpId) {
        return repository.findById(usrGrpId) //
                .map(oldData -> {
                    newData.setUsrGrpId(oldData.getUsrGrpId());
                    return new ResponseEntity<>(repository.save(newData), HttpStatus.OK);
                })
                .orElseGet(() -> {
                    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
                });

    }

    // @Operation(summary = "사용자 그룹(Table) 수정" , description = "사용자 그룹(Table) 데이터 수정" )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Update the MUsrGrp", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = MUsrGrp.class)) }),
            @ApiResponse(responseCode = "404", description = "MUsrGrp not found", content = @Content) })
	@PatchMapping("/musrgrps/{usrGrpId}")
    ResponseEntity<MUsrGrp> patchData(@RequestBody Map<String, Object> newMap, @PathVariable("usrGrpId") String usrGrpId) {
        MUsrGrp newData = mapper.convertValue(newMap, MUsrGrp.class);
        return repository.findById(usrGrpId) //
                .map(oldData -> {
                    newMap.forEach((strKey, strValue) -> {
						switch(strKey){
						    case "usrGrpNm" : oldData.setUsrGrpNm(newData.getUsrGrpNm()); break;
						    case "usrGrpNmKor" : oldData.setUsrGrpNmKor(newData.getUsrGrpNmKor()); break;
						    case "usrGrpNmRus" : oldData.setUsrGrpNmRus(newData.getUsrGrpNmRus()); break;
						    case "busnFlag" : oldData.setBusnFlag(newData.getBusnFlag()); break;
						    case "notfcFlag" : oldData.setNotfcFlag(newData.getNotfcFlag()); break;
						    case "qtySeq" : oldData.setQtySeq(newData.getQtySeq()); break;
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
	
    // @Operation(summary = "사용자 그룹(Table) 삭제" , description = "사용자 그룹(Table) Primary Key로 삭제" )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Delete the MUsrGrp", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = MUsrGrp.class)) }),
            @ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content) })
    @DeleteMapping("/musrgrps/{usrGrpId}")
    public ResponseEntity<HttpStatus> deleteUser(@PathVariable("usrGrpId") String usrGrpId) {
        try {
            repository.deleteById(usrGrpId);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
