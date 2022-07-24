/**
 * HSmsMkcallInfo Entity 클래스
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

import com.weni.ecs.domain.listener.HSmsMkcallInfoListener;

@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED) // AccessLevel.PUBLIC
@Entity
@EntityListeners(HSmsMkcallInfoListener.class)
@Table(name = "H_SMS_MKCALL_INFO") //--SMS_발신_이력(Table)
@Schema(description = "SMS 발신 이력(Table)")
public class HSmsMkcallInfo implements Serializable {
    @Id //  Integer
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "MKCALL_SEQ_NUM", nullable = false)
//    @Schema(description = "", nullable = true , defaultValue = "" , example = ""  , allowableValues = {"", ""})
    @Schema(description = "발신 순번(pk)", nullable = false)
    private Integer mkcallSeqNum; //--발신_순번(pk)

    @Column(name = "MDT_DEV_ID", nullable = false)
    @Schema(description = "mdt 디바이스 id", nullable = false)
    private Integer mdtDevId; //--mdt_디바이스_id

    @Column(name = "MSG_NUM", nullable = true)
    @Schema(description = "메시지 번호", nullable = true)
    private Byte msgNum; //--메시지_번호

    @Column(name = "INDIC_ITM", length = 140, nullable = false)
    @Schema(description = "지시 사항", nullable = false)
    private String indicItm; //--지시_사항

    @Column(name = "CALLER_ID", length = 30, nullable = false)
    @Schema(description = "발신자id", nullable = false)
    private String callerId; //--발신자id

    @Column(name = "RECPT_TM", nullable = false)
    @Schema(description = "접수 시간", nullable = false)
    private Date recptTm; //--접수_시간

    @Column(name = "MKCALL_TM", nullable = true)
    @Schema(description = "발신 시간", nullable = true)
    private Date mkcallTm; //--발신_시간

    @Column(name = "RECV_TM", nullable = true)
    @Schema(description = "수신 시간", nullable = true)
    private Date recvTm; //--수신_시간

    @Column(name = "CFM_TM", nullable = true)
    @Schema(description = "확인 시간", nullable = true)
    private Date cfmTm; //--확인_시간

    @Column(name = "MKCALL_STT", length = 1, nullable = false)
    @Schema(description = "발신 상태", nullable = false)
    private String mkcallStt; //--발신_상태

    @Column(name = "SEND_RSLT", length = 200, nullable = true)
    @Schema(description = "전송 결과", nullable = true)
    private String sendRslt; //--전송_결과

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
    public HSmsMkcallInfo(Integer mdtDevId, Byte msgNum, String indicItm, String callerId, Date recptTm, Date mkcallTm, Date recvTm, Date cfmTm, String mkcallStt, String sendRslt, String fstRegpersnId, String finalUptpersnId, Date fstRegTm, Date finalUptTm) {
        this.mdtDevId = mdtDevId;
        this.msgNum = msgNum;
        this.indicItm = indicItm;
        this.callerId = callerId;
        this.recptTm = recptTm;
        this.mkcallTm = mkcallTm;
        this.recvTm = recvTm;
        this.cfmTm = cfmTm;
        this.mkcallStt = mkcallStt;
        this.sendRslt = sendRslt;
        this.fstRegpersnId = fstRegpersnId;
        this.finalUptpersnId = finalUptpersnId;
        this.fstRegTm = fstRegTm;
        this.finalUptTm = finalUptTm;
    }
}
