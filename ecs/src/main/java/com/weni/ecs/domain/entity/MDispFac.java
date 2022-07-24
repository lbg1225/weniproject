/**
 * MDispFac Entity 클래스
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

import com.weni.ecs.domain.listener.MDispFacListener;

@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED) // AccessLevel.PUBLIC
@Entity
@EntityListeners(MDispFacListener.class)
@Table(name = "M_DISP_FAC") //--출동_요소(Table)
@Schema(description = "출동 요소(Table)")
public class MDispFac implements Serializable {
    @Id //  Integer
    @Column(name = "MDT_DEV_ID", nullable = false)
//    @Schema(description = "", nullable = true , defaultValue = "" , example = ""  , allowableValues = {"", ""})
    @Schema(description = "mdt 디바이스 id(pk)", nullable = false)
    private Integer mdtDevId; //--mdt_디바이스_id(pk)

    @Column(name = "JURIS_CODE", length = 20, nullable = false)
    @Schema(description = "관할 코드", nullable = false)
    private String jurisCode; //--관할_코드

    @Column(name = "ICON", length = 200, nullable = false)
    @Schema(description = "icon", nullable = false)
    private String icon; //--icon

    @Column(name = "MDT_DEV_NM", length = 50, nullable = false)
    @Schema(description = "mdt 디바이스 명", nullable = false)
    private String mdtDevNm; //--mdt_디바이스_명

    @Column(name = "TRANSMIT_PRD", nullable = true)
    @Schema(description = "송출 주기", nullable = true)
    private Integer transmitPrd; //--송출_주기

    @Column(name = "CURR_EXIST_STT", length = 1, nullable = false)
    @Schema(description = "현재 존재 상태", nullable = false)
    private String currExistStt; //--현재_존재_상태

    @Column(name = "DEL_FLAG", length = 1, nullable = false)
    @Schema(description = "삭제 플래그", nullable = false)
    private String delFlag; //--삭제_플래그

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
    public MDispFac(Integer mdtDevId, String jurisCode, String icon, String mdtDevNm, Integer transmitPrd, String currExistStt, String delFlag, String fstRegpersnId, String finalUptpersnId, Date fstRegTm, Date finalUptTm) {
        this.mdtDevId = mdtDevId;
        this.jurisCode = jurisCode;
        this.icon = icon;
        this.mdtDevNm = mdtDevNm;
        this.transmitPrd = transmitPrd;
        this.currExistStt = currExistStt;
        this.delFlag = delFlag;
        this.fstRegpersnId = fstRegpersnId;
        this.finalUptpersnId = finalUptpersnId;
        this.fstRegTm = fstRegTm;
        this.finalUptTm = finalUptTm;
    }
}
