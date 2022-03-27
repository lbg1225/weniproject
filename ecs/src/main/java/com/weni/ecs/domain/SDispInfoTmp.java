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
@Table(name="S_DISP_INFO_TMP")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED) // AccessLevel.PUBLIC
@EqualsAndHashCode // (of = {"email","name"}, callSuper = true, onParam = @__(@NonNull))
@ToString //(exclude = "password") // exclude 속성을 사용하면, 특정 필드를 toString() 결과에서 제외
public class SDispInfoTmp implements Serializable {
    @Id //  Integer
    @Column(name = "RECPT_NUM", nullable = false)
    private Integer recptNum;

    @Column(name = "DTL_SEQ_NUM", nullable = false)
    private Integer dtlSeqNum;

    @Column(name = "DISP_CMD_TM", nullable = true)
    private Date dispCmdTm;

    @Column(name = "DISP_STRT_TM", nullable = true)
    private Date dispStrtTm;

    @Column(name = "DISP_CLOSE_TM", nullable = true)
    private Date dispCloseTm;

    @Column(name = "MDT_DEV_ID", nullable = false)
    private Integer mdtDevId;

    @Column(name = "DISP_PRCS_INSP_ID", nullable = false)
    private String dispPrcsInspId;

    @Column(name = "FST_REGPERSN_ID", nullable = true)
    private String fstRegpersnId;

    @Column(name = "FINAL_UPTPERSN_ID", nullable = true)
    private String finalUptpersnId;

    @Column(name = "FST_REG_TM", nullable = true)
    private Date fstRegTm;

    @Column(name = "FINAL_UPT_TM", nullable = true)
    private Date finalUptTm;


    @Builder
    public SDispInfoTmp(Integer recptNum, Integer dtlSeqNum, Date dispCmdTm, Date dispStrtTm, Date dispCloseTm, Integer mdtDevId, String dispPrcsInspId, String fstRegpersnId, String finalUptpersnId, Date fstRegTm, Date finalUptTm) {
        this.recptNum = recptNum;
        this.dtlSeqNum = dtlSeqNum;
        this.dispCmdTm = dispCmdTm;
        this.dispStrtTm = dispStrtTm;
        this.dispCloseTm = dispCloseTm;
        this.mdtDevId = mdtDevId;
        this.dispPrcsInspId = dispPrcsInspId;
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

