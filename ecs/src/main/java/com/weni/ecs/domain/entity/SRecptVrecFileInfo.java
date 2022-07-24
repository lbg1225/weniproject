/**
 * SRecptVrecFileInfo Entity 클래스
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

import com.weni.ecs.domain.listener.SRecptVrecFileInfoListener;

@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED) // AccessLevel.PUBLIC
@Entity
@EntityListeners(SRecptVrecFileInfoListener.class)
@Table(name = "S_RECPT_VREC_FILE_INFO") //--접속_녹취_파일_정보(Table)
@Schema(description = "접속 녹취 파일 정보(Table)")
public class SRecptVrecFileInfo implements Serializable {
    @Id //  String
    @Column(name = "RECPT_VREC_ID", length = 100, nullable = false)
//    @Schema(description = "", nullable = true , defaultValue = "" , example = ""  , allowableValues = {"", ""})
    @Schema(description = "접수 녹취 id(pk)", nullable = false)
    private String recptVrecId; //--접수_녹취_id(pk)

    @Column(name = "RECPT_NUM", nullable = false)
    @Schema(description = "접수 번호", nullable = false)
    private Integer recptNum; //--접수_번호

    @Column(name = "RECPT_VREC_FILE_FOLD", length = 1000, nullable = true)
    @Schema(description = "접수 녹취 파일 폴더", nullable = true)
    private String recptVrecFileFold; //--접수_녹취_파일_폴더

    @Column(name = "RECPT_VREC_FILE_NM", length = 200, nullable = true)
    @Schema(description = "접수 녹취 파일 명", nullable = true)
    private String recptVrecFileNm; //--접수_녹취_파일_명

    @Column(name = "CALL_RECVPERSN_ID", length = 30, nullable = true)
    @Schema(description = "콜 수신자 id", nullable = true)
    private String callRecvpersnId; //--콜_수신자_id

    @Column(name = "CALL_ID", length = 20, nullable = true)
    @Schema(description = "콜 id", nullable = true)
    private String callId; //--콜_id

    @Column(name = "WORKST_ID", length = 20, nullable = true)
    @Schema(description = "워크스테이션 id", nullable = true)
    private String workstId; //--워크스테이션_id

    @Column(name = "CONN_ID", length = 20, nullable = true)
    @Schema(description = "접속 id", nullable = true)
    private String connId; //--접속_id

    @Column(name = "CONN_TM", nullable = true)
    @Schema(description = "접속 시간", nullable = true)
    private Date connTm; //--접속_시간

    @Column(name = "DNIS", length = 20, nullable = true)
    @Schema(description = "dnis", nullable = true)
    private String dnis; //--dnis

    @Column(name = "THIS_DN", length = 20, nullable = true)
    @Schema(description = "this dn", nullable = true)
    private String thisDn; //--this_dn

    @Column(name = "OTHR_DN", length = 20, nullable = true)
    @Schema(description = "other dn", nullable = true)
    private String othrDn; //--other_dn

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
    public SRecptVrecFileInfo(String recptVrecId, Integer recptNum, String recptVrecFileFold, String recptVrecFileNm, String callRecvpersnId, String callId, String workstId, String connId, Date connTm, String dnis, String thisDn, String othrDn, String fstRegpersnId, String finalUptpersnId, Date fstRegTm, Date finalUptTm) {
        this.recptVrecId = recptVrecId;
        this.recptNum = recptNum;
        this.recptVrecFileFold = recptVrecFileFold;
        this.recptVrecFileNm = recptVrecFileNm;
        this.callRecvpersnId = callRecvpersnId;
        this.callId = callId;
        this.workstId = workstId;
        this.connId = connId;
        this.connTm = connTm;
        this.dnis = dnis;
        this.thisDn = thisDn;
        this.othrDn = othrDn;
        this.fstRegpersnId = fstRegpersnId;
        this.finalUptpersnId = finalUptpersnId;
        this.fstRegTm = fstRegTm;
        this.finalUptTm = finalUptTm;
    }
}
