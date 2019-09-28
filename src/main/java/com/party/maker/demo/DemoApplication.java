package com.party.maker.demo;

import com.party.maker.demo.domain.EventDetails;
import com.party.maker.demo.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import springfox.documentation.RequestHandler;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class

DemoApplication /*implements CommandLineRunner*/ {

/*	private final EventRepository repository;

	@Autowired
	public DemoApplication(EventRepository repository) {
		this.repository = repository;
	}*/

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

/*	@Override
	public void run(String... args) throws Exception {
		EventDetails details = new EventDetails();
		*//*details.setEventID(300L);*//*
		details.setEventName("Birthday");
		repository.save(details);

		EventDetails details1 = new EventDetails();
		details1.setEventName("Graduation");
		repository.save(details1);
	}*/

	@Bean
	public Docket productApi(){
		return new Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.basePackage("com.party.maker.demo")).build();
	}
}
