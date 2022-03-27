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
@Table(name="H_NOTFC_MKCALL_HIST")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED) // AccessLevel.PUBLIC
@EqualsAndHashCode // (of = {"email","name"}, callSuper = true, onParam = @__(@NonNull))
@ToString //(exclude = "password") // exclude 속성을 사용하면, 특정 필드를 toString() 결과에서 제외
public class HNotfcMkcallHist implements Serializable {
    @Id //  Integer
    @Column(name = "MKCALL_SEQ_NUM", nullable = false)
    private Integer mkcallSeqNum;

    @Column(name = "SENDPERSN_ID", nullable = false)
    private String sendpersnId;

    @Column(name = "INCID_NUM", nullable = true)
    private String incidNum;

    @Column(name = "INCID_OVIEW", nullable = true)
    private String incidOview;

    @Column(name = "INDIC_ITM", nullable = false)
    private String indicItm;

    @Column(name = "SEND_TM", nullable = false)
    private Date sendTm;

    @Column(name = "FST_REGPERSN_ID", nullable = true)
    private String fstRegpersnId;

    @Column(name = "FINAL_UPTPERSN_ID", nullable = true)
    private String finalUptpersnId;

    @Column(name = "FST_REG_TM", nullable = true)
    private Date fstRegTm;

    @Column(name = "FINAL_UPT_TM", nullable = true)
    private Date finalUptTm;


    @Builder
    public HNotfcMkcallHist(Integer mkcallSeqNum, String sendpersnId, String incidNum, String incidOview, String indicItm, Date sendTm, String fstRegpersnId, String finalUptpersnId, Date fstRegTm, Date finalUptTm) {
        this.mkcallSeqNum = mkcallSeqNum;
        this.sendpersnId = sendpersnId;
        this.incidNum = incidNum;
        this.incidOview = incidOview;
        this.indicItm = indicItm;
        this.sendTm = sendTm;
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

