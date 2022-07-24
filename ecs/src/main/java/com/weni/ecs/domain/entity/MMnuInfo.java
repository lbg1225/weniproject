/**
 * MMnuInfo Entity 클래스
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
// import javax.persistence.Temporal;
// import javax.persistence.TemporalType;
import javax.persistence.Table;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import com.weni.ecs.domain.listener.MMnuInfoListener;

@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED) // AccessLevel.PUBLIC
@Entity
@EntityListeners(MMnuInfoListener.class)
@Table(name = "M_MNU_INFO") //--메뉴_정보(Table)
@Schema(description = "메뉴 정보(Table)")
public class MMnuInfo implements Serializable {
    @Id //  String
    @Column(name = "MNU_ID", length = 50, nullable = false)
//    @Schema(description = "", nullable = true , defaultValue = "" , example = ""  , allowableValues = {"", ""})
    @Schema(description = "메뉴 id(pk)", nullable = false)
    private String mnuId; //--메뉴_id(pk)

    @Column(name = "BUSN_DOMAIN", length = 150, nullable = true)
    @Schema(description = "업무 영역", nullable = true)
    private String busnDomain; //--업무_영역

    @Column(name = "BUSN_SKILL", length = 400, nullable = true)
    @Schema(description = "업무 기능", nullable = true)
    private String busnSkill; //--업무_기능

    @Column(name = "SCR_NM", length = 300, nullable = true)
    @Schema(description = "화면 명", nullable = true)
    private String scrNm; //--화면_명

    @Column(name = "SCR_EXP", length = 500, nullable = true)
    @Schema(description = "화면 설명", nullable = true)
    private String scrExp; //--화면_설명

    @Column(name = "DEL_FLAG", length = 1, nullable = true)
    @Schema(description = "삭제 플래그", nullable = true)
    private String delFlag; //--삭제_플래그

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

    @Column(name = "SCR_NM_KOR", length = 300, nullable = true)
    @Schema(description = "화면 명 한국", nullable = true)
    private String scrNmKor; //--화면_명_한국

    @Column(name = "SCR_NM_RUS", length = 300, nullable = true)
    @Schema(description = "화면 명 러시아", nullable = true)
    private String scrNmRus; //--화면_명_러시아

    @Column(name = "LST_NUMB", nullable = true)
    @Schema(description = "목록 수", nullable = true)
    private Integer lstNumb; //--목록_수

    @Column(name = "QRY_SEQ", nullable = false)
    @Schema(description = "조회 순서", nullable = false)
    private Integer qrySeq; //--조회_순서

    @Column(name = "QRY_FLAG", length = 1, nullable = true)
    @Schema(description = "조회 플래그", nullable = true)
    private String qryFlag; //--조회_플래그

    @Column(name = "UPT_FLAG", length = 1, nullable = true)
    @Schema(description = "수정 플래그", nullable = true)
    private String uptFlag; //--수정_플래그

    @Column(name = "INS_FLAG", length = 1, nullable = true)
    @Schema(description = "입력 플래그", nullable = true)
    private String insFlag; //--입력_플래그

    @Builder
    public MMnuInfo(String mnuId, String busnDomain, String busnSkill, String scrNm, String scrExp, String delFlag, String fstRegpersnId, String finalUptpersnId, Date fstRegTm, Date finalUptTm, String scrNmKor, String scrNmRus, Integer lstNumb, Integer qrySeq, String qryFlag, String uptFlag, String insFlag) {
        this.mnuId = mnuId;
        this.busnDomain = busnDomain;
        this.busnSkill = busnSkill;
        this.scrNm = scrNm;
        this.scrExp = scrExp;
        this.delFlag = delFlag;
        this.fstRegpersnId = fstRegpersnId;
        this.finalUptpersnId = finalUptpersnId;
        this.fstRegTm = fstRegTm;
        this.finalUptTm = finalUptTm;
        this.scrNmKor = scrNmKor;
        this.scrNmRus = scrNmRus;
        this.lstNumb = lstNumb;
        this.qrySeq = qrySeq;
        this.qryFlag = qryFlag;
        this.uptFlag = uptFlag;
        this.insFlag = insFlag;
    }
}
