/**
 * MClssfyCodeGetNum Entity 클래스
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

import com.weni.ecs.domain.listener.MClssfyCodeGetNumListener;

@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED) // AccessLevel.PUBLIC
@Entity
@EntityListeners(MClssfyCodeGetNumListener.class)
@Table(name = "M_CLSSFY_CODE_GET_NUM") //--분류_코드_채번(Table)
@Schema(description = "분류 코드 채번(Table)")
public class MClssfyCodeGetNum implements Serializable {
    @Id //  String
    @Column(name = "GET_NUM_CODE", length = 20, nullable = false)
//    @Schema(description = "", nullable = true , defaultValue = "" , example = ""  , allowableValues = {"", ""})
    @Schema(description = "채번 코드(pk)", nullable = false)
    private String getNumCode; //--채번_코드(pk)

    @Column(name = "JURIS_MNG_CODE", length = 20, nullable = true)
    @Schema(description = "관할 관리 코드", nullable = true)
    private String jurisMngCode; //--관할_관리_코드

    @Column(name = "MNG_JNL_CLSSFY_CODE", length = 30, nullable = true)
    @Schema(description = "관리 대장 분류 코드", nullable = true)
    private String mngJnlClssfyCode; //--관리_대장_분류_코드

    @Column(name = "ETC_INCID_MNG_CODE", length = 30, nullable = true)
    @Schema(description = "기타 사건 관리 코그", nullable = true)
    private String etcIncidMngCode; //--기타_사건_관리_코그

    @Column(name = "FINAL_MNG_JNL_NUM", length = 40, nullable = true)
    @Schema(description = "최종 관리 대장 번호", nullable = true)
    private String finalMngJnlNum; //--최종_관리_대장_번호

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
    public MClssfyCodeGetNum(String getNumCode, String jurisMngCode, String mngJnlClssfyCode, String etcIncidMngCode, String finalMngJnlNum, String fstRegpersnId, String finalUptpersnId, Date fstRegTm, Date finalUptTm) {
        this.getNumCode = getNumCode;
        this.jurisMngCode = jurisMngCode;
        this.mngJnlClssfyCode = mngJnlClssfyCode;
        this.etcIncidMngCode = etcIncidMngCode;
        this.finalMngJnlNum = finalMngJnlNum;
        this.fstRegpersnId = fstRegpersnId;
        this.finalUptpersnId = finalUptpersnId;
        this.fstRegTm = fstRegTm;
        this.finalUptTm = finalUptTm;
    }
}
