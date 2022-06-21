/** 
* MAddrBldg Entity 클래스 

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
@Table(name="M_ADDR_BLDG") //--PRIMARY
@Getter
@NoArgsConstructor // (access = AccessLevel.PROTECTED) // AccessLevel.PUBLIC
@EqualsAndHashCode // (of = {"email","name"}, callSuper = true, onParam = @__(@NonNull))
@ToString //(exclude = "password") // exclude 속성을 사용하면, 특정 필드를 toString() 결과에서 제외
public class MAddrBldg {
    @Id //  String
    @Column(name = "BLDG_CODE", length = 24, nullable = false)
    private String bldgCode; //--null

    @Column(name = "ADDR_ALL_CODE", length = 9, nullable = false)
    private String addrAllCode; //--null

    @Column(name = "ROAD_SECT_CODE", length = 7, nullable = false)
    private String roadSectCode; //--null

    @Column(name = "MAIN_HS_NUM", length = 4, nullable = true)
    private String mainHsNum; //--null

    @Column(name = "SUB_HS_NUM", length = 4, nullable = true)
    private String subHsNum; //--null

    @Column(name = "BLDG_NM", length = 200, nullable = true)
    private String bldgNm; //--null

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


    @Builder
    public MAddrBldg(String bldgCode, String addrAllCode, String roadSectCode, String mainHsNum, String subHsNum, String bldgNm, Float lgt, Float ltt, String fstRegpersnId, String finalUptpersnId, Date fstRegTm, Date finalUptTm) {
        this.bldgCode = bldgCode;
        this.addrAllCode = addrAllCode;
        this.roadSectCode = roadSectCode;
        this.mainHsNum = mainHsNum;
        this.subHsNum = subHsNum;
        this.bldgNm = bldgNm;
        this.lgt = lgt;
        this.ltt = ltt;
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

