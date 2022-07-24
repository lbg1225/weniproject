/**
 * MMnuInfo Entity Controller 클래스
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
import com.weni.ecs.domain.entity.MMnuInfo;
import com.weni.ecs.domain.repository.MMnuInfoRepository;

import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;


@RestController
@Tag(name = "MMnuInfo 메뉴 정보(Table) Controller")
@Slf4j
public class MMnuInfoController {

    @Autowired
    MMnuInfoRepository repository;


    @Autowired
    ObjectMapper mapper;

    // @Operation(summary = "메뉴 정보(Table) 전체조회" , summary = "메뉴 정보(Table) 조회" )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the mmnuinfos", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = MMnuInfo.class)) }),
            @ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content) })
    @GetMapping("/mmnuinfos")
    public ResponseEntity<Page<MMnuInfo>> getAll(@PageableDefault Pageable pageable) {
        try {
			log.info("findAll");
            return ResponseEntity.ok().body(repository.findAll(pageable));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(null);
        }
    }

    
    // @Operation(summary = "메뉴 정보(Table) Key조회" , description = "메뉴 정보(Table) Primary Key로 조회" )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the MMnuInfo", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = MMnuInfo.class)) }),
            @ApiResponse(responseCode = "404", description = "MMnuInfo not found", content = @Content) })
    @GetMapping("/mmnuinfos/{mnuId}")
    public ResponseEntity<MMnuInfo> getById(@PathVariable("mnuId") String mnuId) {
        Optional<MMnuInfo> data = repository.findById(mnuId);

        if (data.isPresent()) {
            return ResponseEntity.ok().body(data.get());
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // @Operation(summary = "메뉴 정보(Table) 등록" , description = "메뉴 정보(Table) 신규 데이터 등록" )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Create the MMnuInfo", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = MMnuInfo.class)) }),
            @ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content) })
    @PostMapping("/mmnuinfos")
    ResponseEntity<MMnuInfo> postData(@RequestBody MMnuInfo newData) {
        try {
            newData = repository.save(newData);
            return new ResponseEntity<>(newData, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // @Operation(summary = "메뉴 정보(Table) 수정" , description = "메뉴 정보(Table) 데이터 수정" )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Update the MMnuInfo", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = MMnuInfo.class)) }),
            @ApiResponse(responseCode = "404", description = "MMnuInfo not found", content = @Content) })
    @PutMapping("/mmnuinfos/{mnuId}")
    ResponseEntity<MMnuInfo> putData(@RequestBody MMnuInfo newData, @PathVariable("mnuId") String mnuId) {
        return repository.findById(mnuId) //
                .map(oldData -> {
                    newData.setMnuId(oldData.getMnuId());
                    return new ResponseEntity<>(repository.save(newData), HttpStatus.OK);
                })
                .orElseGet(() -> {
                    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
                });

    }

    // @Operation(summary = "메뉴 정보(Table) 수정" , description = "메뉴 정보(Table) 데이터 수정" )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Update the MMnuInfo", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = MMnuInfo.class)) }),
            @ApiResponse(responseCode = "404", description = "MMnuInfo not found", content = @Content) })
	@PatchMapping("/mmnuinfos/{mnuId}")
    ResponseEntity<MMnuInfo> patchData(@RequestBody Map<String, Object> newMap, @PathVariable("mnuId") String mnuId) {
        MMnuInfo newData = mapper.convertValue(newMap, MMnuInfo.class);
        return repository.findById(mnuId) //
                .map(oldData -> {
                    newMap.forEach((strKey, strValue) -> {
						switch(strKey){
						    case "busnDomain" : oldData.setBusnDomain(newData.getBusnDomain()); break;
						    case "busnSkill" : oldData.setBusnSkill(newData.getBusnSkill()); break;
						    case "scrNm" : oldData.setScrNm(newData.getScrNm()); break;
						    case "scrExp" : oldData.setScrExp(newData.getScrExp()); break;
						    case "delFlag" : oldData.setDelFlag(newData.getDelFlag()); break;
						    case "fstRegpersnId" : oldData.setFstRegpersnId(newData.getFstRegpersnId()); break;
						    case "finalUptpersnId" : oldData.setFinalUptpersnId(newData.getFinalUptpersnId()); break;
						    case "fstRegTm" : oldData.setFstRegTm(newData.getFstRegTm()); break;
						    case "finalUptTm" : oldData.setFinalUptTm(newData.getFinalUptTm()); break;
						    case "scrNmKor" : oldData.setScrNmKor(newData.getScrNmKor()); break;
						    case "scrNmRus" : oldData.setScrNmRus(newData.getScrNmRus()); break;
						    case "lstNumb" : oldData.setLstNumb(newData.getLstNumb()); break;
						    case "qrySeq" : oldData.setQrySeq(newData.getQrySeq()); break;
						    case "qryFlag" : oldData.setQryFlag(newData.getQryFlag()); break;
						    case "uptFlag" : oldData.setUptFlag(newData.getUptFlag()); break;
						    case "insFlag" : oldData.setInsFlag(newData.getInsFlag()); break;
						}
                    });
                    return new ResponseEntity<>(repository.save(oldData), HttpStatus.OK);
                })
                .orElseGet(() -> {
                    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
                });
    }
	
    // @Operation(summary = "메뉴 정보(Table) 삭제" , description = "메뉴 정보(Table) Primary Key로 삭제" )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Delete the MMnuInfo", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = MMnuInfo.class)) }),
            @ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content) })
    @DeleteMapping("/mmnuinfos/{mnuId}")
    public ResponseEntity<HttpStatus> deleteUser(@PathVariable("mnuId") String mnuId) {
        try {
            repository.deleteById(mnuId);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
