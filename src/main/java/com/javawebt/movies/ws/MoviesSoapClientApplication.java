package com.javawebt.movies.ws;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.javawebt.movies.ws.client.MoviesClient;
import com.javawebt.movies.ws.client.SoapClientConfig;

import movies.wsdl.GetMovieByIdResponse;

@SpringBootApplication
public class MoviesSoapClientApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(MoviesSoapClientApplication.class, args);

	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Runner is executing ********");
		System.out.println("****************************************");
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SoapClientConfig.class);
		MoviesClient client = context.getBean(MoviesClient.class);
		GetMovieByIdResponse response = client.getMovieById(new Long(107));
		System.out.println("response: Movie id=" + response.getMovieType().getMovieId() + ", title="
				+ response.getMovieType().getTitle() + ", category=" + response.getMovieType().getCategory());
		
	}

}
