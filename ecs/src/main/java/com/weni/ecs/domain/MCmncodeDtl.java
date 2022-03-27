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
@Table(name="M_CMNCODE_DTL")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED) // AccessLevel.PUBLIC
@EqualsAndHashCode // (of = {"email","name"}, callSuper = true, onParam = @__(@NonNull))
@ToString //(exclude = "password") // exclude 속성을 사용하면, 특정 필드를 toString() 결과에서 제외
public class MCmncodeDtl implements Serializable {
    @Id //  String
    @Column(name = "CLSSFY_DTL_CODE", nullable = false)
    private String clssfyDtlCode;

    @Column(name = "CLSSFY_CODE", nullable = false)
    private String clssfyCode;

    @Column(name = "CLSSFY_DTL_NM", nullable = true)
    private String clssfyDtlNm;

    @Column(name = "CLSSFY_1", nullable = true)
    private String clssfy_1;

    @Column(name = "CLSSFY_2", nullable = true)
    private String clssfy_2;

    @Column(name = "CLSSFY_3", nullable = true)
    private String clssfy_3;

    @Column(name = "FST_REGPERSN_ID", nullable = true)
    private String fstRegpersnId;

    @Column(name = "FINAL_UPTPERSN_ID", nullable = true)
    private String finalUptpersnId;

    @Column(name = "FST_REG_TM", nullable = true)
    private Date fstRegTm;

    @Column(name = "FINAL_UPT_TM", nullable = true)
    private Date finalUptTm;

    @Column(name = "CLSSFY_DTL_NM_KOR", nullable = true)
    private String clssfyDtlNmKor;

    @Column(name = "CLSSFY_DTL_NM_RUS", nullable = true)
    private String clssfyDtlNmRus;

    @Column(name = "CLSSFY_DTL_EXP", nullable = true)
    private String clssfyDtlExp;


    @Builder
    public MCmncodeDtl(String clssfyDtlCode, String clssfyCode, String clssfyDtlNm, String clssfy_1, String clssfy_2, String clssfy_3, String fstRegpersnId, String finalUptpersnId, Date fstRegTm, Date finalUptTm, String clssfyDtlNmKor, String clssfyDtlNmRus, String clssfyDtlExp) {
        this.clssfyDtlCode = clssfyDtlCode;
        this.clssfyCode = clssfyCode;
        this.clssfyDtlNm = clssfyDtlNm;
        this.clssfy_1 = clssfy_1;
        this.clssfy_2 = clssfy_2;
        this.clssfy_3 = clssfy_3;
        this.fstRegpersnId = fstRegpersnId;
        this.finalUptpersnId = finalUptpersnId;
        this.fstRegTm = fstRegTm;
        this.finalUptTm = finalUptTm;
        this.clssfyDtlNmKor = clssfyDtlNmKor;
        this.clssfyDtlNmRus = clssfyDtlNmRus;
        this.clssfyDtlExp = clssfyDtlExp;
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

