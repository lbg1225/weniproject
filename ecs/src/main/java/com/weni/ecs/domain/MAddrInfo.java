/** 
* MAddrInfo Entity 클래스 

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
@Table(name="M_ADDR_INFO") //--PRIMARY
@Getter
@NoArgsConstructor // (access = AccessLevel.PROTECTED) // AccessLevel.PUBLIC
@EqualsAndHashCode // (of = {"email","name"}, callSuper = true, onParam = @__(@NonNull))
@ToString //(exclude = "password") // exclude 속성을 사용하면, 특정 필드를 toString() 결과에서 제외
public class MAddrInfo {
    @Id //  String
    @Column(name = "ADDR_ALL_CODE", length = 9, nullable = false)
    private String addrAllCode; //--null

    @Column(name = "LVL", length = 1, nullable = true)
    private String lvl; //--null

    @Column(name = "ADDR_STATE_CODE", length = 2, nullable = true)
    private String addrStateCode; //--null

    @Column(name = "ADDR_CITY_CODE", length = 3, nullable = true)
    private String addrCityCode; //--null

    @Column(name = "ADDR_DISTRICT_CODE", length = 4, nullable = true)
    private String addrDistrictCode; //--null

    @Column(name = "ADDR_ALL_NM", length = 500, nullable = true)
    private String addrAllNm; //--null

    @Column(name = "ADDR_STATE_NM", length = 100, nullable = true)
    private String addrStateNm; //--null

    @Column(name = "ADDR_CITY_NM", length = 100, nullable = true)
    private String addrCityNm; //--null

    @Column(name = "ADDR_DISTRICT_NM", length = 100, nullable = true)
    private String addrDistrictNm; //--null

    @Column(name = "FST_REGPERSN_ID", length = 30, nullable = true)
    private String fstRegpersnId; //--null

    @Column(name = "FINAL_UPTPERSN_ID", length = 30, nullable = true)
    private String finalUptpersnId; //--null

    @Column(name = "FST_REG_TM", nullable = true)
    private Date fstRegTm; //--null

    @Column(name = "FINAL_UPT_TM", nullable = true)
    private Date finalUptTm; //--null


    @Builder
    public MAddrInfo(String addrAllCode, String lvl, String addrStateCode, String addrCityCode, String addrDistrictCode, String addrAllNm, String addrStateNm, String addrCityNm, String addrDistrictNm, String fstRegpersnId, String finalUptpersnId, Date fstRegTm, Date finalUptTm) {
        this.addrAllCode = addrAllCode;
        this.lvl = lvl;
        this.addrStateCode = addrStateCode;
        this.addrCityCode = addrCityCode;
        this.addrDistrictCode = addrDistrictCode;
        this.addrAllNm = addrAllNm;
        this.addrStateNm = addrStateNm;
        this.addrCityNm = addrCityNm;
        this.addrDistrictNm = addrDistrictNm;
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

