/**
 * MUsrInfo Entity 클래스
 *
 *  @author  Lee Byoung Gwan
 *  @version 1.0
**/
package com.weni.ecs.domain.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
// import javax.persistence.Temporal;
// import javax.persistence.TemporalType;
import javax.persistence.Table;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import com.weni.ecs.domain.listener.MUsrInfoListener;

@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED) // AccessLevel.PUBLIC
@Entity
@EntityListeners(MUsrInfoListener.class)
@Table(name = "M_USR_INFO") //--사용자_정보(Table)
@Schema(description = "사용자 정보(Table)")
public class MUsrInfo implements Serializable {
    @Id //  String
    @Column(name = "USR_ID", length = 30, nullable = false)
//    @Schema(description = "", nullable = true , defaultValue = "" , example = ""  , allowableValues = {"", ""})
    @Schema(description = "사용자 id(pk)", nullable = false)
    private String usrId; //--사용자_id(pk)

    @Column(name = "JURIS_CODE", length = 20, nullable = true)
    @Schema(description = "관할 코드", nullable = true)
    private String jurisCode; //--관할_코드

    @Column(name = "OFF_RANK_CODE", length = 10, nullable = true)
    @Schema(description = "직위 코드", nullable = true)
    private String offRankCode; //--직위_코드

    @Column(name = "FAM_NM", length = 100, nullable = true)
    @Schema(description = "성", nullable = true)
    private String famNm; //--성

    @Column(name = "GIV_NM", length = 100, nullable = true)
    @Schema(description = "이름", nullable = true)
    private String givNm; //--이름

    @Column(name = "MID_NM", length = 200, nullable = true)
    @Schema(description = "부성", nullable = true)
    private String midNm; //--부성

    @Column(name = "PWD", length = 40, nullable = true)
    @Schema(description = "패스워드", nullable = true)
    private String pwd; //--패스워드

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

    @Column(name = "LOCALE_CODE", length = 20, nullable = true)
    @Schema(description = "현지 코드", nullable = true)
    private String localeCode; //--현지_코드

    @Column(name = "CURR_EXIST_STT", length = 1, nullable = true)
    @Schema(description = "현재 존재 상태", nullable = true)
    private String currExistStt; //--현재_존재_상태

    @Column(name = "SOFTPHONE_NUM", length = 6, nullable = true)
    @Schema(description = "소프트폰 번호", nullable = true)
    private String softphoneNum; //--소프트폰_번호

    @Column(name = "LOGIN_KEEP_TM", precision = 10, scale = 0, nullable = true)
    @Schema(description = "로그인 유지 시간", nullable = true)
    private BigDecimal loginKeepTm; //--로그인_유지_시간

    @Column(name = "GIS_USR_GRP", length = 30, nullable = true)
    @Schema(description = "gis 사용자 그룹", nullable = true)
    private String gisUsrGrp; //--gis_사용자_그룹

    @Builder
    public MUsrInfo(String usrId, String jurisCode, String offRankCode, String famNm, String givNm, String midNm, String pwd, String fstRegpersnId, String finalUptpersnId, Date fstRegTm, Date finalUptTm, String localeCode, String currExistStt, String softphoneNum, BigDecimal loginKeepTm, String gisUsrGrp) {
        this.usrId = usrId;
        this.jurisCode = jurisCode;
        this.offRankCode = offRankCode;
        this.famNm = famNm;
        this.givNm = givNm;
        this.midNm = midNm;
        this.pwd = pwd;
        this.fstRegpersnId = fstRegpersnId;
        this.finalUptpersnId = finalUptpersnId;
        this.fstRegTm = fstRegTm;
        this.finalUptTm = finalUptTm;
        this.localeCode = localeCode;
        this.currExistStt = currExistStt;
        this.softphoneNum = softphoneNum;
        this.loginKeepTm = loginKeepTm;
        this.gisUsrGrp = gisUsrGrp;
    }
}
