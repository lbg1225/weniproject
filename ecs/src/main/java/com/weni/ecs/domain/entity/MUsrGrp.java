/**
 * MUsrGrp Entity 클래스
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

import com.weni.ecs.domain.listener.MUsrGrpListener;

@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED) // AccessLevel.PUBLIC
@Entity
@EntityListeners(MUsrGrpListener.class)
@Table(name = "M_USR_GRP") //--사용자_그룹(Table)
@Schema(description = "사용자 그룹(Table)")
public class MUsrGrp implements Serializable {
    @Id //  String
    @Column(name = "USR_GRP_ID", length = 50, nullable = false)
//    @Schema(description = "", nullable = true , defaultValue = "" , example = ""  , allowableValues = {"", ""})
    @Schema(description = "사용자 그룹 id(pk)", nullable = false)
    private String usrGrpId; //--사용자_그룹_id(pk)

    @Column(name = "USR_GRP_NM", length = 100, nullable = true)
    @Schema(description = "사용자그룹 명", nullable = true)
    private String usrGrpNm; //--사용자그룹_명

    @Column(name = "USR_GRP_NM_KOR", length = 100, nullable = true)
    @Schema(description = "사용자그룹 명 한국", nullable = true)
    private String usrGrpNmKor; //--사용자그룹_명_한국

    @Column(name = "USR_GRP_NM_RUS", length = 100, nullable = true)
    @Schema(description = "사용자그룹 명 러시아", nullable = true)
    private String usrGrpNmRus; //--사용자그룹_명_러시아

    @Column(name = "BUSN_FLAG", length = 1, nullable = true)
    @Schema(description = "업무 플래그", nullable = true)
    private String busnFlag; //--업무_플래그

    @Column(name = "NOTFC_FLAG", length = 1, nullable = true)
    @Schema(description = "알림 플래그", nullable = true)
    private String notfcFlag; //--알림_플래그

    @Column(name = "QTY_SEQ", nullable = true)
    @Schema(description = "조회 순서", nullable = true)
    private Integer qtySeq; //--조회_순서

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
    public MUsrGrp(String usrGrpId, String usrGrpNm, String usrGrpNmKor, String usrGrpNmRus, String busnFlag, String notfcFlag, Integer qtySeq, String fstRegpersnId, String finalUptpersnId, Date fstRegTm, Date finalUptTm) {
        this.usrGrpId = usrGrpId;
        this.usrGrpNm = usrGrpNm;
        this.usrGrpNmKor = usrGrpNmKor;
        this.usrGrpNmRus = usrGrpNmRus;
        this.busnFlag = busnFlag;
        this.notfcFlag = notfcFlag;
        this.qtySeq = qtySeq;
        this.fstRegpersnId = fstRegpersnId;
        this.finalUptpersnId = finalUptpersnId;
        this.fstRegTm = fstRegTm;
        this.finalUptTm = finalUptTm;
    }
}
