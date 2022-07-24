/**
 * MCtry Entity 클래스
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

import com.weni.ecs.domain.listener.MCtryListener;

@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED) // AccessLevel.PUBLIC
@Entity
@EntityListeners(MCtryListener.class)
@Table(name = "M_CTRY") //--국가(Table)
@Schema(description = "국가(Table)")
public class MCtry implements Serializable {
    @Id //  String
    @Column(name = "CTRY_CODE_3", length = 3, nullable = false)
//    @Schema(description = "", nullable = true , defaultValue = "" , example = ""  , allowableValues = {"", ""})
    @Schema(description = "국가 코드 3(pk)", nullable = false)
    private String ctryCode3; //--국가_코드_3(pk)

    @Column(name = "CTRY_CODE_2", length = 2, nullable = true)
    @Schema(description = "국가 코드 2", nullable = true)
    private String ctryCode2; //--국가_코드_2

    @Column(name = "CTRY_NM", length = 100, nullable = true)
    @Schema(description = "국가 명", nullable = true)
    private String ctryNm; //--국가_명

    @Column(name = "CTRY_ABBR_NM", length = 100, nullable = true)
    @Schema(description = "국가 약어 명", nullable = true)
    private String ctryAbbrNm; //--국가_약어_명

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
    public MCtry(String ctryCode3, String ctryCode2, String ctryNm, String ctryAbbrNm, String fstRegpersnId, String finalUptpersnId, Date fstRegTm, Date finalUptTm) {
        this.ctryCode3 = ctryCode3;
        this.ctryCode2 = ctryCode2;
        this.ctryNm = ctryNm;
        this.ctryAbbrNm = ctryAbbrNm;
        this.fstRegpersnId = fstRegpersnId;
        this.finalUptpersnId = finalUptpersnId;
        this.fstRegTm = fstRegTm;
        this.finalUptTm = finalUptTm;
    }
}
