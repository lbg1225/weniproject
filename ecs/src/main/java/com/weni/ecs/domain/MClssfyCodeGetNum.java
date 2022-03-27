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
@Table(name="M_CLSSFY_CODE_GET_NUM")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED) // AccessLevel.PUBLIC
@EqualsAndHashCode // (of = {"email","name"}, callSuper = true, onParam = @__(@NonNull))
@ToString //(exclude = "password") // exclude 속성을 사용하면, 특정 필드를 toString() 결과에서 제외
public class MClssfyCodeGetNum implements Serializable {
    @Id //  String
    @Column(name = "GET_NUM_CODE", nullable = false)
    private String getNumCode;

    @Column(name = "JURIS_MNG_CODE", nullable = true)
    private String jurisMngCode;

    @Column(name = "MNG_JNL_CLSSFY_CODE", nullable = true)
    private String mngJnlClssfyCode;

    @Column(name = "ETC_INCID_MNG_CODE", nullable = true)
    private String etcIncidMngCode;

    @Column(name = "FINAL_MNG_JNL_NUM", nullable = true)
    private String finalMngJnlNum;

    @Column(name = "FST_REGPERSN_ID", nullable = true)
    private String fstRegpersnId;

    @Column(name = "FINAL_UPTPERSN_ID", nullable = true)
    private String finalUptpersnId;

    @Column(name = "FST_REG_TM", nullable = true)
    private Date fstRegTm;

    @Column(name = "FINAL_UPT_TM", nullable = true)
    private Date finalUptTm;


    @Builder
    public MClssfyCodeGetNum(String getNumCode, String jurisMngCode, String mngJnlClssfyCode, String etcIncidMngCode, String finalMngJnlNum, String fstRegpersnId, String finalUptpersnId, Date fstRegTm, Date finalUptTm) {
        this.getNumCode = getNumCode;
        this.jurisMngCode = jurisMngCode;
        this.mngJnlClssfyCode = mngJnlClssfyCode;
        this.etcIncidMngCode = etcIncidMngCode;
        this.finalMngJnlNum = finalMngJnlNum;
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

