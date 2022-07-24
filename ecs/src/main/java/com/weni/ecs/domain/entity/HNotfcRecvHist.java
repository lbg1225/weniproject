/**
 * HNotfcRecvHist Entity 클래스
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

import com.weni.ecs.domain.listener.HNotfcRecvHistListener;

@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED) // AccessLevel.PUBLIC
@Entity
@EntityListeners(HNotfcRecvHistListener.class)
@Table(name = "H_NOTFC_RECV_HIST") //--알림_수신_이력(Table)
@Schema(description = "알림 수신 이력(Table)")
@IdClass(HNotfcRecvHistPK.class)
public class HNotfcRecvHist implements Serializable {
    @Id //  Integer
    @Column(name = "MKCALL_SEQ_NUM", nullable = false)
//    @Schema(description = "", nullable = true , defaultValue = "" , example = ""  , allowableValues = {"", ""})
    @Schema(description = "발신 순번(pk)", nullable = false)
    private Integer mkcallSeqNum; //--발신_순번(pk)

    @Id //  String
    @Column(name = "USR_ID", length = 30, nullable = false)
    @Schema(description = "사용자 id(pk)", nullable = false)
    private String usrId; //--사용자_id(pk)

    @Column(name = "RECV_TM", nullable = true)
    @Schema(description = "수신 시간", nullable = true)
    private Date recvTm; //--수신_시간

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
    public HNotfcRecvHist(Integer mkcallSeqNum, String usrId, Date recvTm, String fstRegpersnId, String finalUptpersnId, Date fstRegTm, Date finalUptTm) {
        this.mkcallSeqNum = mkcallSeqNum;
        this.usrId = usrId;
        this.recvTm = recvTm;
        this.fstRegpersnId = fstRegpersnId;
        this.finalUptpersnId = finalUptpersnId;
        this.fstRegTm = fstRegTm;
        this.finalUptTm = finalUptTm;
    }
}
