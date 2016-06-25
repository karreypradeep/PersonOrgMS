package com.brilapps;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

@SpringBootApplication
@EnableRedisHttpSession
public class PersonOrgMsApplication {

	public static void main(final String[] args) {
		SpringApplication.run(PersonOrgMsApplication.class, args);
	}
}
