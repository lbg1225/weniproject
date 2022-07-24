/**
 * SDispInfoTmp Entity 클래스
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

import com.weni.ecs.domain.listener.SDispInfoTmpListener;

@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED) // AccessLevel.PUBLIC
@Entity
@EntityListeners(SDispInfoTmpListener.class)
@Table(name = "S_DISP_INFO_TMP") //--출동_정보_TMP(Table)
@Schema(description = "출동 정보 TMP(Table)")
@IdClass(SDispInfoTmpPK.class)
public class SDispInfoTmp implements Serializable {
    @Id //  Integer
    @Column(name = "RECPT_NUM", nullable = false)
//    @Schema(description = "", nullable = true , defaultValue = "" , example = ""  , allowableValues = {"", ""})
    @Schema(description = "접수 번호(pk)", nullable = false)
    private Integer recptNum; //--접수_번호(pk)

    @Id //  Integer
    @Column(name = "DTL_SEQ_NUM", nullable = false)
    @Schema(description = "상세 순번(pk)", nullable = false)
    private Integer dtlSeqNum; //--상세_순번(pk)

    @Column(name = "DISP_CMD_TM", nullable = true)
    @Schema(description = "출동 지령 시간", nullable = true)
    private Date dispCmdTm; //--출동_지령_시간

    @Column(name = "DISP_STRT_TM", nullable = true)
    @Schema(description = "출동 시작 시간", nullable = true)
    private Date dispStrtTm; //--출동_시작_시간

    @Column(name = "DISP_CLOSE_TM", nullable = true)
    @Schema(description = "출동 종료 시간", nullable = true)
    private Date dispCloseTm; //--출동_종료_시간

    @Column(name = "MDT_DEV_ID", nullable = false)
    @Schema(description = "mdt 디바이스 id", nullable = false)
    private Integer mdtDevId; //--mdt_디바이스_id

    @Column(name = "DISP_PRCS_INSP_ID", length = 30, nullable = false)
    @Schema(description = "출동 처리 인스펙터 id", nullable = false)
    private String dispPrcsInspId; //--출동_처리_인스펙터_id

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
    public SDispInfoTmp(Integer recptNum, Integer dtlSeqNum, Date dispCmdTm, Date dispStrtTm, Date dispCloseTm, Integer mdtDevId, String dispPrcsInspId, String fstRegpersnId, String finalUptpersnId, Date fstRegTm, Date finalUptTm) {
        this.recptNum = recptNum;
        this.dtlSeqNum = dtlSeqNum;
        this.dispCmdTm = dispCmdTm;
        this.dispStrtTm = dispStrtTm;
        this.dispCloseTm = dispCloseTm;
        this.mdtDevId = mdtDevId;
        this.dispPrcsInspId = dispPrcsInspId;
        this.fstRegpersnId = fstRegpersnId;
        this.finalUptpersnId = finalUptpersnId;
        this.fstRegTm = fstRegTm;
        this.finalUptTm = finalUptTm;
    }
}
