package io.github.massimosiani.webreactiveexample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;

@EnableReactiveMongoRepositories
@SpringBootApplication
public class WebReactiveExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebReactiveExampleApplication.class, args);
	}
}
