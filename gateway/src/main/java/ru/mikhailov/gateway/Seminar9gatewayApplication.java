package ru.mikhailov.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

/*
Это модуль GateWay, созданный в учебных целях для управления модулем AppNotes
 */
@SpringBootApplication
public class Seminar9gatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(Seminar9gatewayApplication.class, args);
	}

	@Bean
	public RouteLocator customRoutLocator (RouteLocatorBuilder builder){
		return  builder.routes()
				.route("appnotes",r->r.path("/appnotes/**")
						.uri("http://localhost:8080/")).build();}
	}
