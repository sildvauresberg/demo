package com.example.demo;

import com.example.demo.domain.Env;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.aws.autoconfigure.context.ContextInstanceDataAutoConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;


@RestController
@SpringBootApplication(exclude = ContextInstanceDataAutoConfiguration.class)
public class DemoApplication {
	Logger log = LoggerFactory.getLogger(DemoApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@GetMapping("/test")
	public Env env() {
		Map<String, String> properties = System.getProperties()
				.keySet()
				.stream()
				.map(Object::toString)
				.collect(Collectors.toMap(Function.identity(), System::getProperty));
		var env = new Env(properties, System.getenv());
		log.info("env={}", env);
		return env;
	}

	@GetMapping("/ip")
	public Object ip() {
		return new RestTemplate().getForObject("https://api.ipify.org?format=json", Object.class);
	}
}
