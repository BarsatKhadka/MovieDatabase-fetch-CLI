package CLI.MovieDatabaseFetch;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class MovieDatabaseFetchApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(MovieDatabaseFetchApplication.class, args);
	}

	public void run(String... args) throws Exception {
		System.out.println("MovieDatabaseFetchApplication started");
	}

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

}
