/** 
* MClssfyCodeGetNum Entity 클래스 

* @author  Lee Byoung Gwan
* @version 1.0 
*/
package com.weni.ecs.domain;
import java.sql.Date;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.PostLoad;
import javax.persistence.PrePersist;
import javax.persistence.PostPersist;
import javax.persistence.PreUpdate;
import javax.persistence.PostUpdate;
import javax.persistence.PreRemove;
import javax.persistence.PostRemove;
// import org.springframework.beans.BeanUtils;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.Builder;

@Entity
@Table(name="M_CLSSFY_CODE_GET_NUM") //--PRIMARY
@Getter
@NoArgsConstructor // (access = AccessLevel.PROTECTED) // AccessLevel.PUBLIC
@EqualsAndHashCode // (of = {"email","name"}, callSuper = true, onParam = @__(@NonNull))
@ToString //(exclude = "password") // exclude 속성을 사용하면, 특정 필드를 toString() 결과에서 제외
public class MClssfyCodeGetNum {
    @Id //  String
    @Column(name = "GET_NUM_CODE", length = 20, nullable = false)
    private String getNumCode; //--null

    @Column(name = "JURIS_MNG_CODE", length = 20, nullable = true)
    private String jurisMngCode; //--null

    @Column(name = "MNG_JNL_CLSSFY_CODE", length = 30, nullable = true)
    private String mngJnlClssfyCode; //--null

    @Column(name = "ETC_INCID_MNG_CODE", length = 30, nullable = true)
    private String etcIncidMngCode; //--null

    @Column(name = "FINAL_MNG_JNL_NUM", length = 40, nullable = true)
    private String finalMngJnlNum; //--null

    @Column(name = "FST_REGPERSN_ID", length = 30, nullable = true)
    private String fstRegpersnId; //--null

    @Column(name = "FINAL_UPTPERSN_ID", length = 30, nullable = true)
    private String finalUptpersnId; //--null

    @Column(name = "FST_REG_TM", nullable = true)
    private Date fstRegTm; //--null

    @Column(name = "FINAL_UPT_TM", nullable = true)
    private Date finalUptTm; //--null


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

    //----------------------------------------------------
    // Load/Persist/Update/Remove(조회/신규/수정/삭제)
    // Entity Pre/Post(이전/이후) 처리에 대한 정의(PreLoad는 없음)
    // * DB의 Trigger와 비슷한 JPA기능
    //----------------------------------------------------
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

