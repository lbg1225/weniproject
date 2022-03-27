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
@Table(name="M_MNU_INFO")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED) // AccessLevel.PUBLIC
@EqualsAndHashCode // (of = {"email","name"}, callSuper = true, onParam = @__(@NonNull))
@ToString //(exclude = "password") // exclude 속성을 사용하면, 특정 필드를 toString() 결과에서 제외
public class MMnuInfo implements Serializable {
    @Id //  String
    @Column(name = "MNU_ID", nullable = false)
    private String mnuId;

    @Column(name = "BUSN_DOMAIN", nullable = true)
    private String busnDomain;

    @Column(name = "BUSN_SKILL", nullable = true)
    private String busnSkill;

    @Column(name = "SCR_NM", nullable = true)
    private String scrNm;

    @Column(name = "SCR_EXP", nullable = true)
    private String scrExp;

    @Column(name = "DEL_FLAG", nullable = true)
    private String delFlag;

    @Column(name = "FST_REGPERSN_ID", nullable = true)
    private String fstRegpersnId;

    @Column(name = "FINAL_UPTPERSN_ID", nullable = true)
    private String finalUptpersnId;

    @Column(name = "FST_REG_TM", nullable = true)
    private Date fstRegTm;

    @Column(name = "FINAL_UPT_TM", nullable = true)
    private Date finalUptTm;

    @Column(name = "SCR_NM_KOR", nullable = true)
    private String scrNmKor;

    @Column(name = "SCR_NM_RUS", nullable = true)
    private String scrNmRus;

    @Column(name = "LST_NUMB", nullable = true)
    private Integer lstNumb;

    @Column(name = "QRY_SEQ", nullable = false)
    private Integer qrySeq;

    @Column(name = "QRY_FLAG", nullable = true)
    private String qryFlag;

    @Column(name = "UPT_FLAG", nullable = true)
    private String uptFlag;

    @Column(name = "INS_FLAG", nullable = true)
    private String insFlag;


    @Builder
    public MMnuInfo(String mnuId, String busnDomain, String busnSkill, String scrNm, String scrExp, String delFlag, String fstRegpersnId, String finalUptpersnId, Date fstRegTm, Date finalUptTm, String scrNmKor, String scrNmRus, Integer lstNumb, Integer qrySeq, String qryFlag, String uptFlag, String insFlag) {
        this.mnuId = mnuId;
        this.busnDomain = busnDomain;
        this.busnSkill = busnSkill;
        this.scrNm = scrNm;
        this.scrExp = scrExp;
        this.delFlag = delFlag;
        this.fstRegpersnId = fstRegpersnId;
        this.finalUptpersnId = finalUptpersnId;
        this.fstRegTm = fstRegTm;
        this.finalUptTm = finalUptTm;
        this.scrNmKor = scrNmKor;
        this.scrNmRus = scrNmRus;
        this.lstNumb = lstNumb;
        this.qrySeq = qrySeq;
        this.qryFlag = qryFlag;
        this.uptFlag = uptFlag;
        this.insFlag = insFlag;
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

