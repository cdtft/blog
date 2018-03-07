package com.cdut.blog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author wangcheng
 */
@SpringBootApplication
@EnableEurekaServer
public class BlogEurekaServiceApplication {

	public static void main(String[] args) {

		SpringApplication.run(BlogEurekaServiceApplication.class, args);
	}
}
