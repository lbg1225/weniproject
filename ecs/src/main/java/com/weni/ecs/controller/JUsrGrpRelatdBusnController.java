/**
 * JUsrGrpRelatdBusn Entity Controller 클래스
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
import com.weni.ecs.domain.entity.JUsrGrpRelatdBusn;
import com.weni.ecs.domain.entity.JUsrGrpRelatdBusnPK;
import com.weni.ecs.domain.repository.JUsrGrpRelatdBusnRepository;

import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;


@RestController
@Tag(name = "JUsrGrpRelatdBusn 사용자 그룹 관련 업무(Table) Controller")
@Slf4j
public class JUsrGrpRelatdBusnController {

    @Autowired
    JUsrGrpRelatdBusnRepository repository;


    @Autowired
    ObjectMapper mapper;

    // @Operation(summary = "사용자 그룹 관련 업무(Table) 전체조회" , summary = "사용자 그룹 관련 업무(Table) 조회" )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the jusrgrprelatdbusns", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = JUsrGrpRelatdBusn.class)) }),
            @ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content) })
    @GetMapping("/jusrgrprelatdbusns")
    public ResponseEntity<Page<JUsrGrpRelatdBusn>> getAll(@PageableDefault Pageable pageable) {
        try {
			log.info("findAll");
            return ResponseEntity.ok().body(repository.findAll(pageable));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(null);
        }
    }

    
    // @Operation(summary = "사용자 그룹 관련 업무(Table) Key조회" , description = "사용자 그룹 관련 업무(Table) Primary Key로 조회" )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the JUsrGrpRelatdBusn", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = JUsrGrpRelatdBusn.class)) }),
            @ApiResponse(responseCode = "404", description = "JUsrGrpRelatdBusn not found", content = @Content) })
    @GetMapping("/jusrgrprelatdbusns/{usrGrpId}/{busn}")
    public ResponseEntity<JUsrGrpRelatdBusn> getById(@PathVariable("usrGrpId") String usrGrpId, @PathVariable("busn") String busn) {
        Optional<JUsrGrpRelatdBusn> data = repository.findById(new JUsrGrpRelatdBusnPK(usrGrpId, busn));

        if (data.isPresent()) {
            return ResponseEntity.ok().body(data.get());
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // @Operation(summary = "사용자 그룹 관련 업무(Table) 등록" , description = "사용자 그룹 관련 업무(Table) 신규 데이터 등록" )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Create the JUsrGrpRelatdBusn", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = JUsrGrpRelatdBusn.class)) }),
            @ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content) })
    @PostMapping("/jusrgrprelatdbusns")
    ResponseEntity<JUsrGrpRelatdBusn> postData(@RequestBody JUsrGrpRelatdBusn newData) {
        try {
            newData = repository.save(newData);
            return new ResponseEntity<>(newData, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // @Operation(summary = "사용자 그룹 관련 업무(Table) 수정" , description = "사용자 그룹 관련 업무(Table) 데이터 수정" )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Update the JUsrGrpRelatdBusn", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = JUsrGrpRelatdBusn.class)) }),
            @ApiResponse(responseCode = "404", description = "JUsrGrpRelatdBusn not found", content = @Content) })
    @PutMapping("/jusrgrprelatdbusns/{usrGrpId}/{busn}")
    ResponseEntity<JUsrGrpRelatdBusn> putData(@RequestBody JUsrGrpRelatdBusn newData, @PathVariable("usrGrpId") String usrGrpId, @PathVariable("busn") String busn) {
        return repository.findById(new JUsrGrpRelatdBusnPK(usrGrpId, busn)) //
                .map(oldData -> {
                    newData.setUsrGrpId(oldData.getUsrGrpId());
                    newData.setBusn(oldData.getBusn());
                    return new ResponseEntity<>(repository.save(newData), HttpStatus.OK);
                })
                .orElseGet(() -> {
                    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
                });

    }

    // @Operation(summary = "사용자 그룹 관련 업무(Table) 수정" , description = "사용자 그룹 관련 업무(Table) 데이터 수정" )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Update the JUsrGrpRelatdBusn", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = JUsrGrpRelatdBusn.class)) }),
            @ApiResponse(responseCode = "404", description = "JUsrGrpRelatdBusn not found", content = @Content) })
	@PatchMapping("/jusrgrprelatdbusns/{usrGrpId}/{busn}")
    ResponseEntity<JUsrGrpRelatdBusn> patchData(@RequestBody Map<String, Object> newMap, @PathVariable("usrGrpId") String usrGrpId, @PathVariable("busn") String busn) {
        JUsrGrpRelatdBusn newData = mapper.convertValue(newMap, JUsrGrpRelatdBusn.class);
        return repository.findById(new JUsrGrpRelatdBusnPK(usrGrpId, busn)) //
                .map(oldData -> {
                    newMap.forEach((strKey, strValue) -> {
						switch(strKey){
						    case "jurisFlag" : oldData.setJurisFlag(newData.getJurisFlag()); break;
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
	
    // @Operation(summary = "사용자 그룹 관련 업무(Table) 삭제" , description = "사용자 그룹 관련 업무(Table) Primary Key로 삭제" )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Delete the JUsrGrpRelatdBusn", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = JUsrGrpRelatdBusn.class)) }),
            @ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content) })
    @DeleteMapping("/jusrgrprelatdbusns/{usrGrpId}/{busn}")
    public ResponseEntity<HttpStatus> deleteUser(@PathVariable("usrGrpId") String usrGrpId, @PathVariable("busn") String busn) {
        try {
            repository.deleteById(new JUsrGrpRelatdBusnPK(usrGrpId, busn));
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
