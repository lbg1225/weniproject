/**
 * JUsrRole Entity Controller 클래스
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
import com.weni.ecs.domain.entity.JUsrRole;
import com.weni.ecs.domain.entity.JUsrRolePK;
import com.weni.ecs.domain.repository.JUsrRoleRepository;

import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;


@RestController
@Tag(name = "JUsrRole 사용자 권한(Table) Controller")
@Slf4j
public class JUsrRoleController {

    @Autowired
    JUsrRoleRepository repository;


    @Autowired
    ObjectMapper mapper;

    // @Operation(summary = "사용자 권한(Table) 전체조회" , summary = "사용자 권한(Table) 조회" )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the jusrroles", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = JUsrRole.class)) }),
            @ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content) })
    @GetMapping("/jusrroles")
    public ResponseEntity<Page<JUsrRole>> getAll(@PageableDefault Pageable pageable) {
        try {
			log.info("findAll");
            return ResponseEntity.ok().body(repository.findAll(pageable));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(null);
        }
    }

    
    // @Operation(summary = "사용자 권한(Table) Key조회" , description = "사용자 권한(Table) Primary Key로 조회" )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the JUsrRole", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = JUsrRole.class)) }),
            @ApiResponse(responseCode = "404", description = "JUsrRole not found", content = @Content) })
    @GetMapping("/jusrroles/{roleCode}/{roleKnd}/{usrId}")
    public ResponseEntity<JUsrRole> getById(@PathVariable("roleCode") String roleCode, @PathVariable("roleKnd") String roleKnd, @PathVariable("usrId") String usrId) {
        Optional<JUsrRole> data = repository.findById(new JUsrRolePK(roleCode, roleKnd, usrId));

        if (data.isPresent()) {
            return ResponseEntity.ok().body(data.get());
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // @Operation(summary = "사용자 권한(Table) 등록" , description = "사용자 권한(Table) 신규 데이터 등록" )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Create the JUsrRole", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = JUsrRole.class)) }),
            @ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content) })
    @PostMapping("/jusrroles")
    ResponseEntity<JUsrRole> postData(@RequestBody JUsrRole newData) {
        try {
            newData = repository.save(newData);
            return new ResponseEntity<>(newData, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // @Operation(summary = "사용자 권한(Table) 수정" , description = "사용자 권한(Table) 데이터 수정" )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Update the JUsrRole", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = JUsrRole.class)) }),
            @ApiResponse(responseCode = "404", description = "JUsrRole not found", content = @Content) })
    @PutMapping("/jusrroles/{roleCode}/{roleKnd}/{usrId}")
    ResponseEntity<JUsrRole> putData(@RequestBody JUsrRole newData, @PathVariable("roleCode") String roleCode, @PathVariable("roleKnd") String roleKnd, @PathVariable("usrId") String usrId) {
        return repository.findById(new JUsrRolePK(roleCode, roleKnd, usrId)) //
                .map(oldData -> {
                    newData.setRoleCode(oldData.getRoleCode());
                    newData.setRoleKnd(oldData.getRoleKnd());
                    newData.setUsrId(oldData.getUsrId());
                    return new ResponseEntity<>(repository.save(newData), HttpStatus.OK);
                })
                .orElseGet(() -> {
                    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
                });

    }

    // @Operation(summary = "사용자 권한(Table) 수정" , description = "사용자 권한(Table) 데이터 수정" )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Update the JUsrRole", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = JUsrRole.class)) }),
            @ApiResponse(responseCode = "404", description = "JUsrRole not found", content = @Content) })
	@PatchMapping("/jusrroles/{roleCode}/{roleKnd}/{usrId}")
    ResponseEntity<JUsrRole> patchData(@RequestBody Map<String, Object> newMap, @PathVariable("roleCode") String roleCode, @PathVariable("roleKnd") String roleKnd, @PathVariable("usrId") String usrId) {
        JUsrRole newData = mapper.convertValue(newMap, JUsrRole.class);
        return repository.findById(new JUsrRolePK(roleCode, roleKnd, usrId)) //
                .map(oldData -> {
                    newMap.forEach((strKey, strValue) -> {
						switch(strKey){
						    case "fstRegpersnId" : oldData.setFstRegpersnId(newData.getFstRegpersnId()); break;
						    case "finalUptpersnId" : oldData.setFinalUptpersnId(newData.getFinalUptpersnId()); break;
						    case "fstRegTm" : oldData.setFstRegTm(newData.getFstRegTm()); break;
						    case "finalUptTm" : oldData.setFinalUptTm(newData.getFinalUptTm()); break;
						    case "editCode" : oldData.setEditCode(newData.getEditCode()); break;
						}
                    });
                    return new ResponseEntity<>(repository.save(oldData), HttpStatus.OK);
                })
                .orElseGet(() -> {
                    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
                });
    }
	
    // @Operation(summary = "사용자 권한(Table) 삭제" , description = "사용자 권한(Table) Primary Key로 삭제" )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Delete the JUsrRole", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = JUsrRole.class)) }),
            @ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content) })
    @DeleteMapping("/jusrroles/{roleCode}/{roleKnd}/{usrId}")
    public ResponseEntity<HttpStatus> deleteUser(@PathVariable("roleCode") String roleCode, @PathVariable("roleKnd") String roleKnd, @PathVariable("usrId") String usrId) {
        try {
            repository.deleteById(new JUsrRolePK(roleCode, roleKnd, usrId));
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
