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
@Table(name="M_CMNCODE")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED) // AccessLevel.PUBLIC
@EqualsAndHashCode // (of = {"email","name"}, callSuper = true, onParam = @__(@NonNull))
@ToString //(exclude = "password") // exclude 속성을 사용하면, 특정 필드를 toString() 결과에서 제외
public class MCmncode implements Serializable {
    @Id //  String
    @Column(name = "CLSSFY_CODE", nullable = false)
    private String clssfyCode;

    @Column(name = "CLSSFY_NM", nullable = true)
    private String clssfyNm;

    @Column(name = "FST_REGPERSN_ID", nullable = true)
    private String fstRegpersnId;

    @Column(name = "FINAL_UPTPERSN_ID", nullable = true)
    private String finalUptpersnId;

    @Column(name = "FST_REG_TM", nullable = true)
    private Date fstRegTm;

    @Column(name = "FINAL_UPT_TM", nullable = true)
    private Date finalUptTm;

    @Column(name = "CLSSFY_NM_KOR", nullable = true)
    private String clssfyNmKor;

    @Column(name = "CLSSFY_NM_RUS", nullable = true)
    private String clssfyNmRus;


    @Builder
    public MCmncode(String clssfyCode, String clssfyNm, String fstRegpersnId, String finalUptpersnId, Date fstRegTm, Date finalUptTm, String clssfyNmKor, String clssfyNmRus) {
        this.clssfyCode = clssfyCode;
        this.clssfyNm = clssfyNm;
        this.fstRegpersnId = fstRegpersnId;
        this.finalUptpersnId = finalUptpersnId;
        this.fstRegTm = fstRegTm;
        this.finalUptTm = finalUptTm;
        this.clssfyNmKor = clssfyNmKor;
        this.clssfyNmRus = clssfyNmRus;
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

