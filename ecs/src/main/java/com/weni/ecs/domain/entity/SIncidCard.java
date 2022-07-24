/**
 * SIncidCard Entity 클래스
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

import com.weni.ecs.domain.listener.SIncidCardListener;

@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED) // AccessLevel.PUBLIC
@Entity
@EntityListeners(SIncidCardListener.class)
@Table(name = "S_INCID_CARD") //--사건_카드(Table)
@Schema(description = "사건 카드(Table)")
public class SIncidCard implements Serializable {
    @Id //  Integer
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "RECPT_NUM", nullable = false)
//    @Schema(description = "", nullable = true , defaultValue = "" , example = ""  , allowableValues = {"", ""})
    @Schema(description = "접수 번호(pk)", nullable = false)
    private Integer recptNum; //--접수_번호(pk)

    @Column(name = "RECPT_DIV", length = 1, nullable = true)
    @Schema(description = "접수 구분", nullable = true)
    private String recptDiv; //--접수_구분

    @Column(name = "INCID_NUM", length = 60, nullable = true)
    @Schema(description = "사건 번호", nullable = true)
    private String incidNum; //--사건_번호

    @Column(name = "SAME_INCID_NUM", length = 60, nullable = true)
    @Schema(description = "동일 사건 번호", nullable = true)
    private String sameIncidNum; //--동일_사건_번호

    @Column(name = "CALLER_RGNNUM", length = 10, nullable = true)
    @Schema(description = "발신자 지역번호", nullable = true)
    private String callerRgnnum; //--발신자_지역번호

    @Column(name = "CALLER_PHONNUM", length = 20, nullable = true)
    @Schema(description = "발신자 전화번호", nullable = true)
    private String callerPhonnum; //--발신자_전화번호

    @Column(name = "WIRENLESS_DIV", length = 1, nullable = true)
    @Schema(description = "유무선 구분", nullable = true)
    private String wirenlessDiv; //--유무선_구분

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

    @Column(name = "CALLER_BLDG_CODE", length = 24, nullable = true)
    @Schema(description = "발신자 건물 코드", nullable = true)
    private String callerBldgCode; //--발신자_건물_코드

    @Column(name = "CALLER_ALL_ADDR", length = 300, nullable = true)
    @Schema(description = "발신자 전체주소", nullable = true)
    private String callerAllAddr; //--발신자_전체주소

    @Column(name = "CALLER_LGT", nullable = true)
    @Schema(description = "발신자 경도", nullable = true)
    private Float callerLgt; //--발신자_경도

    @Column(name = "CALLER_LTT", nullable = true)
    @Schema(description = "발신자 위도", nullable = true)
    private Float callerLtt; //--발신자_위도

    @Column(name = "CALLER_AGCY_KND", length = 30, nullable = true)
    @Schema(description = "발신자 기관 종류", nullable = true)
    private String callerAgcyKnd; //--발신자_기관_종류

    @Column(name = "CALLER_AGCY_NM", length = 200, nullable = true)
    @Schema(description = "발신자 기관 명", nullable = true)
    private String callerAgcyNm; //--발신자_기관_명

    @Column(name = "REPRTPERSN_NAT", length = 30, nullable = true)
    @Schema(description = "신고자 국적", nullable = true)
    private String reprtpersnNat; //--신고자_국적

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

    @Column(name = "REPRTPERSN_OFF_RANK", length = 50, nullable = true)
    @Schema(description = "신고자 직위", nullable = true)
    private String reprtpersnOffRank; //--신고자_직위

    @Column(name = "REPRTPERSN_DEPT", length = 100, nullable = true)
    @Schema(description = "신고자 부서", nullable = true)
    private String reprtpersnDept; //--신고자_부서

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

    @Column(name = "INCIDOCR_TM", nullable = true)
    @Schema(description = "사건발생 시간", nullable = true)
    private Date incidocrTm; //--사건발생_시간

    @Column(name = "INCIDOCR_LGT", nullable = true)
    @Schema(description = "사건발생 경도", nullable = true)
    private Float incidocrLgt; //--사건발생_경도

    @Column(name = "INCIDOCR_LTT", nullable = true)
    @Schema(description = "사건발생 위도", nullable = true)
    private Float incidocrLtt; //--사건발생_위도

    @Column(name = "INCIDOCR_BLDG_CODE", length = 24, nullable = true)
    @Schema(description = "사건발생 건물 코드", nullable = true)
    private String incidocrBldgCode; //--사건발생_건물_코드

    @Column(name = "RELATDBUSN_FIRE_FLAG", length = 1, nullable = true)
    @Schema(description = "관련업무 소방 플래그", nullable = true)
    private String relatdbusnFireFlag; //--관련업무_소방_플래그

    @Column(name = "RELATDBUSN_POL_FLAG", length = 1, nullable = true)
    @Schema(description = "관련업무 경찰 플래그", nullable = true)
    private String relatdbusnPolFlag; //--관련업무_경찰_플래그

    @Column(name = "RELATDBUSN_TRFC_POL_FLAG", length = 1, nullable = true)
    @Schema(description = "관련업무 교통경찰 플래그", nullable = true)
    private String relatdbusnTrfcPolFlag; //--관련업무_교통경찰_플래그

    @Column(name = "JURIS_CODE", length = 20, nullable = true)
    @Schema(description = "관할 코드", nullable = true)
    private String jurisCode; //--관할_코드

    @Column(name = "INCID_OVIEW", length = 4000, nullable = true)
    @Schema(description = "사건 개요", nullable = true)
    private String incidOview; //--사건_개요

    @Column(name = "RECPTPERSN_ID", length = 30, nullable = true)
    @Schema(description = "접수자 id", nullable = true)
    private String recptpersnId; //--접수자_id

    @Column(name = "RECPT_REPRT_TM", nullable = true)
    @Schema(description = "접수 신고 시간", nullable = true)
    private Date recptReprtTm; //--접수_신고_시간

    @Column(name = "RECPT_CLOSE_TM", nullable = true)
    @Schema(description = "접수 종료 시간", nullable = true)
    private Date recptCloseTm; //--접수_종료_시간

    @Column(name = "REPRTPERSN_HANDWR_STT", length = 1, nullable = true)
    @Schema(description = "신고자 수기 상태", nullable = true)
    private String reprtpersnHandwrStt; //--신고자_수기_상태

    @Column(name = "PRCS_STT", length = 2, nullable = true)
    @Schema(description = "처리 상태", nullable = true)
    private String prcsStt; //--처리_상태

    @Column(name = "ENDPRCS_TM", nullable = true)
    @Schema(description = "종결처리 시간", nullable = true)
    private Date endprcsTm; //--종결처리_시간

    @Column(name = "NPRCSD_INSP_ID", length = 30, nullable = true)
    @Schema(description = "미처리 인스팩터 id", nullable = true)
    private String nprcsdInspId; //--미처리_인스팩터_id

    @Column(name = "END_PRCS_INSP_ID", length = 30, nullable = true)
    @Schema(description = "종결 처리 인스팩터 id", nullable = true)
    private String endPrcsInspId; //--종결_처리_인스팩터_id

    @Column(name = "MNG_JNL_CLSSFY_CODE", length = 30, nullable = true)
    @Schema(description = "관리 대장 분류 코드", nullable = true)
    private String mngJnlClssfyCode; //--관리_대장_분류_코드

    @Column(name = "ETC_INCID_MNG_CODE", length = 30, nullable = true)
    @Schema(description = "기타 사건 관리 코그", nullable = true)
    private String etcIncidMngCode; //--기타_사건_관리_코그

    @Column(name = "MNG_JNL_NUM", length = 40, nullable = true)
    @Schema(description = "관리 대장 번호", nullable = true)
    private String mngJnlNum; //--관리_대장_번호

    @Column(name = "INSP_FAM_NM", length = 200, nullable = true)
    @Schema(description = "인스팩터 성", nullable = true)
    private String inspFamNm; //--인스팩터_성

    @Column(name = "DISP_NEED_PERSN", length = 4000, nullable = true)
    @Schema(description = "출동요원", nullable = true)
    private String dispNeedPersn; //--출동요원

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

    @Column(name = "JURIS_MNG_CODE", length = 20, nullable = true)
    @Schema(description = "관할 관리 코드", nullable = true)
    private String jurisMngCode; //--관할_관리_코드

    @Column(name = "NPRCSD_CLOSE_TM", nullable = true)
    @Schema(description = "미처리 종료 시간", nullable = true)
    private Date nprcsdCloseTm; //--미처리_종료_시간

    @Builder
    public SIncidCard(String recptDiv, String incidNum, String sameIncidNum, String callerRgnnum, String callerPhonnum, String wirenlessDiv, String callerFlname, String callerPassNum, String callerFcity, String callerDistrict, String callerDist, String callerHsNum, String callerAptDistrict, String callerAptKvartir, String callerBldgCode, String callerAllAddr, Float callerLgt, Float callerLtt, String callerAgcyKnd, String callerAgcyNm, String reprtpersnNat, String reprtpersnFamNm, String reprtpersnGivNm, String reprtpersnMidNm, Date reprtpersnBirthyearmmdd, String reprtpersnTphone, String reprtpersnHp, String reprtpersnPassNum, String reprtpersnFcity, String reprtpersnDistrict, String reprtpersnDist, String reprtpersnHsNum, String reprtpersnAptDistrict, String reprtpersnAptKvartir, String reprtpersnForgnrFcity, String reprtpersnForgnrDist, String reprtpersnForgnrHsNum, String reprtpersnForgnrKvartir, String reprtpersnOffRank, String reprtpersnDept, String incidocrFcity, String incidocrDistrict, String incidocrDist, String incidocrHsNum, String incidocrAptDistrict, String incidocrAptKvartir, String incidocrBldg, String incidtypeBigclssfyCode, String incidtypeMedclssfyCode, String incidtypeSmallclssfyCode, Date incidocrTm, Float incidocrLgt, Float incidocrLtt, String incidocrBldgCode, String relatdbusnFireFlag, String relatdbusnPolFlag, String relatdbusnTrfcPolFlag, String jurisCode, String incidOview, String recptpersnId, Date recptReprtTm, Date recptCloseTm, String reprtpersnHandwrStt, String prcsStt, Date endprcsTm, String nprcsdInspId, String endPrcsInspId, String mngJnlClssfyCode, String etcIncidMngCode, String mngJnlNum, String inspFamNm, String dispNeedPersn, String fstRegpersnId, String finalUptpersnId, Date fstRegTm, Date finalUptTm, String jurisMngCode, Date nprcsdCloseTm) {
        this.recptDiv = recptDiv;
        this.incidNum = incidNum;
        this.sameIncidNum = sameIncidNum;
        this.callerRgnnum = callerRgnnum;
        this.callerPhonnum = callerPhonnum;
        this.wirenlessDiv = wirenlessDiv;
        this.callerFlname = callerFlname;
        this.callerPassNum = callerPassNum;
        this.callerFcity = callerFcity;
        this.callerDistrict = callerDistrict;
        this.callerDist = callerDist;
        this.callerHsNum = callerHsNum;
        this.callerAptDistrict = callerAptDistrict;
        this.callerAptKvartir = callerAptKvartir;
        this.callerBldgCode = callerBldgCode;
        this.callerAllAddr = callerAllAddr;
        this.callerLgt = callerLgt;
        this.callerLtt = callerLtt;
        this.callerAgcyKnd = callerAgcyKnd;
        this.callerAgcyNm = callerAgcyNm;
        this.reprtpersnNat = reprtpersnNat;
        this.reprtpersnFamNm = reprtpersnFamNm;
        this.reprtpersnGivNm = reprtpersnGivNm;
        this.reprtpersnMidNm = reprtpersnMidNm;
        this.reprtpersnBirthyearmmdd = reprtpersnBirthyearmmdd;
        this.reprtpersnTphone = reprtpersnTphone;
        this.reprtpersnHp = reprtpersnHp;
        this.reprtpersnPassNum = reprtpersnPassNum;
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
        this.reprtpersnOffRank = reprtpersnOffRank;
        this.reprtpersnDept = reprtpersnDept;
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
        this.incidocrTm = incidocrTm;
        this.incidocrLgt = incidocrLgt;
        this.incidocrLtt = incidocrLtt;
        this.incidocrBldgCode = incidocrBldgCode;
        this.relatdbusnFireFlag = relatdbusnFireFlag;
        this.relatdbusnPolFlag = relatdbusnPolFlag;
        this.relatdbusnTrfcPolFlag = relatdbusnTrfcPolFlag;
        this.jurisCode = jurisCode;
        this.incidOview = incidOview;
        this.recptpersnId = recptpersnId;
        this.recptReprtTm = recptReprtTm;
        this.recptCloseTm = recptCloseTm;
        this.reprtpersnHandwrStt = reprtpersnHandwrStt;
        this.prcsStt = prcsStt;
        this.endprcsTm = endprcsTm;
        this.nprcsdInspId = nprcsdInspId;
        this.endPrcsInspId = endPrcsInspId;
        this.mngJnlClssfyCode = mngJnlClssfyCode;
        this.etcIncidMngCode = etcIncidMngCode;
        this.mngJnlNum = mngJnlNum;
        this.inspFamNm = inspFamNm;
        this.dispNeedPersn = dispNeedPersn;
        this.fstRegpersnId = fstRegpersnId;
        this.finalUptpersnId = finalUptpersnId;
        this.fstRegTm = fstRegTm;
        this.finalUptTm = finalUptTm;
        this.jurisMngCode = jurisMngCode;
        this.nprcsdCloseTm = nprcsdCloseTm;
    }
}
