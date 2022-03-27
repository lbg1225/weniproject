package com.weni.ecs.domain;
import java.sql.Date;
import java.io.Serializable;
import javax.persistence.*;
// import org.springframework.beans.BeanUtils;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.Builder;

@Entity
@Table(name="M_BLDG_FILE_INFO")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED) // AccessLevel.PUBLIC
@EqualsAndHashCode // (of = {"email","name"}, callSuper = true, onParam = @__(@NonNull))
@ToString //(exclude = "password") // exclude 속성을 사용하면, 특정 필드를 toString() 결과에서 제외
public class MBldgFileInfo implements Serializable {
    @Id //  String
    @Column(name = "BLDG_FILE_FOLD", nullable = false)
    private String bldgFileFold;

    @Column(name = "FST_REGPERSN_ID", nullable = true)
    private String fstRegpersnId;

    @Column(name = "FINAL_UPTPERSN_ID", nullable = true)
    private String finalUptpersnId;

    @Column(name = "FST_REG_TM", nullable = true)
    private Date fstRegTm;

    @Column(name = "FINAL_UPT_TM", nullable = true)
    private Date finalUptTm;

    @Column(name = "DTL_DIV_CODE", nullable = false)
    private String dtlDivCode;

    @Column(name = "DTL_SEQ_NUM", nullable = false)
    private Integer dtlSeqNum;

    @Column(name = "BLDG_FILE_NM", nullable = false)
    private String bldgFileNm;

    @Column(name = "BLDG_FILE_TYPE_CODE", nullable = true)
    private String bldgFileTypeCode;

    @Column(name = "BLDG_FILE_FLOOR_CODE", nullable = true)
    private String bldgFileFloorCode;

    @Column(name = "BLDG_CODE", nullable = false)
    private String bldgCode;


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

