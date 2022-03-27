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
@Table(name="M_BTN_ROLE")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED) // AccessLevel.PUBLIC
@EqualsAndHashCode // (of = {"email","name"}, callSuper = true, onParam = @__(@NonNull))
@ToString //(exclude = "password") // exclude 속성을 사용하면, 특정 필드를 toString() 결과에서 제외
public class MBtnRole implements Serializable {
    @Id //  String
    @Column(name = "BTN_ROLE_CODE", nullable = false)
    private String btnRoleCode;

    @Column(name = "BTN_ROLE_NM", nullable = false)
    private String btnRoleNm;

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

    @Column(name = "BTN_ROLE_NM_RUS", nullable = false)
    private String btnRoleNmRus;

    @Column(name = "BTN_ROLE_NM_KOR", nullable = false)
    private String btnRoleNmKor;


    @Builder
    public MBtnRole(String btnRoleCode, String btnRoleNm, String delFlag, String fstRegpersnId, String finalUptpersnId, Date fstRegTm, Date finalUptTm, String btnRoleNmRus, String btnRoleNmKor) {
        this.btnRoleCode = btnRoleCode;
        this.btnRoleNm = btnRoleNm;
        this.delFlag = delFlag;
        this.fstRegpersnId = fstRegpersnId;
        this.finalUptpersnId = finalUptpersnId;
        this.fstRegTm = fstRegTm;
        this.finalUptTm = finalUptTm;
        this.btnRoleNmRus = btnRoleNmRus;
        this.btnRoleNmKor = btnRoleNmKor;
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

