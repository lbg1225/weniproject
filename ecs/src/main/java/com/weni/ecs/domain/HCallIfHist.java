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
@Table(name="H_CALL_IF_HIST")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED) // AccessLevel.PUBLIC
@EqualsAndHashCode // (of = {"email","name"}, callSuper = true, onParam = @__(@NonNull))
@ToString //(exclude = "password") // exclude 속성을 사용하면, 특정 필드를 toString() 결과에서 제외
public class HCallIfHist implements Serializable {
    @Id //  Integer
    @Column(name = "HIST_SEQ_NUM", nullable = false)
    private Integer histSeqNum;

    @Column(name = "PCALL_STRT_DAYTIME", nullable = true)
    private Date pcallStrtDaytime;

    @Column(name = "PCALL_CLOSE_DAYTIME", nullable = true)
    private Date pcallCloseDaytime;

    @Column(name = "PCALL_LEN", nullable = true)
    private Integer pcallLen;

    @Column(name = "NUMBMKCALL_YN", nullable = true)
    private String numbmkcallYn;

    @Column(name = "FAM_NM", nullable = true)
    private String famNm;

    @Column(name = "GIV_NM", nullable = true)
    private String givNm;

    @Column(name = "CTI_USR_ID", nullable = true)
    private String ctiUsrId;

    @Column(name = "CALL_ID", nullable = true)
    private String callId;

    @Column(name = "FST_REGPERSN_ID", nullable = true)
    private String fstRegpersnId;

    @Column(name = "FINAL_UPTPERSN_ID", nullable = true)
    private String finalUptpersnId;

    @Column(name = "FST_REG_TM", nullable = true)
    private Date fstRegTm;

    @Column(name = "FINAL_UPT_TM", nullable = true)
    private Date finalUptTm;


    @Builder
    public HCallIfHist(Integer histSeqNum, Date pcallStrtDaytime, Date pcallCloseDaytime, Integer pcallLen, String numbmkcallYn, String famNm, String givNm, String ctiUsrId, String callId, String fstRegpersnId, String finalUptpersnId, Date fstRegTm, Date finalUptTm) {
        this.histSeqNum = histSeqNum;
        this.pcallStrtDaytime = pcallStrtDaytime;
        this.pcallCloseDaytime = pcallCloseDaytime;
        this.pcallLen = pcallLen;
        this.numbmkcallYn = numbmkcallYn;
        this.famNm = famNm;
        this.givNm = givNm;
        this.ctiUsrId = ctiUsrId;
        this.callId = callId;
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

