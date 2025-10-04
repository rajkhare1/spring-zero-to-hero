package com.rajkhare.khareschool;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication
@EnableJpaRepositories("com.rajkhare.khareschool.repository")
@EntityScan("com.rajkhare.khareschool.model")
@EnableJpaAuditing(auditorAwareRef = "auditAwareImpl")
public class KhareSchoolApplication {

	public static void main(String[] args) {
		SpringApplication.run(KhareSchoolApplication.class, args);
	}

}
