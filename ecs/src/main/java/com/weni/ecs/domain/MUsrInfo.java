/** 
* MUsrInfo Entity 클래스 

* @author  Lee Byoung Gwan
* @version 1.0 
*/
package com.weni.ecs.domain;
import java.math.BigDecimal;
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
@Table(name="M_USR_INFO") //--PRIMARY
@Getter
@NoArgsConstructor // (access = AccessLevel.PROTECTED) // AccessLevel.PUBLIC
@EqualsAndHashCode // (of = {"email","name"}, callSuper = true, onParam = @__(@NonNull))
@ToString //(exclude = "password") // exclude 속성을 사용하면, 특정 필드를 toString() 결과에서 제외
public class MUsrInfo {
    @Id //  String
    @Column(name = "USR_ID", length = 30, nullable = false)
    private String usrId; //--null

    @Column(name = "JURIS_CODE", length = 20, nullable = true)
    private String jurisCode; //--null

    @Column(name = "OFF_RANK_CODE", length = 10, nullable = true)
    private String offRankCode; //--null

    @Column(name = "FAM_NM", length = 100, nullable = true)
    private String famNm; //--null

    @Column(name = "GIV_NM", length = 100, nullable = true)
    private String givNm; //--null

    @Column(name = "MID_NM", length = 200, nullable = true)
    private String midNm; //--null

    @Column(name = "PWD", length = 40, nullable = true)
    private String pwd; //--null

    @Column(name = "FST_REGPERSN_ID", length = 30, nullable = true)
    private String fstRegpersnId; //--null

    @Column(name = "FINAL_UPTPERSN_ID", length = 30, nullable = true)
    private String finalUptpersnId; //--null

    @Column(name = "FST_REG_TM", nullable = true)
    private Date fstRegTm; //--null

    @Column(name = "FINAL_UPT_TM", nullable = true)
    private Date finalUptTm; //--null

    @Column(name = "LOCALE_CODE", length = 20, nullable = true)
    private String localeCode; //--null

    @Column(name = "CURR_EXIST_STT", length = 1, nullable = true)
    private String currExistStt; //--null

    @Column(name = "SOFTPHONE_NUM", length = 6, nullable = true)
    private String softphoneNum; //--null

    @Column(name = "LOGIN_KEEP_TM", precision = 10, scale = 0, nullable = true)
    private BigDecimal loginKeepTm; //--null

    @Column(name = "GIS_USR_GRP", length = 30, nullable = true)
    private String gisUsrGrp; //--null


    @Builder
    public MUsrInfo(String usrId, String jurisCode, String offRankCode, String famNm, String givNm, String midNm, String pwd, String fstRegpersnId, String finalUptpersnId, Date fstRegTm, Date finalUptTm, String localeCode, String currExistStt, String softphoneNum, BigDecimal loginKeepTm, String gisUsrGrp) {
        this.usrId = usrId;
        this.jurisCode = jurisCode;
        this.offRankCode = offRankCode;
        this.famNm = famNm;
        this.givNm = givNm;
        this.midNm = midNm;
        this.pwd = pwd;
        this.fstRegpersnId = fstRegpersnId;
        this.finalUptpersnId = finalUptpersnId;
        this.fstRegTm = fstRegTm;
        this.finalUptTm = finalUptTm;
        this.localeCode = localeCode;
        this.currExistStt = currExistStt;
        this.softphoneNum = softphoneNum;
        this.loginKeepTm = loginKeepTm;
        this.gisUsrGrp = gisUsrGrp;
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

