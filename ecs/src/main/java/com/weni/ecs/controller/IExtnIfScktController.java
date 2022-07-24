/**
 * IExtnIfSckt Entity Controller 클래스
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
import com.weni.ecs.domain.entity.IExtnIfSckt;
import com.weni.ecs.domain.repository.IExtnIfScktRepository;

import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;


@RestController
@Tag(name = "IExtnIfSckt 외부 인터페이스 소켓(Table) Controller")
@Slf4j
public class IExtnIfScktController {

    @Autowired
    IExtnIfScktRepository repository;


    @Autowired
    ObjectMapper mapper;

    // @Operation(summary = "외부 인터페이스 소켓(Table) 전체조회" , summary = "외부 인터페이스 소켓(Table) 조회" )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the iextnifsckts", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = IExtnIfSckt.class)) }),
            @ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content) })
    @GetMapping("/iextnifsckts")
    public ResponseEntity<Page<IExtnIfSckt>> getAll(@PageableDefault Pageable pageable) {
        try {
			log.info("findAll");
            return ResponseEntity.ok().body(repository.findAll(pageable));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(null);
        }
    }

    
    // @Operation(summary = "외부 인터페이스 소켓(Table) Key조회" , description = "외부 인터페이스 소켓(Table) Primary Key로 조회" )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the IExtnIfSckt", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = IExtnIfSckt.class)) }),
            @ApiResponse(responseCode = "404", description = "IExtnIfSckt not found", content = @Content) })
    @GetMapping("/iextnifsckts/{serNum}")
    public ResponseEntity<IExtnIfSckt> getById(@PathVariable("serNum") String serNum) {
        Optional<IExtnIfSckt> data = repository.findById(serNum);

        if (data.isPresent()) {
            return ResponseEntity.ok().body(data.get());
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // @Operation(summary = "외부 인터페이스 소켓(Table) 등록" , description = "외부 인터페이스 소켓(Table) 신규 데이터 등록" )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Create the IExtnIfSckt", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = IExtnIfSckt.class)) }),
            @ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content) })
    @PostMapping("/iextnifsckts")
    ResponseEntity<IExtnIfSckt> postData(@RequestBody IExtnIfSckt newData) {
        try {
            newData = repository.save(newData);
            return new ResponseEntity<>(newData, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // @Operation(summary = "외부 인터페이스 소켓(Table) 수정" , description = "외부 인터페이스 소켓(Table) 데이터 수정" )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Update the IExtnIfSckt", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = IExtnIfSckt.class)) }),
            @ApiResponse(responseCode = "404", description = "IExtnIfSckt not found", content = @Content) })
    @PutMapping("/iextnifsckts/{serNum}")
    ResponseEntity<IExtnIfSckt> putData(@RequestBody IExtnIfSckt newData, @PathVariable("serNum") String serNum) {
        return repository.findById(serNum) //
                .map(oldData -> {
                    newData.setSerNum(oldData.getSerNum());
                    return new ResponseEntity<>(repository.save(newData), HttpStatus.OK);
                })
                .orElseGet(() -> {
                    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
                });

    }

    // @Operation(summary = "외부 인터페이스 소켓(Table) 수정" , description = "외부 인터페이스 소켓(Table) 데이터 수정" )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Update the IExtnIfSckt", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = IExtnIfSckt.class)) }),
            @ApiResponse(responseCode = "404", description = "IExtnIfSckt not found", content = @Content) })
	@PatchMapping("/iextnifsckts/{serNum}")
    ResponseEntity<IExtnIfSckt> patchData(@RequestBody Map<String, Object> newMap, @PathVariable("serNum") String serNum) {
        IExtnIfSckt newData = mapper.convertValue(newMap, IExtnIfSckt.class);
        return repository.findById(serNum) //
                .map(oldData -> {
                    newMap.forEach((strKey, strValue) -> {
						switch(strKey){
						    case "reqId" : oldData.setReqId(newData.getReqId()); break;
						    case "proxyType" : oldData.setProxyType(newData.getProxyType()); break;
						    case "host" : oldData.setHost(newData.getHost()); break;
						    case "port" : oldData.setPort(newData.getPort()); break;
						    case "sendMsg" : oldData.setSendMsg(newData.getSendMsg()); break;
						    case "syncYn" : oldData.setSyncYn(newData.getSyncYn()); break;
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
	
    // @Operation(summary = "외부 인터페이스 소켓(Table) 삭제" , description = "외부 인터페이스 소켓(Table) Primary Key로 삭제" )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Delete the IExtnIfSckt", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = IExtnIfSckt.class)) }),
            @ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content) })
    @DeleteMapping("/iextnifsckts/{serNum}")
    public ResponseEntity<HttpStatus> deleteUser(@PathVariable("serNum") String serNum) {
        try {
            repository.deleteById(serNum);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
