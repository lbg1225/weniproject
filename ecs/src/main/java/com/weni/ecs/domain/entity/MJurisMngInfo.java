/**
 * MJurisMngInfo Entity 클래스
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

import com.weni.ecs.domain.listener.MJurisMngInfoListener;

@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED) // AccessLevel.PUBLIC
@Entity
@EntityListeners(MJurisMngInfoListener.class)
@Table(name = "M_JURIS_MNG_INFO") //--관할_관리_정보(Table)
@Schema(description = "관할 관리 정보(Table)")
public class MJurisMngInfo implements Serializable {
    @Id //  String
    @Column(name = "JURIS_MNG_CODE", length = 20, nullable = false)
//    @Schema(description = "", nullable = true , defaultValue = "" , example = ""  , allowableValues = {"", ""})
    @Schema(description = "관할 관리 코드(pk)", nullable = false)
    private String jurisMngCode; //--관할_관리_코드(pk)

    @Column(name = "JURIS_MNG_NM", length = 300, nullable = true)
    @Schema(description = "관할 관리 명", nullable = true)
    private String jurisMngNm; //--관할_관리_명

    @Column(name = "JURIS_MNG_NM_KOR", length = 300, nullable = true)
    @Schema(description = "관할 관리 명 한국", nullable = true)
    private String jurisMngNmKor; //--관할_관리_명_한국

    @Column(name = "JURIS_MNG_NM_RUS", length = 300, nullable = true)
    @Schema(description = "관할 관리 명 러시아", nullable = true)
    private String jurisMngNmRus; //--관할_관리_명_러시아

    @Column(name = "JURIS_MNG_ABBR_NM", length = 20, nullable = true)
    @Schema(description = "관할 관리 약명", nullable = true)
    private String jurisMngAbbrNm; //--관할_관리_약명

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
    public MJurisMngInfo(String jurisMngCode, String jurisMngNm, String jurisMngNmKor, String jurisMngNmRus, String jurisMngAbbrNm, String fstRegpersnId, String finalUptpersnId, Date fstRegTm, Date finalUptTm) {
        this.jurisMngCode = jurisMngCode;
        this.jurisMngNm = jurisMngNm;
        this.jurisMngNmKor = jurisMngNmKor;
        this.jurisMngNmRus = jurisMngNmRus;
        this.jurisMngAbbrNm = jurisMngAbbrNm;
        this.fstRegpersnId = fstRegpersnId;
        this.finalUptpersnId = finalUptpersnId;
        this.fstRegTm = fstRegTm;
        this.finalUptTm = finalUptTm;
    }
}
