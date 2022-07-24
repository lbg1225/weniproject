/**
 * MBtnRole Entity 클래스
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

import com.weni.ecs.domain.listener.MBtnRoleListener;

@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED) // AccessLevel.PUBLIC
@Entity
@EntityListeners(MBtnRoleListener.class)
@Table(name = "M_BTN_ROLE") //--버튼_권한(Table)
@Schema(description = "버튼 권한(Table)")
public class MBtnRole implements Serializable {
    @Id //  String
    @Column(name = "BTN_ROLE_CODE", length = 20, nullable = false)
//    @Schema(description = "", nullable = true , defaultValue = "" , example = ""  , allowableValues = {"", ""})
    @Schema(description = "버튼 권한 코드(pk)", nullable = false)
    private String btnRoleCode; //--버튼_권한_코드(pk)

    @Column(name = "BTN_ROLE_NM", length = 100, nullable = false)
    @Schema(description = "버튼 권한 명", nullable = false)
    private String btnRoleNm; //--버튼_권한_명

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

    @Column(name = "BTN_ROLE_NM_RUS", length = 100, nullable = false)
    @Schema(description = "버튼 권한 명 러시아", nullable = false)
    private String btnRoleNmRus; //--버튼_권한_명_러시아

    @Column(name = "BTN_ROLE_NM_KOR", length = 100, nullable = false)
    @Schema(description = "버튼 권한 명 한국", nullable = false)
    private String btnRoleNmKor; //--버튼_권한_명_한국

    @Builder
    public MBtnRole(String btnRoleCode, String btnRoleNm, String delFlag, String fstRegpersnId, String finalUptpersnId, Date fstRegTm, Date finalUptTm, String btnRoleNmRus, String btnRoleNmKor) {
        this.btnRoleCode = btnRoleCode;
        this.btnRoleNm = btnRoleNm;
        this.delFlag = delFlag;
        this.fstRegpersnId = fstRegpersnId;
        this.finalUptpersnId = finalUptpersnId;
        this.fstRegTm = fstRegTm;
        this.finalUptTm = finalUptTm;
        this.btnRoleNmRus = btnRoleNmRus;
        this.btnRoleNmKor = btnRoleNmKor;
    }
}
