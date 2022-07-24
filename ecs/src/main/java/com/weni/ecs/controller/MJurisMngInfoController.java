/**
 * MJurisMngInfo Entity Controller 클래스
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
import com.weni.ecs.domain.entity.MJurisMngInfo;
import com.weni.ecs.domain.repository.MJurisMngInfoRepository;

import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;


@RestController
@Tag(name = "MJurisMngInfo 관할 관리 정보(Table) Controller")
@Slf4j
public class MJurisMngInfoController {

    @Autowired
    MJurisMngInfoRepository repository;


    @Autowired
    ObjectMapper mapper;

    // @Operation(summary = "관할 관리 정보(Table) 전체조회" , summary = "관할 관리 정보(Table) 조회" )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the mjurismnginfos", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = MJurisMngInfo.class)) }),
            @ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content) })
    @GetMapping("/mjurismnginfos")
    public ResponseEntity<Page<MJurisMngInfo>> getAll(@PageableDefault Pageable pageable) {
        try {
			log.info("findAll");
            return ResponseEntity.ok().body(repository.findAll(pageable));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(null);
        }
    }

    
    // @Operation(summary = "관할 관리 정보(Table) Key조회" , description = "관할 관리 정보(Table) Primary Key로 조회" )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the MJurisMngInfo", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = MJurisMngInfo.class)) }),
            @ApiResponse(responseCode = "404", description = "MJurisMngInfo not found", content = @Content) })
    @GetMapping("/mjurismnginfos/{jurisMngCode}")
    public ResponseEntity<MJurisMngInfo> getById(@PathVariable("jurisMngCode") String jurisMngCode) {
        Optional<MJurisMngInfo> data = repository.findById(jurisMngCode);

        if (data.isPresent()) {
            return ResponseEntity.ok().body(data.get());
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // @Operation(summary = "관할 관리 정보(Table) 등록" , description = "관할 관리 정보(Table) 신규 데이터 등록" )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Create the MJurisMngInfo", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = MJurisMngInfo.class)) }),
            @ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content) })
    @PostMapping("/mjurismnginfos")
    ResponseEntity<MJurisMngInfo> postData(@RequestBody MJurisMngInfo newData) {
        try {
            newData = repository.save(newData);
            return new ResponseEntity<>(newData, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // @Operation(summary = "관할 관리 정보(Table) 수정" , description = "관할 관리 정보(Table) 데이터 수정" )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Update the MJurisMngInfo", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = MJurisMngInfo.class)) }),
            @ApiResponse(responseCode = "404", description = "MJurisMngInfo not found", content = @Content) })
    @PutMapping("/mjurismnginfos/{jurisMngCode}")
    ResponseEntity<MJurisMngInfo> putData(@RequestBody MJurisMngInfo newData, @PathVariable("jurisMngCode") String jurisMngCode) {
        return repository.findById(jurisMngCode) //
                .map(oldData -> {
                    newData.setJurisMngCode(oldData.getJurisMngCode());
                    return new ResponseEntity<>(repository.save(newData), HttpStatus.OK);
                })
                .orElseGet(() -> {
                    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
                });

    }

    // @Operation(summary = "관할 관리 정보(Table) 수정" , description = "관할 관리 정보(Table) 데이터 수정" )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Update the MJurisMngInfo", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = MJurisMngInfo.class)) }),
            @ApiResponse(responseCode = "404", description = "MJurisMngInfo not found", content = @Content) })
	@PatchMapping("/mjurismnginfos/{jurisMngCode}")
    ResponseEntity<MJurisMngInfo> patchData(@RequestBody Map<String, Object> newMap, @PathVariable("jurisMngCode") String jurisMngCode) {
        MJurisMngInfo newData = mapper.convertValue(newMap, MJurisMngInfo.class);
        return repository.findById(jurisMngCode) //
                .map(oldData -> {
                    newMap.forEach((strKey, strValue) -> {
						switch(strKey){
						    case "jurisMngNm" : oldData.setJurisMngNm(newData.getJurisMngNm()); break;
						    case "jurisMngNmKor" : oldData.setJurisMngNmKor(newData.getJurisMngNmKor()); break;
						    case "jurisMngNmRus" : oldData.setJurisMngNmRus(newData.getJurisMngNmRus()); break;
						    case "jurisMngAbbrNm" : oldData.setJurisMngAbbrNm(newData.getJurisMngAbbrNm()); break;
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
	
    // @Operation(summary = "관할 관리 정보(Table) 삭제" , description = "관할 관리 정보(Table) Primary Key로 삭제" )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Delete the MJurisMngInfo", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = MJurisMngInfo.class)) }),
            @ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content) })
    @DeleteMapping("/mjurismnginfos/{jurisMngCode}")
    public ResponseEntity<HttpStatus> deleteUser(@PathVariable("jurisMngCode") String jurisMngCode) {
        try {
            repository.deleteById(jurisMngCode);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
