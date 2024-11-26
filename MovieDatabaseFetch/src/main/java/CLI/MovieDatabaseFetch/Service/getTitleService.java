package CLI.MovieDatabaseFetch.Service;


import CLI.MovieDatabaseFetch.models.RequestAPIModel;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class getTitleService {


    public RestTemplate restTemplate = new RestTemplate();

    HttpHeaders headers = new HttpHeaders();

    public void getPopularTitle(){
        String url = "https://api.themoviedb.org/3/discover/movie?include_adult=false&include_video=false&language=en-US&page=1&sort_by=popularity.desc";
        headers.set("accept", "application/json");
        headers.set("Authorization", "Bearer {your_api_token}");
        HttpEntity<String> entity = new HttpEntity<>(headers);
        ResponseEntity<RequestAPIModel> responseEntity = restTemplate.exchange(url, HttpMethod.GET, entity, RequestAPIModel.class);
        System.out.println(responseEntity.getBody());
    }


}
