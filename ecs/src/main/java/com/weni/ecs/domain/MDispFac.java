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
@Table(name="M_DISP_FAC")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED) // AccessLevel.PUBLIC
@EqualsAndHashCode // (of = {"email","name"}, callSuper = true, onParam = @__(@NonNull))
@ToString //(exclude = "password") // exclude 속성을 사용하면, 특정 필드를 toString() 결과에서 제외
public class MDispFac implements Serializable {
    @Id //  Integer
    @Column(name = "MDT_DEV_ID", nullable = false)
    private Integer mdtDevId;

    @Column(name = "JURIS_CODE", nullable = false)
    private String jurisCode;

    @Column(name = "ICON", nullable = false)
    private String icon;

    @Column(name = "MDT_DEV_NM", nullable = false)
    private String mdtDevNm;

    @Column(name = "TRANSMIT_PRD", nullable = true)
    private Integer transmitPrd;

    @Column(name = "CURR_EXIST_STT", nullable = false)
    private String currExistStt;

    @Column(name = "DEL_FLAG", nullable = false)
    private String delFlag;

    @Column(name = "FST_REGPERSN_ID", nullable = true)
    private String fstRegpersnId;

    @Column(name = "FINAL_UPTPERSN_ID", nullable = true)
    private String finalUptpersnId;

    @Column(name = "FST_REG_TM", nullable = true)
    private Date fstRegTm;

    @Column(name = "FINAL_UPT_TM", nullable = true)
    private Date finalUptTm;


    @Builder
    public MDispFac(Integer mdtDevId, String jurisCode, String icon, String mdtDevNm, Integer transmitPrd, String currExistStt, String delFlag, String fstRegpersnId, String finalUptpersnId, Date fstRegTm, Date finalUptTm) {
        this.mdtDevId = mdtDevId;
        this.jurisCode = jurisCode;
        this.icon = icon;
        this.mdtDevNm = mdtDevNm;
        this.transmitPrd = transmitPrd;
        this.currExistStt = currExistStt;
        this.delFlag = delFlag;
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

