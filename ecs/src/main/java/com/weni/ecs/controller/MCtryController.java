/**
 * MCtry Entity Controller 클래스
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
import com.weni.ecs.domain.entity.MCtry;
import com.weni.ecs.domain.repository.MCtryRepository;

import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;


@RestController
@Tag(name = "MCtry 국가(Table) Controller")
@Slf4j
public class MCtryController {

    @Autowired
    MCtryRepository repository;


    @Autowired
    ObjectMapper mapper;

    // @Operation(summary = "국가(Table) 전체조회" , summary = "국가(Table) 조회" )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the mctrys", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = MCtry.class)) }),
            @ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content) })
    @GetMapping("/mctrys")
    public ResponseEntity<Page<MCtry>> getAll(@PageableDefault Pageable pageable) {
        try {
			log.info("findAll");
            return ResponseEntity.ok().body(repository.findAll(pageable));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(null);
        }
    }

    
    // @Operation(summary = "국가(Table) Key조회" , description = "국가(Table) Primary Key로 조회" )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the MCtry", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = MCtry.class)) }),
            @ApiResponse(responseCode = "404", description = "MCtry not found", content = @Content) })
    @GetMapping("/mctrys/{ctryCode3}")
    public ResponseEntity<MCtry> getById(@PathVariable("ctryCode3") String ctryCode3) {
        Optional<MCtry> data = repository.findById(ctryCode3);

        if (data.isPresent()) {
            return ResponseEntity.ok().body(data.get());
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // @Operation(summary = "국가(Table) 등록" , description = "국가(Table) 신규 데이터 등록" )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Create the MCtry", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = MCtry.class)) }),
            @ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content) })
    @PostMapping("/mctrys")
    ResponseEntity<MCtry> postData(@RequestBody MCtry newData) {
        try {
            newData = repository.save(newData);
            return new ResponseEntity<>(newData, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // @Operation(summary = "국가(Table) 수정" , description = "국가(Table) 데이터 수정" )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Update the MCtry", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = MCtry.class)) }),
            @ApiResponse(responseCode = "404", description = "MCtry not found", content = @Content) })
    @PutMapping("/mctrys/{ctryCode3}")
    ResponseEntity<MCtry> putData(@RequestBody MCtry newData, @PathVariable("ctryCode3") String ctryCode3) {
        return repository.findById(ctryCode3) //
                .map(oldData -> {
                    newData.setCtryCode3(oldData.getCtryCode3());
                    return new ResponseEntity<>(repository.save(newData), HttpStatus.OK);
                })
                .orElseGet(() -> {
                    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
                });

    }

    // @Operation(summary = "국가(Table) 수정" , description = "국가(Table) 데이터 수정" )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Update the MCtry", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = MCtry.class)) }),
            @ApiResponse(responseCode = "404", description = "MCtry not found", content = @Content) })
	@PatchMapping("/mctrys/{ctryCode3}")
    ResponseEntity<MCtry> patchData(@RequestBody Map<String, Object> newMap, @PathVariable("ctryCode3") String ctryCode3) {
        MCtry newData = mapper.convertValue(newMap, MCtry.class);
        return repository.findById(ctryCode3) //
                .map(oldData -> {
                    newMap.forEach((strKey, strValue) -> {
						switch(strKey){
						    case "ctryCode2" : oldData.setCtryCode2(newData.getCtryCode2()); break;
						    case "ctryNm" : oldData.setCtryNm(newData.getCtryNm()); break;
						    case "ctryAbbrNm" : oldData.setCtryAbbrNm(newData.getCtryAbbrNm()); break;
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
	
    // @Operation(summary = "국가(Table) 삭제" , description = "국가(Table) Primary Key로 삭제" )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Delete the MCtry", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = MCtry.class)) }),
            @ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content) })
    @DeleteMapping("/mctrys/{ctryCode3}")
    public ResponseEntity<HttpStatus> deleteUser(@PathVariable("ctryCode3") String ctryCode3) {
        try {
            repository.deleteById(ctryCode3);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
