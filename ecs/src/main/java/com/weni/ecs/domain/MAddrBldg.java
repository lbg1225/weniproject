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
@Table(name="M_ADDR_BLDG")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED) // AccessLevel.PUBLIC
@EqualsAndHashCode // (of = {"email","name"}, callSuper = true, onParam = @__(@NonNull))
@ToString //(exclude = "password") // exclude 속성을 사용하면, 특정 필드를 toString() 결과에서 제외
public class MAddrBldg implements Serializable {
    @Id //  String
    @Column(name = "BLDG_CODE", nullable = false)
    private String bldgCode;

    @Column(name = "ADDR_ALL_CODE", nullable = false)
    private String addrAllCode;

    @Column(name = "ROAD_SECT_CODE", nullable = false)
    private String roadSectCode;

    @Column(name = "MAIN_HS_NUM", nullable = true)
    private String mainHsNum;

    @Column(name = "SUB_HS_NUM", nullable = true)
    private String subHsNum;

    @Column(name = "BLDG_NM", nullable = true)
    private String bldgNm;

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


    @Builder
    public MAddrBldg(String bldgCode, String addrAllCode, String roadSectCode, String mainHsNum, String subHsNum, String bldgNm, Double lgt, Double ltt, String fstRegpersnId, String finalUptpersnId, Date fstRegTm, Date finalUptTm) {
        this.bldgCode = bldgCode;
        this.addrAllCode = addrAllCode;
        this.roadSectCode = roadSectCode;
        this.mainHsNum = mainHsNum;
        this.subHsNum = subHsNum;
        this.bldgNm = bldgNm;
        this.lgt = lgt;
        this.ltt = ltt;
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

