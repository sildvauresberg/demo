package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Value;

import java.nio.file.FileStore;
import java.nio.file.FileSystems;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;


@RestController
@SpringBootApplication
public class DemoApplication {
	@Value("${collector.jpg-dir:not found}") private String dir;
	@Value("${AWS_ACCESS_KEY_ID:not found}") private String accessKey;
	@Value("${AWS_SECRET_ACCESS_KEY:not found}") private String secretAccessKey;
	@Value("${AWS_DEFAULT_REGION:not found}") private String region;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@GetMapping("/test")
	public ResponseEntity<String> test() {
		String rBody = Stream.concat(
			StreamSupport.stream(
				FileSystems.getDefault().getFileStores().spliterator(),
				false
			)
				.map(FileStore::name),
			Stream.of(
				"dir=" + dir,
				"accessKey=" + accessKey,
				"secretAccessKey=" + secretAccessKey,
				"region=" + region
			)
		)
			.collect(Collectors.joining());
		return ResponseEntity.ok(rBody);
	}
}
