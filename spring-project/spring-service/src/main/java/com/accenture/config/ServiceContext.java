package com.accenture.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.accenture.config.PersistenceJPAConfig;

@Configuration
@Import(PersistenceJPAConfig.class)
@ComponentScan(basePackages = "com.accenture.service")
public class ServiceContext {

}
