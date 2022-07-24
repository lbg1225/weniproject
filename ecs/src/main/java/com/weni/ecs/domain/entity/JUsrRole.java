/**
 * JUsrRole Entity 클래스
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

import com.weni.ecs.domain.listener.JUsrRoleListener;

@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED) // AccessLevel.PUBLIC
@Entity
@EntityListeners(JUsrRoleListener.class)
@Table(name = "J_USR_ROLE") //--사용자_권한(Table)
@Schema(description = "사용자 권한(Table)")
@IdClass(JUsrRolePK.class)
public class JUsrRole implements Serializable {
    @Column(name = "FST_REGPERSN_ID", length = 30, nullable = true)
//    @Schema(description = "", nullable = true , defaultValue = "" , example = ""  , allowableValues = {"", ""})
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

    @Id //  String
    @Column(name = "ROLE_CODE", length = 20, nullable = false)
    @Schema(description = "권한 코드(pk)", nullable = false)
    private String roleCode; //--권한_코드(pk)

    @Column(name = "EDIT_CODE", length = 20, nullable = true)
    @Schema(description = "편집 코드", nullable = true)
    private String editCode; //--편집_코드

    @Id //  String
    @Column(name = "ROLE_KND", length = 20, nullable = false)
    @Schema(description = "권한 종류(pk)", nullable = false)
    private String roleKnd; //--권한_종류(pk)

    @Id //  String
    @Column(name = "USR_ID", length = 30, nullable = false)
    @Schema(description = "사용자 id(pk)", nullable = false)
    private String usrId; //--사용자_id(pk)

    @Builder
    public JUsrRole(String fstRegpersnId, String finalUptpersnId, Date fstRegTm, Date finalUptTm, String roleCode, String editCode, String roleKnd, String usrId) {
        this.fstRegpersnId = fstRegpersnId;
        this.finalUptpersnId = finalUptpersnId;
        this.fstRegTm = fstRegTm;
        this.finalUptTm = finalUptTm;
        this.roleCode = roleCode;
        this.editCode = editCode;
        this.roleKnd = roleKnd;
        this.usrId = usrId;
    }
}
