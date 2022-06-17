package com.weni.ecs.dto;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;

import lombok.Builder;
import lombok.Data;

@Data
public class MCmncodeDtlMCmncode  implements Serializable  {
    @Column(name = "CLSSFY_DTL_CODE", nullable = false)
    private String clssfyDtlCode;

    @Column(name = "CLSSFY_CODE", nullable = false)
    private String clssfyCode;

    @Column(name = "CLSSFY_DTL_NM", nullable = true)
    private String clssfyDtlNm;

    @Column(name = "CLSSFY_1", nullable = true)
    private String clssfy_1;

    @Column(name = "CLSSFY_2", nullable = true)
    private String clssfy_2;

    @Column(name = "CLSSFY_3", nullable = true)
    private String clssfy_3;

    @Column(name = "FST_REGPERSN_ID", nullable = true)
    private String fstRegpersnId;

    @Column(name = "FINAL_UPTPERSN_ID", nullable = true)
    private String finalUptpersnId;

    @Column(name = "FST_REG_TM", nullable = true)
    private Date fstRegTm;

    @Column(name = "FINAL_UPT_TM", nullable = true)
    private Date finalUptTm;

    @Column(name = "CLSSFY_DTL_NM_KOR", nullable = true)
    private String clssfyDtlNmKor;

    @Column(name = "CLSSFY_DTL_NM_RUS", nullable = true)
    private String clssfyDtlNmRus;

    @Column(name = "CLSSFY_DTL_EXP", nullable = true)
    private String clssfyDtlExp;

//    private String clssfyNm;
    @Column(name = "CLSSFY_NM_KOR", nullable = true)
    private String clssfyNmKor;
 //   private String clssfyNmRus;

    @Builder
    public MCmncodeDtlMCmncode(String clssfyDtlCode, String clssfyCode, String clssfyDtlNm, String clssfy_1,
            String clssfy_2, String clssfy_3, String fstRegpersnId, String finalUptpersnId, Date fstRegTm,
            Date finalUptTm, String clssfyDtlNmKor, String clssfyDtlNmRus, String clssfyDtlExp, String clssfyNmKor) {
        this.clssfyDtlCode = clssfyDtlCode;
        this.clssfyCode = clssfyCode;
        this.clssfyDtlNm = clssfyDtlNm;
        this.clssfy_1 = clssfy_1;
        this.clssfy_2 = clssfy_2;
        this.clssfy_3 = clssfy_3;
        this.fstRegpersnId = fstRegpersnId;
        this.finalUptpersnId = finalUptpersnId;
        this.fstRegTm = fstRegTm;
        this.finalUptTm = finalUptTm;
        this.clssfyDtlNmKor = clssfyDtlNmKor;
        this.clssfyDtlNmRus = clssfyDtlNmRus;
        this.clssfyDtlExp = clssfyDtlExp;
        this.clssfyNmKor = clssfyNmKor;
    }

}
