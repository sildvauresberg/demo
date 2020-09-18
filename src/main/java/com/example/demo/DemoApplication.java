package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.aws.autoconfigure.context.ContextInstanceDataAutoConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;


@RestController
@SpringBootApplication(exclude = ContextInstanceDataAutoConfiguration.class)
public class DemoApplication {
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@GetMapping("/test")
	public Env test() {
		Map<String, String> properties = System.getProperties()
				.keySet()
				.stream()
				.map(Object::toString)
				.collect(Collectors.toMap(Function.identity(), System::getProperty));
		return new Env(properties, System.getenv());
	}

	private static class Env {
		private final Map<String, String> props;
		private final Map<String, String> env;

		private Env(Map<String, String> props, Map<String, String> env) {
			this.props = props;
			this.env = env;
		}

		public Map<String, String> getProps() {
			return props;
		}

		public Map<String, String> getEnv() {
			return env;
		}
	}
}
