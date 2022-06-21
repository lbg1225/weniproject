/** 
* HChangeHist Entity 클래스 

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
@Table(name="H_CHANGE_HIST") //--PRIMARY
@Getter
@NoArgsConstructor // (access = AccessLevel.PROTECTED) // AccessLevel.PUBLIC
@EqualsAndHashCode // (of = {"email","name"}, callSuper = true, onParam = @__(@NonNull))
@ToString //(exclude = "password") // exclude 속성을 사용하면, 특정 필드를 toString() 결과에서 제외
public class HChangeHist {
    @Id //  Integer
    @Column(name = "CHANGE_SEQ_NUM", nullable = false)
    private Integer changeSeqNum; //--null

    @Column(name = "RECPT_NUM", nullable = false)
    private Integer recptNum; //--null

    @Column(name = "USR_ID", length = 30, nullable = true)
    private String usrId; //--null

    @Column(name = "CHANGE_DIV", length = 1, nullable = true)
    private String changeDiv; //--null

    @Column(name = "CHANGE_ITEM", length = 200, nullable = true)
    private String changeItem; //--null

    @Column(name = "PRE_DATA", length = 4000, nullable = true)
    private String preData; //--null

    @Column(name = "AFTER_DATA", length = 4000, nullable = true)
    private String afterData; //--null

    @Column(name = "CHANGEPERSN_ID", length = 30, nullable = false)
    private String changepersnId; //--null

    @Column(name = "CHANGE_TM", nullable = true)
    private Date changeTm; //--null

    @Column(name = "FST_REGPERSN_ID", length = 30, nullable = true)
    private String fstRegpersnId; //--null

    @Column(name = "FINAL_UPTPERSN_ID", length = 30, nullable = true)
    private String finalUptpersnId; //--null

    @Column(name = "FST_REG_TM", nullable = true)
    private Date fstRegTm; //--null

    @Column(name = "FINAL_UPT_TM", nullable = true)
    private Date finalUptTm; //--null


    @Builder
    public HChangeHist(Integer changeSeqNum, Integer recptNum, String usrId, String changeDiv, String changeItem, String preData, String afterData, String changepersnId, Date changeTm, String fstRegpersnId, String finalUptpersnId, Date fstRegTm, Date finalUptTm) {
        this.changeSeqNum = changeSeqNum;
        this.recptNum = recptNum;
        this.usrId = usrId;
        this.changeDiv = changeDiv;
        this.changeItem = changeItem;
        this.preData = preData;
        this.afterData = afterData;
        this.changepersnId = changepersnId;
        this.changeTm = changeTm;
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

