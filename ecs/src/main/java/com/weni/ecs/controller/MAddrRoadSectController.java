/**
 * MAddrRoadSect Entity Controller 클래스
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
import com.weni.ecs.domain.entity.MAddrRoadSect;
import com.weni.ecs.domain.repository.MAddrRoadSectRepository;

import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;


@RestController
@Tag(name = "MAddrRoadSect 주소 도로 구간(Table) Controller")
@Slf4j
public class MAddrRoadSectController {

    @Autowired
    MAddrRoadSectRepository repository;


    @Autowired
    ObjectMapper mapper;

    // @Operation(summary = "주소 도로 구간(Table) 전체조회" , summary = "주소 도로 구간(Table) 조회" )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the maddrroadsects", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = MAddrRoadSect.class)) }),
            @ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content) })
    @GetMapping("/maddrroadsects")
    public ResponseEntity<Page<MAddrRoadSect>> getAll(@PageableDefault Pageable pageable) {
        try {
			log.info("findAll");
            return ResponseEntity.ok().body(repository.findAll(pageable));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(null);
        }
    }

    
    // @Operation(summary = "주소 도로 구간(Table) Key조회" , description = "주소 도로 구간(Table) Primary Key로 조회" )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the MAddrRoadSect", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = MAddrRoadSect.class)) }),
            @ApiResponse(responseCode = "404", description = "MAddrRoadSect not found", content = @Content) })
    @GetMapping("/maddrroadsects/{roadSectCode}")
    public ResponseEntity<MAddrRoadSect> getById(@PathVariable("roadSectCode") String roadSectCode) {
        Optional<MAddrRoadSect> data = repository.findById(roadSectCode);

        if (data.isPresent()) {
            return ResponseEntity.ok().body(data.get());
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // @Operation(summary = "주소 도로 구간(Table) 등록" , description = "주소 도로 구간(Table) 신규 데이터 등록" )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Create the MAddrRoadSect", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = MAddrRoadSect.class)) }),
            @ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content) })
    @PostMapping("/maddrroadsects")
    ResponseEntity<MAddrRoadSect> postData(@RequestBody MAddrRoadSect newData) {
        try {
            newData = repository.save(newData);
            return new ResponseEntity<>(newData, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // @Operation(summary = "주소 도로 구간(Table) 수정" , description = "주소 도로 구간(Table) 데이터 수정" )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Update the MAddrRoadSect", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = MAddrRoadSect.class)) }),
            @ApiResponse(responseCode = "404", description = "MAddrRoadSect not found", content = @Content) })
    @PutMapping("/maddrroadsects/{roadSectCode}")
    ResponseEntity<MAddrRoadSect> putData(@RequestBody MAddrRoadSect newData, @PathVariable("roadSectCode") String roadSectCode) {
        return repository.findById(roadSectCode) //
                .map(oldData -> {
                    newData.setRoadSectCode(oldData.getRoadSectCode());
                    return new ResponseEntity<>(repository.save(newData), HttpStatus.OK);
                })
                .orElseGet(() -> {
                    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
                });

    }

    // @Operation(summary = "주소 도로 구간(Table) 수정" , description = "주소 도로 구간(Table) 데이터 수정" )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Update the MAddrRoadSect", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = MAddrRoadSect.class)) }),
            @ApiResponse(responseCode = "404", description = "MAddrRoadSect not found", content = @Content) })
	@PatchMapping("/maddrroadsects/{roadSectCode}")
    ResponseEntity<MAddrRoadSect> patchData(@RequestBody Map<String, Object> newMap, @PathVariable("roadSectCode") String roadSectCode) {
        MAddrRoadSect newData = mapper.convertValue(newMap, MAddrRoadSect.class);
        return repository.findById(roadSectCode) //
                .map(oldData -> {
                    newMap.forEach((strKey, strValue) -> {
						switch(strKey){
						    case "roadSectNm" : oldData.setRoadSectNm(newData.getRoadSectNm()); break;
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
	
    // @Operation(summary = "주소 도로 구간(Table) 삭제" , description = "주소 도로 구간(Table) Primary Key로 삭제" )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Delete the MAddrRoadSect", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = MAddrRoadSect.class)) }),
            @ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content) })
    @DeleteMapping("/maddrroadsects/{roadSectCode}")
    public ResponseEntity<HttpStatus> deleteUser(@PathVariable("roadSectCode") String roadSectCode) {
        try {
            repository.deleteById(roadSectCode);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
