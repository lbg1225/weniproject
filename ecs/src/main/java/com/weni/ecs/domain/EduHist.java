package com.weni.ecs.domain;
import java.math.BigDecimal;
import java.sql.Timestamp;
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
@Table(name="EDU_HIST")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED) // AccessLevel.PUBLIC
@EqualsAndHashCode // (of = {"email","name"}, callSuper = true, onParam = @__(@NonNull))
@ToString //(exclude = "password") // exclude 속성을 사용하면, 특정 필드를 toString() 결과에서 제외
public class EduHist implements Serializable {
    @Id //  Integer
    @Column(name = "ACNT_NO", nullable = false)
    private Integer acntNo;

    @Column(name = "TX_TIMESTAMP", nullable = false)
    private Timestamp txTimestamp;

    @Column(name = "TYPE", nullable = true)
    private String type;

    @Column(name = "AMOUNT", nullable = true)
    private BigDecimal amount;


    @Builder
    public EduHist(Integer acntNo, Timestamp txTimestamp, String type, BigDecimal amount) {
        this.acntNo = acntNo;
        this.txTimestamp = txTimestamp;
        this.type = type;
        this.amount = amount;
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

