/** 
* HCallIfHist Entity 클래스 

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
@Table(name="H_CALL_IF_HIST") //--PRIMARY
@Getter
@NoArgsConstructor // (access = AccessLevel.PROTECTED) // AccessLevel.PUBLIC
@EqualsAndHashCode // (of = {"email","name"}, callSuper = true, onParam = @__(@NonNull))
@ToString //(exclude = "password") // exclude 속성을 사용하면, 특정 필드를 toString() 결과에서 제외
public class HCallIfHist {
    @Id //  Integer
    @Column(name = "HIST_SEQ_NUM", nullable = false)
    private Integer histSeqNum; //--null

    @Column(name = "PCALL_STRT_DAYTIME", nullable = true)
    private Date pcallStrtDaytime; //--null

    @Column(name = "PCALL_CLOSE_DAYTIME", nullable = true)
    private Date pcallCloseDaytime; //--null

    @Column(name = "PCALL_LEN", nullable = true)
    private Integer pcallLen; //--null

    @Column(name = "NUMBMKCALL_YN", length = 1, nullable = true)
    private String numbmkcallYn; //--null

    @Column(name = "FAM_NM", length = 100, nullable = true)
    private String famNm; //--null

    @Column(name = "GIV_NM", length = 100, nullable = true)
    private String givNm; //--null

    @Column(name = "CTI_USR_ID", length = 30, nullable = true)
    private String ctiUsrId; //--null

    @Column(name = "CALL_ID", length = 20, nullable = true)
    private String callId; //--null

    @Column(name = "FST_REGPERSN_ID", length = 30, nullable = true)
    private String fstRegpersnId; //--null

    @Column(name = "FINAL_UPTPERSN_ID", length = 30, nullable = true)
    private String finalUptpersnId; //--null

    @Column(name = "FST_REG_TM", nullable = true)
    private Date fstRegTm; //--null

    @Column(name = "FINAL_UPT_TM", nullable = true)
    private Date finalUptTm; //--null


    @Builder
    public HCallIfHist(Integer histSeqNum, Date pcallStrtDaytime, Date pcallCloseDaytime, Integer pcallLen, String numbmkcallYn, String famNm, String givNm, String ctiUsrId, String callId, String fstRegpersnId, String finalUptpersnId, Date fstRegTm, Date finalUptTm) {
        this.histSeqNum = histSeqNum;
        this.pcallStrtDaytime = pcallStrtDaytime;
        this.pcallCloseDaytime = pcallCloseDaytime;
        this.pcallLen = pcallLen;
        this.numbmkcallYn = numbmkcallYn;
        this.famNm = famNm;
        this.givNm = givNm;
        this.ctiUsrId = ctiUsrId;
        this.callId = callId;
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

