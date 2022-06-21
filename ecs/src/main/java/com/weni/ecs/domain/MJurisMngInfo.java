/** 
* MJurisMngInfo Entity 클래스 

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
@Table(name="M_JURIS_MNG_INFO") //--PRIMARY
@Getter
@NoArgsConstructor // (access = AccessLevel.PROTECTED) // AccessLevel.PUBLIC
@EqualsAndHashCode // (of = {"email","name"}, callSuper = true, onParam = @__(@NonNull))
@ToString //(exclude = "password") // exclude 속성을 사용하면, 특정 필드를 toString() 결과에서 제외
public class MJurisMngInfo {
    @Id //  String
    @Column(name = "JURIS_MNG_CODE", length = 20, nullable = false)
    private String jurisMngCode; //--null

    @Column(name = "JURIS_MNG_NM", length = 300, nullable = true)
    private String jurisMngNm; //--null

    @Column(name = "JURIS_MNG_NM_KOR", length = 300, nullable = true)
    private String jurisMngNmKor; //--null

    @Column(name = "JURIS_MNG_NM_RUS", length = 300, nullable = true)
    private String jurisMngNmRus; //--null

    @Column(name = "JURIS_MNG_ABBR_NM", length = 20, nullable = true)
    private String jurisMngAbbrNm; //--null

    @Column(name = "FST_REGPERSN_ID", length = 30, nullable = true)
    private String fstRegpersnId; //--null

    @Column(name = "FINAL_UPTPERSN_ID", length = 30, nullable = true)
    private String finalUptpersnId; //--null

    @Column(name = "FST_REG_TM", nullable = true)
    private Date fstRegTm; //--null

    @Column(name = "FINAL_UPT_TM", nullable = true)
    private Date finalUptTm; //--null

    @Column(name = "DEL_FLAG", length = 1, nullable = true)
    private String delFlag; //--null


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

