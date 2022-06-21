/** 
* SIncidCardFire Entity 클래스 

* @author  Lee Byoung Gwan
* @version 1.0 
*/
package com.weni.ecs.domain;
import java.sql.Date;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.PostLoad;
import javax.persistence.PrePersist;
import javax.persistence.PostPersist;
import javax.persistence.PreUpdate;
import javax.persistence.PostUpdate;
import javax.persistence.PreRemove;
import javax.persistence.PostRemove;
// import org.springframework.beans.BeanUtils;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.Builder;

@Entity
@Table(name="S_INCID_CARD_FIRE") //--PRIMARY
@Getter
@NoArgsConstructor // (access = AccessLevel.PROTECTED) // AccessLevel.PUBLIC
@EqualsAndHashCode // (of = {"email","name"}, callSuper = true, onParam = @__(@NonNull))
@ToString //(exclude = "password") // exclude 속성을 사용하면, 특정 필드를 toString() 결과에서 제외
public class SIncidCardFire {
    @Id //  Integer
    @Column(name = "RECPT_NUM", nullable = false)
    private Integer recptNum; //--null

    @Column(name = "FIRE_FST_DISP_TM", nullable = true)
    private Date fireFstDispTm; //--null

    @Column(name = "FIRE_FIELD_ARRV_TM", nullable = true)
    private Date fireFieldArrvTm; //--null

    @Column(name = "FIRE_SPRAY_WAT_STRT_TM", nullable = true)
    private Date fireSprayWatStrtTm; //--null

    @Column(name = "FIRE_AFIRE_TRGT_CODE", length = 30, nullable = true)
    private String fireAfireTrgtCode; //--null

    @Column(name = "FIRE_AFIRE_SPRD_RISK_FLAG", length = 1, nullable = true)
    private String fireAfireSprdRiskFlag; //--null

    @Column(name = "FIRE_DAMAGEPERSN_OCR_RISK_FLAG", length = 1, nullable = true)
    private String fireDamagepersnOcrRiskFlag; //--null

    @Column(name = "FIRE_BLDG_COLLAPSE_RISK_FLAG", length = 1, nullable = true)
    private String fireBldgCollapseRiskFlag; //--null

    @Column(name = "FIRE_ADD_REQ_FIRECAR_NUMB", nullable = true)
    private Integer fireAddReqFirecarNumb; //--null

    @Column(name = "FIRE_ADD_REQ_FFIGHTER_NUMB", nullable = true)
    private Integer fireAddReqFfighterNumb; //--null

    @Column(name = "FIRE_ADD_REQ_EQU_NUMB", nullable = true)
    private Integer fireAddReqEquNumb; //--null

    @Column(name = "FIRE_AFIRE_GRD_CODE", length = 30, nullable = true)
    private String fireAfireGrdCode; //--null

    @Column(name = "FIRE_L10N", nullable = true)
    private Date fireL10n; //--null

    @Column(name = "FIRE_AFIRE_CLOSE_TM", nullable = true)
    private Date fireAfireCloseTm; //--null

    @Column(name = "FIRE_FIRECAR_RTN_TM", nullable = true)
    private Date fireFirecarRtnTm; //--null

    @Column(name = "FIRE_FST_FIRECAR_NUMB", nullable = true)
    private Integer fireFstFirecarNumb; //--null

    @Column(name = "FIRE_AFIRE_RESN_CODE", length = 30, nullable = true)
    private String fireAfireResnCode; //--null

    @Column(name = "FIRE_DISP_PTCL_VEHICLE", length = 200, nullable = true)
    private String fireDispPtclVehicle; //--null

    @Column(name = "FIRE_CCND_AGCY_SPRT_REQ_ITM", length = 4000, nullable = true)
    private String fireCcndAgcySprtReqItm; //--null

    @Column(name = "FIRE_LOSS_DESC", length = 4000, nullable = true)
    private String fireLossDesc; //--null

    @Column(name = "FIRE_LOSS_AMOUNT", nullable = true)
    private Integer fireLossAmount; //--null

    @Column(name = "FIRE_THREPRT_EXCLUDE_FLAG", length = 1, nullable = true)
    private String fireThreprtExcludeFlag; //--null

    @Column(name = "FIRE_LOSS_AMOUNT_EXCLUDE_FLAG", length = 1, nullable = true)
    private String fireLossAmountExcludeFlag; //--null

    @Column(name = "FIRE_ADDITM", length = 4000, nullable = true)
    private String fireAdditm; //--null

    @Column(name = "BLDG_PROPRTR", length = 200, nullable = true)
    private String bldgProprtr; //--null

    @Column(name = "AFIRE_SIZE", nullable = true)
    private Integer afireSize; //--null

    @Column(name = "FST_REGPERSN_ID", length = 30, nullable = true)
    private String fstRegpersnId; //--null

    @Column(name = "FINAL_UPTPERSN_ID", length = 30, nullable = true)
    private String finalUptpersnId; //--null

    @Column(name = "FST_REG_TM", nullable = true)
    private Date fstRegTm; //--null

    @Column(name = "FINAL_UPT_TM", nullable = true)
    private Date finalUptTm; //--null


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

    //----------------------------------------------------
    // Load/Persist/Update/Remove(조회/신규/수정/삭제)
    // Entity Pre/Post(이전/이후) 처리에 대한 정의(PreLoad는 없음)
    // * DB의 Trigger와 비슷한 JPA기능
    //----------------------------------------------------
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

