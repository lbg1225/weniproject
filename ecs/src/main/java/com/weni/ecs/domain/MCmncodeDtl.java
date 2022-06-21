/** 
* MCmncodeDtl Entity 클래스 

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
@Table(name="M_CMNCODE_DTL") //--PRIMARY
@Getter
@NoArgsConstructor // (access = AccessLevel.PROTECTED) // AccessLevel.PUBLIC
@EqualsAndHashCode // (of = {"email","name"}, callSuper = true, onParam = @__(@NonNull))
@ToString //(exclude = "password") // exclude 속성을 사용하면, 특정 필드를 toString() 결과에서 제외
public class MCmncodeDtl {
    @Id //  String
    @Column(name = "CLSSFY_DTL_CODE", length = 30, nullable = false)
    private String clssfyDtlCode; //--null

    @Column(name = "CLSSFY_CODE", length = 20, nullable = false)
    private String clssfyCode; //--null

    @Column(name = "CLSSFY_DTL_NM", length = 100, nullable = true)
    private String clssfyDtlNm; //--null

    @Column(name = "CLSSFY_1", length = 30, nullable = true)
    private String clssfy1; //--null

    @Column(name = "CLSSFY_2", length = 30, nullable = true)
    private String clssfy2; //--null

    @Column(name = "CLSSFY_3", length = 30, nullable = true)
    private String clssfy3; //--null

    @Column(name = "FST_REGPERSN_ID", length = 30, nullable = true)
    private String fstRegpersnId; //--null

    @Column(name = "FINAL_UPTPERSN_ID", length = 30, nullable = true)
    private String finalUptpersnId; //--null

    @Column(name = "FST_REG_TM", nullable = true)
    private Date fstRegTm; //--null

    @Column(name = "FINAL_UPT_TM", nullable = true)
    private Date finalUptTm; //--null

    @Column(name = "CLSSFY_DTL_NM_KOR", length = 100, nullable = true)
    private String clssfyDtlNmKor; //--null

    @Column(name = "CLSSFY_DTL_NM_RUS", length = 100, nullable = true)
    private String clssfyDtlNmRus; //--null

    @Column(name = "CLSSFY_DTL_EXP", length = 4000, nullable = true)
    private String clssfyDtlExp; //--null


    @Builder
    public MCmncodeDtl(String clssfyDtlCode, String clssfyCode, String clssfyDtlNm, String clssfy1, String clssfy2, String clssfy3, String fstRegpersnId, String finalUptpersnId, Date fstRegTm, Date finalUptTm, String clssfyDtlNmKor, String clssfyDtlNmRus, String clssfyDtlExp) {
        this.clssfyDtlCode = clssfyDtlCode;
        this.clssfyCode = clssfyCode;
        this.clssfyDtlNm = clssfyDtlNm;
        this.clssfy1 = clssfy1;
        this.clssfy2 = clssfy2;
        this.clssfy3 = clssfy3;
        this.fstRegpersnId = fstRegpersnId;
        this.finalUptpersnId = finalUptpersnId;
        this.fstRegTm = fstRegTm;
        this.finalUptTm = finalUptTm;
        this.clssfyDtlNmKor = clssfyDtlNmKor;
        this.clssfyDtlNmRus = clssfyDtlNmRus;
        this.clssfyDtlExp = clssfyDtlExp;
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

