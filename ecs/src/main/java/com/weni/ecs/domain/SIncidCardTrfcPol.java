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
@Table(name="S_INCID_CARD_TRFC_POL")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED) // AccessLevel.PUBLIC
@EqualsAndHashCode // (of = {"email","name"}, callSuper = true, onParam = @__(@NonNull))
@ToString //(exclude = "password") // exclude 속성을 사용하면, 특정 필드를 toString() 결과에서 제외
public class SIncidCardTrfcPol implements Serializable {
    @Id //  Integer
    @Column(name = "RECPT_NUM", nullable = false)
    private Integer recptNum;

    @Column(name = "TRFC_POL_INCID_KND_CODE", nullable = true)
    private String trfcPolIncidKndCode;

    @Column(name = "TRFC_POL_OCR_TM", nullable = true)
    private Date trfcPolOcrTm;

    @Column(name = "TRFC_POL_RESID_RGN_DIV_CODE", nullable = true)
    private String trfcPolResidRgnDivCode;

    @Column(name = "TRFC_POL_RESID_RGN_CITY", nullable = true)
    private String trfcPolResidRgnCity;

    @Column(name = "TRFC_POL_RESID_RGN_RGN", nullable = true)
    private String trfcPolResidRgnRgn;

    @Column(name = "TRFC_POL_RESID_RGN_NM", nullable = true)
    private String trfcPolResidRgnNm;

    @Column(name = "TRFC_POL_ROAD_RGN_OWN_CODE", nullable = true)
    private String trfcPolRoadRgnOwnCode;

    @Column(name = "TRFC_POL_ROAD_RGN_ROAD_DIV_CODE", nullable = true)
    private String trfcPolRoadRgnRoadDivCode;

    @Column(name = "TRFC_POL_ROAD_RGN_LIMITSPEED", nullable = true)
    private Integer trfcPolRoadRgnLimitspeed;

    @Column(name = "TRFC_POL_PAVE_YN_CODE", nullable = true)
    private String trfcPolPaveYnCode;

    @Column(name = "TRFC_POL_ROAD_STT_CODE", nullable = true)
    private String trfcPolRoadSttCode;

    @Column(name = "TRFC_POL_LIGHT_CODE", nullable = true)
    private String trfcPolLightCode;

    @Column(name = "TRFC_POL_ACCDNT_OCR_LCT_CODE", nullable = true)
    private String trfcPolAccdntOcrLctCode;

    @Column(name = "TRFC_POL_PEDESTRN_VIOLTN_YN_CODE", nullable = true)
    private String trfcPolPedestrnVioltnYnCode;

    @Column(name = "TRFC_ACCDNT_EXP", nullable = true)
    private String trfcAccdntExp;

    @Column(name = "FST_REGPERSN_ID", nullable = true)
    private String fstRegpersnId;

    @Column(name = "FINAL_UPTPERSN_ID", nullable = true)
    private String finalUptpersnId;

    @Column(name = "FST_REG_TM", nullable = true)
    private Date fstRegTm;

    @Column(name = "FINAL_UPT_TM", nullable = true)
    private Date finalUptTm;


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

