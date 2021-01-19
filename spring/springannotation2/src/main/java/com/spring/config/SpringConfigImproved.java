package com.spring.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan("com.spring.service")
@Import({JDBCConfig.class, MybatisConfig.class})
public class SpringConfigImproved {
}
