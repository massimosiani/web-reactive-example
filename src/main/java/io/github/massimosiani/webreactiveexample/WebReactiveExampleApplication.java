package io.github.massimosiani.webreactiveexample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.reactive.config.EnableWebFlux;

@SpringBootApplication
public class WebReactiveExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebReactiveExampleApplication.class, args);
	}
}
