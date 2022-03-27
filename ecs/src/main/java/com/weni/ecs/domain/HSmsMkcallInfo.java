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
@Table(name="H_SMS_MKCALL_INFO")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED) // AccessLevel.PUBLIC
@EqualsAndHashCode // (of = {"email","name"}, callSuper = true, onParam = @__(@NonNull))
@ToString //(exclude = "password") // exclude 속성을 사용하면, 특정 필드를 toString() 결과에서 제외
public class HSmsMkcallInfo implements Serializable {
    @Id //  Integer
    @Column(name = "MKCALL_SEQ_NUM", nullable = false)
    private Integer mkcallSeqNum;

    @Column(name = "MDT_DEV_ID", nullable = false)
    private Integer mdtDevId;

    @Column(name = "MSG_NUM", nullable = true)
    private Integer msgNum;

    @Column(name = "INDIC_ITM", nullable = false)
    private String indicItm;

    @Column(name = "CALLER_ID", nullable = false)
    private String callerId;

    @Column(name = "RECPT_TM", nullable = false)
    private Date recptTm;

    @Column(name = "MKCALL_TM", nullable = true)
    private Date mkcallTm;

    @Column(name = "RECV_TM", nullable = true)
    private Date recvTm;

    @Column(name = "CFM_TM", nullable = true)
    private Date cfmTm;

    @Column(name = "MKCALL_STT", nullable = false)
    private String mkcallStt;

    @Column(name = "SEND_RSLT", nullable = true)
    private String sendRslt;

    @Column(name = "FST_REGPERSN_ID", nullable = true)
    private String fstRegpersnId;

    @Column(name = "FINAL_UPTPERSN_ID", nullable = true)
    private String finalUptpersnId;

    @Column(name = "FST_REG_TM", nullable = true)
    private Date fstRegTm;

    @Column(name = "FINAL_UPT_TM", nullable = true)
    private Date finalUptTm;


    @Builder
    public HSmsMkcallInfo(Integer mkcallSeqNum, Integer mdtDevId, Integer msgNum, String indicItm, String callerId, Date recptTm, Date mkcallTm, Date recvTm, Date cfmTm, String mkcallStt, String sendRslt, String fstRegpersnId, String finalUptpersnId, Date fstRegTm, Date finalUptTm) {
        this.mkcallSeqNum = mkcallSeqNum;
        this.mdtDevId = mdtDevId;
        this.msgNum = msgNum;
        this.indicItm = indicItm;
        this.callerId = callerId;
        this.recptTm = recptTm;
        this.mkcallTm = mkcallTm;
        this.recvTm = recvTm;
        this.cfmTm = cfmTm;
        this.mkcallStt = mkcallStt;
        this.sendRslt = sendRslt;
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

