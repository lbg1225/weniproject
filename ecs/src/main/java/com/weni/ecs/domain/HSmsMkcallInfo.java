/** 
* HSmsMkcallInfo Entity 클래스 

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
@Table(name="H_SMS_MKCALL_INFO") //--PRIMARY
@Getter
@NoArgsConstructor // (access = AccessLevel.PROTECTED) // AccessLevel.PUBLIC
@EqualsAndHashCode // (of = {"email","name"}, callSuper = true, onParam = @__(@NonNull))
@ToString //(exclude = "password") // exclude 속성을 사용하면, 특정 필드를 toString() 결과에서 제외
public class HSmsMkcallInfo {
    @Id //  Integer
    @Column(name = "MKCALL_SEQ_NUM", nullable = false)
    private Integer mkcallSeqNum; //--null

    @Column(name = "MDT_DEV_ID", nullable = false)
    private Integer mdtDevId; //--null

    @Column(name = "MSG_NUM", nullable = true)
    private Byte msgNum; //--null

    @Column(name = "INDIC_ITM", length = 140, nullable = false)
    private String indicItm; //--null

    @Column(name = "CALLER_ID", length = 30, nullable = false)
    private String callerId; //--null

    @Column(name = "RECPT_TM", nullable = false)
    private Date recptTm; //--null

    @Column(name = "MKCALL_TM", nullable = true)
    private Date mkcallTm; //--null

    @Column(name = "RECV_TM", nullable = true)
    private Date recvTm; //--null

    @Column(name = "CFM_TM", nullable = true)
    private Date cfmTm; //--null

    @Column(name = "MKCALL_STT", length = 1, nullable = false)
    private String mkcallStt; //--null

    @Column(name = "SEND_RSLT", length = 200, nullable = true)
    private String sendRslt; //--null

    @Column(name = "FST_REGPERSN_ID", length = 30, nullable = true)
    private String fstRegpersnId; //--null

    @Column(name = "FINAL_UPTPERSN_ID", length = 30, nullable = true)
    private String finalUptpersnId; //--null

    @Column(name = "FST_REG_TM", nullable = true)
    private Date fstRegTm; //--null

    @Column(name = "FINAL_UPT_TM", nullable = true)
    private Date finalUptTm; //--null


    @Builder
    public HSmsMkcallInfo(Integer mkcallSeqNum, Integer mdtDevId, Byte msgNum, String indicItm, String callerId, Date recptTm, Date mkcallTm, Date recvTm, Date cfmTm, String mkcallStt, String sendRslt, String fstRegpersnId, String finalUptpersnId, Date fstRegTm, Date finalUptTm) {
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

