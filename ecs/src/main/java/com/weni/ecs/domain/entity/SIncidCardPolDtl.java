/**
 * SIncidCardPolDtl Entity 클래스
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
import javax.persistence.Id;
import javax.persistence.IdClass;
// import javax.persistence.Temporal;
// import javax.persistence.TemporalType;
import javax.persistence.Table;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import com.weni.ecs.domain.listener.SIncidCardPolDtlListener;

@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED) // AccessLevel.PUBLIC
@Entity
@EntityListeners(SIncidCardPolDtlListener.class)
@Table(name = "S_INCID_CARD_POL_DTL") //--사건_카드_경찰_상세(Table)
@Schema(description = "사건 카드 경찰 상세(Table)")
@IdClass(SIncidCardPolDtlPK.class)
public class SIncidCardPolDtl implements Serializable {
    @Id //  Integer
    @Column(name = "RECPT_NUM", nullable = false)
//    @Schema(description = "", nullable = true , defaultValue = "" , example = ""  , allowableValues = {"", ""})
    @Schema(description = "접수 번호(pk)", nullable = false)
    private Integer recptNum; //--접수_번호(pk)

    @Id //  String
    @Column(name = "DTL_DIV_CODE", length = 30, nullable = false)
    @Schema(description = "건물 구분 코드(pk)", nullable = false)
    private String dtlDivCode; //--건물_구분_코드(pk)

    @Id //  Integer
    @Column(name = "DTL_SEQ_NUM", nullable = false)
    @Schema(description = "상세 순번(pk)", nullable = false)
    private Integer dtlSeqNum; //--상세_순번(pk)

    @Column(name = "CTRY_CODE_3", length = 30, nullable = true)
    @Schema(description = "국가 코드 3", nullable = true)
    private String ctryCode3; //--국가_코드_3

    @Column(name = "FAM_NM", length = 100, nullable = true)
    @Schema(description = "성", nullable = true)
    private String famNm; //--성

    @Column(name = "GIV_NM", length = 100, nullable = true)
    @Schema(description = "이름", nullable = true)
    private String givNm; //--이름

    @Column(name = "MID_NM", length = 200, nullable = true)
    @Schema(description = "부성", nullable = true)
    private String midNm; //--부성

    @Column(name = "BIRTHYEARMMDD", nullable = true)
    @Schema(description = "생년월일", nullable = true)
    private Date birthyearmmdd; //--생년월일

    @Column(name = "TPHONE", length = 20, nullable = true)
    @Schema(description = "집전화", nullable = true)
    private String tphone; //--집전화

    @Column(name = "HP", length = 20, nullable = true)
    @Schema(description = "핸드폰", nullable = true)
    private String hp; //--핸드폰

    @Column(name = "PASS_NUM", length = 120, nullable = true)
    @Schema(description = "여권번호", nullable = true)
    private String passNum; //--여권번호

    @Column(name = "DOMPERS_FCITY", length = 100, nullable = true)
    @Schema(description = "국내인 도시", nullable = true)
    private String dompersFcity; //--국내인_도시

    @Column(name = "DOMPERS_DISTRICT", length = 100, nullable = true)
    @Schema(description = "국내인 동", nullable = true)
    private String dompersDistrict; //--국내인_동

    @Column(name = "DOMPERS_DIST", length = 100, nullable = true)
    @Schema(description = "국내인 거리", nullable = true)
    private String dompersDist; //--국내인_거리

    @Column(name = "DOMPERS_HS_NUM", length = 100, nullable = true)
    @Schema(description = "국내인 번지", nullable = true)
    private String dompersHsNum; //--국내인_번지

    @Column(name = "DOMPERS_APT_DISTRICT", length = 30, nullable = true)
    @Schema(description = "국내인 아파트 동", nullable = true)
    private String dompersAptDistrict; //--국내인_아파트_동

    @Column(name = "DOMPERS_APT_KVARTIR", length = 30, nullable = true)
    @Schema(description = "국내인 아파트 호", nullable = true)
    private String dompersAptKvartir; //--국내인_아파트_호

    @Column(name = "FORGNR_FCITY", length = 100, nullable = true)
    @Schema(description = "외국인 도시", nullable = true)
    private String forgnrFcity; //--외국인_도시

    @Column(name = "FORGNR_DIST", length = 100, nullable = true)
    @Schema(description = "외국인 거리", nullable = true)
    private String forgnrDist; //--외국인_거리

    @Column(name = "FORGNR_HS_NUM", length = 100, nullable = true)
    @Schema(description = "외국인 번지", nullable = true)
    private String forgnrHsNum; //--외국인_번지

    @Column(name = "FORGNR_KVARTIR", length = 30, nullable = true)
    @Schema(description = "외국인 호", nullable = true)
    private String forgnrKvartir; //--외국인_호

    @Column(name = "SEX_CODE", length = 30, nullable = true)
    @Schema(description = "성별 코드", nullable = true)
    private String sexCode; //--성별_코드

    @Column(name = "FAM_REL_CODE", length = 30, nullable = true)
    @Schema(description = "가존 관계 코드", nullable = true)
    private String famRelCode; //--가존_관계_코드

    @Column(name = "CRIM_REC", length = 150, nullable = true)
    @Schema(description = "전과", nullable = true)
    private String crimRec; //--전과

    @Column(name = "WRK_PLACE_NM", length = 200, nullable = true)
    @Schema(description = "직장 명", nullable = true)
    private String wrkPlaceNm; //--직장_명

    @Column(name = "INJURY_KND_CODE", length = 30, nullable = true)
    @Schema(description = "상해 종류 코드", nullable = true)
    private String injuryKndCode; //--상해_종류_코드

    @Column(name = "INJURY_GRD_CODE", length = 30, nullable = true)
    @Schema(description = "상해 등급 코드", nullable = true)
    private String injuryGrdCode; //--상해_등급_코드

    @Column(name = "NARCOTIC_KND_CODE", length = 30, nullable = true)
    @Schema(description = "마약 종류 코드", nullable = true)
    private String narcoticKndCode; //--마약_종류_코드

    @Column(name = "NARCOTIC_WEIGHT", nullable = true)
    @Schema(description = "마약 무게", nullable = true)
    private Float narcoticWeight; //--마약_무게

    @Column(name = "NARCOTIC_WEIGHT_UNIT_CODE", length = 30, nullable = true)
    @Schema(description = "마약 무게 단위 코드", nullable = true)
    private String narcoticWeightUnitCode; //--마약_무게_단위_코드

    @Column(name = "VIDEO_FILE_FOLD", length = 1000, nullable = true)
    @Schema(description = "영상 파일 폴더", nullable = true)
    private String videoFileFold; //--영상_파일_폴더

    @Column(name = "VIDEO_FILE_NM", length = 200, nullable = true)
    @Schema(description = "영상 파일 명", nullable = true)
    private String videoFileNm; //--영상_파일_명

    @Column(name = "HANDWR_STT", length = 1, nullable = true)
    @Schema(description = "수기 상태", nullable = true)
    private String handwrStt; //--수기_상태

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

    @Builder
    public SIncidCardPolDtl(Integer recptNum, String dtlDivCode, Integer dtlSeqNum, String ctryCode3, String famNm, String givNm, String midNm, Date birthyearmmdd, String tphone, String hp, String passNum, String dompersFcity, String dompersDistrict, String dompersDist, String dompersHsNum, String dompersAptDistrict, String dompersAptKvartir, String forgnrFcity, String forgnrDist, String forgnrHsNum, String forgnrKvartir, String sexCode, String famRelCode, String crimRec, String wrkPlaceNm, String injuryKndCode, String injuryGrdCode, String narcoticKndCode, Float narcoticWeight, String narcoticWeightUnitCode, String videoFileFold, String videoFileNm, String handwrStt, String fstRegpersnId, String finalUptpersnId, Date fstRegTm, Date finalUptTm) {
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
}
