package com.divergentsl.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import com.divergentsl.services.AuditorAwareImpl;

@Configuration
@EnableJpaAuditing
public class AuditConfiguration {

	@Bean
	AuditorAware<String> getAuditorAware()
	{
		return new AuditorAwareImpl();
	}
}
