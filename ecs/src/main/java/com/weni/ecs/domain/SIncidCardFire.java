package com.weni.ecs.domain;
import java.sql.Date;
import java.io.Serializable;
import javax.persistence.*;
// import org.springframework.beans.BeanUtils;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.Builder;

@Entity
@Table(name="S_INCID_CARD_FIRE")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED) // AccessLevel.PUBLIC
@EqualsAndHashCode // (of = {"email","name"}, callSuper = true, onParam = @__(@NonNull))
@ToString //(exclude = "password") // exclude 속성을 사용하면, 특정 필드를 toString() 결과에서 제외
public class SIncidCardFire implements Serializable {
    @Id //  Integer
    @Column(name = "RECPT_NUM", nullable = false)
    private Integer recptNum;

    @Column(name = "FIRE_FST_DISP_TM", nullable = true)
    private Date fireFstDispTm;

    @Column(name = "FIRE_FIELD_ARRV_TM", nullable = true)
    private Date fireFieldArrvTm;

    @Column(name = "FIRE_SPRAY_WAT_STRT_TM", nullable = true)
    private Date fireSprayWatStrtTm;

    @Column(name = "FIRE_AFIRE_TRGT_CODE", nullable = true)
    private String fireAfireTrgtCode;

    @Column(name = "FIRE_AFIRE_SPRD_RISK_FLAG", nullable = true)
    private String fireAfireSprdRiskFlag;

    @Column(name = "FIRE_DAMAGEPERSN_OCR_RISK_FLAG", nullable = true)
    private String fireDamagepersnOcrRiskFlag;

    @Column(name = "FIRE_BLDG_COLLAPSE_RISK_FLAG", nullable = true)
    private String fireBldgCollapseRiskFlag;

    @Column(name = "FIRE_ADD_REQ_FIRECAR_NUMB", nullable = true)
    private Integer fireAddReqFirecarNumb;

    @Column(name = "FIRE_ADD_REQ_FFIGHTER_NUMB", nullable = true)
    private Integer fireAddReqFfighterNumb;

    @Column(name = "FIRE_ADD_REQ_EQU_NUMB", nullable = true)
    private Integer fireAddReqEquNumb;

    @Column(name = "FIRE_AFIRE_GRD_CODE", nullable = true)
    private String fireAfireGrdCode;

    @Column(name = "FIRE_L10N", nullable = true)
    private Date fireL10n;

    @Column(name = "FIRE_AFIRE_CLOSE_TM", nullable = true)
    private Date fireAfireCloseTm;

    @Column(name = "FIRE_FIRECAR_RTN_TM", nullable = true)
    private Date fireFirecarRtnTm;

    @Column(name = "FIRE_FST_FIRECAR_NUMB", nullable = true)
    private Integer fireFstFirecarNumb;

    @Column(name = "FIRE_AFIRE_RESN_CODE", nullable = true)
    private String fireAfireResnCode;

    @Column(name = "FIRE_DISP_PTCL_VEHICLE", nullable = true)
    private String fireDispPtclVehicle;

    @Column(name = "FIRE_CCND_AGCY_SPRT_REQ_ITM", nullable = true)
    private String fireCcndAgcySprtReqItm;

    @Column(name = "FIRE_LOSS_DESC", nullable = true)
    private String fireLossDesc;

    @Column(name = "FIRE_LOSS_AMOUNT", nullable = true)
    private Integer fireLossAmount;

    @Column(name = "FIRE_THREPRT_EXCLUDE_FLAG", nullable = true)
    private String fireThreprtExcludeFlag;

    @Column(name = "FIRE_LOSS_AMOUNT_EXCLUDE_FLAG", nullable = true)
    private String fireLossAmountExcludeFlag;

    @Column(name = "FIRE_ADDITM", nullable = true)
    private String fireAdditm;

    @Column(name = "BLDG_PROPRTR", nullable = true)
    private String bldgProprtr;

    @Column(name = "AFIRE_SIZE", nullable = true)
    private Integer afireSize;

    @Column(name = "FST_REGPERSN_ID", nullable = true)
    private String fstRegpersnId;

    @Column(name = "FINAL_UPTPERSN_ID", nullable = true)
    private String finalUptpersnId;

    @Column(name = "FST_REG_TM", nullable = true)
    private Date fstRegTm;

    @Column(name = "FINAL_UPT_TM", nullable = true)
    private Date finalUptTm;


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

    @PostLoad
    public void onPostLoad() {

    }

    @PrePersist
    public void onPrePersist() {

    }

    @PostPersist
    public void onPostPersist() {

    }

    @PreUpdate
    public void onPreUpdate() {

    }

    @PostUpdate
    public void onPostUpdate() {

    }

    @PreRemove
    public void onPreRemove() {

    }

    @PostRemove
    public void onPostRemove() {

    }
}

