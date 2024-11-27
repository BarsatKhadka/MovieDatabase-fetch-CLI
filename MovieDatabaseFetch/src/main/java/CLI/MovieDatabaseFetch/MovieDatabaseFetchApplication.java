package CLI.MovieDatabaseFetch;


import CLI.MovieDatabaseFetch.Service.commandLineService;
import CLI.MovieDatabaseFetch.Service.getTitleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import java.util.Scanner;

@SpringBootApplication
public class MovieDatabaseFetchApplication implements CommandLineRunner {

	private final getTitleService movieTitle;
	private final commandLineService commandLine;

	@Autowired
	public MovieDatabaseFetchApplication(getTitleService movieTitle , commandLineService commandLine) {
		this.movieTitle = movieTitle;
		this.commandLine = commandLine;
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
		while(true) {
			System.out.print("tmdb-app --type ");
			Scanner scanner = new Scanner(System.in);
			String userInput = scanner.nextLine();
			boolean checkCommand = commandLine.checkCommand(userInput);

			if(checkCommand) {
				System.out.print("tmdb-app --type ");
			}


			}
			else{
				System.out.println("Invalid command. For command help type '-h'");
			}
//
//
//		}





	}







}
