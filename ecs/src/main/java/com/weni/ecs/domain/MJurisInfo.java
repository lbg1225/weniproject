/** 
* MJurisInfo Entity 클래스 

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
@Table(name="M_JURIS_INFO") //--PRIMARY
@Getter
@NoArgsConstructor // (access = AccessLevel.PROTECTED) // AccessLevel.PUBLIC
@EqualsAndHashCode // (of = {"email","name"}, callSuper = true, onParam = @__(@NonNull))
@ToString //(exclude = "password") // exclude 속성을 사용하면, 특정 필드를 toString() 결과에서 제외
public class MJurisInfo {
    @Id //  String
    @Column(name = "JURIS_CODE", length = 20, nullable = false)
    private String jurisCode; //--null

    @Column(name = "JURIS_NM", length = 300, nullable = true)
    private String jurisNm; //--null

    @Column(name = "BUSN", length = 20, nullable = true)
    private String busn; //--null

    @Column(name = "FST_REGPERSN_ID", length = 30, nullable = true)
    private String fstRegpersnId; //--null

    @Column(name = "FINAL_UPTPERSN_ID", length = 30, nullable = true)
    private String finalUptpersnId; //--null

    @Column(name = "FST_REG_TM", nullable = true)
    private Date fstRegTm; //--null

    @Column(name = "FINAL_UPT_TM", nullable = true)
    private Date finalUptTm; //--null

    @Column(name = "JURIS_NM_KOR", length = 300, nullable = true)
    private String jurisNmKor; //--null

    @Column(name = "JURIS_NM_RUS", length = 300, nullable = true)
    private String jurisNmRus; //--null

    @Column(name = "LGT", nullable = true)
    private Float lgt; //--null

    @Column(name = "LTT", nullable = true)
    private Float ltt; //--null

    @Column(name = "DEL_FLAG", length = 1, nullable = true)
    private String delFlag; //--null


    @Builder
    public MJurisInfo(String jurisCode, String jurisNm, String busn, String fstRegpersnId, String finalUptpersnId, Date fstRegTm, Date finalUptTm, String jurisNmKor, String jurisNmRus, Float lgt, Float ltt, String delFlag) {
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

