/**
 * SIncidCardVideoFileInfo Entity 클래스
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

import com.weni.ecs.domain.listener.SIncidCardVideoFileInfoListener;

@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED) // AccessLevel.PUBLIC
@Entity
@EntityListeners(SIncidCardVideoFileInfoListener.class)
@Table(name = "S_INCID_CARD_VIDEO_FILE_INFO") //--사건_카드_영상_파일_정보(Table)
@Schema(description = "사건 카드 영상 파일 정보(Table)")
@IdClass(SIncidCardVideoFileInfoPK.class)
public class SIncidCardVideoFileInfo implements Serializable {
    @Id //  Integer
    @Column(name = "RECPT_NUM", nullable = false)
//    @Schema(description = "", nullable = true , defaultValue = "" , example = ""  , allowableValues = {"", ""})
    @Schema(description = "접수 번호(pk)", nullable = false)
    private Integer recptNum; //--접수_번호(pk)

    @Id //  Integer
    @Column(name = "DTL_SEQ_NUM", nullable = false)
    @Schema(description = "상세 순번(pk)", nullable = false)
    private Integer dtlSeqNum; //--상세_순번(pk)

    @Column(name = "VIDEO_FILE_FOLD", length = 1000, nullable = true)
    @Schema(description = "영상 파일 폴더", nullable = true)
    private String videoFileFold; //--영상_파일_폴더

    @Column(name = "VIDEO_FILE_NM", length = 200, nullable = true)
    @Schema(description = "영상 파일 명", nullable = true)
    private String videoFileNm; //--영상_파일_명

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
    public SIncidCardVideoFileInfo(Integer recptNum, Integer dtlSeqNum, String videoFileFold, String videoFileNm, String fstRegpersnId, String finalUptpersnId, Date fstRegTm, Date finalUptTm) {
        this.recptNum = recptNum;
        this.dtlSeqNum = dtlSeqNum;
        this.videoFileFold = videoFileFold;
        this.videoFileNm = videoFileNm;
        this.fstRegpersnId = fstRegpersnId;
        this.finalUptpersnId = finalUptpersnId;
        this.fstRegTm = fstRegTm;
        this.finalUptTm = finalUptTm;
    }
}
