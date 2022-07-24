/**
 * MQstnLst Entity 클래스
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

import com.weni.ecs.domain.listener.MQstnLstListener;

@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED) // AccessLevel.PUBLIC
@Entity
@EntityListeners(MQstnLstListener.class)
@Table(name = "M_QSTN_LST") //--질문_목록(Table)
@Schema(description = "질문 목록(Table)")
public class MQstnLst implements Serializable {
    @Id //  String
    @Column(name = "QSTN_ID", length = 20, nullable = false)
//    @Schema(description = "", nullable = true , defaultValue = "" , example = ""  , allowableValues = {"", ""})
    @Schema(description = "질문 id(pk)", nullable = false)
    private String qstnId; //--질문_id(pk)

    @Column(name = "INCIDTYPE_BIGCLSSFY_CODE", length = 30, nullable = false)
    @Schema(description = "사건 유형 대분류 코드", nullable = false)
    private String incidtypeBigclssfyCode; //--사건_유형_대분류_코드

    @Column(name = "INCIDTYPE_MEDCLSSFY_CODE", length = 30, nullable = false)
    @Schema(description = "사건 유형 중분류 코드", nullable = false)
    private String incidtypeMedclssfyCode; //--사건_유형_중분류_코드

    @Column(name = "INCIDTYPE_SMALLCLSSFY_CODE", length = 30, nullable = false)
    @Schema(description = "사건 유형 소분류 코드", nullable = false)
    private String incidtypeSmallclssfyCode; //--사건_유형_소분류_코드

    @Column(name = "QSTN_CONT", length = 4000, nullable = true)
    @Schema(description = "질문 내용", nullable = true)
    private String qstnCont; //--질문_내용

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
    public MQstnLst(String qstnId, String incidtypeBigclssfyCode, String incidtypeMedclssfyCode, String incidtypeSmallclssfyCode, String qstnCont, String fstRegpersnId, String finalUptpersnId, Date fstRegTm, Date finalUptTm) {
        this.qstnId = qstnId;
        this.incidtypeBigclssfyCode = incidtypeBigclssfyCode;
        this.incidtypeMedclssfyCode = incidtypeMedclssfyCode;
        this.incidtypeSmallclssfyCode = incidtypeSmallclssfyCode;
        this.qstnCont = qstnCont;
        this.fstRegpersnId = fstRegpersnId;
        this.finalUptpersnId = finalUptpersnId;
        this.fstRegTm = fstRegTm;
        this.finalUptTm = finalUptTm;
    }
}
