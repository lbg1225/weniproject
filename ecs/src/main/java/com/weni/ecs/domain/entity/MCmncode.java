/**
 * MCmncode Entity 클래스
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

import com.weni.ecs.domain.listener.MCmncodeListener;

@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED) // AccessLevel.PUBLIC
@Entity
@EntityListeners(MCmncodeListener.class)
@Table(name = "M_CMNCODE") //--공통_코드(Table)
@Schema(description = "공통 코드(Table)")
public class MCmncode implements Serializable {
    @Id //  String
    @Column(name = "CLSSFY_CODE", length = 20, nullable = false)
//    @Schema(description = "", nullable = true , defaultValue = "" , example = ""  , allowableValues = {"", ""})
    @Schema(description = "분류 코드(pk)", nullable = false)
    private String clssfyCode; //--분류_코드(pk)

    @Column(name = "CLSSFY_NM", length = 100, nullable = true)
    @Schema(description = "분류 코드 명", nullable = true)
    private String clssfyNm; //--분류_코드_명

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

    @Column(name = "CLSSFY_NM_KOR", length = 100, nullable = true)
    @Schema(description = "분류 코드 명 한국", nullable = true)
    private String clssfyNmKor; //--분류_코드_명_한국

    @Column(name = "CLSSFY_NM_RUS", length = 100, nullable = true)
    @Schema(description = "분류 코드 명 러시아", nullable = true)
    private String clssfyNmRus; //--분류_코드_명_러시아

    @Builder
    public MCmncode(String clssfyCode, String clssfyNm, String fstRegpersnId, String finalUptpersnId, Date fstRegTm, Date finalUptTm, String clssfyNmKor, String clssfyNmRus) {
        this.clssfyCode = clssfyCode;
        this.clssfyNm = clssfyNm;
        this.fstRegpersnId = fstRegpersnId;
        this.finalUptpersnId = finalUptpersnId;
        this.fstRegTm = fstRegTm;
        this.finalUptTm = finalUptTm;
        this.clssfyNmKor = clssfyNmKor;
        this.clssfyNmRus = clssfyNmRus;
    }
}
