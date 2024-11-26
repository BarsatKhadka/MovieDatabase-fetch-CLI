package CLI.MovieDatabaseFetch;


import CLI.MovieDatabaseFetch.Service.getTitleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class MovieDatabaseFetchApplication implements CommandLineRunner {

	private final getTitleService movieTitle;

	@Autowired
	public MovieDatabaseFetchApplication(getTitleService movieTitle) {
		this.movieTitle = movieTitle;
	}

	public static void main(String[] args) {
		SpringApplication.run(MovieDatabaseFetchApplication.class, args);
	}

	public void run(String... args) throws Exception {
		System.out.println("Popular titles");
		movieTitle.getPopularTitle();
		System.out.println("------------------------");
		System.out.println("Now playing Titles");
		movieTitle.getNowPlayingTitle();
		System.out.println("------------------------");
		System.out.println("Top Rated Titles");
		movieTitle.getTopRatedTitle();
		System.out.println("------------------------");
		System.out.println("Upcoming Movie Titles");
		movieTitle.getUpcomingTitle();
	}







}
