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
@Table(name="M_ADDR_INFO")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED) // AccessLevel.PUBLIC
@EqualsAndHashCode // (of = {"email","name"}, callSuper = true, onParam = @__(@NonNull))
@ToString //(exclude = "password") // exclude 속성을 사용하면, 특정 필드를 toString() 결과에서 제외
public class MAddrInfo implements Serializable {
    @Id //  String
    @Column(name = "ADDR_ALL_CODE", nullable = false)
    private String addrAllCode;

    @Column(name = "LVL", nullable = true)
    private String lvl;

    @Column(name = "ADDR_STATE_CODE", nullable = true)
    private String addrStateCode;

    @Column(name = "ADDR_CITY_CODE", nullable = true)
    private String addrCityCode;

    @Column(name = "ADDR_DISTRICT_CODE", nullable = true)
    private String addrDistrictCode;

    @Column(name = "ADDR_ALL_NM", nullable = true)
    private String addrAllNm;

    @Column(name = "ADDR_STATE_NM", nullable = true)
    private String addrStateNm;

    @Column(name = "ADDR_CITY_NM", nullable = true)
    private String addrCityNm;

    @Column(name = "ADDR_DISTRICT_NM", nullable = true)
    private String addrDistrictNm;

    @Column(name = "FST_REGPERSN_ID", nullable = true)
    private String fstRegpersnId;

    @Column(name = "FINAL_UPTPERSN_ID", nullable = true)
    private String finalUptpersnId;

    @Column(name = "FST_REG_TM", nullable = true)
    private Date fstRegTm;

    @Column(name = "FINAL_UPT_TM", nullable = true)
    private Date finalUptTm;


    @Builder
    public MAddrInfo(String addrAllCode, String lvl, String addrStateCode, String addrCityCode, String addrDistrictCode, String addrAllNm, String addrStateNm, String addrCityNm, String addrDistrictNm, String fstRegpersnId, String finalUptpersnId, Date fstRegTm, Date finalUptTm) {
        this.addrAllCode = addrAllCode;
        this.lvl = lvl;
        this.addrStateCode = addrStateCode;
        this.addrCityCode = addrCityCode;
        this.addrDistrictCode = addrDistrictCode;
        this.addrAllNm = addrAllNm;
        this.addrStateNm = addrStateNm;
        this.addrCityNm = addrCityNm;
        this.addrDistrictNm = addrDistrictNm;
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

