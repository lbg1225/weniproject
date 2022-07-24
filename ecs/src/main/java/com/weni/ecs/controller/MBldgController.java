/**
 * MBldg Entity Controller 클래스
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
import com.weni.ecs.domain.entity.MBldg;
import com.weni.ecs.domain.repository.MBldgRepository;

import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;


@RestController
@Tag(name = "MBldg 건물(Table) Controller")
@Slf4j
public class MBldgController {

    @Autowired
    MBldgRepository repository;


    @Autowired
    ObjectMapper mapper;

    // @Operation(summary = "건물(Table) 전체조회" , summary = "건물(Table) 조회" )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the mbldgs", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = MBldg.class)) }),
            @ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content) })
    @GetMapping("/mbldgs")
    public ResponseEntity<Page<MBldg>> getAll(@PageableDefault Pageable pageable) {
        try {
			log.info("findAll");
            return ResponseEntity.ok().body(repository.findAll(pageable));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(null);
        }
    }

    
    // @Operation(summary = "건물(Table) Key조회" , description = "건물(Table) Primary Key로 조회" )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the MBldg", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = MBldg.class)) }),
            @ApiResponse(responseCode = "404", description = "MBldg not found", content = @Content) })
    @GetMapping("/mbldgs/{bldgCode}")
    public ResponseEntity<MBldg> getById(@PathVariable("bldgCode") String bldgCode) {
        Optional<MBldg> data = repository.findById(bldgCode);

        if (data.isPresent()) {
            return ResponseEntity.ok().body(data.get());
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // @Operation(summary = "건물(Table) 등록" , description = "건물(Table) 신규 데이터 등록" )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Create the MBldg", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = MBldg.class)) }),
            @ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content) })
    @PostMapping("/mbldgs")
    ResponseEntity<MBldg> postData(@RequestBody MBldg newData) {
        try {
            newData = repository.save(newData);
            return new ResponseEntity<>(newData, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // @Operation(summary = "건물(Table) 수정" , description = "건물(Table) 데이터 수정" )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Update the MBldg", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = MBldg.class)) }),
            @ApiResponse(responseCode = "404", description = "MBldg not found", content = @Content) })
    @PutMapping("/mbldgs/{bldgCode}")
    ResponseEntity<MBldg> putData(@RequestBody MBldg newData, @PathVariable("bldgCode") String bldgCode) {
        return repository.findById(bldgCode) //
                .map(oldData -> {
                    newData.setBldgCode(oldData.getBldgCode());
                    return new ResponseEntity<>(repository.save(newData), HttpStatus.OK);
                })
                .orElseGet(() -> {
                    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
                });

    }

    // @Operation(summary = "건물(Table) 수정" , description = "건물(Table) 데이터 수정" )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Update the MBldg", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = MBldg.class)) }),
            @ApiResponse(responseCode = "404", description = "MBldg not found", content = @Content) })
	@PatchMapping("/mbldgs/{bldgCode}")
    ResponseEntity<MBldg> patchData(@RequestBody Map<String, Object> newMap, @PathVariable("bldgCode") String bldgCode) {
        MBldg newData = mapper.convertValue(newMap, MBldg.class);
        return repository.findById(bldgCode) //
                .map(oldData -> {
                    newMap.forEach((strKey, strValue) -> {
						switch(strKey){
						    case "bldgNm" : oldData.setBldgNm(newData.getBldgNm()); break;
						    case "addrState" : oldData.setAddrState(newData.getAddrState()); break;
						    case "addrFcity" : oldData.setAddrFcity(newData.getAddrFcity()); break;
						    case "addrWard" : oldData.setAddrWard(newData.getAddrWard()); break;
						    case "addrDistrict" : oldData.setAddrDistrict(newData.getAddrDistrict()); break;
						    case "addrDist" : oldData.setAddrDist(newData.getAddrDist()); break;
						    case "addrHsNum" : oldData.setAddrHsNum(newData.getAddrHsNum()); break;
						    case "addrAptDistrict" : oldData.setAddrAptDistrict(newData.getAddrAptDistrict()); break;
						    case "lgt" : oldData.setLgt(newData.getLgt()); break;
						    case "ltt" : oldData.setLtt(newData.getLtt()); break;
						    case "fstRegpersnId" : oldData.setFstRegpersnId(newData.getFstRegpersnId()); break;
						    case "finalUptpersnId" : oldData.setFinalUptpersnId(newData.getFinalUptpersnId()); break;
						    case "fstRegTm" : oldData.setFstRegTm(newData.getFstRegTm()); break;
						    case "finalUptTm" : oldData.setFinalUptTm(newData.getFinalUptTm()); break;
						    case "bldgGbCode" : oldData.setBldgGbCode(newData.getBldgGbCode()); break;
						}
                    });
                    return new ResponseEntity<>(repository.save(oldData), HttpStatus.OK);
                })
                .orElseGet(() -> {
                    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
                });
    }
	
    // @Operation(summary = "건물(Table) 삭제" , description = "건물(Table) Primary Key로 삭제" )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Delete the MBldg", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = MBldg.class)) }),
            @ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content) })
    @DeleteMapping("/mbldgs/{bldgCode}")
    public ResponseEntity<HttpStatus> deleteUser(@PathVariable("bldgCode") String bldgCode) {
        try {
            repository.deleteById(bldgCode);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
