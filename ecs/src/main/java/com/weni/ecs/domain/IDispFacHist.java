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
@Table(name="I_DISP_FAC_HIST")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED) // AccessLevel.PUBLIC
@EqualsAndHashCode // (of = {"email","name"}, callSuper = true, onParam = @__(@NonNull))
@ToString //(exclude = "password") // exclude 속성을 사용하면, 특정 필드를 toString() 결과에서 제외
public class IDispFacHist implements Serializable {
    @Id //  Integer
    @Column(name = "MDT_DEV_ID", nullable = false)
    private Integer mdtDevId;

    @Column(name = "COLL_TM", nullable = false)
    private Date collTm;

    @Column(name = "LGT", nullable = true)
    private Double lgt;

    @Column(name = "LTT", nullable = true)
    private Double ltt;

    @Column(name = "STT", nullable = true)
    private String stt;

    @Column(name = "TRANSMIT_PRD", nullable = true)
    private Integer transmitPrd;

    @Column(name = "JURIS_CODE", nullable = true)
    private String jurisCode;

    @Column(name = "FST_REGPERSN_ID", nullable = true)
    private String fstRegpersnId;

    @Column(name = "FINAL_UPTPERSN_ID", nullable = true)
    private String finalUptpersnId;

    @Column(name = "FST_REG_TM", nullable = true)
    private Date fstRegTm;

    @Column(name = "FINAL_UPT_TM", nullable = true)
    private Date finalUptTm;


    @Builder
    public IDispFacHist(Integer mdtDevId, Date collTm, Double lgt, Double ltt, String stt, Integer transmitPrd, String jurisCode, String fstRegpersnId, String finalUptpersnId, Date fstRegTm, Date finalUptTm) {
        this.mdtDevId = mdtDevId;
        this.collTm = collTm;
        this.lgt = lgt;
        this.ltt = ltt;
        this.stt = stt;
        this.transmitPrd = transmitPrd;
        this.jurisCode = jurisCode;
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

