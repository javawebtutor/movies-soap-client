package com.javawebt.movies.ws.client;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@Configuration
public class SoapClientConfig {

	@Bean
	public Jaxb2Marshaller marshaller() {
		Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
		// this package must match the package in the  specified in
		// pom.xml
		marshaller.setContextPath("movies.wsdl");
		return marshaller;
	}

	@Bean
	public MoviesClient movieClient(Jaxb2Marshaller marshaller) {
		MoviesClient client = new MoviesClient();
		client.setDefaultUri("http://localhost:8080/ws/movies");
		client.setMarshaller(marshaller);
		client.setUnmarshaller(marshaller);
		return client;
	}
}
