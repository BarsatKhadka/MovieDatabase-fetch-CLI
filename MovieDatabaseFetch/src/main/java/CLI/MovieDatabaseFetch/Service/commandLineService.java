package CLI.MovieDatabaseFetch.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class commandLineService {

    List<String> commands = new ArrayList<>(Arrays.asList("playing", "popular", "top", "upcoming"));

    @Autowired
    private getTitleService getTitleService;

    public boolean checkCommand(String command) {
        return commands.contains(command);
    }
    public void print(){
        System.out.print("Hello");
    }


}
