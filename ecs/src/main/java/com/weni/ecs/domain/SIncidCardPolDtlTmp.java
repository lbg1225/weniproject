/** 
* SIncidCardPolDtlTmp Entity 클래스 

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
@Table(name="S_INCID_CARD_POL_DTL_TMP") //--PRIMARY
@Getter
@NoArgsConstructor // (access = AccessLevel.PROTECTED) // AccessLevel.PUBLIC
@EqualsAndHashCode // (of = {"email","name"}, callSuper = true, onParam = @__(@NonNull))
@ToString //(exclude = "password") // exclude 속성을 사용하면, 특정 필드를 toString() 결과에서 제외
public class SIncidCardPolDtlTmp {
    @Id //  Integer
    @Column(name = "RECPT_NUM", nullable = false)
    private Integer recptNum; //--null

    @Column(name = "DTL_DIV_CODE", length = 30, nullable = false)
    private String dtlDivCode; //--null

    @Column(name = "DTL_SEQ_NUM", nullable = false)
    private Integer dtlSeqNum; //--null

    @Column(name = "CTRY_CODE_3", length = 30, nullable = true)
    private String ctryCode3; //--null

    @Column(name = "FAM_NM", length = 100, nullable = true)
    private String famNm; //--null

    @Column(name = "GIV_NM", length = 100, nullable = true)
    private String givNm; //--null

    @Column(name = "MID_NM", length = 200, nullable = true)
    private String midNm; //--null

    @Column(name = "BIRTHYEARMMDD", nullable = true)
    private Date birthyearmmdd; //--null

    @Column(name = "TPHONE", length = 20, nullable = true)
    private String tphone; //--null

    @Column(name = "HP", length = 20, nullable = true)
    private String hp; //--null

    @Column(name = "PASS_NUM", length = 120, nullable = true)
    private String passNum; //--null

    @Column(name = "DOMPERS_FCITY", length = 100, nullable = true)
    private String dompersFcity; //--null

    @Column(name = "DOMPERS_DISTRICT", length = 100, nullable = true)
    private String dompersDistrict; //--null

    @Column(name = "DOMPERS_DIST", length = 100, nullable = true)
    private String dompersDist; //--null

    @Column(name = "DOMPERS_HS_NUM", length = 100, nullable = true)
    private String dompersHsNum; //--null

    @Column(name = "DOMPERS_APT_DISTRICT", length = 30, nullable = true)
    private String dompersAptDistrict; //--null

    @Column(name = "DOMPERS_APT_KVARTIR", length = 30, nullable = true)
    private String dompersAptKvartir; //--null

    @Column(name = "FORGNR_FCITY", length = 100, nullable = true)
    private String forgnrFcity; //--null

    @Column(name = "FORGNR_DIST", length = 100, nullable = true)
    private String forgnrDist; //--null

    @Column(name = "FORGNR_HS_NUM", length = 100, nullable = true)
    private String forgnrHsNum; //--null

    @Column(name = "FORGNR_KVARTIR", length = 30, nullable = true)
    private String forgnrKvartir; //--null

    @Column(name = "SEX_CODE", length = 30, nullable = true)
    private String sexCode; //--null

    @Column(name = "FAM_REL_CODE", length = 30, nullable = true)
    private String famRelCode; //--null

    @Column(name = "CRIM_REC", length = 150, nullable = true)
    private String crimRec; //--null

    @Column(name = "WRK_PLACE_NM", length = 200, nullable = true)
    private String wrkPlaceNm; //--null

    @Column(name = "INJURY_KND_CODE", length = 30, nullable = true)
    private String injuryKndCode; //--null

    @Column(name = "INJURY_GRD_CODE", length = 30, nullable = true)
    private String injuryGrdCode; //--null

    @Column(name = "NARCOTIC_KND_CODE", length = 30, nullable = true)
    private String narcoticKndCode; //--null

    @Column(name = "NARCOTIC_WEIGHT", nullable = true)
    private Float narcoticWeight; //--null

    @Column(name = "NARCOTIC_WEIGHT_UNIT_CODE", length = 30, nullable = true)
    private String narcoticWeightUnitCode; //--null

    @Column(name = "VIDEO_FILE_FOLD", length = 1000, nullable = true)
    private String videoFileFold; //--null

    @Column(name = "VIDEO_FILE_NM", length = 200, nullable = true)
    private String videoFileNm; //--null

    @Column(name = "HANDWR_STT", length = 1, nullable = true)
    private String handwrStt; //--null

    @Column(name = "FST_REGPERSN_ID", length = 30, nullable = true)
    private String fstRegpersnId; //--null

    @Column(name = "FINAL_UPTPERSN_ID", length = 30, nullable = true)
    private String finalUptpersnId; //--null

    @Column(name = "FST_REG_TM", nullable = true)
    private Date fstRegTm; //--null

    @Column(name = "FINAL_UPT_TM", nullable = true)
    private Date finalUptTm; //--null


    @Builder
    public SIncidCardPolDtlTmp(Integer recptNum, String dtlDivCode, Integer dtlSeqNum, String ctryCode3, String famNm, String givNm, String midNm, Date birthyearmmdd, String tphone, String hp, String passNum, String dompersFcity, String dompersDistrict, String dompersDist, String dompersHsNum, String dompersAptDistrict, String dompersAptKvartir, String forgnrFcity, String forgnrDist, String forgnrHsNum, String forgnrKvartir, String sexCode, String famRelCode, String crimRec, String wrkPlaceNm, String injuryKndCode, String injuryGrdCode, String narcoticKndCode, Float narcoticWeight, String narcoticWeightUnitCode, String videoFileFold, String videoFileNm, String handwrStt, String fstRegpersnId, String finalUptpersnId, Date fstRegTm, Date finalUptTm) {
        this.recptNum = recptNum;
        this.dtlDivCode = dtlDivCode;
        this.dtlSeqNum = dtlSeqNum;
        this.ctryCode3 = ctryCode3;
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

