/**
 * SIncidCardPol Entity Controller 클래스
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
import com.weni.ecs.domain.entity.SIncidCardPol;
import com.weni.ecs.domain.repository.SIncidCardPolRepository;

import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;


@RestController
@Tag(name = "SIncidCardPol 사건 카드 경찰(Table) Controller")
@Slf4j
public class SIncidCardPolController {

    @Autowired
    SIncidCardPolRepository repository;


    @Autowired
    ObjectMapper mapper;

    // @Operation(summary = "사건 카드 경찰(Table) 전체조회" , summary = "사건 카드 경찰(Table) 조회" )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the sincidcardpols", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = SIncidCardPol.class)) }),
            @ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content) })
    @GetMapping("/sincidcardpols")
    public ResponseEntity<Page<SIncidCardPol>> getAll(@PageableDefault Pageable pageable) {
        try {
			log.info("findAll");
            return ResponseEntity.ok().body(repository.findAll(pageable));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(null);
        }
    }

    
    // @Operation(summary = "사건 카드 경찰(Table) Key조회" , description = "사건 카드 경찰(Table) Primary Key로 조회" )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the SIncidCardPol", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = SIncidCardPol.class)) }),
            @ApiResponse(responseCode = "404", description = "SIncidCardPol not found", content = @Content) })
    @GetMapping("/sincidcardpols/{recptNum}")
    public ResponseEntity<SIncidCardPol> getById(@PathVariable("recptNum") Integer recptNum) {
        Optional<SIncidCardPol> data = repository.findById(recptNum);

        if (data.isPresent()) {
            return ResponseEntity.ok().body(data.get());
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // @Operation(summary = "사건 카드 경찰(Table) 등록" , description = "사건 카드 경찰(Table) 신규 데이터 등록" )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Create the SIncidCardPol", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = SIncidCardPol.class)) }),
            @ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content) })
    @PostMapping("/sincidcardpols")
    ResponseEntity<SIncidCardPol> postData(@RequestBody SIncidCardPol newData) {
        try {
            newData = repository.save(newData);
            return new ResponseEntity<>(newData, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // @Operation(summary = "사건 카드 경찰(Table) 수정" , description = "사건 카드 경찰(Table) 데이터 수정" )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Update the SIncidCardPol", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = SIncidCardPol.class)) }),
            @ApiResponse(responseCode = "404", description = "SIncidCardPol not found", content = @Content) })
    @PutMapping("/sincidcardpols/{recptNum}")
    ResponseEntity<SIncidCardPol> putData(@RequestBody SIncidCardPol newData, @PathVariable("recptNum") Integer recptNum) {
        return repository.findById(recptNum) //
                .map(oldData -> {
                    newData.setRecptNum(oldData.getRecptNum());
                    return new ResponseEntity<>(repository.save(newData), HttpStatus.OK);
                })
                .orElseGet(() -> {
                    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
                });

    }

    // @Operation(summary = "사건 카드 경찰(Table) 수정" , description = "사건 카드 경찰(Table) 데이터 수정" )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Update the SIncidCardPol", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = SIncidCardPol.class)) }),
            @ApiResponse(responseCode = "404", description = "SIncidCardPol not found", content = @Content) })
	@PatchMapping("/sincidcardpols/{recptNum}")
    ResponseEntity<SIncidCardPol> patchData(@RequestBody Map<String, Object> newMap, @PathVariable("recptNum") Integer recptNum) {
        SIncidCardPol newData = mapper.convertValue(newMap, SIncidCardPol.class);
        return repository.findById(recptNum) //
                .map(oldData -> {
                    newMap.forEach((strKey, strValue) -> {
						switch(strKey){
						    case "polIncidoview" : oldData.setPolIncidoview(newData.getPolIncidoview()); break;
						    case "polPossCrimeTrgt" : oldData.setPolPossCrimeTrgt(newData.getPolPossCrimeTrgt()); break;
						    case "polLossamount" : oldData.setPolLossamount(newData.getPolLossamount()); break;
						    case "polValutaCode" : oldData.setPolValutaCode(newData.getPolValutaCode()); break;
						    case "polPhysEvidDesc" : oldData.setPolPhysEvidDesc(newData.getPolPhysEvidDesc()); break;
						    case "polAdditm" : oldData.setPolAdditm(newData.getPolAdditm()); break;
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
	
    // @Operation(summary = "사건 카드 경찰(Table) 삭제" , description = "사건 카드 경찰(Table) Primary Key로 삭제" )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Delete the SIncidCardPol", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = SIncidCardPol.class)) }),
            @ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content) })
    @DeleteMapping("/sincidcardpols/{recptNum}")
    public ResponseEntity<HttpStatus> deleteUser(@PathVariable("recptNum") Integer recptNum) {
        try {
            repository.deleteById(recptNum);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
