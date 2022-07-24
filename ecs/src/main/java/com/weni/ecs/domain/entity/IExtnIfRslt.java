/**
 * IExtnIfRslt Entity 클래스
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

import com.weni.ecs.domain.listener.IExtnIfRsltListener;

@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED) // AccessLevel.PUBLIC
@Entity
@EntityListeners(IExtnIfRsltListener.class)
@Table(name = "I_EXTN_IF_RSLT") //--외부_인터페이스_결과(Table)
@Schema(description = "외부 인터페이스 결과(Table)")
public class IExtnIfRslt implements Serializable {
    @Id //  String
    @Column(name = "REQ_ID", length = 30, nullable = false)
//    @Schema(description = "", nullable = true , defaultValue = "" , example = ""  , allowableValues = {"", ""})
    @Schema(description = "요청 id(pk)", nullable = false)
    private String reqId; //--요청_id(pk)

    @Column(name = "REQ_INFO", length = 4000, nullable = true)
    @Schema(description = "요청 정보", nullable = true)
    private String reqInfo; //--요청_정보

    @Column(name = "REQ_TM", length = 30, nullable = true)
    @Schema(description = "요청 시간", nullable = true)
    private String reqTm; //--요청_시간

    @Column(name = "RSLT_MSG", length = 4000, nullable = true)
    @Schema(description = "결과 메시지", nullable = true)
    private String rsltMsg; //--결과_메시지

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
    public IExtnIfRslt(String reqId, String reqInfo, String reqTm, String rsltMsg, String fstRegpersnId, String finalUptpersnId, Date fstRegTm, Date finalUptTm) {
        this.reqId = reqId;
        this.reqInfo = reqInfo;
        this.reqTm = reqTm;
        this.rsltMsg = rsltMsg;
        this.fstRegpersnId = fstRegpersnId;
        this.finalUptpersnId = finalUptpersnId;
        this.fstRegTm = fstRegTm;
        this.finalUptTm = finalUptTm;
    }
}
