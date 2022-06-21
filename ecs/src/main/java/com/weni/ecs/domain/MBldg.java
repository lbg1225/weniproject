/** 
* MBldg Entity 클래스 

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
@Table(name="M_BLDG") //--PRIMARY
@Getter
@NoArgsConstructor // (access = AccessLevel.PROTECTED) // AccessLevel.PUBLIC
@EqualsAndHashCode // (of = {"email","name"}, callSuper = true, onParam = @__(@NonNull))
@ToString //(exclude = "password") // exclude 속성을 사용하면, 특정 필드를 toString() 결과에서 제외
public class MBldg {
    @Id //  String
    @Column(name = "BLDG_CODE", length = 24, nullable = false)
    private String bldgCode; //--null

    @Column(name = "BLDG_NM", length = 200, nullable = true)
    private String bldgNm; //--null

    @Column(name = "ADDR_STATE", length = 100, nullable = true)
    private String addrState; //--null

    @Column(name = "ADDR_FCITY", length = 100, nullable = true)
    private String addrFcity; //--null

    @Column(name = "ADDR_WARD", length = 100, nullable = true)
    private String addrWard; //--null

    @Column(name = "ADDR_DISTRICT", length = 100, nullable = true)
    private String addrDistrict; //--null

    @Column(name = "ADDR_DIST", length = 100, nullable = true)
    private String addrDist; //--null

    @Column(name = "ADDR_HS_NUM", length = 100, nullable = true)
    private String addrHsNum; //--null

    @Column(name = "ADDR_APT_DISTRICT", length = 30, nullable = true)
    private String addrAptDistrict; //--null

    @Column(name = "LGT", nullable = true)
    private Float lgt; //--null

    @Column(name = "LTT", nullable = true)
    private Float ltt; //--null

    @Column(name = "FST_REGPERSN_ID", length = 30, nullable = true)
    private String fstRegpersnId; //--null

    @Column(name = "FINAL_UPTPERSN_ID", length = 30, nullable = true)
    private String finalUptpersnId; //--null

    @Column(name = "FST_REG_TM", nullable = true)
    private Date fstRegTm; //--null

    @Column(name = "FINAL_UPT_TM", nullable = true)
    private Date finalUptTm; //--null

    @Column(name = "BLDG_GB_CODE", length = 20, nullable = true)
    private String bldgGbCode; //--null


    @Builder
    public MBldg(String bldgCode, String bldgNm, String addrState, String addrFcity, String addrWard, String addrDistrict, String addrDist, String addrHsNum, String addrAptDistrict, Float lgt, Float ltt, String fstRegpersnId, String finalUptpersnId, Date fstRegTm, Date finalUptTm, String bldgGbCode) {
        this.bldgCode = bldgCode;
        this.bldgNm = bldgNm;
        this.addrState = addrState;
        this.addrFcity = addrFcity;
        this.addrWard = addrWard;
        this.addrDistrict = addrDistrict;
        this.addrDist = addrDist;
        this.addrHsNum = addrHsNum;
        this.addrAptDistrict = addrAptDistrict;
        this.lgt = lgt;
        this.ltt = ltt;
        this.fstRegpersnId = fstRegpersnId;
        this.finalUptpersnId = finalUptpersnId;
        this.fstRegTm = fstRegTm;
        this.finalUptTm = finalUptTm;
        this.bldgGbCode = bldgGbCode;
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

