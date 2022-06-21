/** 
* MIncidType Entity 클래스 

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
@Table(name="M_INCID_TYPE") //--PRIMARY
@Getter
@NoArgsConstructor // (access = AccessLevel.PROTECTED) // AccessLevel.PUBLIC
@EqualsAndHashCode // (of = {"email","name"}, callSuper = true, onParam = @__(@NonNull))
@ToString //(exclude = "password") // exclude 속성을 사용하면, 특정 필드를 toString() 결과에서 제외
public class MIncidType {
    @Id //  String
    @Column(name = "INCIDTYPE_BIGCLSSFY_CODE", length = 30, nullable = false)
    private String incidtypeBigclssfyCode; //--null

    @Column(name = "INCIDTYPE_MEDCLSSFY_CODE", length = 30, nullable = false)
    private String incidtypeMedclssfyCode; //--null

    @Column(name = "INCIDTYPE_SMALLCLSSFY_CODE", length = 30, nullable = false)
    private String incidtypeSmallclssfyCode; //--null

    @Column(name = "CLSSFY_LVL", length = 1, nullable = true)
    private String clssfyLvl; //--null

    @Column(name = "INCIDTYPE_BIGCLSSFY_NM", length = 100, nullable = true)
    private String incidtypeBigclssfyNm; //--null

    @Column(name = "INCIDTYPE_MEDCLSSFY_NM", length = 100, nullable = true)
    private String incidtypeMedclssfyNm; //--null

    @Column(name = "INCIDTYPE_SMALLCLSSFY_NM", length = 100, nullable = true)
    private String incidtypeSmallclssfyNm; //--null

    @Column(name = "FST_REGPERSN_ID", length = 30, nullable = true)
    private String fstRegpersnId; //--null

    @Column(name = "FINAL_UPTPERSN_ID", length = 30, nullable = true)
    private String finalUptpersnId; //--null

    @Column(name = "FST_REG_TM", nullable = true)
    private Date fstRegTm; //--null

    @Column(name = "FINAL_UPT_TM", nullable = true)
    private Date finalUptTm; //--null

    @Column(name = "INCIDTYPE_BIGCLSSFY_NM_KOR", length = 100, nullable = true)
    private String incidtypeBigclssfyNmKor; //--null

    @Column(name = "INCIDTYPE_MEDCLSSFY_NM_KOR", length = 100, nullable = true)
    private String incidtypeMedclssfyNmKor; //--null

    @Column(name = "INCIDTYPE_SMALLCLSSFY_NM_KOR", length = 100, nullable = true)
    private String incidtypeSmallclssfyNmKor; //--null

    @Column(name = "INCIDTYPE_BIGCLSSFY_NM_RUS", length = 100, nullable = true)
    private String incidtypeBigclssfyNmRus; //--null

    @Column(name = "INCIDTYPE_MEDCLSSFY_NM_RUS", length = 100, nullable = true)
    private String incidtypeMedclssfyNmRus; //--null

    @Column(name = "INCIDTYPE_SMALLCLSSFY_NM_RUS", length = 100, nullable = true)
    private String incidtypeSmallclssfyNmRus; //--null

    @Column(name = "INCIDTYPE_EXP", length = 4000, nullable = true)
    private String incidtypeExp; //--null

    @Column(name = "INCIDTYPE_BG_COLOR", length = 20, nullable = true)
    private String incidtypeBgColor; //--null


    @Builder
    public MIncidType(String incidtypeBigclssfyCode, String incidtypeMedclssfyCode, String incidtypeSmallclssfyCode, String clssfyLvl, String incidtypeBigclssfyNm, String incidtypeMedclssfyNm, String incidtypeSmallclssfyNm, String fstRegpersnId, String finalUptpersnId, Date fstRegTm, Date finalUptTm, String incidtypeBigclssfyNmKor, String incidtypeMedclssfyNmKor, String incidtypeSmallclssfyNmKor, String incidtypeBigclssfyNmRus, String incidtypeMedclssfyNmRus, String incidtypeSmallclssfyNmRus, String incidtypeExp, String incidtypeBgColor) {
        this.incidtypeBigclssfyCode = incidtypeBigclssfyCode;
        this.incidtypeMedclssfyCode = incidtypeMedclssfyCode;
        this.incidtypeSmallclssfyCode = incidtypeSmallclssfyCode;
        this.clssfyLvl = clssfyLvl;
        this.incidtypeBigclssfyNm = incidtypeBigclssfyNm;
        this.incidtypeMedclssfyNm = incidtypeMedclssfyNm;
        this.incidtypeSmallclssfyNm = incidtypeSmallclssfyNm;
        this.fstRegpersnId = fstRegpersnId;
        this.finalUptpersnId = finalUptpersnId;
        this.fstRegTm = fstRegTm;
        this.finalUptTm = finalUptTm;
        this.incidtypeBigclssfyNmKor = incidtypeBigclssfyNmKor;
        this.incidtypeMedclssfyNmKor = incidtypeMedclssfyNmKor;
        this.incidtypeSmallclssfyNmKor = incidtypeSmallclssfyNmKor;
        this.incidtypeBigclssfyNmRus = incidtypeBigclssfyNmRus;
        this.incidtypeMedclssfyNmRus = incidtypeMedclssfyNmRus;
        this.incidtypeSmallclssfyNmRus = incidtypeSmallclssfyNmRus;
        this.incidtypeExp = incidtypeExp;
        this.incidtypeBgColor = incidtypeBgColor;
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

