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
@Table(name="M_BLDG")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED) // AccessLevel.PUBLIC
@EqualsAndHashCode // (of = {"email","name"}, callSuper = true, onParam = @__(@NonNull))
@ToString //(exclude = "password") // exclude 속성을 사용하면, 특정 필드를 toString() 결과에서 제외
public class MBldg implements Serializable {
    @Id //  String
    @Column(name = "BLDG_CODE", nullable = false)
    private String bldgCode;

    @Column(name = "BLDG_NM", nullable = true)
    private String bldgNm;

    @Column(name = "ADDR_STATE", nullable = true)
    private String addrState;

    @Column(name = "ADDR_FCITY", nullable = true)
    private String addrFcity;

    @Column(name = "ADDR_WARD", nullable = true)
    private String addrWard;

    @Column(name = "ADDR_DISTRICT", nullable = true)
    private String addrDistrict;

    @Column(name = "ADDR_DIST", nullable = true)
    private String addrDist;

    @Column(name = "ADDR_HS_NUM", nullable = true)
    private String addrHsNum;

    @Column(name = "ADDR_APT_DISTRICT", nullable = true)
    private String addrAptDistrict;

    @Column(name = "LGT", nullable = true)
    private Double lgt;

    @Column(name = "LTT", nullable = true)
    private Double ltt;

    @Column(name = "FST_REGPERSN_ID", nullable = true)
    private String fstRegpersnId;

    @Column(name = "FINAL_UPTPERSN_ID", nullable = true)
    private String finalUptpersnId;

    @Column(name = "FST_REG_TM", nullable = true)
    private Date fstRegTm;

    @Column(name = "FINAL_UPT_TM", nullable = true)
    private Date finalUptTm;

    @Column(name = "BLDG_GB_CODE", nullable = true)
    private String bldgGbCode;


    @Builder
    public MBldg(String bldgCode, String bldgNm, String addrState, String addrFcity, String addrWard, String addrDistrict, String addrDist, String addrHsNum, String addrAptDistrict, Double lgt, Double ltt, String fstRegpersnId, String finalUptpersnId, Date fstRegTm, Date finalUptTm, String bldgGbCode) {
        this.bldgCode = bldgCode;
        this.bldgNm = bldgNm;
        this.addrState = addrState;
        this.addrFcity = addrFcity;
        this.addrWard = addrWard;
        this.addrDistrict = addrDistrict;
        this.addrDist = addrDist;
        this.addrHsNum = addrHsNum;
        this.addrAptDistrict = addrAptDistrict;
        this.lgt = lgt;
        this.ltt = ltt;
        this.fstRegpersnId = fstRegpersnId;
        this.finalUptpersnId = finalUptpersnId;
        this.fstRegTm = fstRegTm;
        this.finalUptTm = finalUptTm;
        this.bldgGbCode = bldgGbCode;
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

