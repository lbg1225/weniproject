/**
 * MEditRole Entity Controller 클래스
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
import com.weni.ecs.domain.entity.MEditRole;
import com.weni.ecs.domain.repository.MEditRoleRepository;

import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;


@RestController
@Tag(name = "MEditRole 편집 권한(Table) Controller")
@Slf4j
public class MEditRoleController {

    @Autowired
    MEditRoleRepository repository;


    @Autowired
    ObjectMapper mapper;

    // @Operation(summary = "편집 권한(Table) 전체조회" , summary = "편집 권한(Table) 조회" )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the meditroles", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = MEditRole.class)) }),
            @ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content) })
    @GetMapping("/meditroles")
    public ResponseEntity<Page<MEditRole>> getAll(@PageableDefault Pageable pageable) {
        try {
			log.info("findAll");
            return ResponseEntity.ok().body(repository.findAll(pageable));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(null);
        }
    }

    
    // @Operation(summary = "편집 권한(Table) Key조회" , description = "편집 권한(Table) Primary Key로 조회" )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the MEditRole", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = MEditRole.class)) }),
            @ApiResponse(responseCode = "404", description = "MEditRole not found", content = @Content) })
    @GetMapping("/meditroles/{editRoleCode}")
    public ResponseEntity<MEditRole> getById(@PathVariable("editRoleCode") String editRoleCode) {
        Optional<MEditRole> data = repository.findById(editRoleCode);

        if (data.isPresent()) {
            return ResponseEntity.ok().body(data.get());
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // @Operation(summary = "편집 권한(Table) 등록" , description = "편집 권한(Table) 신규 데이터 등록" )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Create the MEditRole", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = MEditRole.class)) }),
            @ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content) })
    @PostMapping("/meditroles")
    ResponseEntity<MEditRole> postData(@RequestBody MEditRole newData) {
        try {
            newData = repository.save(newData);
            return new ResponseEntity<>(newData, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // @Operation(summary = "편집 권한(Table) 수정" , description = "편집 권한(Table) 데이터 수정" )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Update the MEditRole", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = MEditRole.class)) }),
            @ApiResponse(responseCode = "404", description = "MEditRole not found", content = @Content) })
    @PutMapping("/meditroles/{editRoleCode}")
    ResponseEntity<MEditRole> putData(@RequestBody MEditRole newData, @PathVariable("editRoleCode") String editRoleCode) {
        return repository.findById(editRoleCode) //
                .map(oldData -> {
                    newData.setEditRoleCode(oldData.getEditRoleCode());
                    return new ResponseEntity<>(repository.save(newData), HttpStatus.OK);
                })
                .orElseGet(() -> {
                    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
                });

    }

    // @Operation(summary = "편집 권한(Table) 수정" , description = "편집 권한(Table) 데이터 수정" )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Update the MEditRole", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = MEditRole.class)) }),
            @ApiResponse(responseCode = "404", description = "MEditRole not found", content = @Content) })
	@PatchMapping("/meditroles/{editRoleCode}")
    ResponseEntity<MEditRole> patchData(@RequestBody Map<String, Object> newMap, @PathVariable("editRoleCode") String editRoleCode) {
        MEditRole newData = mapper.convertValue(newMap, MEditRole.class);
        return repository.findById(editRoleCode) //
                .map(oldData -> {
                    newMap.forEach((strKey, strValue) -> {
						switch(strKey){
						    case "editRoleNm" : oldData.setEditRoleNm(newData.getEditRoleNm()); break;
						    case "delFlag" : oldData.setDelFlag(newData.getDelFlag()); break;
						    case "fstRegpersnId" : oldData.setFstRegpersnId(newData.getFstRegpersnId()); break;
						    case "finalUptpersnId" : oldData.setFinalUptpersnId(newData.getFinalUptpersnId()); break;
						    case "fstRegTm" : oldData.setFstRegTm(newData.getFstRegTm()); break;
						    case "finalUptTm" : oldData.setFinalUptTm(newData.getFinalUptTm()); break;
						    case "editRoleNmRus" : oldData.setEditRoleNmRus(newData.getEditRoleNmRus()); break;
						    case "editRoleNmKor" : oldData.setEditRoleNmKor(newData.getEditRoleNmKor()); break;
						}
                    });
                    return new ResponseEntity<>(repository.save(oldData), HttpStatus.OK);
                })
                .orElseGet(() -> {
                    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
                });
    }
	
    // @Operation(summary = "편집 권한(Table) 삭제" , description = "편집 권한(Table) Primary Key로 삭제" )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Delete the MEditRole", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = MEditRole.class)) }),
            @ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content) })
    @DeleteMapping("/meditroles/{editRoleCode}")
    public ResponseEntity<HttpStatus> deleteUser(@PathVariable("editRoleCode") String editRoleCode) {
        try {
            repository.deleteById(editRoleCode);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
