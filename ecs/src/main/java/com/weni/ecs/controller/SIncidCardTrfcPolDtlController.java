/**
 * SIncidCardTrfcPolDtl Entity Controller 클래스
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
import com.weni.ecs.domain.entity.SIncidCardTrfcPolDtl;
import com.weni.ecs.domain.entity.SIncidCardTrfcPolDtlPK;
import com.weni.ecs.domain.repository.SIncidCardTrfcPolDtlRepository;

import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;


@RestController
@Tag(name = "SIncidCardTrfcPolDtl 사건 카드 교통 경찰 상세(Table) Controller")
@Slf4j
public class SIncidCardTrfcPolDtlController {

    @Autowired
    SIncidCardTrfcPolDtlRepository repository;


    @Autowired
    ObjectMapper mapper;

    // @Operation(summary = "사건 카드 교통 경찰 상세(Table) 전체조회" , summary = "사건 카드 교통 경찰 상세(Table) 조회" )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the sincidcardtrfcpoldtls", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = SIncidCardTrfcPolDtl.class)) }),
            @ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content) })
    @GetMapping("/sincidcardtrfcpoldtls")
    public ResponseEntity<Page<SIncidCardTrfcPolDtl>> getAll(@PageableDefault Pageable pageable) {
        try {
			log.info("findAll");
            return ResponseEntity.ok().body(repository.findAll(pageable));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(null);
        }
    }

    
    // @Operation(summary = "사건 카드 교통 경찰 상세(Table) Key조회" , description = "사건 카드 교통 경찰 상세(Table) Primary Key로 조회" )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the SIncidCardTrfcPolDtl", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = SIncidCardTrfcPolDtl.class)) }),
            @ApiResponse(responseCode = "404", description = "SIncidCardTrfcPolDtl not found", content = @Content) })
    @GetMapping("/sincidcardtrfcpoldtls/{recptNum}/{dtlDivCode}/{dtlSeqNum}")
    public ResponseEntity<SIncidCardTrfcPolDtl> getById(@PathVariable("recptNum") Integer recptNum, @PathVariable("dtlDivCode") String dtlDivCode, @PathVariable("dtlSeqNum") Integer dtlSeqNum) {
        Optional<SIncidCardTrfcPolDtl> data = repository.findById(new SIncidCardTrfcPolDtlPK(recptNum, dtlDivCode, dtlSeqNum));

        if (data.isPresent()) {
            return ResponseEntity.ok().body(data.get());
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // @Operation(summary = "사건 카드 교통 경찰 상세(Table) 등록" , description = "사건 카드 교통 경찰 상세(Table) 신규 데이터 등록" )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Create the SIncidCardTrfcPolDtl", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = SIncidCardTrfcPolDtl.class)) }),
            @ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content) })
    @PostMapping("/sincidcardtrfcpoldtls")
    ResponseEntity<SIncidCardTrfcPolDtl> postData(@RequestBody SIncidCardTrfcPolDtl newData) {
        try {
            newData = repository.save(newData);
            return new ResponseEntity<>(newData, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // @Operation(summary = "사건 카드 교통 경찰 상세(Table) 수정" , description = "사건 카드 교통 경찰 상세(Table) 데이터 수정" )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Update the SIncidCardTrfcPolDtl", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = SIncidCardTrfcPolDtl.class)) }),
            @ApiResponse(responseCode = "404", description = "SIncidCardTrfcPolDtl not found", content = @Content) })
    @PutMapping("/sincidcardtrfcpoldtls/{recptNum}/{dtlDivCode}/{dtlSeqNum}")
    ResponseEntity<SIncidCardTrfcPolDtl> putData(@RequestBody SIncidCardTrfcPolDtl newData, @PathVariable("recptNum") Integer recptNum, @PathVariable("dtlDivCode") String dtlDivCode, @PathVariable("dtlSeqNum") Integer dtlSeqNum) {
        return repository.findById(new SIncidCardTrfcPolDtlPK(recptNum, dtlDivCode, dtlSeqNum)) //
                .map(oldData -> {
                    newData.setRecptNum(oldData.getRecptNum());
                    newData.setDtlDivCode(oldData.getDtlDivCode());
                    newData.setDtlSeqNum(oldData.getDtlSeqNum());
                    return new ResponseEntity<>(repository.save(newData), HttpStatus.OK);
                })
                .orElseGet(() -> {
                    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
                });

    }

    // @Operation(summary = "사건 카드 교통 경찰 상세(Table) 수정" , description = "사건 카드 교통 경찰 상세(Table) 데이터 수정" )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Update the SIncidCardTrfcPolDtl", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = SIncidCardTrfcPolDtl.class)) }),
            @ApiResponse(responseCode = "404", description = "SIncidCardTrfcPolDtl not found", content = @Content) })
	@PatchMapping("/sincidcardtrfcpoldtls/{recptNum}/{dtlDivCode}/{dtlSeqNum}")
    ResponseEntity<SIncidCardTrfcPolDtl> patchData(@RequestBody Map<String, Object> newMap, @PathVariable("recptNum") Integer recptNum, @PathVariable("dtlDivCode") String dtlDivCode, @PathVariable("dtlSeqNum") Integer dtlSeqNum) {
        SIncidCardTrfcPolDtl newData = mapper.convertValue(newMap, SIncidCardTrfcPolDtl.class);
        return repository.findById(new SIncidCardTrfcPolDtlPK(recptNum, dtlDivCode, dtlSeqNum)) //
                .map(oldData -> {
                    newMap.forEach((strKey, strValue) -> {
						switch(strKey){
						    case "ctryCode3" : oldData.setCtryCode3(newData.getCtryCode3()); break;
						    case "famNm" : oldData.setFamNm(newData.getFamNm()); break;
						    case "givNm" : oldData.setGivNm(newData.getGivNm()); break;
						    case "midNm" : oldData.setMidNm(newData.getMidNm()); break;
						    case "birthyearmmdd" : oldData.setBirthyearmmdd(newData.getBirthyearmmdd()); break;
						    case "tphone" : oldData.setTphone(newData.getTphone()); break;
						    case "hp" : oldData.setHp(newData.getHp()); break;
						    case "passNum" : oldData.setPassNum(newData.getPassNum()); break;
						    case "dompersFcity" : oldData.setDompersFcity(newData.getDompersFcity()); break;
						    case "dompersDistrict" : oldData.setDompersDistrict(newData.getDompersDistrict()); break;
						    case "dompersDist" : oldData.setDompersDist(newData.getDompersDist()); break;
						    case "dompersHsNum" : oldData.setDompersHsNum(newData.getDompersHsNum()); break;
						    case "dompersAptDistrict" : oldData.setDompersAptDistrict(newData.getDompersAptDistrict()); break;
						    case "dompersAptKvartir" : oldData.setDompersAptKvartir(newData.getDompersAptKvartir()); break;
						    case "forgnrFcity" : oldData.setForgnrFcity(newData.getForgnrFcity()); break;
						    case "forgnrDist" : oldData.setForgnrDist(newData.getForgnrDist()); break;
						    case "forgnrHsNum" : oldData.setForgnrHsNum(newData.getForgnrHsNum()); break;
						    case "forgnrKvartir" : oldData.setForgnrKvartir(newData.getForgnrKvartir()); break;
						    case "sexCode" : oldData.setSexCode(newData.getSexCode()); break;
						    case "famRelCode" : oldData.setFamRelCode(newData.getFamRelCode()); break;
						    case "crimRec" : oldData.setCrimRec(newData.getCrimRec()); break;
						    case "wrkPlaceNm" : oldData.setWrkPlaceNm(newData.getWrkPlaceNm()); break;
						    case "expernce" : oldData.setExpernce(newData.getExpernce()); break;
						    case "driveTm" : oldData.setDriveTm(newData.getDriveTm()); break;
						    case "doamMemberYnFlag" : oldData.setDoamMemberYnFlag(newData.getDoamMemberYnFlag()); break;
						    case "trfcLawVioltnCode" : oldData.setTrfcLawVioltnCode(newData.getTrfcLawVioltnCode()); break;
						    case "truckConPartCode" : oldData.setTruckConPartCode(newData.getTruckConPartCode()); break;
						    case "vehicleSttCode" : oldData.setVehicleSttCode(newData.getVehicleSttCode()); break;
						    case "driveLicenseNum" : oldData.setDriveLicenseNum(newData.getDriveLicenseNum()); break;
						    case "manufMdl" : oldData.setManufMdl(newData.getManufMdl()); break;
						    case "vehicleNum" : oldData.setVehicleNum(newData.getVehicleNum()); break;
						    case "persndistrictcarRegNum" : oldData.setPersndistrictcarRegNum(newData.getPersndistrictcarRegNum()); break;
						    case "wrkPlaceAddr" : oldData.setWrkPlaceAddr(newData.getWrkPlaceAddr()); break;
						    case "ownerAddr" : oldData.setOwnerAddr(newData.getOwnerAddr()); break;
						    case "indivOwn" : oldData.setIndivOwn(newData.getIndivOwn()); break;
						    case "injuryKndCode" : oldData.setInjuryKndCode(newData.getInjuryKndCode()); break;
						    case "injuryGrdCode" : oldData.setInjuryGrdCode(newData.getInjuryGrdCode()); break;
						    case "safeApparat" : oldData.setSafeApparat(newData.getSafeApparat()); break;
						    case "evacPlace" : oldData.setEvacPlace(newData.getEvacPlace()); break;
						    case "videoFileFold" : oldData.setVideoFileFold(newData.getVideoFileFold()); break;
						    case "videoFileNm" : oldData.setVideoFileNm(newData.getVideoFileNm()); break;
						    case "trfcAccdntLeadCondCode" : oldData.setTrfcAccdntLeadCondCode(newData.getTrfcAccdntLeadCondCode()); break;
						    case "handwrStt" : oldData.setHandwrStt(newData.getHandwrStt()); break;
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
	
    // @Operation(summary = "사건 카드 교통 경찰 상세(Table) 삭제" , description = "사건 카드 교통 경찰 상세(Table) Primary Key로 삭제" )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Delete the SIncidCardTrfcPolDtl", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = SIncidCardTrfcPolDtl.class)) }),
            @ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content) })
    @DeleteMapping("/sincidcardtrfcpoldtls/{recptNum}/{dtlDivCode}/{dtlSeqNum}")
    public ResponseEntity<HttpStatus> deleteUser(@PathVariable("recptNum") Integer recptNum, @PathVariable("dtlDivCode") String dtlDivCode, @PathVariable("dtlSeqNum") Integer dtlSeqNum) {
        try {
            repository.deleteById(new SIncidCardTrfcPolDtlPK(recptNum, dtlDivCode, dtlSeqNum));
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
