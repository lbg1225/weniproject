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
@Table(name="S_INCID_CARD_POL")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED) // AccessLevel.PUBLIC
@EqualsAndHashCode // (of = {"email","name"}, callSuper = true, onParam = @__(@NonNull))
@ToString //(exclude = "password") // exclude 속성을 사용하면, 특정 필드를 toString() 결과에서 제외
public class SIncidCardPol implements Serializable {
    @Id //  Integer
    @Column(name = "RECPT_NUM", nullable = false)
    private Integer recptNum;

    @Column(name = "POL_INCIDOVIEW", nullable = true)
    private String polIncidoview;

    @Column(name = "POL_POSS_CRIME_TRGT", nullable = true)
    private String polPossCrimeTrgt;

    @Column(name = "POL_LOSSAMOUNT", nullable = true)
    private Integer polLossamount;

    @Column(name = "POL_VALUTA_CODE", nullable = true)
    private String polValutaCode;

    @Column(name = "POL_PHYS_EVID_DESC", nullable = true)
    private String polPhysEvidDesc;

    @Column(name = "POL_ADDITM", nullable = true)
    private String polAdditm;

    @Column(name = "FST_REGPERSN_ID", nullable = true)
    private String fstRegpersnId;

    @Column(name = "FINAL_UPTPERSN_ID", nullable = true)
    private String finalUptpersnId;

    @Column(name = "FST_REG_TM", nullable = true)
    private Date fstRegTm;

    @Column(name = "FINAL_UPT_TM", nullable = true)
    private Date finalUptTm;


    @Builder
    public SIncidCardPol(Integer recptNum, String polIncidoview, String polPossCrimeTrgt, Integer polLossamount, String polValutaCode, String polPhysEvidDesc, String polAdditm, String fstRegpersnId, String finalUptpersnId, Date fstRegTm, Date finalUptTm) {
        this.recptNum = recptNum;
        this.polIncidoview = polIncidoview;
        this.polPossCrimeTrgt = polPossCrimeTrgt;
        this.polLossamount = polLossamount;
        this.polValutaCode = polValutaCode;
        this.polPhysEvidDesc = polPhysEvidDesc;
        this.polAdditm = polAdditm;
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

