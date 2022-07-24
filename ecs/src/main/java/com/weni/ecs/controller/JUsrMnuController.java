/**
 * JUsrMnu Entity Controller 클래스
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
import com.weni.ecs.domain.entity.JUsrMnu;
import com.weni.ecs.domain.entity.JUsrMnuPK;
import com.weni.ecs.domain.repository.JUsrMnuRepository;

import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;


@RestController
@Tag(name = "JUsrMnu 사용자 메뉴(Table) Controller")
@Slf4j
public class JUsrMnuController {

    @Autowired
    JUsrMnuRepository repository;


    @Autowired
    ObjectMapper mapper;

    // @Operation(summary = "사용자 메뉴(Table) 전체조회" , summary = "사용자 메뉴(Table) 조회" )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the jusrmnus", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = JUsrMnu.class)) }),
            @ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content) })
    @GetMapping("/jusrmnus")
    public ResponseEntity<Page<JUsrMnu>> getAll(@PageableDefault Pageable pageable) {
        try {
			log.info("findAll");
            return ResponseEntity.ok().body(repository.findAll(pageable));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(null);
        }
    }

    
    // @Operation(summary = "사용자 메뉴(Table) Key조회" , description = "사용자 메뉴(Table) Primary Key로 조회" )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the JUsrMnu", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = JUsrMnu.class)) }),
            @ApiResponse(responseCode = "404", description = "JUsrMnu not found", content = @Content) })
    @GetMapping("/jusrmnus/{usrId}/{mnuId}")
    public ResponseEntity<JUsrMnu> getById(@PathVariable("usrId") String usrId, @PathVariable("mnuId") String mnuId) {
        Optional<JUsrMnu> data = repository.findById(new JUsrMnuPK(usrId, mnuId));

        if (data.isPresent()) {
            return ResponseEntity.ok().body(data.get());
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // @Operation(summary = "사용자 메뉴(Table) 등록" , description = "사용자 메뉴(Table) 신규 데이터 등록" )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Create the JUsrMnu", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = JUsrMnu.class)) }),
            @ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content) })
    @PostMapping("/jusrmnus")
    ResponseEntity<JUsrMnu> postData(@RequestBody JUsrMnu newData) {
        try {
            newData = repository.save(newData);
            return new ResponseEntity<>(newData, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // @Operation(summary = "사용자 메뉴(Table) 수정" , description = "사용자 메뉴(Table) 데이터 수정" )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Update the JUsrMnu", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = JUsrMnu.class)) }),
            @ApiResponse(responseCode = "404", description = "JUsrMnu not found", content = @Content) })
    @PutMapping("/jusrmnus/{usrId}/{mnuId}")
    ResponseEntity<JUsrMnu> putData(@RequestBody JUsrMnu newData, @PathVariable("usrId") String usrId, @PathVariable("mnuId") String mnuId) {
        return repository.findById(new JUsrMnuPK(usrId, mnuId)) //
                .map(oldData -> {
                    newData.setUsrId(oldData.getUsrId());
                    newData.setMnuId(oldData.getMnuId());
                    return new ResponseEntity<>(repository.save(newData), HttpStatus.OK);
                })
                .orElseGet(() -> {
                    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
                });

    }

    // @Operation(summary = "사용자 메뉴(Table) 수정" , description = "사용자 메뉴(Table) 데이터 수정" )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Update the JUsrMnu", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = JUsrMnu.class)) }),
            @ApiResponse(responseCode = "404", description = "JUsrMnu not found", content = @Content) })
	@PatchMapping("/jusrmnus/{usrId}/{mnuId}")
    ResponseEntity<JUsrMnu> patchData(@RequestBody Map<String, Object> newMap, @PathVariable("usrId") String usrId, @PathVariable("mnuId") String mnuId) {
        JUsrMnu newData = mapper.convertValue(newMap, JUsrMnu.class);
        return repository.findById(new JUsrMnuPK(usrId, mnuId)) //
                .map(oldData -> {
                    newMap.forEach((strKey, strValue) -> {
						switch(strKey){
						    case "qryFlag" : oldData.setQryFlag(newData.getQryFlag()); break;
						    case "uptFlag" : oldData.setUptFlag(newData.getUptFlag()); break;
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
	
    // @Operation(summary = "사용자 메뉴(Table) 삭제" , description = "사용자 메뉴(Table) Primary Key로 삭제" )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Delete the JUsrMnu", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = JUsrMnu.class)) }),
            @ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content) })
    @DeleteMapping("/jusrmnus/{usrId}/{mnuId}")
    public ResponseEntity<HttpStatus> deleteUser(@PathVariable("usrId") String usrId, @PathVariable("mnuId") String mnuId) {
        try {
            repository.deleteById(new JUsrMnuPK(usrId, mnuId));
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
