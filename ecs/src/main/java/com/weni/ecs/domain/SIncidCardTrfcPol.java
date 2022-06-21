/** 
* SIncidCardTrfcPol Entity 클래스 

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
@Table(name="S_INCID_CARD_TRFC_POL") //--PRIMARY
@Getter
@NoArgsConstructor // (access = AccessLevel.PROTECTED) // AccessLevel.PUBLIC
@EqualsAndHashCode // (of = {"email","name"}, callSuper = true, onParam = @__(@NonNull))
@ToString //(exclude = "password") // exclude 속성을 사용하면, 특정 필드를 toString() 결과에서 제외
public class SIncidCardTrfcPol {
    @Id //  Integer
    @Column(name = "RECPT_NUM", nullable = false)
    private Integer recptNum; //--null

    @Column(name = "TRFC_POL_INCID_KND_CODE", length = 30, nullable = true)
    private String trfcPolIncidKndCode; //--null

    @Column(name = "TRFC_POL_OCR_TM", nullable = true)
    private Date trfcPolOcrTm; //--null

    @Column(name = "TRFC_POL_RESID_RGN_DIV_CODE", length = 30, nullable = true)
    private String trfcPolResidRgnDivCode; //--null

    @Column(name = "TRFC_POL_RESID_RGN_CITY", length = 100, nullable = true)
    private String trfcPolResidRgnCity; //--null

    @Column(name = "TRFC_POL_RESID_RGN_RGN", length = 100, nullable = true)
    private String trfcPolResidRgnRgn; //--null

    @Column(name = "TRFC_POL_RESID_RGN_NM", length = 100, nullable = true)
    private String trfcPolResidRgnNm; //--null

    @Column(name = "TRFC_POL_ROAD_RGN_OWN_CODE", length = 30, nullable = true)
    private String trfcPolRoadRgnOwnCode; //--null

    @Column(name = "TRFC_POL_ROAD_RGN_ROAD_DIV_CODE", length = 30, nullable = true)
    private String trfcPolRoadRgnRoadDivCode; //--null

    @Column(name = "TRFC_POL_ROAD_RGN_LIMITSPEED", nullable = true)
    private Integer trfcPolRoadRgnLimitspeed; //--null

    @Column(name = "TRFC_POL_PAVE_YN_CODE", length = 30, nullable = true)
    private String trfcPolPaveYnCode; //--null

    @Column(name = "TRFC_POL_ROAD_STT_CODE", length = 30, nullable = true)
    private String trfcPolRoadSttCode; //--null

    @Column(name = "TRFC_POL_LIGHT_CODE", length = 30, nullable = true)
    private String trfcPolLightCode; //--null

    @Column(name = "TRFC_POL_ACCDNT_OCR_LCT_CODE", length = 30, nullable = true)
    private String trfcPolAccdntOcrLctCode; //--null

    @Column(name = "TRFC_POL_PEDESTRN_VIOLTN_YN_CODE", length = 30, nullable = true)
    private String trfcPolPedestrnVioltnYnCode; //--null

    @Column(name = "TRFC_ACCDNT_EXP", length = 4000, nullable = true)
    private String trfcAccdntExp; //--null

    @Column(name = "FST_REGPERSN_ID", length = 30, nullable = true)
    private String fstRegpersnId; //--null

    @Column(name = "FINAL_UPTPERSN_ID", length = 30, nullable = true)
    private String finalUptpersnId; //--null

    @Column(name = "FST_REG_TM", nullable = true)
    private Date fstRegTm; //--null

    @Column(name = "FINAL_UPT_TM", nullable = true)
    private Date finalUptTm; //--null


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

