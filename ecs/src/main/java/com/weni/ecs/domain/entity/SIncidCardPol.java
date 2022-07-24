/**
 * SIncidCardPol Entity 클래스
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

import com.weni.ecs.domain.listener.SIncidCardPolListener;

@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED) // AccessLevel.PUBLIC
@Entity
@EntityListeners(SIncidCardPolListener.class)
@Table(name = "S_INCID_CARD_POL") //--사건_카드_경찰(Table)
@Schema(description = "사건 카드 경찰(Table)")
public class SIncidCardPol implements Serializable {
    @Id //  Integer
    @Column(name = "RECPT_NUM", nullable = false)
//    @Schema(description = "", nullable = true , defaultValue = "" , example = ""  , allowableValues = {"", ""})
    @Schema(description = "접수 번호(pk)", nullable = false)
    private Integer recptNum; //--접수_번호(pk)

    @Column(name = "POL_INCIDOVIEW", length = 4000, nullable = true)
    @Schema(description = "경찰 사건개요", nullable = true)
    private String polIncidoview; //--경찰_사건개요

    @Column(name = "POL_POSS_CRIME_TRGT", length = 4000, nullable = true)
    @Schema(description = "경찰 소유물 범죄 대상", nullable = true)
    private String polPossCrimeTrgt; //--경찰_소유물_범죄_대상

    @Column(name = "POL_LOSSAMOUNT", nullable = true)
    @Schema(description = "경찰 손실금액", nullable = true)
    private Integer polLossamount; //--경찰_손실금액

    @Column(name = "POL_VALUTA_CODE", length = 30, nullable = true)
    @Schema(description = "경찰 화폐 코드", nullable = true)
    private String polValutaCode; //--경찰_화폐_코드

    @Column(name = "POL_PHYS_EVID_DESC", length = 4000, nullable = true)
    @Schema(description = "경찰 물적 증거 내역", nullable = true)
    private String polPhysEvidDesc; //--경찰_물적_증거_내역

    @Column(name = "POL_ADDITM", length = 4000, nullable = true)
    @Schema(description = "경찰 추가사항", nullable = true)
    private String polAdditm; //--경찰_추가사항

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
    public SIncidCardPol(Integer recptNum, String polIncidoview, String polPossCrimeTrgt, Integer polLossamount, String polValutaCode, String polPhysEvidDesc, String polAdditm, String fstRegpersnId, String finalUptpersnId, Date fstRegTm, Date finalUptTm) {
        this.recptNum = recptNum;
        this.polIncidoview = polIncidoview;
        this.polPossCrimeTrgt = polPossCrimeTrgt;
        this.polLossamount = polLossamount;
        this.polValutaCode = polValutaCode;
        this.polPhysEvidDesc = polPhysEvidDesc;
        this.polAdditm = polAdditm;
        this.fstRegpersnId = fstRegpersnId;
        this.finalUptpersnId = finalUptpersnId;
        this.fstRegTm = fstRegTm;
        this.finalUptTm = finalUptTm;
    }
}
