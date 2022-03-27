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
@Table(name="H_CHANGE_HIST")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED) // AccessLevel.PUBLIC
@EqualsAndHashCode // (of = {"email","name"}, callSuper = true, onParam = @__(@NonNull))
@ToString //(exclude = "password") // exclude 속성을 사용하면, 특정 필드를 toString() 결과에서 제외
public class HChangeHist implements Serializable {
    @Id //  Integer
    @Column(name = "CHANGE_SEQ_NUM", nullable = false)
    private Integer changeSeqNum;

    @Column(name = "RECPT_NUM", nullable = false)
    private Integer recptNum;

    @Column(name = "USR_ID", nullable = true)
    private String usrId;

    @Column(name = "CHANGE_DIV", nullable = true)
    private String changeDiv;

    @Column(name = "CHANGE_ITEM", nullable = true)
    private String changeItem;

    @Column(name = "PRE_DATA", nullable = true)
    private String preData;

    @Column(name = "AFTER_DATA", nullable = true)
    private String afterData;

    @Column(name = "CHANGEPERSN_ID", nullable = false)
    private String changepersnId;

    @Column(name = "CHANGE_TM", nullable = true)
    private Date changeTm;

    @Column(name = "FST_REGPERSN_ID", nullable = true)
    private String fstRegpersnId;

    @Column(name = "FINAL_UPTPERSN_ID", nullable = true)
    private String finalUptpersnId;

    @Column(name = "FST_REG_TM", nullable = true)
    private Date fstRegTm;

    @Column(name = "FINAL_UPT_TM", nullable = true)
    private Date finalUptTm;


    @Builder
    public HChangeHist(Integer changeSeqNum, Integer recptNum, String usrId, String changeDiv, String changeItem, String preData, String afterData, String changepersnId, Date changeTm, String fstRegpersnId, String finalUptpersnId, Date fstRegTm, Date finalUptTm) {
        this.changeSeqNum = changeSeqNum;
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

