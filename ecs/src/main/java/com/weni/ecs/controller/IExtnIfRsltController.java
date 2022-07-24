/**
 * IExtnIfRslt Entity Controller 클래스
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
import com.weni.ecs.domain.entity.IExtnIfRslt;
import com.weni.ecs.domain.repository.IExtnIfRsltRepository;

import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;


@RestController
@Tag(name = "IExtnIfRslt 외부 인터페이스 결과(Table) Controller")
@Slf4j
public class IExtnIfRsltController {

    @Autowired
    IExtnIfRsltRepository repository;


    @Autowired
    ObjectMapper mapper;

    // @Operation(summary = "외부 인터페이스 결과(Table) 전체조회" , summary = "외부 인터페이스 결과(Table) 조회" )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the iextnifrslts", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = IExtnIfRslt.class)) }),
            @ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content) })
    @GetMapping("/iextnifrslts")
    public ResponseEntity<Page<IExtnIfRslt>> getAll(@PageableDefault Pageable pageable) {
        try {
			log.info("findAll");
            return ResponseEntity.ok().body(repository.findAll(pageable));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(null);
        }
    }

    
    // @Operation(summary = "외부 인터페이스 결과(Table) Key조회" , description = "외부 인터페이스 결과(Table) Primary Key로 조회" )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the IExtnIfRslt", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = IExtnIfRslt.class)) }),
            @ApiResponse(responseCode = "404", description = "IExtnIfRslt not found", content = @Content) })
    @GetMapping("/iextnifrslts/{reqId}")
    public ResponseEntity<IExtnIfRslt> getById(@PathVariable("reqId") String reqId) {
        Optional<IExtnIfRslt> data = repository.findById(reqId);

        if (data.isPresent()) {
            return ResponseEntity.ok().body(data.get());
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // @Operation(summary = "외부 인터페이스 결과(Table) 등록" , description = "외부 인터페이스 결과(Table) 신규 데이터 등록" )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Create the IExtnIfRslt", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = IExtnIfRslt.class)) }),
            @ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content) })
    @PostMapping("/iextnifrslts")
    ResponseEntity<IExtnIfRslt> postData(@RequestBody IExtnIfRslt newData) {
        try {
            newData = repository.save(newData);
            return new ResponseEntity<>(newData, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // @Operation(summary = "외부 인터페이스 결과(Table) 수정" , description = "외부 인터페이스 결과(Table) 데이터 수정" )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Update the IExtnIfRslt", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = IExtnIfRslt.class)) }),
            @ApiResponse(responseCode = "404", description = "IExtnIfRslt not found", content = @Content) })
    @PutMapping("/iextnifrslts/{reqId}")
    ResponseEntity<IExtnIfRslt> putData(@RequestBody IExtnIfRslt newData, @PathVariable("reqId") String reqId) {
        return repository.findById(reqId) //
                .map(oldData -> {
                    newData.setReqId(oldData.getReqId());
                    return new ResponseEntity<>(repository.save(newData), HttpStatus.OK);
                })
                .orElseGet(() -> {
                    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
                });

    }

    // @Operation(summary = "외부 인터페이스 결과(Table) 수정" , description = "외부 인터페이스 결과(Table) 데이터 수정" )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Update the IExtnIfRslt", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = IExtnIfRslt.class)) }),
            @ApiResponse(responseCode = "404", description = "IExtnIfRslt not found", content = @Content) })
	@PatchMapping("/iextnifrslts/{reqId}")
    ResponseEntity<IExtnIfRslt> patchData(@RequestBody Map<String, Object> newMap, @PathVariable("reqId") String reqId) {
        IExtnIfRslt newData = mapper.convertValue(newMap, IExtnIfRslt.class);
        return repository.findById(reqId) //
                .map(oldData -> {
                    newMap.forEach((strKey, strValue) -> {
						switch(strKey){
						    case "reqInfo" : oldData.setReqInfo(newData.getReqInfo()); break;
						    case "reqTm" : oldData.setReqTm(newData.getReqTm()); break;
						    case "rsltMsg" : oldData.setRsltMsg(newData.getRsltMsg()); break;
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
	
    // @Operation(summary = "외부 인터페이스 결과(Table) 삭제" , description = "외부 인터페이스 결과(Table) Primary Key로 삭제" )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Delete the IExtnIfRslt", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = IExtnIfRslt.class)) }),
            @ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content) })
    @DeleteMapping("/iextnifrslts/{reqId}")
    public ResponseEntity<HttpStatus> deleteUser(@PathVariable("reqId") String reqId) {
        try {
            repository.deleteById(reqId);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
