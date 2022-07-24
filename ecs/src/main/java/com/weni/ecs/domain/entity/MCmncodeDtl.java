/**
 * MCmncodeDtl Entity 클래스
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

import com.weni.ecs.domain.listener.MCmncodeDtlListener;

@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED) // AccessLevel.PUBLIC
@Entity
@EntityListeners(MCmncodeDtlListener.class)
@Table(name = "M_CMNCODE_DTL") //--공통_코드_상세(Table)
@Schema(description = "공통 코드 상세(Table)")
public class MCmncodeDtl implements Serializable {
    @Id //  String
    @Column(name = "CLSSFY_DTL_CODE", length = 30, nullable = false)
//    @Schema(description = "", nullable = true , defaultValue = "" , example = ""  , allowableValues = {"", ""})
    @Schema(description = "분류 상세 코드(pk)", nullable = false)
    private String clssfyDtlCode; //--분류_상세_코드(pk)

    @Column(name = "CLSSFY_CODE", length = 20, nullable = false)
    @Schema(description = "분류 코드", nullable = false)
    private String clssfyCode; //--분류_코드

    @Column(name = "CLSSFY_DTL_NM", length = 100, nullable = true)
    @Schema(description = "분류 상세 명", nullable = true)
    private String clssfyDtlNm; //--분류_상세_명

    @Column(name = "CLSSFY_1", length = 30, nullable = true)
    @Schema(description = "분류 1", nullable = true)
    private String clssfy1; //--분류_1

    @Column(name = "CLSSFY_2", length = 30, nullable = true)
    @Schema(description = "분류 2", nullable = true)
    private String clssfy2; //--분류_2

    @Column(name = "CLSSFY_3", length = 30, nullable = true)
    @Schema(description = "분류 3", nullable = true)
    private String clssfy3; //--분류_3

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

    @Column(name = "CLSSFY_DTL_NM_KOR", length = 100, nullable = true)
    @Schema(description = "분류 상세 명 한국", nullable = true)
    private String clssfyDtlNmKor; //--분류_상세_명_한국

    @Column(name = "CLSSFY_DTL_NM_RUS", length = 100, nullable = true)
    @Schema(description = "분류 상세 명 러시아", nullable = true)
    private String clssfyDtlNmRus; //--분류_상세_명_러시아

    @Column(name = "CLSSFY_DTL_EXP", length = 4000, nullable = true)
    @Schema(description = "분류 상세 명 설명", nullable = true)
    private String clssfyDtlExp; //--분류_상세_명_설명

    @Builder
    public MCmncodeDtl(String clssfyDtlCode, String clssfyCode, String clssfyDtlNm, String clssfy1, String clssfy2, String clssfy3, String fstRegpersnId, String finalUptpersnId, Date fstRegTm, Date finalUptTm, String clssfyDtlNmKor, String clssfyDtlNmRus, String clssfyDtlExp) {
        this.clssfyDtlCode = clssfyDtlCode;
        this.clssfyCode = clssfyCode;
        this.clssfyDtlNm = clssfyDtlNm;
        this.clssfy1 = clssfy1;
        this.clssfy2 = clssfy2;
        this.clssfy3 = clssfy3;
        this.fstRegpersnId = fstRegpersnId;
        this.finalUptpersnId = finalUptpersnId;
        this.fstRegTm = fstRegTm;
        this.finalUptTm = finalUptTm;
        this.clssfyDtlNmKor = clssfyDtlNmKor;
        this.clssfyDtlNmRus = clssfyDtlNmRus;
        this.clssfyDtlExp = clssfyDtlExp;
    }
}
