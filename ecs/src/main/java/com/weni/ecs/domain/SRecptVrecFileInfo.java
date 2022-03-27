package com.weni.ecs.domain;
import java.sql.Date;
import java.io.Serializable;
import javax.persistence.*;
// import org.springframework.beans.BeanUtils;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.Builder;

@Entity
@Table(name="S_RECPT_VREC_FILE_INFO")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED) // AccessLevel.PUBLIC
@EqualsAndHashCode // (of = {"email","name"}, callSuper = true, onParam = @__(@NonNull))
@ToString //(exclude = "password") // exclude 속성을 사용하면, 특정 필드를 toString() 결과에서 제외
public class SRecptVrecFileInfo implements Serializable {
    @Id //  String
    @Column(name = "RECPT_VREC_ID", nullable = false)
    private String recptVrecId;

    @Column(name = "RECPT_NUM", nullable = false)
    private Integer recptNum;

    @Column(name = "RECPT_VREC_FILE_FOLD", nullable = true)
    private String recptVrecFileFold;

    @Column(name = "RECPT_VREC_FILE_NM", nullable = true)
    private String recptVrecFileNm;

    @Column(name = "CALL_RECVPERSN_ID", nullable = true)
    private String callRecvpersnId;

    @Column(name = "CALL_ID", nullable = true)
    private String callId;

    @Column(name = "WORKST_ID", nullable = true)
    private String workstId;

    @Column(name = "CONN_ID", nullable = true)
    private String connId;

    @Column(name = "CONN_TM", nullable = true)
    private Date connTm;

    @Column(name = "DNIS", nullable = true)
    private String dnis;

    @Column(name = "THIS_DN", nullable = true)
    private String thisDn;

    @Column(name = "OTHR_DN", nullable = true)
    private String othrDn;

    @Column(name = "FST_REGPERSN_ID", nullable = true)
    private String fstRegpersnId;

    @Column(name = "FINAL_UPTPERSN_ID", nullable = true)
    private String finalUptpersnId;

    @Column(name = "FST_REG_TM", nullable = true)
    private Date fstRegTm;

    @Column(name = "FINAL_UPT_TM", nullable = true)
    private Date finalUptTm;


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

