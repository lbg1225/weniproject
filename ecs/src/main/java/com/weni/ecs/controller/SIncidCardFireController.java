/**
 * SIncidCardFire Entity Controller 클래스
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
import com.weni.ecs.domain.entity.SIncidCardFire;
import com.weni.ecs.domain.repository.SIncidCardFireRepository;

import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;


@RestController
@Tag(name = "SIncidCardFire 사건 카드 소방(Table) Controller")
@Slf4j
public class SIncidCardFireController {

    @Autowired
    SIncidCardFireRepository repository;


    @Autowired
    ObjectMapper mapper;

    // @Operation(summary = "사건 카드 소방(Table) 전체조회" , summary = "사건 카드 소방(Table) 조회" )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the sincidcardfires", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = SIncidCardFire.class)) }),
            @ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content) })
    @GetMapping("/sincidcardfires")
    public ResponseEntity<Page<SIncidCardFire>> getAll(@PageableDefault Pageable pageable) {
        try {
			log.info("findAll");
            return ResponseEntity.ok().body(repository.findAll(pageable));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(null);
        }
    }

    
    // @Operation(summary = "사건 카드 소방(Table) Key조회" , description = "사건 카드 소방(Table) Primary Key로 조회" )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the SIncidCardFire", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = SIncidCardFire.class)) }),
            @ApiResponse(responseCode = "404", description = "SIncidCardFire not found", content = @Content) })
    @GetMapping("/sincidcardfires/{recptNum}")
    public ResponseEntity<SIncidCardFire> getById(@PathVariable("recptNum") Integer recptNum) {
        Optional<SIncidCardFire> data = repository.findById(recptNum);

        if (data.isPresent()) {
            return ResponseEntity.ok().body(data.get());
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // @Operation(summary = "사건 카드 소방(Table) 등록" , description = "사건 카드 소방(Table) 신규 데이터 등록" )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Create the SIncidCardFire", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = SIncidCardFire.class)) }),
            @ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content) })
    @PostMapping("/sincidcardfires")
    ResponseEntity<SIncidCardFire> postData(@RequestBody SIncidCardFire newData) {
        try {
            newData = repository.save(newData);
            return new ResponseEntity<>(newData, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // @Operation(summary = "사건 카드 소방(Table) 수정" , description = "사건 카드 소방(Table) 데이터 수정" )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Update the SIncidCardFire", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = SIncidCardFire.class)) }),
            @ApiResponse(responseCode = "404", description = "SIncidCardFire not found", content = @Content) })
    @PutMapping("/sincidcardfires/{recptNum}")
    ResponseEntity<SIncidCardFire> putData(@RequestBody SIncidCardFire newData, @PathVariable("recptNum") Integer recptNum) {
        return repository.findById(recptNum) //
                .map(oldData -> {
                    newData.setRecptNum(oldData.getRecptNum());
                    return new ResponseEntity<>(repository.save(newData), HttpStatus.OK);
                })
                .orElseGet(() -> {
                    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
                });

    }

    // @Operation(summary = "사건 카드 소방(Table) 수정" , description = "사건 카드 소방(Table) 데이터 수정" )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Update the SIncidCardFire", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = SIncidCardFire.class)) }),
            @ApiResponse(responseCode = "404", description = "SIncidCardFire not found", content = @Content) })
	@PatchMapping("/sincidcardfires/{recptNum}")
    ResponseEntity<SIncidCardFire> patchData(@RequestBody Map<String, Object> newMap, @PathVariable("recptNum") Integer recptNum) {
        SIncidCardFire newData = mapper.convertValue(newMap, SIncidCardFire.class);
        return repository.findById(recptNum) //
                .map(oldData -> {
                    newMap.forEach((strKey, strValue) -> {
						switch(strKey){
						    case "fireFstDispTm" : oldData.setFireFstDispTm(newData.getFireFstDispTm()); break;
						    case "fireFieldArrvTm" : oldData.setFireFieldArrvTm(newData.getFireFieldArrvTm()); break;
						    case "fireSprayWatStrtTm" : oldData.setFireSprayWatStrtTm(newData.getFireSprayWatStrtTm()); break;
						    case "fireAfireTrgtCode" : oldData.setFireAfireTrgtCode(newData.getFireAfireTrgtCode()); break;
						    case "fireAfireSprdRiskFlag" : oldData.setFireAfireSprdRiskFlag(newData.getFireAfireSprdRiskFlag()); break;
						    case "fireDamagepersnOcrRiskFlag" : oldData.setFireDamagepersnOcrRiskFlag(newData.getFireDamagepersnOcrRiskFlag()); break;
						    case "fireBldgCollapseRiskFlag" : oldData.setFireBldgCollapseRiskFlag(newData.getFireBldgCollapseRiskFlag()); break;
						    case "fireAddReqFirecarNumb" : oldData.setFireAddReqFirecarNumb(newData.getFireAddReqFirecarNumb()); break;
						    case "fireAddReqFfighterNumb" : oldData.setFireAddReqFfighterNumb(newData.getFireAddReqFfighterNumb()); break;
						    case "fireAddReqEquNumb" : oldData.setFireAddReqEquNumb(newData.getFireAddReqEquNumb()); break;
						    case "fireAfireGrdCode" : oldData.setFireAfireGrdCode(newData.getFireAfireGrdCode()); break;
						    case "fireL10n" : oldData.setFireL10n(newData.getFireL10n()); break;
						    case "fireAfireCloseTm" : oldData.setFireAfireCloseTm(newData.getFireAfireCloseTm()); break;
						    case "fireFirecarRtnTm" : oldData.setFireFirecarRtnTm(newData.getFireFirecarRtnTm()); break;
						    case "fireFstFirecarNumb" : oldData.setFireFstFirecarNumb(newData.getFireFstFirecarNumb()); break;
						    case "fireAfireResnCode" : oldData.setFireAfireResnCode(newData.getFireAfireResnCode()); break;
						    case "fireDispPtclVehicle" : oldData.setFireDispPtclVehicle(newData.getFireDispPtclVehicle()); break;
						    case "fireCcndAgcySprtReqItm" : oldData.setFireCcndAgcySprtReqItm(newData.getFireCcndAgcySprtReqItm()); break;
						    case "fireLossDesc" : oldData.setFireLossDesc(newData.getFireLossDesc()); break;
						    case "fireLossAmount" : oldData.setFireLossAmount(newData.getFireLossAmount()); break;
						    case "fireThreprtExcludeFlag" : oldData.setFireThreprtExcludeFlag(newData.getFireThreprtExcludeFlag()); break;
						    case "fireLossAmountExcludeFlag" : oldData.setFireLossAmountExcludeFlag(newData.getFireLossAmountExcludeFlag()); break;
						    case "fireAdditm" : oldData.setFireAdditm(newData.getFireAdditm()); break;
						    case "bldgProprtr" : oldData.setBldgProprtr(newData.getBldgProprtr()); break;
						    case "afireSize" : oldData.setAfireSize(newData.getAfireSize()); break;
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
	
    // @Operation(summary = "사건 카드 소방(Table) 삭제" , description = "사건 카드 소방(Table) Primary Key로 삭제" )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Delete the SIncidCardFire", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = SIncidCardFire.class)) }),
            @ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content) })
    @DeleteMapping("/sincidcardfires/{recptNum}")
    public ResponseEntity<HttpStatus> deleteUser(@PathVariable("recptNum") Integer recptNum) {
        try {
            repository.deleteById(recptNum);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
