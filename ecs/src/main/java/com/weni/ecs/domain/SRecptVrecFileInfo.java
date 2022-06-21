/** 
* SRecptVrecFileInfo Entity 클래스 

* @author  Lee Byoung Gwan
* @version 1.0 
*/
package com.weni.ecs.domain;
import java.sql.Date;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.PostLoad;
import javax.persistence.PrePersist;
import javax.persistence.PostPersist;
import javax.persistence.PreUpdate;
import javax.persistence.PostUpdate;
import javax.persistence.PreRemove;
import javax.persistence.PostRemove;
// import org.springframework.beans.BeanUtils;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.Builder;

@Entity
@Table(name="S_RECPT_VREC_FILE_INFO") //--PRIMARY
@Getter
@NoArgsConstructor // (access = AccessLevel.PROTECTED) // AccessLevel.PUBLIC
@EqualsAndHashCode // (of = {"email","name"}, callSuper = true, onParam = @__(@NonNull))
@ToString //(exclude = "password") // exclude 속성을 사용하면, 특정 필드를 toString() 결과에서 제외
public class SRecptVrecFileInfo {
    @Id //  String
    @Column(name = "RECPT_VREC_ID", length = 100, nullable = false)
    private String recptVrecId; //--null

    @Column(name = "RECPT_NUM", nullable = false)
    private Integer recptNum; //--null

    @Column(name = "RECPT_VREC_FILE_FOLD", length = 1000, nullable = true)
    private String recptVrecFileFold; //--null

    @Column(name = "RECPT_VREC_FILE_NM", length = 200, nullable = true)
    private String recptVrecFileNm; //--null

    @Column(name = "CALL_RECVPERSN_ID", length = 30, nullable = true)
    private String callRecvpersnId; //--null

    @Column(name = "CALL_ID", length = 20, nullable = true)
    private String callId; //--null

    @Column(name = "WORKST_ID", length = 20, nullable = true)
    private String workstId; //--null

    @Column(name = "CONN_ID", length = 20, nullable = true)
    private String connId; //--null

    @Column(name = "CONN_TM", nullable = true)
    private Date connTm; //--null

    @Column(name = "DNIS", length = 20, nullable = true)
    private String dnis; //--null

    @Column(name = "THIS_DN", length = 20, nullable = true)
    private String thisDn; //--null

    @Column(name = "OTHR_DN", length = 20, nullable = true)
    private String othrDn; //--null

    @Column(name = "FST_REGPERSN_ID", length = 30, nullable = true)
    private String fstRegpersnId; //--null

    @Column(name = "FINAL_UPTPERSN_ID", length = 30, nullable = true)
    private String finalUptpersnId; //--null

    @Column(name = "FST_REG_TM", nullable = true)
    private Date fstRegTm; //--null

    @Column(name = "FINAL_UPT_TM", nullable = true)
    private Date finalUptTm; //--null


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

    //----------------------------------------------------
    // Load/Persist/Update/Remove(조회/신규/수정/삭제)
    // Entity Pre/Post(이전/이후) 처리에 대한 정의(PreLoad는 없음)
    // * DB의 Trigger와 비슷한 JPA기능
    //----------------------------------------------------
    @PostLoad
    public void onPostLoad() {

    }

    @PrePersist
    public void onPrePersist() {

    }

    @PostPersist
    public void onPostPersist() {

    }

    @PreUpdate
    public void onPreUpdate() {

    }

    @PostUpdate
    public void onPostUpdate() {

    }

    @PreRemove
    public void onPreRemove() {

    }

    @PostRemove
    public void onPostRemove() {

    }

}

