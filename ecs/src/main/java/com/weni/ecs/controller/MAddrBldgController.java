/**
 * MAddrBldg Entity Controller 클래스
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
import com.weni.ecs.domain.entity.MAddrBldg;
import com.weni.ecs.domain.repository.MAddrBldgRepository;

import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;


@RestController
@Tag(name = "MAddrBldg 주소 건물(Table) Controller")
@Slf4j
public class MAddrBldgController {

    @Autowired
    MAddrBldgRepository repository;


    @Autowired
    ObjectMapper mapper;

    // @Operation(summary = "주소 건물(Table) 전체조회" , summary = "주소 건물(Table) 조회" )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the maddrbldgs", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = MAddrBldg.class)) }),
            @ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content) })
    @GetMapping("/maddrbldgs")
    public ResponseEntity<Page<MAddrBldg>> getAll(@PageableDefault Pageable pageable) {
        try {
			log.info("findAll");
            return ResponseEntity.ok().body(repository.findAll(pageable));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(null);
        }
    }

    
    // @Operation(summary = "주소 건물(Table) Key조회" , description = "주소 건물(Table) Primary Key로 조회" )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the MAddrBldg", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = MAddrBldg.class)) }),
            @ApiResponse(responseCode = "404", description = "MAddrBldg not found", content = @Content) })
    @GetMapping("/maddrbldgs/{bldgCode}")
    public ResponseEntity<MAddrBldg> getById(@PathVariable("bldgCode") String bldgCode) {
        Optional<MAddrBldg> data = repository.findById(bldgCode);

        if (data.isPresent()) {
            return ResponseEntity.ok().body(data.get());
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // @Operation(summary = "주소 건물(Table) 등록" , description = "주소 건물(Table) 신규 데이터 등록" )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Create the MAddrBldg", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = MAddrBldg.class)) }),
            @ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content) })
    @PostMapping("/maddrbldgs")
    ResponseEntity<MAddrBldg> postData(@RequestBody MAddrBldg newData) {
        try {
            newData = repository.save(newData);
            return new ResponseEntity<>(newData, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // @Operation(summary = "주소 건물(Table) 수정" , description = "주소 건물(Table) 데이터 수정" )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Update the MAddrBldg", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = MAddrBldg.class)) }),
            @ApiResponse(responseCode = "404", description = "MAddrBldg not found", content = @Content) })
    @PutMapping("/maddrbldgs/{bldgCode}")
    ResponseEntity<MAddrBldg> putData(@RequestBody MAddrBldg newData, @PathVariable("bldgCode") String bldgCode) {
        return repository.findById(bldgCode) //
                .map(oldData -> {
                    newData.setBldgCode(oldData.getBldgCode());
                    return new ResponseEntity<>(repository.save(newData), HttpStatus.OK);
                })
                .orElseGet(() -> {
                    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
                });

    }

    // @Operation(summary = "주소 건물(Table) 수정" , description = "주소 건물(Table) 데이터 수정" )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Update the MAddrBldg", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = MAddrBldg.class)) }),
            @ApiResponse(responseCode = "404", description = "MAddrBldg not found", content = @Content) })
	@PatchMapping("/maddrbldgs/{bldgCode}")
    ResponseEntity<MAddrBldg> patchData(@RequestBody Map<String, Object> newMap, @PathVariable("bldgCode") String bldgCode) {
        MAddrBldg newData = mapper.convertValue(newMap, MAddrBldg.class);
        return repository.findById(bldgCode) //
                .map(oldData -> {
                    newMap.forEach((strKey, strValue) -> {
						switch(strKey){
						    case "addrAllCode" : oldData.setAddrAllCode(newData.getAddrAllCode()); break;
						    case "roadSectCode" : oldData.setRoadSectCode(newData.getRoadSectCode()); break;
						    case "mainHsNum" : oldData.setMainHsNum(newData.getMainHsNum()); break;
						    case "subHsNum" : oldData.setSubHsNum(newData.getSubHsNum()); break;
						    case "bldgNm" : oldData.setBldgNm(newData.getBldgNm()); break;
						    case "lgt" : oldData.setLgt(newData.getLgt()); break;
						    case "ltt" : oldData.setLtt(newData.getLtt()); break;
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
	
    // @Operation(summary = "주소 건물(Table) 삭제" , description = "주소 건물(Table) Primary Key로 삭제" )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Delete the MAddrBldg", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = MAddrBldg.class)) }),
            @ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content) })
    @DeleteMapping("/maddrbldgs/{bldgCode}")
    public ResponseEntity<HttpStatus> deleteUser(@PathVariable("bldgCode") String bldgCode) {
        try {
            repository.deleteById(bldgCode);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
