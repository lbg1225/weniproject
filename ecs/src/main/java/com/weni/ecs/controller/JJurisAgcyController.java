/**
 * JJurisAgcy Entity Controller 클래스
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
import com.weni.ecs.domain.entity.JJurisAgcy;
import com.weni.ecs.domain.entity.JJurisAgcyPK;
import com.weni.ecs.domain.repository.JJurisAgcyRepository;

import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;


@RestController
@Tag(name = "JJurisAgcy 관할 기관(Table) Controller")
@Slf4j
public class JJurisAgcyController {

    @Autowired
    JJurisAgcyRepository repository;


    @Autowired
    ObjectMapper mapper;

    // @Operation(summary = "관할 기관(Table) 전체조회" , summary = "관할 기관(Table) 조회" )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the jjurisagcys", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = JJurisAgcy.class)) }),
            @ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content) })
    @GetMapping("/jjurisagcys")
    public ResponseEntity<Page<JJurisAgcy>> getAll(@PageableDefault Pageable pageable) {
        try {
			log.info("findAll");
            return ResponseEntity.ok().body(repository.findAll(pageable));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(null);
        }
    }

    
    // @Operation(summary = "관할 기관(Table) Key조회" , description = "관할 기관(Table) Primary Key로 조회" )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the JJurisAgcy", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = JJurisAgcy.class)) }),
            @ApiResponse(responseCode = "404", description = "JJurisAgcy not found", content = @Content) })
    @GetMapping("/jjurisagcys/{jurisCode}/{jurisMngCode}")
    public ResponseEntity<JJurisAgcy> getById(@PathVariable("jurisCode") String jurisCode, @PathVariable("jurisMngCode") String jurisMngCode) {
        Optional<JJurisAgcy> data = repository.findById(new JJurisAgcyPK(jurisCode, jurisMngCode));

        if (data.isPresent()) {
            return ResponseEntity.ok().body(data.get());
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // @Operation(summary = "관할 기관(Table) 등록" , description = "관할 기관(Table) 신규 데이터 등록" )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Create the JJurisAgcy", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = JJurisAgcy.class)) }),
            @ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content) })
    @PostMapping("/jjurisagcys")
    ResponseEntity<JJurisAgcy> postData(@RequestBody JJurisAgcy newData) {
        try {
            newData = repository.save(newData);
            return new ResponseEntity<>(newData, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // @Operation(summary = "관할 기관(Table) 수정" , description = "관할 기관(Table) 데이터 수정" )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Update the JJurisAgcy", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = JJurisAgcy.class)) }),
            @ApiResponse(responseCode = "404", description = "JJurisAgcy not found", content = @Content) })
    @PutMapping("/jjurisagcys/{jurisCode}/{jurisMngCode}")
    ResponseEntity<JJurisAgcy> putData(@RequestBody JJurisAgcy newData, @PathVariable("jurisCode") String jurisCode, @PathVariable("jurisMngCode") String jurisMngCode) {
        return repository.findById(new JJurisAgcyPK(jurisCode, jurisMngCode)) //
                .map(oldData -> {
                    newData.setJurisCode(oldData.getJurisCode());
                    newData.setJurisMngCode(oldData.getJurisMngCode());
                    return new ResponseEntity<>(repository.save(newData), HttpStatus.OK);
                })
                .orElseGet(() -> {
                    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
                });

    }

    // @Operation(summary = "관할 기관(Table) 수정" , description = "관할 기관(Table) 데이터 수정" )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Update the JJurisAgcy", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = JJurisAgcy.class)) }),
            @ApiResponse(responseCode = "404", description = "JJurisAgcy not found", content = @Content) })
	@PatchMapping("/jjurisagcys/{jurisCode}/{jurisMngCode}")
    ResponseEntity<JJurisAgcy> patchData(@RequestBody Map<String, Object> newMap, @PathVariable("jurisCode") String jurisCode, @PathVariable("jurisMngCode") String jurisMngCode) {
        JJurisAgcy newData = mapper.convertValue(newMap, JJurisAgcy.class);
        return repository.findById(new JJurisAgcyPK(jurisCode, jurisMngCode)) //
                .map(oldData -> {
                    newMap.forEach((strKey, strValue) -> {
						switch(strKey){
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
	
    // @Operation(summary = "관할 기관(Table) 삭제" , description = "관할 기관(Table) Primary Key로 삭제" )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Delete the JJurisAgcy", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = JJurisAgcy.class)) }),
            @ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content) })
    @DeleteMapping("/jjurisagcys/{jurisCode}/{jurisMngCode}")
    public ResponseEntity<HttpStatus> deleteUser(@PathVariable("jurisCode") String jurisCode, @PathVariable("jurisMngCode") String jurisMngCode) {
        try {
            repository.deleteById(new JJurisAgcyPK(jurisCode, jurisMngCode));
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
