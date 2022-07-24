/**
 * MBtnRole Entity Controller 클래스
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
import com.weni.ecs.domain.entity.MBtnRole;
import com.weni.ecs.domain.repository.MBtnRoleRepository;

import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;


@RestController
@Tag(name = "MBtnRole 버튼 권한(Table) Controller")
@Slf4j
public class MBtnRoleController {

    @Autowired
    MBtnRoleRepository repository;


    @Autowired
    ObjectMapper mapper;

    // @Operation(summary = "버튼 권한(Table) 전체조회" , summary = "버튼 권한(Table) 조회" )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the mbtnroles", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = MBtnRole.class)) }),
            @ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content) })
    @GetMapping("/mbtnroles")
    public ResponseEntity<Page<MBtnRole>> getAll(@PageableDefault Pageable pageable) {
        try {
			log.info("findAll");
            return ResponseEntity.ok().body(repository.findAll(pageable));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(null);
        }
    }

    
    // @Operation(summary = "버튼 권한(Table) Key조회" , description = "버튼 권한(Table) Primary Key로 조회" )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the MBtnRole", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = MBtnRole.class)) }),
            @ApiResponse(responseCode = "404", description = "MBtnRole not found", content = @Content) })
    @GetMapping("/mbtnroles/{btnRoleCode}")
    public ResponseEntity<MBtnRole> getById(@PathVariable("btnRoleCode") String btnRoleCode) {
        Optional<MBtnRole> data = repository.findById(btnRoleCode);

        if (data.isPresent()) {
            return ResponseEntity.ok().body(data.get());
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // @Operation(summary = "버튼 권한(Table) 등록" , description = "버튼 권한(Table) 신규 데이터 등록" )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Create the MBtnRole", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = MBtnRole.class)) }),
            @ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content) })
    @PostMapping("/mbtnroles")
    ResponseEntity<MBtnRole> postData(@RequestBody MBtnRole newData) {
        try {
            newData = repository.save(newData);
            return new ResponseEntity<>(newData, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // @Operation(summary = "버튼 권한(Table) 수정" , description = "버튼 권한(Table) 데이터 수정" )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Update the MBtnRole", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = MBtnRole.class)) }),
            @ApiResponse(responseCode = "404", description = "MBtnRole not found", content = @Content) })
    @PutMapping("/mbtnroles/{btnRoleCode}")
    ResponseEntity<MBtnRole> putData(@RequestBody MBtnRole newData, @PathVariable("btnRoleCode") String btnRoleCode) {
        return repository.findById(btnRoleCode) //
                .map(oldData -> {
                    newData.setBtnRoleCode(oldData.getBtnRoleCode());
                    return new ResponseEntity<>(repository.save(newData), HttpStatus.OK);
                })
                .orElseGet(() -> {
                    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
                });

    }

    // @Operation(summary = "버튼 권한(Table) 수정" , description = "버튼 권한(Table) 데이터 수정" )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Update the MBtnRole", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = MBtnRole.class)) }),
            @ApiResponse(responseCode = "404", description = "MBtnRole not found", content = @Content) })
	@PatchMapping("/mbtnroles/{btnRoleCode}")
    ResponseEntity<MBtnRole> patchData(@RequestBody Map<String, Object> newMap, @PathVariable("btnRoleCode") String btnRoleCode) {
        MBtnRole newData = mapper.convertValue(newMap, MBtnRole.class);
        return repository.findById(btnRoleCode) //
                .map(oldData -> {
                    newMap.forEach((strKey, strValue) -> {
						switch(strKey){
						    case "btnRoleNm" : oldData.setBtnRoleNm(newData.getBtnRoleNm()); break;
						    case "delFlag" : oldData.setDelFlag(newData.getDelFlag()); break;
						    case "fstRegpersnId" : oldData.setFstRegpersnId(newData.getFstRegpersnId()); break;
						    case "finalUptpersnId" : oldData.setFinalUptpersnId(newData.getFinalUptpersnId()); break;
						    case "fstRegTm" : oldData.setFstRegTm(newData.getFstRegTm()); break;
						    case "finalUptTm" : oldData.setFinalUptTm(newData.getFinalUptTm()); break;
						    case "btnRoleNmRus" : oldData.setBtnRoleNmRus(newData.getBtnRoleNmRus()); break;
						    case "btnRoleNmKor" : oldData.setBtnRoleNmKor(newData.getBtnRoleNmKor()); break;
						}
                    });
                    return new ResponseEntity<>(repository.save(oldData), HttpStatus.OK);
                })
                .orElseGet(() -> {
                    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
                });
    }
	
    // @Operation(summary = "버튼 권한(Table) 삭제" , description = "버튼 권한(Table) Primary Key로 삭제" )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Delete the MBtnRole", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = MBtnRole.class)) }),
            @ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content) })
    @DeleteMapping("/mbtnroles/{btnRoleCode}")
    public ResponseEntity<HttpStatus> deleteUser(@PathVariable("btnRoleCode") String btnRoleCode) {
        try {
            repository.deleteById(btnRoleCode);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
