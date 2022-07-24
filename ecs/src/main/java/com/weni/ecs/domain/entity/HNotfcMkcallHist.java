/**
 * HNotfcMkcallHist Entity 클래스
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

import com.weni.ecs.domain.listener.HNotfcMkcallHistListener;

@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED) // AccessLevel.PUBLIC
@Entity
@EntityListeners(HNotfcMkcallHistListener.class)
@Table(name = "H_NOTFC_MKCALL_HIST") //--알림_발신_이력(Table)
@Schema(description = "알림 발신 이력(Table)")
public class HNotfcMkcallHist implements Serializable {
    @Id //  Integer
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "MKCALL_SEQ_NUM", nullable = false)
//    @Schema(description = "", nullable = true , defaultValue = "" , example = ""  , allowableValues = {"", ""})
    @Schema(description = "발신 순번(pk)", nullable = false)
    private Integer mkcallSeqNum; //--발신_순번(pk)

    @Column(name = "SENDPERSN_ID", length = 30, nullable = false)
    @Schema(description = "전송자 id", nullable = false)
    private String sendpersnId; //--전송자_id

    @Column(name = "INCID_NUM", length = 60, nullable = true)
    @Schema(description = "사건 번호", nullable = true)
    private String incidNum; //--사건_번호

    @Column(name = "INCID_OVIEW", length = 4000, nullable = true)
    @Schema(description = "사건 개요", nullable = true)
    private String incidOview; //--사건_개요

    @Column(name = "INDIC_ITM", length = 4000, nullable = false)
    @Schema(description = "지시 사항", nullable = false)
    private String indicItm; //--지시_사항

    @Column(name = "SEND_TM", nullable = false)
    @Schema(description = "전송 시간", nullable = false)
    private Date sendTm; //--전송_시간

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
    public HNotfcMkcallHist(String sendpersnId, String incidNum, String incidOview, String indicItm, Date sendTm, String fstRegpersnId, String finalUptpersnId, Date fstRegTm, Date finalUptTm) {
        this.sendpersnId = sendpersnId;
        this.incidNum = incidNum;
        this.incidOview = incidOview;
        this.indicItm = indicItm;
        this.sendTm = sendTm;
        this.fstRegpersnId = fstRegpersnId;
        this.finalUptpersnId = finalUptpersnId;
        this.fstRegTm = fstRegTm;
        this.finalUptTm = finalUptTm;
    }
}
