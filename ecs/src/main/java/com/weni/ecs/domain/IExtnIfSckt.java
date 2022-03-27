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
@Table(name="I_EXTN_IF_SCKT")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED) // AccessLevel.PUBLIC
@EqualsAndHashCode // (of = {"email","name"}, callSuper = true, onParam = @__(@NonNull))
@ToString //(exclude = "password") // exclude 속성을 사용하면, 특정 필드를 toString() 결과에서 제외
public class IExtnIfSckt implements Serializable {
    @Id //  String
    @Column(name = "SER_NUM", nullable = true)
    private String serNum;

    @Column(name = "REQ_ID", nullable = true)
    private String reqId;

    @Column(name = "PROXY_TYPE", nullable = true)
    private String proxyType;

    @Column(name = "HOST", nullable = true)
    private String host;

    @Column(name = "PORT", nullable = true)
    private Integer port;

    @Column(name = "SEND_MSG", nullable = true)
    private String sendMsg;

    @Column(name = "SYNC_YN", nullable = true)
    private Boolean syncYn;

    @Column(name = "FST_REGPERSN_ID", nullable = true)
    private String fstRegpersnId;

    @Column(name = "FINAL_UPTPERSN_ID", nullable = true)
    private String finalUptpersnId;

    @Column(name = "FST_REG_TM", nullable = true)
    private Date fstRegTm;

    @Column(name = "FINAL_UPT_TM", nullable = true)
    private Date finalUptTm;


    @Builder
    public IExtnIfSckt(String serNum, String reqId, String proxyType, String host, Integer port, String sendMsg, Boolean syncYn, String fstRegpersnId, String finalUptpersnId, Date fstRegTm, Date finalUptTm) {
        this.serNum = serNum;
        this.reqId = reqId;
        this.proxyType = proxyType;
        this.host = host;
        this.port = port;
        this.sendMsg = sendMsg;
        this.syncYn = syncYn;
        this.fstRegpersnId = fstRegpersnId;
        this.finalUptpersnId = finalUptpersnId;
        this.fstRegTm = fstRegTm;
        this.finalUptTm = finalUptTm;
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

