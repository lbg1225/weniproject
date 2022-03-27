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
@Table(name="M_RELATD_BUSN")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED) // AccessLevel.PUBLIC
@EqualsAndHashCode // (of = {"email","name"}, callSuper = true, onParam = @__(@NonNull))
@ToString //(exclude = "password") // exclude 속성을 사용하면, 특정 필드를 toString() 결과에서 제외
public class MRelatdBusn implements Serializable {
    @Id //  String
    @Column(name = "BUSN", nullable = false)
    private String busn;

    @Column(name = "BUSN_NM", nullable = false)
    private String busnNm;

    @Column(name = "BUSN_NM_RUS", nullable = false)
    private String busnNmRus;

    @Column(name = "BUSN_NM_KOR", nullable = false)
    private String busnNmKor;

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
    public MRelatdBusn(String busn, String busnNm, String busnNmRus, String busnNmKor, String delFlag, String fstRegpersnId, String finalUptpersnId, Date fstRegTm, Date finalUptTm) {
        this.busn = busn;
        this.busnNm = busnNm;
        this.busnNmRus = busnNmRus;
        this.busnNmKor = busnNmKor;
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

