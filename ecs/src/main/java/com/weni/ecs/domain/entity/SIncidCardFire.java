/**
 * SIncidCardFire Entity 클래스
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

import com.weni.ecs.domain.listener.SIncidCardFireListener;

@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED) // AccessLevel.PUBLIC
@Entity
@EntityListeners(SIncidCardFireListener.class)
@Table(name = "S_INCID_CARD_FIRE") //--사건_카드_소방(Table)
@Schema(description = "사건 카드 소방(Table)")
public class SIncidCardFire implements Serializable {
    @Id //  Integer
    @Column(name = "RECPT_NUM", nullable = false)
//    @Schema(description = "", nullable = true , defaultValue = "" , example = ""  , allowableValues = {"", ""})
    @Schema(description = "접수 번호(pk)", nullable = false)
    private Integer recptNum; //--접수_번호(pk)

    @Column(name = "FIRE_FST_DISP_TM", nullable = true)
    @Schema(description = "소방 최초 출동 시간", nullable = true)
    private Date fireFstDispTm; //--소방_최초_출동_시간

    @Column(name = "FIRE_FIELD_ARRV_TM", nullable = true)
    @Schema(description = "소방 현장 도착 시간", nullable = true)
    private Date fireFieldArrvTm; //--소방_현장_도착_시간

    @Column(name = "FIRE_SPRAY_WAT_STRT_TM", nullable = true)
    @Schema(description = "소방 방수 시작 시간", nullable = true)
    private Date fireSprayWatStrtTm; //--소방_방수_시작_시간

    @Column(name = "FIRE_AFIRE_TRGT_CODE", length = 30, nullable = true)
    @Schema(description = "소방 화재 대상 코드", nullable = true)
    private String fireAfireTrgtCode; //--소방_화재_대상_코드

    @Column(name = "FIRE_AFIRE_SPRD_RISK_FLAG", length = 1, nullable = true)
    @Schema(description = "소방 화재 확산 위험 플래그", nullable = true)
    private String fireAfireSprdRiskFlag; //--소방_화재_확산_위험_플래그

    @Column(name = "FIRE_DAMAGEPERSN_OCR_RISK_FLAG", length = 1, nullable = true)
    @Schema(description = "소방 피해자 발생 위험 플래그", nullable = true)
    private String fireDamagepersnOcrRiskFlag; //--소방_피해자_발생_위험_플래그

    @Column(name = "FIRE_BLDG_COLLAPSE_RISK_FLAG", length = 1, nullable = true)
    @Schema(description = "소방 건물 붕괴 위험 플래그", nullable = true)
    private String fireBldgCollapseRiskFlag; //--소방_건물_붕괴_위험_플래그

    @Column(name = "FIRE_ADD_REQ_FIRECAR_NUMB", nullable = true)
    @Schema(description = "소방 추가 요청 소방차 수", nullable = true)
    private Integer fireAddReqFirecarNumb; //--소방_추가_요청_소방차_수

    @Column(name = "FIRE_ADD_REQ_FFIGHTER_NUMB", nullable = true)
    @Schema(description = "소방 추가 요청 소방관 수", nullable = true)
    private Integer fireAddReqFfighterNumb; //--소방_추가_요청_소방관_수

    @Column(name = "FIRE_ADD_REQ_EQU_NUMB", nullable = true)
    @Schema(description = "소방 추가 요청 장비 수", nullable = true)
    private Integer fireAddReqEquNumb; //--소방_추가_요청_장비_수

    @Column(name = "FIRE_AFIRE_GRD_CODE", length = 30, nullable = true)
    @Schema(description = "소방 화재 등급 코드", nullable = true)
    private String fireAfireGrdCode; //--소방_화재_등급_코드

    @Column(name = "FIRE_L10N", nullable = true)
    @Schema(description = "소방 localization", nullable = true)
    private Date fireL10n; //--소방_localization

    @Column(name = "FIRE_AFIRE_CLOSE_TM", nullable = true)
    @Schema(description = "소방 화재 종료 시간", nullable = true)
    private Date fireAfireCloseTm; //--소방_화재_종료_시간

    @Column(name = "FIRE_FIRECAR_RTN_TM", nullable = true)
    @Schema(description = "소방 소방차 복귀 시간", nullable = true)
    private Date fireFirecarRtnTm; //--소방_소방차_복귀_시간

    @Column(name = "FIRE_FST_FIRECAR_NUMB", nullable = true)
    @Schema(description = "소방 최종 소방차 수", nullable = true)
    private Integer fireFstFirecarNumb; //--소방_최종_소방차_수

    @Column(name = "FIRE_AFIRE_RESN_CODE", length = 30, nullable = true)
    @Schema(description = "소방 화재 원인 코드", nullable = true)
    private String fireAfireResnCode; //--소방_화재_원인_코드

    @Column(name = "FIRE_DISP_PTCL_VEHICLE", length = 200, nullable = true)
    @Schema(description = "소방 출동 특수 차량", nullable = true)
    private String fireDispPtclVehicle; //--소방_출동_특수_차량

    @Column(name = "FIRE_CCND_AGCY_SPRT_REQ_ITM", length = 4000, nullable = true)
    @Schema(description = "소방 유관 기관 지원 요청 사항", nullable = true)
    private String fireCcndAgcySprtReqItm; //--소방_유관_기관_지원_요청_사항

    @Column(name = "FIRE_LOSS_DESC", length = 4000, nullable = true)
    @Schema(description = "소방 손실 내역", nullable = true)
    private String fireLossDesc; //--소방_손실_내역

    @Column(name = "FIRE_LOSS_AMOUNT", nullable = true)
    @Schema(description = "소방 손실 금액", nullable = true)
    private Integer fireLossAmount; //--소방_손실_금액

    @Column(name = "FIRE_THREPRT_EXCLUDE_FLAG", length = 1, nullable = true)
    @Schema(description = "소방 보고서 미포함 플래그", nullable = true)
    private String fireThreprtExcludeFlag; //--소방_보고서_미포함_플래그

    @Column(name = "FIRE_LOSS_AMOUNT_EXCLUDE_FLAG", length = 1, nullable = true)
    @Schema(description = "소방 손실 금액 미포함 플래그", nullable = true)
    private String fireLossAmountExcludeFlag; //--소방_손실_금액_미포함_플래그

    @Column(name = "FIRE_ADDITM", length = 4000, nullable = true)
    @Schema(description = "소방 추가사항", nullable = true)
    private String fireAdditm; //--소방_추가사항

    @Column(name = "BLDG_PROPRTR", length = 200, nullable = true)
    @Schema(description = "건물 소유주", nullable = true)
    private String bldgProprtr; //--건물_소유주

    @Column(name = "AFIRE_SIZE", nullable = true)
    @Schema(description = "화재 면적", nullable = true)
    private Integer afireSize; //--화재_면적

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
    public SIncidCardFire(Integer recptNum, Date fireFstDispTm, Date fireFieldArrvTm, Date fireSprayWatStrtTm, String fireAfireTrgtCode, String fireAfireSprdRiskFlag, String fireDamagepersnOcrRiskFlag, String fireBldgCollapseRiskFlag, Integer fireAddReqFirecarNumb, Integer fireAddReqFfighterNumb, Integer fireAddReqEquNumb, String fireAfireGrdCode, Date fireL10n, Date fireAfireCloseTm, Date fireFirecarRtnTm, Integer fireFstFirecarNumb, String fireAfireResnCode, String fireDispPtclVehicle, String fireCcndAgcySprtReqItm, String fireLossDesc, Integer fireLossAmount, String fireThreprtExcludeFlag, String fireLossAmountExcludeFlag, String fireAdditm, String bldgProprtr, Integer afireSize, String fstRegpersnId, String finalUptpersnId, Date fstRegTm, Date finalUptTm) {
        this.recptNum = recptNum;
        this.fireFstDispTm = fireFstDispTm;
        this.fireFieldArrvTm = fireFieldArrvTm;
        this.fireSprayWatStrtTm = fireSprayWatStrtTm;
        this.fireAfireTrgtCode = fireAfireTrgtCode;
        this.fireAfireSprdRiskFlag = fireAfireSprdRiskFlag;
        this.fireDamagepersnOcrRiskFlag = fireDamagepersnOcrRiskFlag;
        this.fireBldgCollapseRiskFlag = fireBldgCollapseRiskFlag;
        this.fireAddReqFirecarNumb = fireAddReqFirecarNumb;
        this.fireAddReqFfighterNumb = fireAddReqFfighterNumb;
        this.fireAddReqEquNumb = fireAddReqEquNumb;
        this.fireAfireGrdCode = fireAfireGrdCode;
        this.fireL10n = fireL10n;
        this.fireAfireCloseTm = fireAfireCloseTm;
        this.fireFirecarRtnTm = fireFirecarRtnTm;
        this.fireFstFirecarNumb = fireFstFirecarNumb;
        this.fireAfireResnCode = fireAfireResnCode;
        this.fireDispPtclVehicle = fireDispPtclVehicle;
        this.fireCcndAgcySprtReqItm = fireCcndAgcySprtReqItm;
        this.fireLossDesc = fireLossDesc;
        this.fireLossAmount = fireLossAmount;
        this.fireThreprtExcludeFlag = fireThreprtExcludeFlag;
        this.fireLossAmountExcludeFlag = fireLossAmountExcludeFlag;
        this.fireAdditm = fireAdditm;
        this.bldgProprtr = bldgProprtr;
        this.afireSize = afireSize;
        this.fstRegpersnId = fstRegpersnId;
        this.finalUptpersnId = finalUptpersnId;
        this.fstRegTm = fstRegTm;
        this.finalUptTm = finalUptTm;
    }
}
