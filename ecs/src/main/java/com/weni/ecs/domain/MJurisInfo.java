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
@Table(name="M_JURIS_INFO")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED) // AccessLevel.PUBLIC
@EqualsAndHashCode // (of = {"email","name"}, callSuper = true, onParam = @__(@NonNull))
@ToString //(exclude = "password") // exclude 속성을 사용하면, 특정 필드를 toString() 결과에서 제외
public class MJurisInfo implements Serializable {
    @Id //  String
    @Column(name = "JURIS_CODE", nullable = false)
    private String jurisCode;

    @Column(name = "JURIS_NM", nullable = true)
    private String jurisNm;

    @Column(name = "BUSN", nullable = true)
    private String busn;

    @Column(name = "FST_REGPERSN_ID", nullable = true)
    private String fstRegpersnId;

    @Column(name = "FINAL_UPTPERSN_ID", nullable = true)
    private String finalUptpersnId;

    @Column(name = "FST_REG_TM", nullable = true)
    private Date fstRegTm;

    @Column(name = "FINAL_UPT_TM", nullable = true)
    private Date finalUptTm;

    @Column(name = "JURIS_NM_KOR", nullable = true)
    private String jurisNmKor;

    @Column(name = "JURIS_NM_RUS", nullable = true)
    private String jurisNmRus;

    @Column(name = "LGT", nullable = true)
    private Double lgt;

    @Column(name = "LTT", nullable = true)
    private Double ltt;

    @Column(name = "DEL_FLAG", nullable = true)
    private String delFlag;


    @Builder
    public MJurisInfo(String jurisCode, String jurisNm, String busn, String fstRegpersnId, String finalUptpersnId, Date fstRegTm, Date finalUptTm, String jurisNmKor, String jurisNmRus, Double lgt, Double ltt, String delFlag) {
        this.jurisCode = jurisCode;
        this.jurisNm = jurisNm;
        this.busn = busn;
        this.fstRegpersnId = fstRegpersnId;
        this.finalUptpersnId = finalUptpersnId;
        this.fstRegTm = fstRegTm;
        this.finalUptTm = finalUptTm;
        this.jurisNmKor = jurisNmKor;
        this.jurisNmRus = jurisNmRus;
        this.lgt = lgt;
        this.ltt = ltt;
        this.delFlag = delFlag;
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

