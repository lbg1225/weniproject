/**
 * HChangeHist Entity 클래스
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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
// import javax.persistence.Temporal;
// import javax.persistence.TemporalType;
import javax.persistence.Table;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import com.weni.ecs.domain.listener.HChangeHistListener;

@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED) // AccessLevel.PUBLIC
@Entity
@EntityListeners(HChangeHistListener.class)
@Table(name = "H_CHANGE_HIST") //--콜_인터페이스_이력(Table)
@Schema(description = "콜 인터페이스 이력(Table)")
public class HChangeHist implements Serializable {
    @Id //  Integer
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "CHANGE_SEQ_NUM", nullable = false)
//    @Schema(description = "", nullable = true , defaultValue = "" , example = ""  , allowableValues = {"", ""})
    @Schema(description = "변경 순번(pk)", nullable = false)
    private Integer changeSeqNum; //--변경_순번(pk)

    @Column(name = "RECPT_NUM", nullable = false)
    @Schema(description = "접수 번호", nullable = false)
    private Integer recptNum; //--접수_번호

    @Column(name = "USR_ID", length = 30, nullable = true)
    @Schema(description = "사용자 id", nullable = true)
    private String usrId; //--사용자_id

    @Column(name = "CHANGE_DIV", length = 1, nullable = true)
    @Schema(description = "변경 구분", nullable = true)
    private String changeDiv; //--변경_구분

    @Column(name = "CHANGE_ITEM", length = 200, nullable = true)
    @Schema(description = "변경 항목", nullable = true)
    private String changeItem; //--변경_항목

    @Column(name = "PRE_DATA", length = 4000, nullable = true)
    @Schema(description = "이전 데이터", nullable = true)
    private String preData; //--이전_데이터

    @Column(name = "AFTER_DATA", length = 4000, nullable = true)
    @Schema(description = "이후 데이터", nullable = true)
    private String afterData; //--이후_데이터

    @Column(name = "CHANGEPERSN_ID", length = 30, nullable = false)
    @Schema(description = "변경자 id", nullable = false)
    private String changepersnId; //--변경자_id

    @Column(name = "CHANGE_TM", nullable = true)
    @Schema(description = "변경 시간", nullable = true)
    private Date changeTm; //--변경_시간

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
    public HChangeHist(Integer recptNum, String usrId, String changeDiv, String changeItem, String preData, String afterData, String changepersnId, Date changeTm, String fstRegpersnId, String finalUptpersnId, Date fstRegTm, Date finalUptTm) {
        this.recptNum = recptNum;
        this.usrId = usrId;
        this.changeDiv = changeDiv;
        this.changeItem = changeItem;
        this.preData = preData;
        this.afterData = afterData;
        this.changepersnId = changepersnId;
        this.changeTm = changeTm;
        this.fstRegpersnId = fstRegpersnId;
        this.finalUptpersnId = finalUptpersnId;
        this.fstRegTm = fstRegTm;
        this.finalUptTm = finalUptTm;
    }
}
