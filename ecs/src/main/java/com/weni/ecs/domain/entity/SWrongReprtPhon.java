/**
 * SWrongReprtPhon Entity 클래스
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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
// import javax.persistence.Temporal;
// import javax.persistence.TemporalType;
import javax.persistence.Table;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import com.weni.ecs.domain.listener.SWrongReprtPhonListener;

@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED) // AccessLevel.PUBLIC
@Entity
@EntityListeners(SWrongReprtPhonListener.class)
@Table(name = "S_WRONG_REPRT_PHON") //--오_신고_전화(Table)
@Schema(description = "오 신고 전화(Table)")
public class SWrongReprtPhon implements Serializable {
    @Id //  Integer
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "RECPT_NUM", nullable = false)
//    @Schema(description = "", nullable = true , defaultValue = "" , example = ""  , allowableValues = {"", ""})
    @Schema(description = "접수 번호(pk)", nullable = false)
    private Integer recptNum; //--접수_번호(pk)

    @Column(name = "CALLER_RGNNUM", length = 10, nullable = true)
    @Schema(description = "발신자 지역번호", nullable = true)
    private String callerRgnnum; //--발신자_지역번호

    @Column(name = "CALLER_PHONNUM", length = 20, nullable = true)
    @Schema(description = "발신자 전화번호", nullable = true)
    private String callerPhonnum; //--발신자_전화번호

    @Column(name = "RECPT_REPRT_TM", nullable = true)
    @Schema(description = "접수 신고 시간", nullable = true)
    private Date recptReprtTm; //--접수_신고_시간

    @Column(name = "WIRENLESS_DIV", length = 1, nullable = true)
    @Schema(description = "유무선 구분", nullable = true)
    private String wirenlessDiv; //--유무선_구분

    @Column(name = "RECPTPERSN_ID", length = 30, nullable = true)
    @Schema(description = "접수자 id", nullable = true)
    private String recptpersnId; //--접수자_id

    @Column(name = "PRCS_STT", length = 2, nullable = true)
    @Schema(description = "처리 상태", nullable = true)
    private String prcsStt; //--처리_상태

    @Column(name = "CALLER_FLNAME", length = 200, nullable = true)
    @Schema(description = "발신자 성명", nullable = true)
    private String callerFlname; //--발신자_성명

    @Column(name = "CALLER_PASS_NUM", length = 300, nullable = true)
    @Schema(description = "발신자 여권번호", nullable = true)
    private String callerPassNum; //--발신자_여권번호

    @Column(name = "CALLER_FCITY", length = 200, nullable = true)
    @Schema(description = "발신자 도시", nullable = true)
    private String callerFcity; //--발신자_도시

    @Column(name = "CALLER_DISTRICT", length = 100, nullable = true)
    @Schema(description = "발신자 동", nullable = true)
    private String callerDistrict; //--발신자_동

    @Column(name = "CALLER_DIST", length = 60, nullable = true)
    @Schema(description = "발신자 거리", nullable = true)
    private String callerDist; //--발신자_거리

    @Column(name = "CALLER_HS_NUM", length = 50, nullable = true)
    @Schema(description = "발신자 번지", nullable = true)
    private String callerHsNum; //--발신자_번지

    @Column(name = "CALLER_APT_DISTRICT", length = 20, nullable = true)
    @Schema(description = "발신자 아파트 동", nullable = true)
    private String callerAptDistrict; //--발신자_아파트_동

    @Column(name = "CALLER_APT_KVARTIR", length = 20, nullable = true)
    @Schema(description = "발신자 아파트 호", nullable = true)
    private String callerAptKvartir; //--발신자_아파트_호

    @Column(name = "CALLER_ALL_ADDR", length = 300, nullable = true)
    @Schema(description = "발신자 전체주소", nullable = true)
    private String callerAllAddr; //--발신자_전체주소

    @Column(name = "CALLER_LGT", nullable = true)
    @Schema(description = "발신자 경도", nullable = true)
    private Float callerLgt; //--발신자_경도

    @Column(name = "CALLER_LTT", nullable = true)
    @Schema(description = "발신자 위도", nullable = true)
    private Float callerLtt; //--발신자_위도

    @Column(name = "REPRTPERSN_FAM_NM", length = 100, nullable = true)
    @Schema(description = "신고자 성", nullable = true)
    private String reprtpersnFamNm; //--신고자_성

    @Column(name = "REPRTPERSN_GIV_NM", length = 100, nullable = true)
    @Schema(description = "신고자 이름", nullable = true)
    private String reprtpersnGivNm; //--신고자_이름

    @Column(name = "REPRTPERSN_MID_NM", length = 200, nullable = true)
    @Schema(description = "신고자 부성", nullable = true)
    private String reprtpersnMidNm; //--신고자_부성

    @Column(name = "REPRTPERSN_BIRTHYEARMMDD", nullable = true)
    @Schema(description = "신고자 생년월일", nullable = true)
    private Date reprtpersnBirthyearmmdd; //--신고자_생년월일

    @Column(name = "REPRTPERSN_TPHONE", length = 20, nullable = true)
    @Schema(description = "신고자 집전화", nullable = true)
    private String reprtpersnTphone; //--신고자_집전화

    @Column(name = "REPRTPERSN_HP", length = 20, nullable = true)
    @Schema(description = "신고자 핸드폰", nullable = true)
    private String reprtpersnHp; //--신고자_핸드폰

    @Column(name = "REPRTPERSN_PASS_NUM", length = 120, nullable = true)
    @Schema(description = "신고자 여권번호", nullable = true)
    private String reprtpersnPassNum; //--신고자_여권번호

    @Column(name = "INCIDOCR_FCITY", length = 100, nullable = true)
    @Schema(description = "사건발생 도시", nullable = true)
    private String incidocrFcity; //--사건발생_도시

    @Column(name = "INCIDOCR_DISTRICT", length = 100, nullable = true)
    @Schema(description = "사건발생 동", nullable = true)
    private String incidocrDistrict; //--사건발생_동

    @Column(name = "INCIDOCR_DIST", length = 100, nullable = true)
    @Schema(description = "사건발생 거리", nullable = true)
    private String incidocrDist; //--사건발생_거리

    @Column(name = "INCIDOCR_HS_NUM", length = 100, nullable = true)
    @Schema(description = "사건발생 번지", nullable = true)
    private String incidocrHsNum; //--사건발생_번지

    @Column(name = "INCIDOCR_APT_DISTRICT", length = 30, nullable = true)
    @Schema(description = "사건발생 아파트 동", nullable = true)
    private String incidocrAptDistrict; //--사건발생_아파트_동

    @Column(name = "INCIDOCR_APT_KVARTIR", length = 30, nullable = true)
    @Schema(description = "사건발생 아파트 호", nullable = true)
    private String incidocrAptKvartir; //--사건발생_아파트_호

    @Column(name = "INCIDOCR_BLDG", length = 200, nullable = true)
    @Schema(description = "사건발생 건물", nullable = true)
    private String incidocrBldg; //--사건발생_건물

    @Column(name = "INCIDTYPE_BIGCLSSFY_CODE", length = 30, nullable = true)
    @Schema(description = "사건 유형 대분류 코드", nullable = true)
    private String incidtypeBigclssfyCode; //--사건_유형_대분류_코드

    @Column(name = "INCIDTYPE_MEDCLSSFY_CODE", length = 30, nullable = true)
    @Schema(description = "사건 유형 중분류 코드", nullable = true)
    private String incidtypeMedclssfyCode; //--사건_유형_중분류_코드

    @Column(name = "INCIDTYPE_SMALLCLSSFY_CODE", length = 30, nullable = true)
    @Schema(description = "사건 유형 소분류 코드", nullable = true)
    private String incidtypeSmallclssfyCode; //--사건_유형_소분류_코드

    @Column(name = "RELATDBUSN_FIRE_FLAG", length = 1, nullable = true)
    @Schema(description = "관련업무 소방 플래그", nullable = true)
    private String relatdbusnFireFlag; //--관련업무_소방_플래그

    @Column(name = "INCID_OVIEW", length = 4000, nullable = true)
    @Schema(description = "사건 개요", nullable = true)
    private String incidOview; //--사건_개요

    @Column(name = "RELATDBUSN_POL_FLAG", length = 1, nullable = true)
    @Schema(description = "관련업무 경찰 플래그", nullable = true)
    private String relatdbusnPolFlag; //--관련업무_경찰_플래그

    @Column(name = "RELATDBUSN_TRFC_POL_FLAG", length = 1, nullable = true)
    @Schema(description = "관련업무 교통경찰 플래그", nullable = true)
    private String relatdbusnTrfcPolFlag; //--관련업무_교통경찰_플래그

    @Column(name = "REPRTPERSN_HANDWR_STT", length = 1, nullable = true)
    @Schema(description = "신고자 수기 상태", nullable = true)
    private String reprtpersnHandwrStt; //--신고자_수기_상태

    @Column(name = "JURIS_CODE", length = 20, nullable = true)
    @Schema(description = "관할 코드", nullable = true)
    private String jurisCode; //--관할_코드

    @Column(name = "RECPT_CLOSE_TM", nullable = true)
    @Schema(description = "접수 종료 시간", nullable = true)
    private Date recptCloseTm; //--접수_종료_시간

    @Column(name = "INCIDOCR_TM", nullable = true)
    @Schema(description = "사건발생 시간", nullable = true)
    private Date incidocrTm; //--사건발생_시간

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

    @Column(name = "INCIDOCR_LGT", nullable = true)
    @Schema(description = "사건발생 경도", nullable = true)
    private Float incidocrLgt; //--사건발생_경도

    @Column(name = "INCIDOCR_LTT", nullable = true)
    @Schema(description = "사건발생 위도", nullable = true)
    private Float incidocrLtt; //--사건발생_위도

    @Column(name = "REPRTPERSN_FCITY", length = 100, nullable = true)
    @Schema(description = "신고자 도시", nullable = true)
    private String reprtpersnFcity; //--신고자_도시

    @Column(name = "REPRTPERSN_DISTRICT", length = 100, nullable = true)
    @Schema(description = "신고자 동", nullable = true)
    private String reprtpersnDistrict; //--신고자_동

    @Column(name = "REPRTPERSN_DIST", length = 100, nullable = true)
    @Schema(description = "시고자 거리", nullable = true)
    private String reprtpersnDist; //--시고자_거리

    @Column(name = "REPRTPERSN_HS_NUM", length = 100, nullable = true)
    @Schema(description = "신고자 번지", nullable = true)
    private String reprtpersnHsNum; //--신고자_번지

    @Column(name = "REPRTPERSN_APT_DISTRICT", length = 30, nullable = true)
    @Schema(description = "신고자 아파트 동", nullable = true)
    private String reprtpersnAptDistrict; //--신고자_아파트_동

    @Column(name = "REPRTPERSN_APT_KVARTIR", length = 30, nullable = true)
    @Schema(description = "신고자 아파트 호", nullable = true)
    private String reprtpersnAptKvartir; //--신고자_아파트_호

    @Column(name = "REPRTPERSN_FORGNR_FCITY", length = 100, nullable = true)
    @Schema(description = "신고자 외국인 도시", nullable = true)
    private String reprtpersnForgnrFcity; //--신고자_외국인_도시

    @Column(name = "REPRTPERSN_FORGNR_DIST", length = 100, nullable = true)
    @Schema(description = "신고자 외국인 거리", nullable = true)
    private String reprtpersnForgnrDist; //--신고자_외국인_거리

    @Column(name = "REPRTPERSN_FORGNR_HS_NUM", length = 100, nullable = true)
    @Schema(description = "신고자 외국인 번지", nullable = true)
    private String reprtpersnForgnrHsNum; //--신고자_외국인_번지

    @Column(name = "REPRTPERSN_FORGNR_KVARTIR", length = 30, nullable = true)
    @Schema(description = "신고자 외국인 호", nullable = true)
    private String reprtpersnForgnrKvartir; //--신고자_외국인_호

    @Column(name = "JURIS_MNG_CODE", length = 20, nullable = true)
    @Schema(description = "관할 관리 코드", nullable = true)
    private String jurisMngCode; //--관할_관리_코드

    @Column(name = "REPRTPERSN_NAT", length = 30, nullable = true)
    @Schema(description = "신고자 국적", nullable = true)
    private String reprtpersnNat; //--신고자_국적

    @Builder
    public SWrongReprtPhon(String callerRgnnum, String callerPhonnum, Date recptReprtTm, String wirenlessDiv, String recptpersnId, String prcsStt, String callerFlname, String callerPassNum, String callerFcity, String callerDistrict, String callerDist, String callerHsNum, String callerAptDistrict, String callerAptKvartir, String callerAllAddr, Float callerLgt, Float callerLtt, String reprtpersnFamNm, String reprtpersnGivNm, String reprtpersnMidNm, Date reprtpersnBirthyearmmdd, String reprtpersnTphone, String reprtpersnHp, String reprtpersnPassNum, String incidocrFcity, String incidocrDistrict, String incidocrDist, String incidocrHsNum, String incidocrAptDistrict, String incidocrAptKvartir, String incidocrBldg, String incidtypeBigclssfyCode, String incidtypeMedclssfyCode, String incidtypeSmallclssfyCode, String relatdbusnFireFlag, String incidOview, String relatdbusnPolFlag, String relatdbusnTrfcPolFlag, String reprtpersnHandwrStt, String jurisCode, Date recptCloseTm, Date incidocrTm, String fstRegpersnId, String finalUptpersnId, Date fstRegTm, Date finalUptTm, Float incidocrLgt, Float incidocrLtt, String reprtpersnFcity, String reprtpersnDistrict, String reprtpersnDist, String reprtpersnHsNum, String reprtpersnAptDistrict, String reprtpersnAptKvartir, String reprtpersnForgnrFcity, String reprtpersnForgnrDist, String reprtpersnForgnrHsNum, String reprtpersnForgnrKvartir, String jurisMngCode, String reprtpersnNat) {
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
}
