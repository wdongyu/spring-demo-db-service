package org.springframework.samples.demo.db;

import org.aspectj.lang.annotation.Before;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.sleuth.sampler.AlwaysSampler;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.boot.builder.SpringApplicationBuilder;

/**
 * @author wdongyu
 */
@EnableDiscoveryClient
@SpringBootApplication
public class DbServiceApplication {

    @Bean
    RestTemplate restTemplate() {
	    return new RestTemplate();
    }

    @Bean 
    public AlwaysSampler defaultSampler() {
        return new AlwaysSampler();
    }

    public static void main(String[] args) {
	new SpringApplicationBuilder(DbServiceApplication.class).web(true).run(args);
        //SpringApplication.run(DbServiceApplication.class, args);
    }

}
