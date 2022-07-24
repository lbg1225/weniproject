/**
 * HCallIfHist Entity 클래스
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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
// import javax.persistence.Temporal;
// import javax.persistence.TemporalType;
import javax.persistence.Table;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import com.weni.ecs.domain.listener.HCallIfHistListener;

@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED) // AccessLevel.PUBLIC
@Entity
@EntityListeners(HCallIfHistListener.class)
@Table(name = "H_CALL_IF_HIST") //--변경_이력(Table)
@Schema(description = "변경 이력(Table)")
public class HCallIfHist implements Serializable {
    @Id //  Integer
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "HIST_SEQ_NUM", nullable = false)
//    @Schema(description = "", nullable = true , defaultValue = "" , example = ""  , allowableValues = {"", ""})
    @Schema(description = "이력 순번(pk)", nullable = false)
    private Integer histSeqNum; //--이력_순번(pk)

    @Column(name = "PCALL_STRT_DAYTIME", nullable = true)
    @Schema(description = "통화 시작 일시", nullable = true)
    private Date pcallStrtDaytime; //--통화_시작_일시

    @Column(name = "PCALL_CLOSE_DAYTIME", nullable = true)
    @Schema(description = "통화 종료 일시", nullable = true)
    private Date pcallCloseDaytime; //--통화_종료_일시

    @Column(name = "PCALL_LEN", nullable = true)
    @Schema(description = "통화 길이", nullable = true)
    private Integer pcallLen; //--통화_길이

    @Column(name = "NUMBMKCALL_YN", length = 1, nullable = true)
    @Schema(description = "수발신 여부", nullable = true)
    private String numbmkcallYn; //--수발신_여부

    @Column(name = "FAM_NM", length = 100, nullable = true)
    @Schema(description = "성", nullable = true)
    private String famNm; //--성

    @Column(name = "GIV_NM", length = 100, nullable = true)
    @Schema(description = "이름", nullable = true)
    private String givNm; //--이름

    @Column(name = "CTI_USR_ID", length = 30, nullable = true)
    @Schema(description = "cti 사용자 id", nullable = true)
    private String ctiUsrId; //--cti_사용자_id

    @Column(name = "CALL_ID", length = 20, nullable = true)
    @Schema(description = "콜 id", nullable = true)
    private String callId; //--콜_id

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
    public HCallIfHist(Date pcallStrtDaytime, Date pcallCloseDaytime, Integer pcallLen, String numbmkcallYn, String famNm, String givNm, String ctiUsrId, String callId, String fstRegpersnId, String finalUptpersnId, Date fstRegTm, Date finalUptTm) {
        this.pcallStrtDaytime = pcallStrtDaytime;
        this.pcallCloseDaytime = pcallCloseDaytime;
        this.pcallLen = pcallLen;
        this.numbmkcallYn = numbmkcallYn;
        this.famNm = famNm;
        this.givNm = givNm;
        this.ctiUsrId = ctiUsrId;
        this.callId = callId;
        this.fstRegpersnId = fstRegpersnId;
        this.finalUptpersnId = finalUptpersnId;
        this.fstRegTm = fstRegTm;
        this.finalUptTm = finalUptTm;
    }
}
