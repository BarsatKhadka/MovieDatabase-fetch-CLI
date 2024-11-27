package CLI.MovieDatabaseFetch;


import CLI.MovieDatabaseFetch.Service.commandLineService;
import CLI.MovieDatabaseFetch.Service.getTitleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import java.io.File;
import java.util.Scanner;

@SpringBootApplication
public class MovieDatabaseFetchApplication implements CommandLineRunner {

	private final commandLineService commandLine;

	@Autowired
	public MovieDatabaseFetchApplication( commandLineService commandLine) {
		this.commandLine = commandLine;
	}

	public static void main(String[] args) {
		SpringApplication.run(MovieDatabaseFetchApplication.class, args);
	}

	public void run(String... args) throws Exception {

		while (true) {
			System.out.print("tmdb-app --type ");
			Scanner scanner = new Scanner(System.in);
			String userInput = scanner.nextLine();
			commandLine.processCommand(userInput);
		}


		}


	}

