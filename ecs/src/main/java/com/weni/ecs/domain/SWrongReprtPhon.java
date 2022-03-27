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
@Table(name="S_WRONG_REPRT_PHON")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED) // AccessLevel.PUBLIC
@EqualsAndHashCode // (of = {"email","name"}, callSuper = true, onParam = @__(@NonNull))
@ToString //(exclude = "password") // exclude 속성을 사용하면, 특정 필드를 toString() 결과에서 제외
public class SWrongReprtPhon implements Serializable {
    @Id //  Integer
    @Column(name = "RECPT_NUM", nullable = false)
    private Integer recptNum;

    @Column(name = "CALLER_RGNNUM", nullable = true)
    private String callerRgnnum;

    @Column(name = "CALLER_PHONNUM", nullable = true)
    private String callerPhonnum;

    @Column(name = "RECPT_REPRT_TM", nullable = true)
    private Date recptReprtTm;

    @Column(name = "WIRENLESS_DIV", nullable = true)
    private String wirenlessDiv;

    @Column(name = "RECPTPERSN_ID", nullable = true)
    private String recptpersnId;

    @Column(name = "PRCS_STT", nullable = true)
    private String prcsStt;

    @Column(name = "CALLER_FLNAME", nullable = true)
    private String callerFlname;

    @Column(name = "CALLER_PASS_NUM", nullable = true)
    private String callerPassNum;

    @Column(name = "CALLER_FCITY", nullable = true)
    private String callerFcity;

    @Column(name = "CALLER_DISTRICT", nullable = true)
    private String callerDistrict;

    @Column(name = "CALLER_DIST", nullable = true)
    private String callerDist;

    @Column(name = "CALLER_HS_NUM", nullable = true)
    private String callerHsNum;

    @Column(name = "CALLER_APT_DISTRICT", nullable = true)
    private String callerAptDistrict;

    @Column(name = "CALLER_APT_KVARTIR", nullable = true)
    private String callerAptKvartir;

    @Column(name = "CALLER_ALL_ADDR", nullable = true)
    private String callerAllAddr;

    @Column(name = "CALLER_LGT", nullable = true)
    private Double callerLgt;

    @Column(name = "CALLER_LTT", nullable = true)
    private Double callerLtt;

    @Column(name = "REPRTPERSN_FAM_NM", nullable = true)
    private String reprtpersnFamNm;

    @Column(name = "REPRTPERSN_GIV_NM", nullable = true)
    private String reprtpersnGivNm;

    @Column(name = "REPRTPERSN_MID_NM", nullable = true)
    private String reprtpersnMidNm;

    @Column(name = "REPRTPERSN_BIRTHYEARMMDD", nullable = true)
    private Date reprtpersnBirthyearmmdd;

    @Column(name = "REPRTPERSN_TPHONE", nullable = true)
    private String reprtpersnTphone;

    @Column(name = "REPRTPERSN_HP", nullable = true)
    private String reprtpersnHp;

    @Column(name = "REPRTPERSN_PASS_NUM", nullable = true)
    private String reprtpersnPassNum;

    @Column(name = "INCIDOCR_FCITY", nullable = true)
    private String incidocrFcity;

    @Column(name = "INCIDOCR_DISTRICT", nullable = true)
    private String incidocrDistrict;

    @Column(name = "INCIDOCR_DIST", nullable = true)
    private String incidocrDist;

    @Column(name = "INCIDOCR_HS_NUM", nullable = true)
    private String incidocrHsNum;

    @Column(name = "INCIDOCR_APT_DISTRICT", nullable = true)
    private String incidocrAptDistrict;

    @Column(name = "INCIDOCR_APT_KVARTIR", nullable = true)
    private String incidocrAptKvartir;

    @Column(name = "INCIDOCR_BLDG", nullable = true)
    private String incidocrBldg;

    @Column(name = "INCIDTYPE_BIGCLSSFY_CODE", nullable = true)
    private String incidtypeBigclssfyCode;

    @Column(name = "INCIDTYPE_MEDCLSSFY_CODE", nullable = true)
    private String incidtypeMedclssfyCode;

    @Column(name = "INCIDTYPE_SMALLCLSSFY_CODE", nullable = true)
    private String incidtypeSmallclssfyCode;

    @Column(name = "RELATDBUSN_FIRE_FLAG", nullable = true)
    private String relatdbusnFireFlag;

    @Column(name = "INCID_OVIEW", nullable = true)
    private String incidOview;

    @Column(name = "RELATDBUSN_POL_FLAG", nullable = true)
    private String relatdbusnPolFlag;

    @Column(name = "RELATDBUSN_TRFC_POL_FLAG", nullable = true)
    private String relatdbusnTrfcPolFlag;

    @Column(name = "REPRTPERSN_HANDWR_STT", nullable = true)
    private String reprtpersnHandwrStt;

    @Column(name = "JURIS_CODE", nullable = true)
    private String jurisCode;

    @Column(name = "RECPT_CLOSE_TM", nullable = true)
    private Date recptCloseTm;

    @Column(name = "INCIDOCR_TM", nullable = true)
    private Date incidocrTm;

    @Column(name = "FST_REGPERSN_ID", nullable = true)
    private String fstRegpersnId;

    @Column(name = "FINAL_UPTPERSN_ID", nullable = true)
    private String finalUptpersnId;

    @Column(name = "FST_REG_TM", nullable = true)
    private Date fstRegTm;

    @Column(name = "FINAL_UPT_TM", nullable = true)
    private Date finalUptTm;

    @Column(name = "INCIDOCR_LGT", nullable = true)
    private Double incidocrLgt;

    @Column(name = "INCIDOCR_LTT", nullable = true)
    private Double incidocrLtt;

    @Column(name = "REPRTPERSN_FCITY", nullable = true)
    private String reprtpersnFcity;

    @Column(name = "REPRTPERSN_DISTRICT", nullable = true)
    private String reprtpersnDistrict;

    @Column(name = "REPRTPERSN_DIST", nullable = true)
    private String reprtpersnDist;

    @Column(name = "REPRTPERSN_HS_NUM", nullable = true)
    private String reprtpersnHsNum;

    @Column(name = "REPRTPERSN_APT_DISTRICT", nullable = true)
    private String reprtpersnAptDistrict;

    @Column(name = "REPRTPERSN_APT_KVARTIR", nullable = true)
    private String reprtpersnAptKvartir;

    @Column(name = "REPRTPERSN_FORGNR_FCITY", nullable = true)
    private String reprtpersnForgnrFcity;

    @Column(name = "REPRTPERSN_FORGNR_DIST", nullable = true)
    private String reprtpersnForgnrDist;

    @Column(name = "REPRTPERSN_FORGNR_HS_NUM", nullable = true)
    private String reprtpersnForgnrHsNum;

    @Column(name = "REPRTPERSN_FORGNR_KVARTIR", nullable = true)
    private String reprtpersnForgnrKvartir;

    @Column(name = "JURIS_MNG_CODE", nullable = true)
    private String jurisMngCode;

    @Column(name = "REPRTPERSN_NAT", nullable = true)
    private String reprtpersnNat;


    @Builder
    public SWrongReprtPhon(Integer recptNum, String callerRgnnum, String callerPhonnum, Date recptReprtTm, String wirenlessDiv, String recptpersnId, String prcsStt, String callerFlname, String callerPassNum, String callerFcity, String callerDistrict, String callerDist, String callerHsNum, String callerAptDistrict, String callerAptKvartir, String callerAllAddr, Double callerLgt, Double callerLtt, String reprtpersnFamNm, String reprtpersnGivNm, String reprtpersnMidNm, Date reprtpersnBirthyearmmdd, String reprtpersnTphone, String reprtpersnHp, String reprtpersnPassNum, String incidocrFcity, String incidocrDistrict, String incidocrDist, String incidocrHsNum, String incidocrAptDistrict, String incidocrAptKvartir, String incidocrBldg, String incidtypeBigclssfyCode, String incidtypeMedclssfyCode, String incidtypeSmallclssfyCode, String relatdbusnFireFlag, String incidOview, String relatdbusnPolFlag, String relatdbusnTrfcPolFlag, String reprtpersnHandwrStt, String jurisCode, Date recptCloseTm, Date incidocrTm, String fstRegpersnId, String finalUptpersnId, Date fstRegTm, Date finalUptTm, Double incidocrLgt, Double incidocrLtt, String reprtpersnFcity, String reprtpersnDistrict, String reprtpersnDist, String reprtpersnHsNum, String reprtpersnAptDistrict, String reprtpersnAptKvartir, String reprtpersnForgnrFcity, String reprtpersnForgnrDist, String reprtpersnForgnrHsNum, String reprtpersnForgnrKvartir, String jurisMngCode, String reprtpersnNat) {
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

