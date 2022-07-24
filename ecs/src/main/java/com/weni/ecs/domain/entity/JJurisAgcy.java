/**
 * JJurisAgcy Entity 클래스
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

import com.weni.ecs.domain.listener.JJurisAgcyListener;

@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED) // AccessLevel.PUBLIC
@Entity
@EntityListeners(JJurisAgcyListener.class)
@Table(name = "J_JURIS_AGCY") //--관할_기관(Table)
@Schema(description = "관할 기관(Table)")
@IdClass(JJurisAgcyPK.class)
public class JJurisAgcy implements Serializable {
    @Column(name = "FST_REGPERSN_ID", length = 30, nullable = true)
//    @Schema(description = "", nullable = true , defaultValue = "" , example = ""  , allowableValues = {"", ""})
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

    @Id //  String
    @Column(name = "JURIS_CODE", length = 20, nullable = false)
    @Schema(description = "관할 코드(pk)", nullable = false)
    private String jurisCode; //--관할_코드(pk)

    @Id //  String
    @Column(name = "JURIS_MNG_CODE", length = 20, nullable = false)
    @Schema(description = "관할 관리 코드(pk)", nullable = false)
    private String jurisMngCode; //--관할_관리_코드(pk)

    @Builder
    public JJurisAgcy(String fstRegpersnId, String finalUptpersnId, Date fstRegTm, Date finalUptTm, String jurisCode, String jurisMngCode) {
        this.fstRegpersnId = fstRegpersnId;
        this.finalUptpersnId = finalUptpersnId;
        this.fstRegTm = fstRegTm;
        this.finalUptTm = finalUptTm;
        this.jurisCode = jurisCode;
        this.jurisMngCode = jurisMngCode;
    }
}
