package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.aws.autoconfigure.context.ContextCredentialsAutoConfiguration;
import org.springframework.cloud.aws.autoconfigure.context.ContextStackAutoConfiguration;


@SpringBootTest
@EnableAutoConfiguration(exclude = ContextStackAutoConfiguration.class)
class DemoApplicationTests {

	@Test
	void contextLoads() {
	}

}
