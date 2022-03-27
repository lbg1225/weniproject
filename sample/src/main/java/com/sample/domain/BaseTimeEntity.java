package com.sample.domain;

import java.time.LocalDateTime;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.Getter;

//-------------------------------------------------------------------------------------------------------------
// 1. BaseTimeEntity 클래스를 만듭니다.
//    이 클래스는 모든 Entity의 상위 클래스가 되어 Entity 들의 createdDate, modifiedDate를 자동으로 관리하는 역할입니다.
//    @MappedSuperclass : JPA Entity 클래스들이 BaseTimeEntity를 상속할 경우 필드들(createdDate, modifiedDate)도 
//    칼럼으로 인식하도록 합니다.
//    @EntityListeners(AuditingEntityListener.class): BaseTimeEntiy 클래스에 Auditing 기능을 포함시킵니다.
//    @CreatedDate: Entity가 생성되어 저장될 때 시간이 자동 저장됩니다.
//    @LastModifiedDate: 조회한 Entity의 값을 변경할 때 시간이 자동 저장됩니다. 
//    
// 2. Order 클래스가 BaseTimeEntity를 상속하도록 했습니다.
//    현재 개발 초기 단계라서 다른 데이터 없이 id, 생성시간, 수정시간만 가지도록 했습니다.
//    @Entity
//    @Table(name = "ORDERS")
//    public class Order extends BaseTimeEntity {  
//        @Id
//        @GeneratedValue(strategy = GenerationType.IDENTITY)
//        private Long id; 
//        public Order() {
//        }
//    }
//
// 3. JPA Auditing 어노테이션들을 모두 활성화할 수 있도록 Application 클래스에 활성화 어노테이션을 추가합니다.
//    @EnableJpaAuditing
//    @SpringBootApplication
//    public class Application {
//        public static void main(String[] args) {
//            SpringApplication.run(CaffeineApplication.class, args);
//        }
//    }
//    @EnableJpaAuditing: JPA Auditing을 활성화 하기 위한 어노테이션입니다.
//-------------------------------------------------------------------------------------------------------------
@Getter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseTimeEntity {

    @CreatedDate
    private LocalDateTime createdDate;

    @LastModifiedDate
    private LocalDateTime modifiedDate;
}