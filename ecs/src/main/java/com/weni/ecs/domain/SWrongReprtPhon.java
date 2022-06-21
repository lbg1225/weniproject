/** 
* SWrongReprtPhon Entity 클래스 

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
@Table(name="S_WRONG_REPRT_PHON") //--PRIMARY
@Getter
@NoArgsConstructor // (access = AccessLevel.PROTECTED) // AccessLevel.PUBLIC
@EqualsAndHashCode // (of = {"email","name"}, callSuper = true, onParam = @__(@NonNull))
@ToString //(exclude = "password") // exclude 속성을 사용하면, 특정 필드를 toString() 결과에서 제외
public class SWrongReprtPhon {
    @Id //  Integer
    @Column(name = "RECPT_NUM", nullable = false)
    private Integer recptNum; //--null

    @Column(name = "CALLER_RGNNUM", length = 10, nullable = true)
    private String callerRgnnum; //--null

    @Column(name = "CALLER_PHONNUM", length = 20, nullable = true)
    private String callerPhonnum; //--null

    @Column(name = "RECPT_REPRT_TM", nullable = true)
    private Date recptReprtTm; //--null

    @Column(name = "WIRENLESS_DIV", length = 1, nullable = true)
    private String wirenlessDiv; //--null

    @Column(name = "RECPTPERSN_ID", length = 30, nullable = true)
    private String recptpersnId; //--null

    @Column(name = "PRCS_STT", length = 2, nullable = true)
    private String prcsStt; //--null

    @Column(name = "CALLER_FLNAME", length = 200, nullable = true)
    private String callerFlname; //--null

    @Column(name = "CALLER_PASS_NUM", length = 300, nullable = true)
    private String callerPassNum; //--null

    @Column(name = "CALLER_FCITY", length = 200, nullable = true)
    private String callerFcity; //--null

    @Column(name = "CALLER_DISTRICT", length = 100, nullable = true)
    private String callerDistrict; //--null

    @Column(name = "CALLER_DIST", length = 60, nullable = true)
    private String callerDist; //--null

    @Column(name = "CALLER_HS_NUM", length = 50, nullable = true)
    private String callerHsNum; //--null

    @Column(name = "CALLER_APT_DISTRICT", length = 20, nullable = true)
    private String callerAptDistrict; //--null

    @Column(name = "CALLER_APT_KVARTIR", length = 20, nullable = true)
    private String callerAptKvartir; //--null

    @Column(name = "CALLER_ALL_ADDR", length = 300, nullable = true)
    private String callerAllAddr; //--null

    @Column(name = "CALLER_LGT", nullable = true)
    private Float callerLgt; //--null

    @Column(name = "CALLER_LTT", nullable = true)
    private Float callerLtt; //--null

    @Column(name = "REPRTPERSN_FAM_NM", length = 100, nullable = true)
    private String reprtpersnFamNm; //--null

    @Column(name = "REPRTPERSN_GIV_NM", length = 100, nullable = true)
    private String reprtpersnGivNm; //--null

    @Column(name = "REPRTPERSN_MID_NM", length = 200, nullable = true)
    private String reprtpersnMidNm; //--null

    @Column(name = "REPRTPERSN_BIRTHYEARMMDD", nullable = true)
    private Date reprtpersnBirthyearmmdd; //--null

    @Column(name = "REPRTPERSN_TPHONE", length = 20, nullable = true)
    private String reprtpersnTphone; //--null

    @Column(name = "REPRTPERSN_HP", length = 20, nullable = true)
    private String reprtpersnHp; //--null

    @Column(name = "REPRTPERSN_PASS_NUM", length = 120, nullable = true)
    private String reprtpersnPassNum; //--null

    @Column(name = "INCIDOCR_FCITY", length = 100, nullable = true)
    private String incidocrFcity; //--null

    @Column(name = "INCIDOCR_DISTRICT", length = 100, nullable = true)
    private String incidocrDistrict; //--null

    @Column(name = "INCIDOCR_DIST", length = 100, nullable = true)
    private String incidocrDist; //--null

    @Column(name = "INCIDOCR_HS_NUM", length = 100, nullable = true)
    private String incidocrHsNum; //--null

    @Column(name = "INCIDOCR_APT_DISTRICT", length = 30, nullable = true)
    private String incidocrAptDistrict; //--null

    @Column(name = "INCIDOCR_APT_KVARTIR", length = 30, nullable = true)
    private String incidocrAptKvartir; //--null

    @Column(name = "INCIDOCR_BLDG", length = 200, nullable = true)
    private String incidocrBldg; //--null

    @Column(name = "INCIDTYPE_BIGCLSSFY_CODE", length = 30, nullable = true)
    private String incidtypeBigclssfyCode; //--null

    @Column(name = "INCIDTYPE_MEDCLSSFY_CODE", length = 30, nullable = true)
    private String incidtypeMedclssfyCode; //--null

    @Column(name = "INCIDTYPE_SMALLCLSSFY_CODE", length = 30, nullable = true)
    private String incidtypeSmallclssfyCode; //--null

    @Column(name = "RELATDBUSN_FIRE_FLAG", length = 1, nullable = true)
    private String relatdbusnFireFlag; //--null

    @Column(name = "INCID_OVIEW", length = 4000, nullable = true)
    private String incidOview; //--null

    @Column(name = "RELATDBUSN_POL_FLAG", length = 1, nullable = true)
    private String relatdbusnPolFlag; //--null

    @Column(name = "RELATDBUSN_TRFC_POL_FLAG", length = 1, nullable = true)
    private String relatdbusnTrfcPolFlag; //--null

    @Column(name = "REPRTPERSN_HANDWR_STT", length = 1, nullable = true)
    private String reprtpersnHandwrStt; //--null

    @Column(name = "JURIS_CODE", length = 20, nullable = true)
    private String jurisCode; //--null

    @Column(name = "RECPT_CLOSE_TM", nullable = true)
    private Date recptCloseTm; //--null

    @Column(name = "INCIDOCR_TM", nullable = true)
    private Date incidocrTm; //--null

    @Column(name = "FST_REGPERSN_ID", length = 30, nullable = true)
    private String fstRegpersnId; //--null

    @Column(name = "FINAL_UPTPERSN_ID", length = 30, nullable = true)
    private String finalUptpersnId; //--null

    @Column(name = "FST_REG_TM", nullable = true)
    private Date fstRegTm; //--null

    @Column(name = "FINAL_UPT_TM", nullable = true)
    private Date finalUptTm; //--null

    @Column(name = "INCIDOCR_LGT", nullable = true)
    private Float incidocrLgt; //--null

    @Column(name = "INCIDOCR_LTT", nullable = true)
    private Float incidocrLtt; //--null

    @Column(name = "REPRTPERSN_FCITY", length = 100, nullable = true)
    private String reprtpersnFcity; //--null

    @Column(name = "REPRTPERSN_DISTRICT", length = 100, nullable = true)
    private String reprtpersnDistrict; //--null

    @Column(name = "REPRTPERSN_DIST", length = 100, nullable = true)
    private String reprtpersnDist; //--null

    @Column(name = "REPRTPERSN_HS_NUM", length = 100, nullable = true)
    private String reprtpersnHsNum; //--null

    @Column(name = "REPRTPERSN_APT_DISTRICT", length = 30, nullable = true)
    private String reprtpersnAptDistrict; //--null

    @Column(name = "REPRTPERSN_APT_KVARTIR", length = 30, nullable = true)
    private String reprtpersnAptKvartir; //--null

    @Column(name = "REPRTPERSN_FORGNR_FCITY", length = 100, nullable = true)
    private String reprtpersnForgnrFcity; //--null

    @Column(name = "REPRTPERSN_FORGNR_DIST", length = 100, nullable = true)
    private String reprtpersnForgnrDist; //--null

    @Column(name = "REPRTPERSN_FORGNR_HS_NUM", length = 100, nullable = true)
    private String reprtpersnForgnrHsNum; //--null

    @Column(name = "REPRTPERSN_FORGNR_KVARTIR", length = 30, nullable = true)
    private String reprtpersnForgnrKvartir; //--null

    @Column(name = "JURIS_MNG_CODE", length = 20, nullable = true)
    private String jurisMngCode; //--null

    @Column(name = "REPRTPERSN_NAT", length = 30, nullable = true)
    private String reprtpersnNat; //--null


    @Builder
    public SWrongReprtPhon(Integer recptNum, String callerRgnnum, String callerPhonnum, Date recptReprtTm, String wirenlessDiv, String recptpersnId, String prcsStt, String callerFlname, String callerPassNum, String callerFcity, String callerDistrict, String callerDist, String callerHsNum, String callerAptDistrict, String callerAptKvartir, String callerAllAddr, Float callerLgt, Float callerLtt, String reprtpersnFamNm, String reprtpersnGivNm, String reprtpersnMidNm, Date reprtpersnBirthyearmmdd, String reprtpersnTphone, String reprtpersnHp, String reprtpersnPassNum, String incidocrFcity, String incidocrDistrict, String incidocrDist, String incidocrHsNum, String incidocrAptDistrict, String incidocrAptKvartir, String incidocrBldg, String incidtypeBigclssfyCode, String incidtypeMedclssfyCode, String incidtypeSmallclssfyCode, String relatdbusnFireFlag, String incidOview, String relatdbusnPolFlag, String relatdbusnTrfcPolFlag, String reprtpersnHandwrStt, String jurisCode, Date recptCloseTm, Date incidocrTm, String fstRegpersnId, String finalUptpersnId, Date fstRegTm, Date finalUptTm, Float incidocrLgt, Float incidocrLtt, String reprtpersnFcity, String reprtpersnDistrict, String reprtpersnDist, String reprtpersnHsNum, String reprtpersnAptDistrict, String reprtpersnAptKvartir, String reprtpersnForgnrFcity, String reprtpersnForgnrDist, String reprtpersnForgnrHsNum, String reprtpersnForgnrKvartir, String jurisMngCode, String reprtpersnNat) {
        this.recptNum = recptNum;
        this.callerRgnnum = callerRgnnum;
        this.callerPhonnum = callerPhonnum;
        this.recptReprtTm = recptReprtTm;
        this.wirenlessDiv = wirenlessDiv;
        this.recptpersnId = recptpersnId;
        this.prcsStt = prcsStt;
        this.callerFlname = callerFlname;
        this.callerPassNum = callerPassNum;
        this.callerFcity = callerFcity;
        this.callerDistrict = callerDistrict;
        this.callerDist = callerDist;
        this.callerHsNum = callerHsNum;
        this.callerAptDistrict = callerAptDistrict;
        this.callerAptKvartir = callerAptKvartir;
        this.callerAllAddr = callerAllAddr;
        this.callerLgt = callerLgt;
        this.callerLtt = callerLtt;
        this.reprtpersnFamNm = reprtpersnFamNm;
        this.reprtpersnGivNm = reprtpersnGivNm;
        this.reprtpersnMidNm = reprtpersnMidNm;
        this.reprtpersnBirthyearmmdd = reprtpersnBirthyearmmdd;
        this.reprtpersnTphone = reprtpersnTphone;
        this.reprtpersnHp = reprtpersnHp;
        this.reprtpersnPassNum = reprtpersnPassNum;
        this.incidocrFcity = incidocrFcity;
        this.incidocrDistrict = incidocrDistrict;
        this.incidocrDist = incidocrDist;
        this.incidocrHsNum = incidocrHsNum;
        this.incidocrAptDistrict = incidocrAptDistrict;
        this.incidocrAptKvartir = incidocrAptKvartir;
        this.incidocrBldg = incidocrBldg;
        this.incidtypeBigclssfyCode = incidtypeBigclssfyCode;
        this.incidtypeMedclssfyCode = incidtypeMedclssfyCode;
        this.incidtypeSmallclssfyCode = incidtypeSmallclssfyCode;
        this.relatdbusnFireFlag = relatdbusnFireFlag;
        this.incidOview = incidOview;
        this.relatdbusnPolFlag = relatdbusnPolFlag;
        this.relatdbusnTrfcPolFlag = relatdbusnTrfcPolFlag;
        this.reprtpersnHandwrStt = reprtpersnHandwrStt;
        this.jurisCode = jurisCode;
        this.recptCloseTm = recptCloseTm;
        this.incidocrTm = incidocrTm;
        this.fstRegpersnId = fstRegpersnId;
        this.finalUptpersnId = finalUptpersnId;
        this.fstRegTm = fstRegTm;
        this.finalUptTm = finalUptTm;
        this.incidocrLgt = incidocrLgt;
        this.incidocrLtt = incidocrLtt;
        this.reprtpersnFcity = reprtpersnFcity;
        this.reprtpersnDistrict = reprtpersnDistrict;
        this.reprtpersnDist = reprtpersnDist;
        this.reprtpersnHsNum = reprtpersnHsNum;
        this.reprtpersnAptDistrict = reprtpersnAptDistrict;
        this.reprtpersnAptKvartir = reprtpersnAptKvartir;
        this.reprtpersnForgnrFcity = reprtpersnForgnrFcity;
        this.reprtpersnForgnrDist = reprtpersnForgnrDist;
        this.reprtpersnForgnrHsNum = reprtpersnForgnrHsNum;
        this.reprtpersnForgnrKvartir = reprtpersnForgnrKvartir;
        this.jurisMngCode = jurisMngCode;
        this.reprtpersnNat = reprtpersnNat;
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

