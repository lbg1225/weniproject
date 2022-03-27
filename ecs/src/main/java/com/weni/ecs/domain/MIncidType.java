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
@Table(name="M_INCID_TYPE")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED) // AccessLevel.PUBLIC
@EqualsAndHashCode // (of = {"email","name"}, callSuper = true, onParam = @__(@NonNull))
@ToString //(exclude = "password") // exclude 속성을 사용하면, 특정 필드를 toString() 결과에서 제외
public class MIncidType implements Serializable {
    @Id //  String
    @Column(name = "INCIDTYPE_BIGCLSSFY_CODE", nullable = false)
    private String incidtypeBigclssfyCode;

    @Column(name = "INCIDTYPE_MEDCLSSFY_CODE", nullable = false)
    private String incidtypeMedclssfyCode;

    @Column(name = "INCIDTYPE_SMALLCLSSFY_CODE", nullable = false)
    private String incidtypeSmallclssfyCode;

    @Column(name = "CLSSFY_LVL", nullable = true)
    private String clssfyLvl;

    @Column(name = "INCIDTYPE_BIGCLSSFY_NM", nullable = true)
    private String incidtypeBigclssfyNm;

    @Column(name = "INCIDTYPE_MEDCLSSFY_NM", nullable = true)
    private String incidtypeMedclssfyNm;

    @Column(name = "INCIDTYPE_SMALLCLSSFY_NM", nullable = true)
    private String incidtypeSmallclssfyNm;

    @Column(name = "FST_REGPERSN_ID", nullable = true)
    private String fstRegpersnId;

    @Column(name = "FINAL_UPTPERSN_ID", nullable = true)
    private String finalUptpersnId;

    @Column(name = "FST_REG_TM", nullable = true)
    private Date fstRegTm;

    @Column(name = "FINAL_UPT_TM", nullable = true)
    private Date finalUptTm;

    @Column(name = "INCIDTYPE_BIGCLSSFY_NM_KOR", nullable = true)
    private String incidtypeBigclssfyNmKor;

    @Column(name = "INCIDTYPE_MEDCLSSFY_NM_KOR", nullable = true)
    private String incidtypeMedclssfyNmKor;

    @Column(name = "INCIDTYPE_SMALLCLSSFY_NM_KOR", nullable = true)
    private String incidtypeSmallclssfyNmKor;

    @Column(name = "INCIDTYPE_BIGCLSSFY_NM_RUS", nullable = true)
    private String incidtypeBigclssfyNmRus;

    @Column(name = "INCIDTYPE_MEDCLSSFY_NM_RUS", nullable = true)
    private String incidtypeMedclssfyNmRus;

    @Column(name = "INCIDTYPE_SMALLCLSSFY_NM_RUS", nullable = true)
    private String incidtypeSmallclssfyNmRus;

    @Column(name = "INCIDTYPE_EXP", nullable = true)
    private String incidtypeExp;

    @Column(name = "INCIDTYPE_BG_COLOR", nullable = true)
    private String incidtypeBgColor;


    @Builder
    public MIncidType(String incidtypeBigclssfyCode, String incidtypeMedclssfyCode, String incidtypeSmallclssfyCode, String clssfyLvl, String incidtypeBigclssfyNm, String incidtypeMedclssfyNm, String incidtypeSmallclssfyNm, String fstRegpersnId, String finalUptpersnId, Date fstRegTm, Date finalUptTm, String incidtypeBigclssfyNmKor, String incidtypeMedclssfyNmKor, String incidtypeSmallclssfyNmKor, String incidtypeBigclssfyNmRus, String incidtypeMedclssfyNmRus, String incidtypeSmallclssfyNmRus, String incidtypeExp, String incidtypeBgColor) {
        this.incidtypeBigclssfyCode = incidtypeBigclssfyCode;
        this.incidtypeMedclssfyCode = incidtypeMedclssfyCode;
        this.incidtypeSmallclssfyCode = incidtypeSmallclssfyCode;
        this.clssfyLvl = clssfyLvl;
        this.incidtypeBigclssfyNm = incidtypeBigclssfyNm;
        this.incidtypeMedclssfyNm = incidtypeMedclssfyNm;
        this.incidtypeSmallclssfyNm = incidtypeSmallclssfyNm;
        this.fstRegpersnId = fstRegpersnId;
        this.finalUptpersnId = finalUptpersnId;
        this.fstRegTm = fstRegTm;
        this.finalUptTm = finalUptTm;
        this.incidtypeBigclssfyNmKor = incidtypeBigclssfyNmKor;
        this.incidtypeMedclssfyNmKor = incidtypeMedclssfyNmKor;
        this.incidtypeSmallclssfyNmKor = incidtypeSmallclssfyNmKor;
        this.incidtypeBigclssfyNmRus = incidtypeBigclssfyNmRus;
        this.incidtypeMedclssfyNmRus = incidtypeMedclssfyNmRus;
        this.incidtypeSmallclssfyNmRus = incidtypeSmallclssfyNmRus;
        this.incidtypeExp = incidtypeExp;
        this.incidtypeBgColor = incidtypeBgColor;
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

