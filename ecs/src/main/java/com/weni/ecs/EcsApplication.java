package com.weni.ecs;

// import com.weni.ecs.config.kafka.KafkaProcessor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
// import org.springframework.cloud.stream.annotation.EnableBinding;
// import org.springframework.cloud.openfeign.EnableFeignClients;

// gradlew -> gradlew jar
@SpringBootApplication
@EnableJpaAuditing     // JPA Auditing을 활성화 하기 위한 어노테이션
// @EnableBinding(KafkaProcessor.class)
// @EnableFeignClients
public class EcsApplication {
	protected static ApplicationContext applicationContext;
    public static void main(String[] args) {
		SpringApplication.run(EcsApplication.class, args);
	}
}
