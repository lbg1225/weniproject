package com.weni.ecs.domain;
import java.math.BigDecimal;
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
@Table(name="M_USR_INFO")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED) // AccessLevel.PUBLIC
@EqualsAndHashCode // (of = {"email","name"}, callSuper = true, onParam = @__(@NonNull))
@ToString //(exclude = "password") // exclude 속성을 사용하면, 특정 필드를 toString() 결과에서 제외
public class MUsrInfo implements Serializable {
    @Id //  String
    @Column(name = "USR_ID", nullable = false)
    private String usrId;

    @Column(name = "JURIS_CODE", nullable = true)
    private String jurisCode;

    @Column(name = "OFF_RANK_CODE", nullable = true)
    private String offRankCode;

    @Column(name = "FAM_NM", nullable = true)
    private String famNm;

    @Column(name = "GIV_NM", nullable = true)
    private String givNm;

    @Column(name = "MID_NM", nullable = true)
    private String midNm;

    @Column(name = "PWD", nullable = true)
    private String pwd;

    @Column(name = "FST_REGPERSN_ID", nullable = true)
    private String fstRegpersnId;

    @Column(name = "FINAL_UPTPERSN_ID", nullable = true)
    private String finalUptpersnId;

    @Column(name = "FST_REG_TM", nullable = true)
    private Date fstRegTm;

    @Column(name = "FINAL_UPT_TM", nullable = true)
    private Date finalUptTm;

    @Column(name = "LOCALE_CODE", nullable = true)
    private String localeCode;

    @Column(name = "CURR_EXIST_STT", nullable = true)
    private String currExistStt;

    @Column(name = "SOFTPHONE_NUM", nullable = true)
    private String softphoneNum;

    @Column(name = "LOGIN_KEEP_TM", nullable = true)
    private BigDecimal loginKeepTm;

    @Column(name = "GIS_USR_GRP", nullable = true)
    private String gisUsrGrp;


    @Builder
    public MUsrInfo(String usrId, String jurisCode, String offRankCode, String famNm, String givNm, String midNm, String pwd, String fstRegpersnId, String finalUptpersnId, Date fstRegTm, Date finalUptTm, String localeCode, String currExistStt, String softphoneNum, BigDecimal loginKeepTm, String gisUsrGrp) {
        this.usrId = usrId;
        this.jurisCode = jurisCode;
        this.offRankCode = offRankCode;
        this.famNm = famNm;
        this.givNm = givNm;
        this.midNm = midNm;
        this.pwd = pwd;
        this.fstRegpersnId = fstRegpersnId;
        this.finalUptpersnId = finalUptpersnId;
        this.fstRegTm = fstRegTm;
        this.finalUptTm = finalUptTm;
        this.localeCode = localeCode;
        this.currExistStt = currExistStt;
        this.softphoneNum = softphoneNum;
        this.loginKeepTm = loginKeepTm;
        this.gisUsrGrp = gisUsrGrp;
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

