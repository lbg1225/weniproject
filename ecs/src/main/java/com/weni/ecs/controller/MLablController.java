/**
 * MLabl Entity Controller 클래스
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
import com.weni.ecs.domain.entity.MLabl;
import com.weni.ecs.domain.repository.MLablRepository;

import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;


@RestController
@Tag(name = "MLabl 라벨(Table) Controller")
@Slf4j
public class MLablController {

    @Autowired
    MLablRepository repository;


    @Autowired
    ObjectMapper mapper;

    // @Operation(summary = "라벨(Table) 전체조회" , summary = "라벨(Table) 조회" )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the mlabls", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = MLabl.class)) }),
            @ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content) })
    @GetMapping("/mlabls")
    public ResponseEntity<Page<MLabl>> getAll(@PageableDefault Pageable pageable) {
        try {
			log.info("findAll");
            return ResponseEntity.ok().body(repository.findAll(pageable));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(null);
        }
    }

    
    // @Operation(summary = "라벨(Table) Key조회" , description = "라벨(Table) Primary Key로 조회" )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the MLabl", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = MLabl.class)) }),
            @ApiResponse(responseCode = "404", description = "MLabl not found", content = @Content) })
    @GetMapping("/mlabls/{id}")
    public ResponseEntity<MLabl> getById(@PathVariable("id") String id) {
        Optional<MLabl> data = repository.findById(id);

        if (data.isPresent()) {
            return ResponseEntity.ok().body(data.get());
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // @Operation(summary = "라벨(Table) 등록" , description = "라벨(Table) 신규 데이터 등록" )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Create the MLabl", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = MLabl.class)) }),
            @ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content) })
    @PostMapping("/mlabls")
    ResponseEntity<MLabl> postData(@RequestBody MLabl newData) {
        try {
            newData = repository.save(newData);
            return new ResponseEntity<>(newData, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // @Operation(summary = "라벨(Table) 수정" , description = "라벨(Table) 데이터 수정" )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Update the MLabl", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = MLabl.class)) }),
            @ApiResponse(responseCode = "404", description = "MLabl not found", content = @Content) })
    @PutMapping("/mlabls/{id}")
    ResponseEntity<MLabl> putData(@RequestBody MLabl newData, @PathVariable("id") String id) {
        return repository.findById(id) //
                .map(oldData -> {
                    newData.setId(oldData.getId());
                    return new ResponseEntity<>(repository.save(newData), HttpStatus.OK);
                })
                .orElseGet(() -> {
                    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
                });

    }

    // @Operation(summary = "라벨(Table) 수정" , description = "라벨(Table) 데이터 수정" )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Update the MLabl", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = MLabl.class)) }),
            @ApiResponse(responseCode = "404", description = "MLabl not found", content = @Content) })
	@PatchMapping("/mlabls/{id}")
    ResponseEntity<MLabl> patchData(@RequestBody Map<String, Object> newMap, @PathVariable("id") String id) {
        MLabl newData = mapper.convertValue(newMap, MLabl.class);
        return repository.findById(id) //
                .map(oldData -> {
                    newMap.forEach((strKey, strValue) -> {
						switch(strKey){
						    case "grpLablId" : oldData.setGrpLablId(newData.getGrpLablId()); break;
						    case "lablId" : oldData.setLablId(newData.getLablId()); break;
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
	
    // @Operation(summary = "라벨(Table) 삭제" , description = "라벨(Table) Primary Key로 삭제" )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Delete the MLabl", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = MLabl.class)) }),
            @ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content) })
    @DeleteMapping("/mlabls/{id}")
    public ResponseEntity<HttpStatus> deleteUser(@PathVariable("id") String id) {
        try {
            repository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
