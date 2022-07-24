/**
 * MRelatdBusn Entity Controller 클래스
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
import com.weni.ecs.domain.entity.MRelatdBusn;
import com.weni.ecs.domain.repository.MRelatdBusnRepository;

import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;


@RestController
@Tag(name = "MRelatdBusn 관련 업무(Table) Controller")
@Slf4j
public class MRelatdBusnController {

    @Autowired
    MRelatdBusnRepository repository;


    @Autowired
    ObjectMapper mapper;

    // @Operation(summary = "관련 업무(Table) 전체조회" , summary = "관련 업무(Table) 조회" )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the mrelatdbusns", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = MRelatdBusn.class)) }),
            @ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content) })
    @GetMapping("/mrelatdbusns")
    public ResponseEntity<Page<MRelatdBusn>> getAll(@PageableDefault Pageable pageable) {
        try {
			log.info("findAll");
            return ResponseEntity.ok().body(repository.findAll(pageable));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(null);
        }
    }

    
    // @Operation(summary = "관련 업무(Table) Key조회" , description = "관련 업무(Table) Primary Key로 조회" )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the MRelatdBusn", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = MRelatdBusn.class)) }),
            @ApiResponse(responseCode = "404", description = "MRelatdBusn not found", content = @Content) })
    @GetMapping("/mrelatdbusns/{busn}")
    public ResponseEntity<MRelatdBusn> getById(@PathVariable("busn") String busn) {
        Optional<MRelatdBusn> data = repository.findById(busn);

        if (data.isPresent()) {
            return ResponseEntity.ok().body(data.get());
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // @Operation(summary = "관련 업무(Table) 등록" , description = "관련 업무(Table) 신규 데이터 등록" )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Create the MRelatdBusn", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = MRelatdBusn.class)) }),
            @ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content) })
    @PostMapping("/mrelatdbusns")
    ResponseEntity<MRelatdBusn> postData(@RequestBody MRelatdBusn newData) {
        try {
            newData = repository.save(newData);
            return new ResponseEntity<>(newData, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // @Operation(summary = "관련 업무(Table) 수정" , description = "관련 업무(Table) 데이터 수정" )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Update the MRelatdBusn", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = MRelatdBusn.class)) }),
            @ApiResponse(responseCode = "404", description = "MRelatdBusn not found", content = @Content) })
    @PutMapping("/mrelatdbusns/{busn}")
    ResponseEntity<MRelatdBusn> putData(@RequestBody MRelatdBusn newData, @PathVariable("busn") String busn) {
        return repository.findById(busn) //
                .map(oldData -> {
                    newData.setBusn(oldData.getBusn());
                    return new ResponseEntity<>(repository.save(newData), HttpStatus.OK);
                })
                .orElseGet(() -> {
                    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
                });

    }

    // @Operation(summary = "관련 업무(Table) 수정" , description = "관련 업무(Table) 데이터 수정" )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Update the MRelatdBusn", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = MRelatdBusn.class)) }),
            @ApiResponse(responseCode = "404", description = "MRelatdBusn not found", content = @Content) })
	@PatchMapping("/mrelatdbusns/{busn}")
    ResponseEntity<MRelatdBusn> patchData(@RequestBody Map<String, Object> newMap, @PathVariable("busn") String busn) {
        MRelatdBusn newData = mapper.convertValue(newMap, MRelatdBusn.class);
        return repository.findById(busn) //
                .map(oldData -> {
                    newMap.forEach((strKey, strValue) -> {
						switch(strKey){
						    case "busnNm" : oldData.setBusnNm(newData.getBusnNm()); break;
						    case "busnNmRus" : oldData.setBusnNmRus(newData.getBusnNmRus()); break;
						    case "busnNmKor" : oldData.setBusnNmKor(newData.getBusnNmKor()); break;
						    case "delFlag" : oldData.setDelFlag(newData.getDelFlag()); break;
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
	
    // @Operation(summary = "관련 업무(Table) 삭제" , description = "관련 업무(Table) Primary Key로 삭제" )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Delete the MRelatdBusn", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = MRelatdBusn.class)) }),
            @ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content) })
    @DeleteMapping("/mrelatdbusns/{busn}")
    public ResponseEntity<HttpStatus> deleteUser(@PathVariable("busn") String busn) {
        try {
            repository.deleteById(busn);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
