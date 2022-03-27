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
@Table(name="M_JURIS_MNG_INFO")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED) // AccessLevel.PUBLIC
@EqualsAndHashCode // (of = {"email","name"}, callSuper = true, onParam = @__(@NonNull))
@ToString //(exclude = "password") // exclude 속성을 사용하면, 특정 필드를 toString() 결과에서 제외
public class MJurisMngInfo implements Serializable {
    @Id //  String
    @Column(name = "JURIS_MNG_CODE", nullable = false)
    private String jurisMngCode;

    @Column(name = "JURIS_MNG_NM", nullable = true)
    private String jurisMngNm;

    @Column(name = "JURIS_MNG_NM_KOR", nullable = true)
    private String jurisMngNmKor;

    @Column(name = "JURIS_MNG_NM_RUS", nullable = true)
    private String jurisMngNmRus;

    @Column(name = "JURIS_MNG_ABBR_NM", nullable = true)
    private String jurisMngAbbrNm;

    @Column(name = "FST_REGPERSN_ID", nullable = true)
    private String fstRegpersnId;

    @Column(name = "FINAL_UPTPERSN_ID", nullable = true)
    private String finalUptpersnId;

    @Column(name = "FST_REG_TM", nullable = true)
    private Date fstRegTm;

    @Column(name = "FINAL_UPT_TM", nullable = true)
    private Date finalUptTm;

    @Column(name = "DEL_FLAG", nullable = true)
    private String delFlag;


    @Builder
    public MJurisMngInfo(String jurisMngCode, String jurisMngNm, String jurisMngNmKor, String jurisMngNmRus, String jurisMngAbbrNm, String fstRegpersnId, String finalUptpersnId, Date fstRegTm, Date finalUptTm, String delFlag) {
        this.jurisMngCode = jurisMngCode;
        this.jurisMngNm = jurisMngNm;
        this.jurisMngNmKor = jurisMngNmKor;
        this.jurisMngNmRus = jurisMngNmRus;
        this.jurisMngAbbrNm = jurisMngAbbrNm;
        this.fstRegpersnId = fstRegpersnId;
        this.finalUptpersnId = finalUptpersnId;
        this.fstRegTm = fstRegTm;
        this.finalUptTm = finalUptTm;
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

