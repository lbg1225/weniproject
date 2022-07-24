/**
 * SIncidCardTrfcPol Entity 클래스
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
// import javax.persistence.Temporal;
// import javax.persistence.TemporalType;
import javax.persistence.Table;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import com.weni.ecs.domain.listener.SIncidCardTrfcPolListener;

@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED) // AccessLevel.PUBLIC
@Entity
@EntityListeners(SIncidCardTrfcPolListener.class)
@Table(name = "S_INCID_CARD_TRFC_POL") //--사건_카드_교통_경찰(Table)
@Schema(description = "사건 카드 교통 경찰(Table)")
public class SIncidCardTrfcPol implements Serializable {
    @Id //  Integer
    @Column(name = "RECPT_NUM", nullable = false)
//    @Schema(description = "", nullable = true , defaultValue = "" , example = ""  , allowableValues = {"", ""})
    @Schema(description = "접수 번호(pk)", nullable = false)
    private Integer recptNum; //--접수_번호(pk)

    @Column(name = "TRFC_POL_INCID_KND_CODE", length = 30, nullable = true)
    @Schema(description = "교통경찰 사건 종류 코드", nullable = true)
    private String trfcPolIncidKndCode; //--교통경찰_사건_종류_코드

    @Column(name = "TRFC_POL_OCR_TM", nullable = true)
    @Schema(description = "교통경찰 발생 시간", nullable = true)
    private Date trfcPolOcrTm; //--교통경찰_발생_시간

    @Column(name = "TRFC_POL_RESID_RGN_DIV_CODE", length = 30, nullable = true)
    @Schema(description = "교통경찰 주거 지역 구분 코드", nullable = true)
    private String trfcPolResidRgnDivCode; //--교통경찰_주거_지역_구분_코드

    @Column(name = "TRFC_POL_RESID_RGN_CITY", length = 100, nullable = true)
    @Schema(description = "교통경찰 주거 지역 시", nullable = true)
    private String trfcPolResidRgnCity; //--교통경찰_주거_지역_시

    @Column(name = "TRFC_POL_RESID_RGN_RGN", length = 100, nullable = true)
    @Schema(description = "교통경찰 주거 지역 지역", nullable = true)
    private String trfcPolResidRgnRgn; //--교통경찰_주거_지역_지역

    @Column(name = "TRFC_POL_RESID_RGN_NM", length = 100, nullable = true)
    @Schema(description = "교통경찰 주거 지역 명", nullable = true)
    private String trfcPolResidRgnNm; //--교통경찰_주거_지역_명

    @Column(name = "TRFC_POL_ROAD_RGN_OWN_CODE", length = 30, nullable = true)
    @Schema(description = "교통경찰 도로 지역 소유 코드", nullable = true)
    private String trfcPolRoadRgnOwnCode; //--교통경찰_도로_지역_소유_코드

    @Column(name = "TRFC_POL_ROAD_RGN_ROAD_DIV_CODE", length = 30, nullable = true)
    @Schema(description = "교통경찰 도로 지역 도로 구분 코드", nullable = true)
    private String trfcPolRoadRgnRoadDivCode; //--교통경찰_도로_지역_도로_구분_코드

    @Column(name = "TRFC_POL_ROAD_RGN_LIMITSPEED", nullable = true)
    @Schema(description = "교통경찰 도로 지역 제한속도", nullable = true)
    private Integer trfcPolRoadRgnLimitspeed; //--교통경찰_도로_지역_제한속도

    @Column(name = "TRFC_POL_PAVE_YN_CODE", length = 30, nullable = true)
    @Schema(description = "교통경찰 포장 여부 코드", nullable = true)
    private String trfcPolPaveYnCode; //--교통경찰_포장_여부_코드

    @Column(name = "TRFC_POL_ROAD_STT_CODE", length = 30, nullable = true)
    @Schema(description = "교통경찰 도로 상태 코드", nullable = true)
    private String trfcPolRoadSttCode; //--교통경찰_도로_상태_코드

    @Column(name = "TRFC_POL_LIGHT_CODE", length = 30, nullable = true)
    @Schema(description = "교통경찰 점등 코드", nullable = true)
    private String trfcPolLightCode; //--교통경찰_점등_코드

    @Column(name = "TRFC_POL_ACCDNT_OCR_LCT_CODE", length = 30, nullable = true)
    @Schema(description = "교통경찰 사고 발생 위치 코드", nullable = true)
    private String trfcPolAccdntOcrLctCode; //--교통경찰_사고_발생_위치_코드

    @Column(name = "TRFC_POL_PEDESTRN_VIOLTN_YN_CODE", length = 30, nullable = true)
    @Schema(description = "교통경찰 보행자 위반 여부 코드", nullable = true)
    private String trfcPolPedestrnVioltnYnCode; //--교통경찰_보행자_위반_여부_코드

    @Column(name = "TRFC_ACCDNT_EXP", length = 4000, nullable = true)
    @Schema(description = "교통 사고 설명", nullable = true)
    private String trfcAccdntExp; //--교통_사고_설명

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

    @Builder
    public SIncidCardTrfcPol(Integer recptNum, String trfcPolIncidKndCode, Date trfcPolOcrTm, String trfcPolResidRgnDivCode, String trfcPolResidRgnCity, String trfcPolResidRgnRgn, String trfcPolResidRgnNm, String trfcPolRoadRgnOwnCode, String trfcPolRoadRgnRoadDivCode, Integer trfcPolRoadRgnLimitspeed, String trfcPolPaveYnCode, String trfcPolRoadSttCode, String trfcPolLightCode, String trfcPolAccdntOcrLctCode, String trfcPolPedestrnVioltnYnCode, String trfcAccdntExp, String fstRegpersnId, String finalUptpersnId, Date fstRegTm, Date finalUptTm) {
        this.recptNum = recptNum;
        this.trfcPolIncidKndCode = trfcPolIncidKndCode;
        this.trfcPolOcrTm = trfcPolOcrTm;
        this.trfcPolResidRgnDivCode = trfcPolResidRgnDivCode;
        this.trfcPolResidRgnCity = trfcPolResidRgnCity;
        this.trfcPolResidRgnRgn = trfcPolResidRgnRgn;
        this.trfcPolResidRgnNm = trfcPolResidRgnNm;
        this.trfcPolRoadRgnOwnCode = trfcPolRoadRgnOwnCode;
        this.trfcPolRoadRgnRoadDivCode = trfcPolRoadRgnRoadDivCode;
        this.trfcPolRoadRgnLimitspeed = trfcPolRoadRgnLimitspeed;
        this.trfcPolPaveYnCode = trfcPolPaveYnCode;
        this.trfcPolRoadSttCode = trfcPolRoadSttCode;
        this.trfcPolLightCode = trfcPolLightCode;
        this.trfcPolAccdntOcrLctCode = trfcPolAccdntOcrLctCode;
        this.trfcPolPedestrnVioltnYnCode = trfcPolPedestrnVioltnYnCode;
        this.trfcAccdntExp = trfcAccdntExp;
        this.fstRegpersnId = fstRegpersnId;
        this.finalUptpersnId = finalUptpersnId;
        this.fstRegTm = fstRegTm;
        this.finalUptTm = finalUptTm;
    }
}
