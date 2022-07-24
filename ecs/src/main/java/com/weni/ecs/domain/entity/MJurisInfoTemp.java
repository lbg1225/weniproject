/**
 * MJurisInfoTemp Entity 클래스
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

import com.weni.ecs.domain.listener.MJurisInfoTempListener;

@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED) // AccessLevel.PUBLIC
@Entity
@EntityListeners(MJurisInfoTempListener.class)
@Table(name = "M_JURIS_INFO_TEMP") //--관할_정보_TMP(Table)
@Schema(description = "관할 정보 TMP(Table)")
public class MJurisInfoTemp implements Serializable {
    @Id //  String
    @Column(name = "JURIS_CODE", length = 20, nullable = false)
//    @Schema(description = "", nullable = true , defaultValue = "" , example = ""  , allowableValues = {"", ""})
    @Schema(description = "관할 코드(pk)", nullable = false)
    private String jurisCode; //--관할_코드(pk)

    @Column(name = "JURIS_NM", length = 300, nullable = true)
    @Schema(description = "관할 명", nullable = true)
    private String jurisNm; //--관할_명

    @Column(name = "BUSN", length = 20, nullable = true)
    @Schema(description = "업무", nullable = true)
    private String busn; //--업무

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

    @Column(name = "JURIS_NM_KOR", length = 300, nullable = true)
    @Schema(description = "관할 명 한국", nullable = true)
    private String jurisNmKor; //--관할_명_한국

    @Column(name = "JURIS_NM_RUS", length = 300, nullable = true)
    @Schema(description = "관할 명 러시아", nullable = true)
    private String jurisNmRus; //--관할_명_러시아

    @Column(name = "LGT", nullable = true)
    @Schema(description = "경도", nullable = true)
    private Float lgt; //--경도

    @Column(name = "LTT", nullable = true)
    @Schema(description = "위도", nullable = true)
    private Float ltt; //--위도

    @Builder
    public MJurisInfoTemp(String jurisCode, String jurisNm, String busn, String fstRegpersnId, String finalUptpersnId, Date fstRegTm, Date finalUptTm, String jurisNmKor, String jurisNmRus, Float lgt, Float ltt) {
        this.jurisCode = jurisCode;
        this.jurisNm = jurisNm;
        this.busn = busn;
        this.fstRegpersnId = fstRegpersnId;
        this.finalUptpersnId = finalUptpersnId;
        this.fstRegTm = fstRegTm;
        this.finalUptTm = finalUptTm;
        this.jurisNmKor = jurisNmKor;
        this.jurisNmRus = jurisNmRus;
        this.lgt = lgt;
        this.ltt = ltt;
    }
}
