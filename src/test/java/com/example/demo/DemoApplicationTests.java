package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.aws.autoconfigure.context.ContextCredentialsAutoConfiguration;


@SpringBootTest
@EnableAutoConfiguration(exclude = ContextCredentialsAutoConfiguration.class)
class DemoApplicationTests {

	@Test
	void contextLoads() {
	}

}
