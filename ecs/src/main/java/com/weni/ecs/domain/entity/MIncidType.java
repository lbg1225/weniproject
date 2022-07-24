/**
 * MIncidType Entity 클래스
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

import com.weni.ecs.domain.listener.MIncidTypeListener;

@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED) // AccessLevel.PUBLIC
@Entity
@EntityListeners(MIncidTypeListener.class)
@Table(name = "M_INCID_TYPE") //--사건_유형(Table)
@Schema(description = "사건 유형(Table)")
@IdClass(MIncidTypePK.class)
public class MIncidType implements Serializable {
    @Id //  String
    @Column(name = "INCIDTYPE_BIGCLSSFY_CODE", length = 30, nullable = false)
//    @Schema(description = "", nullable = true , defaultValue = "" , example = ""  , allowableValues = {"", ""})
    @Schema(description = "사건 유형 대분류 코드(pk)", nullable = false)
    private String incidtypeBigclssfyCode; //--사건_유형_대분류_코드(pk)

    @Id //  String
    @Column(name = "INCIDTYPE_MEDCLSSFY_CODE", length = 30, nullable = false)
    @Schema(description = "사건 유형 중분류 코드(pk)", nullable = false)
    private String incidtypeMedclssfyCode; //--사건_유형_중분류_코드(pk)

    @Id //  String
    @Column(name = "INCIDTYPE_SMALLCLSSFY_CODE", length = 30, nullable = false)
    @Schema(description = "사건 유형 소분류 코드(pk)", nullable = false)
    private String incidtypeSmallclssfyCode; //--사건_유형_소분류_코드(pk)

    @Column(name = "CLSSFY_LVL", length = 1, nullable = true)
    @Schema(description = "분류 레벨", nullable = true)
    private String clssfyLvl; //--분류_레벨

    @Column(name = "INCIDTYPE_BIGCLSSFY_NM", length = 100, nullable = true)
    @Schema(description = "사건 유형 대분류 명", nullable = true)
    private String incidtypeBigclssfyNm; //--사건_유형_대분류_명

    @Column(name = "INCIDTYPE_MEDCLSSFY_NM", length = 100, nullable = true)
    @Schema(description = "사건 유형 중분류 명", nullable = true)
    private String incidtypeMedclssfyNm; //--사건_유형_중분류_명

    @Column(name = "INCIDTYPE_SMALLCLSSFY_NM", length = 100, nullable = true)
    @Schema(description = "사건 유형 소분류 명", nullable = true)
    private String incidtypeSmallclssfyNm; //--사건_유형_소분류_명

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

    @Column(name = "INCIDTYPE_BIGCLSSFY_NM_KOR", length = 100, nullable = true)
    @Schema(description = "사건 유형 대분류 명 한국", nullable = true)
    private String incidtypeBigclssfyNmKor; //--사건_유형_대분류_명_한국

    @Column(name = "INCIDTYPE_MEDCLSSFY_NM_KOR", length = 100, nullable = true)
    @Schema(description = "사건 유형 중분류 명 한국", nullable = true)
    private String incidtypeMedclssfyNmKor; //--사건_유형_중분류_명_한국

    @Column(name = "INCIDTYPE_SMALLCLSSFY_NM_KOR", length = 100, nullable = true)
    @Schema(description = "사건 유형 소분류 명 한국", nullable = true)
    private String incidtypeSmallclssfyNmKor; //--사건_유형_소분류_명_한국

    @Column(name = "INCIDTYPE_BIGCLSSFY_NM_RUS", length = 100, nullable = true)
    @Schema(description = "사건 유형 대분류 명 러시아", nullable = true)
    private String incidtypeBigclssfyNmRus; //--사건_유형_대분류_명_러시아

    @Column(name = "INCIDTYPE_MEDCLSSFY_NM_RUS", length = 100, nullable = true)
    @Schema(description = "사건 유형 중분류 명 러시아", nullable = true)
    private String incidtypeMedclssfyNmRus; //--사건_유형_중분류_명_러시아

    @Column(name = "INCIDTYPE_SMALLCLSSFY_NM_RUS", length = 100, nullable = true)
    @Schema(description = "사건 유형 소분류 명 러시아", nullable = true)
    private String incidtypeSmallclssfyNmRus; //--사건_유형_소분류_명_러시아

    @Column(name = "INCIDTYPE_EXP", length = 4000, nullable = true)
    @Schema(description = "사건유형 설명", nullable = true)
    private String incidtypeExp; //--사건유형_설명

    @Column(name = "INCIDTYPE_BG_COLOR", length = 20, nullable = true)
    @Schema(description = "사건유형 배경 색", nullable = true)
    private String incidtypeBgColor; //--사건유형_배경_색

    @Builder
    public MIncidType(String incidtypeBigclssfyCode, String incidtypeMedclssfyCode, String incidtypeSmallclssfyCode, String clssfyLvl, String incidtypeBigclssfyNm, String incidtypeMedclssfyNm, String incidtypeSmallclssfyNm, String fstRegpersnId, String finalUptpersnId, Date fstRegTm, Date finalUptTm, String incidtypeBigclssfyNmKor, String incidtypeMedclssfyNmKor, String incidtypeSmallclssfyNmKor, String incidtypeBigclssfyNmRus, String incidtypeMedclssfyNmRus, String incidtypeSmallclssfyNmRus, String incidtypeExp, String incidtypeBgColor) {
        this.incidtypeBigclssfyCode = incidtypeBigclssfyCode;
        this.incidtypeMedclssfyCode = incidtypeMedclssfyCode;
        this.incidtypeSmallclssfyCode = incidtypeSmallclssfyCode;
        this.clssfyLvl = clssfyLvl;
        this.incidtypeBigclssfyNm = incidtypeBigclssfyNm;
        this.incidtypeMedclssfyNm = incidtypeMedclssfyNm;
        this.incidtypeSmallclssfyNm = incidtypeSmallclssfyNm;
        this.fstRegpersnId = fstRegpersnId;
        this.finalUptpersnId = finalUptpersnId;
        this.fstRegTm = fstRegTm;
        this.finalUptTm = finalUptTm;
        this.incidtypeBigclssfyNmKor = incidtypeBigclssfyNmKor;
        this.incidtypeMedclssfyNmKor = incidtypeMedclssfyNmKor;
        this.incidtypeSmallclssfyNmKor = incidtypeSmallclssfyNmKor;
        this.incidtypeBigclssfyNmRus = incidtypeBigclssfyNmRus;
        this.incidtypeMedclssfyNmRus = incidtypeMedclssfyNmRus;
        this.incidtypeSmallclssfyNmRus = incidtypeSmallclssfyNmRus;
        this.incidtypeExp = incidtypeExp;
        this.incidtypeBgColor = incidtypeBgColor;
    }
}
