/**
 * JUsrGrpRelatdBusn Entity 클래스
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

import com.weni.ecs.domain.listener.JUsrGrpRelatdBusnListener;

@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED) // AccessLevel.PUBLIC
@Entity
@EntityListeners(JUsrGrpRelatdBusnListener.class)
@Table(name = "J_USR_GRP_RELATD_BUSN") //--사용자_그룹_관련_업무(Table)
@Schema(description = "사용자 그룹 관련 업무(Table)")
@IdClass(JUsrGrpRelatdBusnPK.class)
public class JUsrGrpRelatdBusn implements Serializable {
    @Id //  String
    @Column(name = "USR_GRP_ID", length = 50, nullable = false)
//    @Schema(description = "", nullable = true , defaultValue = "" , example = ""  , allowableValues = {"", ""})
    @Schema(description = "사용자 그룹 id(pk)", nullable = false)
    private String usrGrpId; //--사용자_그룹_id(pk)

    @Id //  String
    @Column(name = "BUSN", length = 20, nullable = false)
    @Schema(description = "업무(pk)", nullable = false)
    private String busn; //--업무(pk)

    @Column(name = "JURIS_FLAG", length = 1, nullable = false)
    @Schema(description = "관할 flag", nullable = false)
    private String jurisFlag; //--관할_flag

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
    public JUsrGrpRelatdBusn(String usrGrpId, String busn, String jurisFlag, String fstRegpersnId, String finalUptpersnId, Date fstRegTm, Date finalUptTm) {
        this.usrGrpId = usrGrpId;
        this.busn = busn;
        this.jurisFlag = jurisFlag;
        this.fstRegpersnId = fstRegpersnId;
        this.finalUptpersnId = finalUptpersnId;
        this.fstRegTm = fstRegTm;
        this.finalUptTm = finalUptTm;
    }
}
