/**
 * MBldgFileInfo Entity 클래스
 *
 *  @author  Lee Byoung Gwan
 *  @version 1.0
**/
package com.weni.ecs.domain.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import java.io.Serializable;
import java.sql.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import javax.persistence.IdClass;
// import javax.persistence.Temporal;
// import javax.persistence.TemporalType;
import javax.persistence.Table;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import com.weni.ecs.domain.listener.MBldgFileInfoListener;

@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED) // AccessLevel.PUBLIC
@Entity
@EntityListeners(MBldgFileInfoListener.class)
@Table(name = "M_BLDG_FILE_INFO") //--건물_파일_정보(Table)
@Schema(description = "건물 파일 정보(Table)")
@IdClass(MBldgFileInfoPK.class)
public class MBldgFileInfo implements Serializable {
    @Column(name = "BLDG_FILE_FOLD", length = 200, nullable = false)
//    @Schema(description = "", nullable = true , defaultValue = "" , example = ""  , allowableValues = {"", ""})
    @Schema(description = "건물 파일 폴더", nullable = false)
    private String bldgFileFold; //--건물_파일_폴더

    @Column(name = "FST_REGPERSN_ID", length = 30, nullable = true)
    @Schema(description = "최초 등록자 id", nullable = true)
    private String fstRegpersnId; //--최초_등록자_id

    @Column(name = "FINAL_UPTPERSN_ID", length = 30, nullable = true)
    @Schema(description = "최종 수정자 id", nullable = true)
    private String finalUptpersnId; //--최종_수정자_id

    @Column(name = "FST_REG_TM", nullable = true)
    @Schema(description = "최초 등록 시간", nullable = true)
    private Date fstRegTm; //--최초_등록_시간

    @Column(name = "FINAL_UPT_TM", nullable = true)
    @Schema(description = "최종 수정 시간", nullable = true)
    private Date finalUptTm; //--최종_수정_시간

    @Column(name = "DTL_DIV_CODE", length = 30, nullable = false)
    @Schema(description = "건물 구분 코드", nullable = false)
    private String dtlDivCode; //--건물_구분_코드

    @Id //  Integer
    @Column(name = "DTL_SEQ_NUM", nullable = false)
    @Schema(description = "상세 순번(pk)", nullable = false)
    private Integer dtlSeqNum; //--상세_순번(pk)

    @Column(name = "BLDG_FILE_NM", length = 200, nullable = false)
    @Schema(description = "건물 파일 명", nullable = false)
    private String bldgFileNm; //--건물_파일_명

    @Column(name = "BLDG_FILE_TYPE_CODE", length = 20, nullable = true)
    @Schema(description = "건물 파일 유형 코드", nullable = true)
    private String bldgFileTypeCode; //--건물_파일_유형_코드

    @Column(name = "BLDG_FILE_FLOOR_CODE", length = 20, nullable = true)
    @Schema(description = "건물 파일 층 코드", nullable = true)
    private String bldgFileFloorCode; //--건물_파일_층_코드

    @Id //  String
    @Column(name = "BLDG_CODE", length = 24, nullable = false)
    @Schema(description = "건물 코드(pk)", nullable = false)
    private String bldgCode; //--건물_코드(pk)

    @Builder
    public MBldgFileInfo(String bldgFileFold, String fstRegpersnId, String finalUptpersnId, Date fstRegTm, Date finalUptTm, String dtlDivCode, Integer dtlSeqNum, String bldgFileNm, String bldgFileTypeCode, String bldgFileFloorCode, String bldgCode) {
        this.bldgFileFold = bldgFileFold;
        this.fstRegpersnId = fstRegpersnId;
        this.finalUptpersnId = finalUptpersnId;
        this.fstRegTm = fstRegTm;
        this.finalUptTm = finalUptTm;
        this.dtlDivCode = dtlDivCode;
        this.dtlSeqNum = dtlSeqNum;
        this.bldgFileNm = bldgFileNm;
        this.bldgFileTypeCode = bldgFileTypeCode;
        this.bldgFileFloorCode = bldgFileFloorCode;
        this.bldgCode = bldgCode;
    }
}
