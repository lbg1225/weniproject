/**
 * MLabl Entity 클래스
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

import com.weni.ecs.domain.listener.MLablListener;

@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED) // AccessLevel.PUBLIC
@Entity
@EntityListeners(MLablListener.class)
@Table(name = "M_LABL") //--라벨(Table)
@Schema(description = "라벨(Table)")
public class MLabl implements Serializable {
    @Id //  String
    @Column(name = "ID", length = 50, nullable = false)
//    @Schema(description = "", nullable = true , defaultValue = "" , example = ""  , allowableValues = {"", ""})
    @Schema(description = "id(pk)", nullable = false)
    private String id; //--id(pk)

    @Column(name = "GRP_LABL_ID", length = 20, nullable = true)
    @Schema(description = "그룹 라벨 id", nullable = true)
    private String grpLablId; //--그룹_라벨_id

    @Column(name = "LABL_ID", length = 20, nullable = false)
    @Schema(description = "라벨 id", nullable = false)
    private String lablId; //--라벨_id

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
    public MLabl(String id, String grpLablId, String lablId, String fstRegpersnId, String finalUptpersnId, Date fstRegTm, Date finalUptTm) {
        this.id = id;
        this.grpLablId = grpLablId;
        this.lablId = lablId;
        this.fstRegpersnId = fstRegpersnId;
        this.finalUptpersnId = finalUptpersnId;
        this.fstRegTm = fstRegTm;
        this.finalUptTm = finalUptTm;
    }
}
