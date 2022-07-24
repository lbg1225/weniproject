/**
 * IDispFacHist Entity 클래스
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

import com.weni.ecs.domain.listener.IDispFacHistListener;

@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED) // AccessLevel.PUBLIC
@Entity
@EntityListeners(IDispFacHistListener.class)
@Table(name = "I_DISP_FAC_HIST") //--출동_요소_이력(Table)
@Schema(description = "출동 요소 이력(Table)")
@IdClass(IDispFacHistPK.class)
public class IDispFacHist implements Serializable {
    @Id //  Integer
    @Column(name = "MDT_DEV_ID", nullable = false)
//    @Schema(description = "", nullable = true , defaultValue = "" , example = ""  , allowableValues = {"", ""})
    @Schema(description = "mdt 디바이스 id(pk)", nullable = false)
    private Integer mdtDevId; //--mdt_디바이스_id(pk)

    @Id //  Date
    @Column(name = "COLL_TM", nullable = false)
    @Schema(description = "수집시간(pk)", nullable = false)
    private Date collTm; //--수집시간(pk)

    @Column(name = "LGT", nullable = true)
    @Schema(description = "경도", nullable = true)
    private Float lgt; //--경도

    @Column(name = "LTT", nullable = true)
    @Schema(description = "위도", nullable = true)
    private Float ltt; //--위도

    @Column(name = "STT", length = 1, nullable = true)
    @Schema(description = "상태", nullable = true)
    private String stt; //--상태

    @Column(name = "TRANSMIT_PRD", nullable = true)
    @Schema(description = "송출 주기", nullable = true)
    private Integer transmitPrd; //--송출_주기

    @Column(name = "JURIS_CODE", length = 20, nullable = true)
    @Schema(description = "관할 코드", nullable = true)
    private String jurisCode; //--관할_코드

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
    public IDispFacHist(Integer mdtDevId, Date collTm, Float lgt, Float ltt, String stt, Integer transmitPrd, String jurisCode, String fstRegpersnId, String finalUptpersnId, Date fstRegTm, Date finalUptTm) {
        this.mdtDevId = mdtDevId;
        this.collTm = collTm;
        this.lgt = lgt;
        this.ltt = ltt;
        this.stt = stt;
        this.transmitPrd = transmitPrd;
        this.jurisCode = jurisCode;
        this.fstRegpersnId = fstRegpersnId;
        this.finalUptpersnId = finalUptpersnId;
        this.fstRegTm = fstRegTm;
        this.finalUptTm = finalUptTm;
    }
}
