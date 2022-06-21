/** 
* MBldgFileInfo Entity 클래스 

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
@Table(name="M_BLDG_FILE_INFO") //--PRIMARY
@Getter
@NoArgsConstructor // (access = AccessLevel.PROTECTED) // AccessLevel.PUBLIC
@EqualsAndHashCode // (of = {"email","name"}, callSuper = true, onParam = @__(@NonNull))
@ToString //(exclude = "password") // exclude 속성을 사용하면, 특정 필드를 toString() 결과에서 제외
public class MBldgFileInfo {
    @Id //  String
    @Column(name = "BLDG_FILE_FOLD", length = 200, nullable = false)
    private String bldgFileFold; //--null

    @Column(name = "FST_REGPERSN_ID", length = 30, nullable = true)
    private String fstRegpersnId; //--null

    @Column(name = "FINAL_UPTPERSN_ID", length = 30, nullable = true)
    private String finalUptpersnId; //--null

    @Column(name = "FST_REG_TM", nullable = true)
    private Date fstRegTm; //--null

    @Column(name = "FINAL_UPT_TM", nullable = true)
    private Date finalUptTm; //--null

    @Column(name = "DTL_DIV_CODE", length = 30, nullable = false)
    private String dtlDivCode; //--null

    @Column(name = "DTL_SEQ_NUM", nullable = false)
    private Integer dtlSeqNum; //--null

    @Column(name = "BLDG_FILE_NM", length = 200, nullable = false)
    private String bldgFileNm; //--null

    @Column(name = "BLDG_FILE_TYPE_CODE", length = 20, nullable = true)
    private String bldgFileTypeCode; //--null

    @Column(name = "BLDG_FILE_FLOOR_CODE", length = 20, nullable = true)
    private String bldgFileFloorCode; //--null

    @Column(name = "BLDG_CODE", length = 24, nullable = false)
    private String bldgCode; //--null


    @Builder
    public MBldgFileInfo(String bldgFileFold, String fstRegpersnId, String finalUptpersnId, Date fstRegTm, Date finalUptTm, String dtlDivCode, Integer dtlSeqNum, String bldgFileNm, String bldgFileTypeCode, String bldgFileFloorCode, String bldgCode) {
        this.bldgFileFold = bldgFileFold;
        this.fstRegpersnId = fstRegpersnId;
        this.finalUptpersnId = finalUptpersnId;
        this.fstRegTm = fstRegTm;
        this.finalUptTm = finalUptTm;
        this.dtlDivCode = dtlDivCode;
        this.dtlSeqNum = dtlSeqNum;
        this.bldgFileNm = bldgFileNm;
        this.bldgFileTypeCode = bldgFileTypeCode;
        this.bldgFileFloorCode = bldgFileFloorCode;
        this.bldgCode = bldgCode;
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

