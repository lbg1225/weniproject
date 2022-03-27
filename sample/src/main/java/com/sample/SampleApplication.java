package com.sample;

import com.sample.config.kafka.KafkaProcessor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing     // JPA Auditing을 활성화 하기 위한 어노테이션
@SpringBootApplication
// @EnableBinding(KafkaProcessor.class)
public class SampleApplication {
	protected static ApplicationContext applicationContext;

	public static void main(String[] args) {
		SpringApplication.run(SampleApplication.class, args);
	}

}
