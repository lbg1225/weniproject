/**
 * IExtnIfSckt Entity 클래스
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

import com.weni.ecs.domain.listener.IExtnIfScktListener;

@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED) // AccessLevel.PUBLIC
@Entity
@EntityListeners(IExtnIfScktListener.class)
@Table(name = "I_EXTN_IF_SCKT") //--외부_인터페이스_소켓(Table)
@Schema(description = "외부 인터페이스 소켓(Table)")
public class IExtnIfSckt implements Serializable {
    @Id //  String
    @Column(name = "SER_NUM", length = 20, nullable = true)
//    @Schema(description = "", nullable = true , defaultValue = "" , example = ""  , allowableValues = {"", ""})
    @Schema(description = "일련번호(pk)", nullable = true)
    private String serNum; //--일련번호(pk)

    @Column(name = "REQ_ID", length = 30, nullable = true)
    @Schema(description = "요청 id", nullable = true)
    private String reqId; //--요청_id

    @Column(name = "PROXY_TYPE", length = 10, nullable = true)
    @Schema(description = "프록시 유형", nullable = true)
    private String proxyType; //--프록시_유형

    @Column(name = "HOST", length = 20, nullable = true)
    @Schema(description = "호스트", nullable = true)
    private String host; //--호스트

    @Column(name = "PORT", nullable = true)
    @Schema(description = "포트", nullable = true)
    private Integer port; //--포트

    @Column(name = "SEND_MSG", length = 4000, nullable = true)
    @Schema(description = "전송 메시지", nullable = true)
    private String sendMsg; //--전송_메시지

    @Column(name = "SYNC_YN", nullable = true)
    @Schema(description = "동기 여부", nullable = true)
    private Boolean syncYn; //--동기_여부

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
    public IExtnIfSckt(String serNum, String reqId, String proxyType, String host, Integer port, String sendMsg, Boolean syncYn, String fstRegpersnId, String finalUptpersnId, Date fstRegTm, Date finalUptTm) {
        this.serNum = serNum;
        this.reqId = reqId;
        this.proxyType = proxyType;
        this.host = host;
        this.port = port;
        this.sendMsg = sendMsg;
        this.syncYn = syncYn;
        this.fstRegpersnId = fstRegpersnId;
        this.finalUptpersnId = finalUptpersnId;
        this.fstRegTm = fstRegTm;
        this.finalUptTm = finalUptTm;
    }
}
