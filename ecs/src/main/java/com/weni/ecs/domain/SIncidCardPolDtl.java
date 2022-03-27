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
@Table(name="S_INCID_CARD_POL_DTL")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED) // AccessLevel.PUBLIC
@EqualsAndHashCode // (of = {"email","name"}, callSuper = true, onParam = @__(@NonNull))
@ToString //(exclude = "password") // exclude 속성을 사용하면, 특정 필드를 toString() 결과에서 제외
public class SIncidCardPolDtl implements Serializable {
    @Id //  Integer
    @Column(name = "RECPT_NUM", nullable = false)
    private Integer recptNum;

    @Column(name = "DTL_DIV_CODE", nullable = false)
    private String dtlDivCode;

    @Column(name = "DTL_SEQ_NUM", nullable = false)
    private Integer dtlSeqNum;

    @Column(name = "CTRY_CODE_3", nullable = true)
    private String ctryCode_3;

    @Column(name = "FAM_NM", nullable = true)
    private String famNm;

    @Column(name = "GIV_NM", nullable = true)
    private String givNm;

    @Column(name = "MID_NM", nullable = true)
    private String midNm;

    @Column(name = "BIRTHYEARMMDD", nullable = true)
    private Date birthyearmmdd;

    @Column(name = "TPHONE", nullable = true)
    private String tphone;

    @Column(name = "HP", nullable = true)
    private String hp;

    @Column(name = "PASS_NUM", nullable = true)
    private String passNum;

    @Column(name = "DOMPERS_FCITY", nullable = true)
    private String dompersFcity;

    @Column(name = "DOMPERS_DISTRICT", nullable = true)
    private String dompersDistrict;

    @Column(name = "DOMPERS_DIST", nullable = true)
    private String dompersDist;

    @Column(name = "DOMPERS_HS_NUM", nullable = true)
    private String dompersHsNum;

    @Column(name = "DOMPERS_APT_DISTRICT", nullable = true)
    private String dompersAptDistrict;

    @Column(name = "DOMPERS_APT_KVARTIR", nullable = true)
    private String dompersAptKvartir;

    @Column(name = "FORGNR_FCITY", nullable = true)
    private String forgnrFcity;

    @Column(name = "FORGNR_DIST", nullable = true)
    private String forgnrDist;

    @Column(name = "FORGNR_HS_NUM", nullable = true)
    private String forgnrHsNum;

    @Column(name = "FORGNR_KVARTIR", nullable = true)
    private String forgnrKvartir;

    @Column(name = "SEX_CODE", nullable = true)
    private String sexCode;

    @Column(name = "FAM_REL_CODE", nullable = true)
    private String famRelCode;

    @Column(name = "CRIM_REC", nullable = true)
    private String crimRec;

    @Column(name = "WRK_PLACE_NM", nullable = true)
    private String wrkPlaceNm;

    @Column(name = "INJURY_KND_CODE", nullable = true)
    private String injuryKndCode;

    @Column(name = "INJURY_GRD_CODE", nullable = true)
    private String injuryGrdCode;

    @Column(name = "NARCOTIC_KND_CODE", nullable = true)
    private String narcoticKndCode;

    @Column(name = "NARCOTIC_WEIGHT", nullable = true)
    private Double narcoticWeight;

    @Column(name = "NARCOTIC_WEIGHT_UNIT_CODE", nullable = true)
    private String narcoticWeightUnitCode;

    @Column(name = "VIDEO_FILE_FOLD", nullable = true)
    private String videoFileFold;

    @Column(name = "VIDEO_FILE_NM", nullable = true)
    private String videoFileNm;

    @Column(name = "HANDWR_STT", nullable = true)
    private String handwrStt;

    @Column(name = "FST_REGPERSN_ID", nullable = true)
    private String fstRegpersnId;

    @Column(name = "FINAL_UPTPERSN_ID", nullable = true)
    private String finalUptpersnId;

    @Column(name = "FST_REG_TM", nullable = true)
    private Date fstRegTm;

    @Column(name = "FINAL_UPT_TM", nullable = true)
    private Date finalUptTm;


    @Builder
    public SIncidCardPolDtl(Integer recptNum, String dtlDivCode, Integer dtlSeqNum, String ctryCode_3, String famNm, String givNm, String midNm, Date birthyearmmdd, String tphone, String hp, String passNum, String dompersFcity, String dompersDistrict, String dompersDist, String dompersHsNum, String dompersAptDistrict, String dompersAptKvartir, String forgnrFcity, String forgnrDist, String forgnrHsNum, String forgnrKvartir, String sexCode, String famRelCode, String crimRec, String wrkPlaceNm, String injuryKndCode, String injuryGrdCode, String narcoticKndCode, Double narcoticWeight, String narcoticWeightUnitCode, String videoFileFold, String videoFileNm, String handwrStt, String fstRegpersnId, String finalUptpersnId, Date fstRegTm, Date finalUptTm) {
        this.recptNum = recptNum;
        this.dtlDivCode = dtlDivCode;
        this.dtlSeqNum = dtlSeqNum;
        this.ctryCode_3 = ctryCode_3;
        this.famNm = famNm;
        this.givNm = givNm;
        this.midNm = midNm;
        this.birthyearmmdd = birthyearmmdd;
        this.tphone = tphone;
        this.hp = hp;
        this.passNum = passNum;
        this.dompersFcity = dompersFcity;
        this.dompersDistrict = dompersDistrict;
        this.dompersDist = dompersDist;
        this.dompersHsNum = dompersHsNum;
        this.dompersAptDistrict = dompersAptDistrict;
        this.dompersAptKvartir = dompersAptKvartir;
        this.forgnrFcity = forgnrFcity;
        this.forgnrDist = forgnrDist;
        this.forgnrHsNum = forgnrHsNum;
        this.forgnrKvartir = forgnrKvartir;
        this.sexCode = sexCode;
        this.famRelCode = famRelCode;
        this.crimRec = crimRec;
        this.wrkPlaceNm = wrkPlaceNm;
        this.injuryKndCode = injuryKndCode;
        this.injuryGrdCode = injuryGrdCode;
        this.narcoticKndCode = narcoticKndCode;
        this.narcoticWeight = narcoticWeight;
        this.narcoticWeightUnitCode = narcoticWeightUnitCode;
        this.videoFileFold = videoFileFold;
        this.videoFileNm = videoFileNm;
        this.handwrStt = handwrStt;
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

