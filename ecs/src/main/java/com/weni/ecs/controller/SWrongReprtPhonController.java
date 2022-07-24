/**
 * SWrongReprtPhon Entity Controller 클래스
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
import com.weni.ecs.domain.entity.SWrongReprtPhon;
import com.weni.ecs.domain.repository.SWrongReprtPhonRepository;

import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;


@RestController
@Tag(name = "SWrongReprtPhon 오 신고 전화(Table) Controller")
@Slf4j
public class SWrongReprtPhonController {

    @Autowired
    SWrongReprtPhonRepository repository;


    @Autowired
    ObjectMapper mapper;

    // @Operation(summary = "오 신고 전화(Table) 전체조회" , summary = "오 신고 전화(Table) 조회" )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the swrongreprtphons", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = SWrongReprtPhon.class)) }),
            @ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content) })
    @GetMapping("/swrongreprtphons")
    public ResponseEntity<Page<SWrongReprtPhon>> getAll(@PageableDefault Pageable pageable) {
        try {
			log.info("findAll");
            return ResponseEntity.ok().body(repository.findAll(pageable));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(null);
        }
    }

    
    // @Operation(summary = "오 신고 전화(Table) Key조회" , description = "오 신고 전화(Table) Primary Key로 조회" )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the SWrongReprtPhon", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = SWrongReprtPhon.class)) }),
            @ApiResponse(responseCode = "404", description = "SWrongReprtPhon not found", content = @Content) })
    @GetMapping("/swrongreprtphons/{recptNum}")
    public ResponseEntity<SWrongReprtPhon> getById(@PathVariable("recptNum") Integer recptNum) {
        Optional<SWrongReprtPhon> data = repository.findById(recptNum);

        if (data.isPresent()) {
            return ResponseEntity.ok().body(data.get());
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // @Operation(summary = "오 신고 전화(Table) 등록" , description = "오 신고 전화(Table) 신규 데이터 등록" )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Create the SWrongReprtPhon", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = SWrongReprtPhon.class)) }),
            @ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content) })
    @PostMapping("/swrongreprtphons")
    ResponseEntity<SWrongReprtPhon> postData(@RequestBody SWrongReprtPhon newData) {
        try {
            newData = repository.save(newData);
            return new ResponseEntity<>(newData, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // @Operation(summary = "오 신고 전화(Table) 수정" , description = "오 신고 전화(Table) 데이터 수정" )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Update the SWrongReprtPhon", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = SWrongReprtPhon.class)) }),
            @ApiResponse(responseCode = "404", description = "SWrongReprtPhon not found", content = @Content) })
    @PutMapping("/swrongreprtphons/{recptNum}")
    ResponseEntity<SWrongReprtPhon> putData(@RequestBody SWrongReprtPhon newData, @PathVariable("recptNum") Integer recptNum) {
        return repository.findById(recptNum) //
                .map(oldData -> {
                    newData.setRecptNum(oldData.getRecptNum());
                    return new ResponseEntity<>(repository.save(newData), HttpStatus.OK);
                })
                .orElseGet(() -> {
                    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
                });

    }

    // @Operation(summary = "오 신고 전화(Table) 수정" , description = "오 신고 전화(Table) 데이터 수정" )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Update the SWrongReprtPhon", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = SWrongReprtPhon.class)) }),
            @ApiResponse(responseCode = "404", description = "SWrongReprtPhon not found", content = @Content) })
	@PatchMapping("/swrongreprtphons/{recptNum}")
    ResponseEntity<SWrongReprtPhon> patchData(@RequestBody Map<String, Object> newMap, @PathVariable("recptNum") Integer recptNum) {
        SWrongReprtPhon newData = mapper.convertValue(newMap, SWrongReprtPhon.class);
        return repository.findById(recptNum) //
                .map(oldData -> {
                    newMap.forEach((strKey, strValue) -> {
						switch(strKey){
						    case "callerRgnnum" : oldData.setCallerRgnnum(newData.getCallerRgnnum()); break;
						    case "callerPhonnum" : oldData.setCallerPhonnum(newData.getCallerPhonnum()); break;
						    case "recptReprtTm" : oldData.setRecptReprtTm(newData.getRecptReprtTm()); break;
						    case "wirenlessDiv" : oldData.setWirenlessDiv(newData.getWirenlessDiv()); break;
						    case "recptpersnId" : oldData.setRecptpersnId(newData.getRecptpersnId()); break;
						    case "prcsStt" : oldData.setPrcsStt(newData.getPrcsStt()); break;
						    case "callerFlname" : oldData.setCallerFlname(newData.getCallerFlname()); break;
						    case "callerPassNum" : oldData.setCallerPassNum(newData.getCallerPassNum()); break;
						    case "callerFcity" : oldData.setCallerFcity(newData.getCallerFcity()); break;
						    case "callerDistrict" : oldData.setCallerDistrict(newData.getCallerDistrict()); break;
						    case "callerDist" : oldData.setCallerDist(newData.getCallerDist()); break;
						    case "callerHsNum" : oldData.setCallerHsNum(newData.getCallerHsNum()); break;
						    case "callerAptDistrict" : oldData.setCallerAptDistrict(newData.getCallerAptDistrict()); break;
						    case "callerAptKvartir" : oldData.setCallerAptKvartir(newData.getCallerAptKvartir()); break;
						    case "callerAllAddr" : oldData.setCallerAllAddr(newData.getCallerAllAddr()); break;
						    case "callerLgt" : oldData.setCallerLgt(newData.getCallerLgt()); break;
						    case "callerLtt" : oldData.setCallerLtt(newData.getCallerLtt()); break;
						    case "reprtpersnFamNm" : oldData.setReprtpersnFamNm(newData.getReprtpersnFamNm()); break;
						    case "reprtpersnGivNm" : oldData.setReprtpersnGivNm(newData.getReprtpersnGivNm()); break;
						    case "reprtpersnMidNm" : oldData.setReprtpersnMidNm(newData.getReprtpersnMidNm()); break;
						    case "reprtpersnBirthyearmmdd" : oldData.setReprtpersnBirthyearmmdd(newData.getReprtpersnBirthyearmmdd()); break;
						    case "reprtpersnTphone" : oldData.setReprtpersnTphone(newData.getReprtpersnTphone()); break;
						    case "reprtpersnHp" : oldData.setReprtpersnHp(newData.getReprtpersnHp()); break;
						    case "reprtpersnPassNum" : oldData.setReprtpersnPassNum(newData.getReprtpersnPassNum()); break;
						    case "incidocrFcity" : oldData.setIncidocrFcity(newData.getIncidocrFcity()); break;
						    case "incidocrDistrict" : oldData.setIncidocrDistrict(newData.getIncidocrDistrict()); break;
						    case "incidocrDist" : oldData.setIncidocrDist(newData.getIncidocrDist()); break;
						    case "incidocrHsNum" : oldData.setIncidocrHsNum(newData.getIncidocrHsNum()); break;
						    case "incidocrAptDistrict" : oldData.setIncidocrAptDistrict(newData.getIncidocrAptDistrict()); break;
						    case "incidocrAptKvartir" : oldData.setIncidocrAptKvartir(newData.getIncidocrAptKvartir()); break;
						    case "incidocrBldg" : oldData.setIncidocrBldg(newData.getIncidocrBldg()); break;
						    case "incidtypeBigclssfyCode" : oldData.setIncidtypeBigclssfyCode(newData.getIncidtypeBigclssfyCode()); break;
						    case "incidtypeMedclssfyCode" : oldData.setIncidtypeMedclssfyCode(newData.getIncidtypeMedclssfyCode()); break;
						    case "incidtypeSmallclssfyCode" : oldData.setIncidtypeSmallclssfyCode(newData.getIncidtypeSmallclssfyCode()); break;
						    case "relatdbusnFireFlag" : oldData.setRelatdbusnFireFlag(newData.getRelatdbusnFireFlag()); break;
						    case "incidOview" : oldData.setIncidOview(newData.getIncidOview()); break;
						    case "relatdbusnPolFlag" : oldData.setRelatdbusnPolFlag(newData.getRelatdbusnPolFlag()); break;
						    case "relatdbusnTrfcPolFlag" : oldData.setRelatdbusnTrfcPolFlag(newData.getRelatdbusnTrfcPolFlag()); break;
						    case "reprtpersnHandwrStt" : oldData.setReprtpersnHandwrStt(newData.getReprtpersnHandwrStt()); break;
						    case "jurisCode" : oldData.setJurisCode(newData.getJurisCode()); break;
						    case "recptCloseTm" : oldData.setRecptCloseTm(newData.getRecptCloseTm()); break;
						    case "incidocrTm" : oldData.setIncidocrTm(newData.getIncidocrTm()); break;
						    case "fstRegpersnId" : oldData.setFstRegpersnId(newData.getFstRegpersnId()); break;
						    case "finalUptpersnId" : oldData.setFinalUptpersnId(newData.getFinalUptpersnId()); break;
						    case "fstRegTm" : oldData.setFstRegTm(newData.getFstRegTm()); break;
						    case "finalUptTm" : oldData.setFinalUptTm(newData.getFinalUptTm()); break;
						    case "incidocrLgt" : oldData.setIncidocrLgt(newData.getIncidocrLgt()); break;
						    case "incidocrLtt" : oldData.setIncidocrLtt(newData.getIncidocrLtt()); break;
						    case "reprtpersnFcity" : oldData.setReprtpersnFcity(newData.getReprtpersnFcity()); break;
						    case "reprtpersnDistrict" : oldData.setReprtpersnDistrict(newData.getReprtpersnDistrict()); break;
						    case "reprtpersnDist" : oldData.setReprtpersnDist(newData.getReprtpersnDist()); break;
						    case "reprtpersnHsNum" : oldData.setReprtpersnHsNum(newData.getReprtpersnHsNum()); break;
						    case "reprtpersnAptDistrict" : oldData.setReprtpersnAptDistrict(newData.getReprtpersnAptDistrict()); break;
						    case "reprtpersnAptKvartir" : oldData.setReprtpersnAptKvartir(newData.getReprtpersnAptKvartir()); break;
						    case "reprtpersnForgnrFcity" : oldData.setReprtpersnForgnrFcity(newData.getReprtpersnForgnrFcity()); break;
						    case "reprtpersnForgnrDist" : oldData.setReprtpersnForgnrDist(newData.getReprtpersnForgnrDist()); break;
						    case "reprtpersnForgnrHsNum" : oldData.setReprtpersnForgnrHsNum(newData.getReprtpersnForgnrHsNum()); break;
						    case "reprtpersnForgnrKvartir" : oldData.setReprtpersnForgnrKvartir(newData.getReprtpersnForgnrKvartir()); break;
						    case "jurisMngCode" : oldData.setJurisMngCode(newData.getJurisMngCode()); break;
						    case "reprtpersnNat" : oldData.setReprtpersnNat(newData.getReprtpersnNat()); break;
						}
                    });
                    return new ResponseEntity<>(repository.save(oldData), HttpStatus.OK);
                })
                .orElseGet(() -> {
                    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
                });
    }
	
    // @Operation(summary = "오 신고 전화(Table) 삭제" , description = "오 신고 전화(Table) Primary Key로 삭제" )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Delete the SWrongReprtPhon", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = SWrongReprtPhon.class)) }),
            @ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content) })
    @DeleteMapping("/swrongreprtphons/{recptNum}")
    public ResponseEntity<HttpStatus> deleteUser(@PathVariable("recptNum") Integer recptNum) {
        try {
            repository.deleteById(recptNum);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
