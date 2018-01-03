package com.util;

import java.util.TimeZone;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.web.servlet.ErrorPage;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan("com.apptium, com.util")
public class Application extends SpringBootServletInitializer {

	static final Logger logger = LoggerFactory.getLogger(Application.class);
	public static ApplicationContext ctx;
	public static String DEFAULT_CORE_URL;
	public static String neo4j_userName;
	public static String neo4j_password;

	public static void main(String[] args) throws Exception {
		logger.info("Application starting....");
		TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
		Environment prop;
		ctx = SpringApplication.run(Application.class, args);
		prop = Application.ctx.getBean(Environment.class);
		if (prop.getProperty("spring.cloud.config.name") == null) {
			logger.warn("EPortal console app is started without spring cloud config server");
		}
		DEFAULT_CORE_URL = ConfigurationProperties.getConfigValue("NEO4J_BOLT_URL");
		neo4j_userName = ConfigurationProperties.getConfigValue("NEO4J_USERNAME");
		neo4j_password = ConfigurationProperties.getConfigValue("NEO4J_PASSWORD");
		logger.info("Application started successfully....");
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(Application.class);
	}

	/*@Bean
	public HttpSessionListener javaMelodyListener() {
		return new net.bull.javamelody.SessionListener();
	}

	@Bean
	public Filter javaMelodyFilter() {
		return new net.bull.javamelody.MonitoringFilter();
	}*/

	@Bean
	public EmbeddedServletContainerCustomizer containerCustomizer() {

		return new EmbeddedServletContainerCustomizer() {
			@Override
			public void customize(ConfigurableEmbeddedServletContainer container) {

				ErrorPage error401Page = new ErrorPage(HttpStatus.UNAUTHORIZED, "/default/pages/AccessDenied.jsp");
				ErrorPage error404Page = new ErrorPage(HttpStatus.SERVICE_UNAVAILABLE,
						"/default/pages/comingSoon.html");
				ErrorPage error451Page = new ErrorPage(HttpStatus.NON_AUTHORITATIVE_INFORMATION,
						"/default/pages/requstAccess.html");
				container.addErrorPages(error401Page);
				container.addErrorPages(error404Page);
				container.addErrorPages(error451Page);
			}
		};
	}
	  @Bean
	    public WebMvcConfigurer corsConfigurer() {
	        return new WebMvcConfigurerAdapter() {
	            @Override
	            public void addCorsMappings(CorsRegistry registry) {
	                registry.addMapping("/**")
	                		.allowedMethods("GET", "POST", "PUT", "DELETE", "HEAD", "OPTIONS");
	            }
	        };
	    }
}