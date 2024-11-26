package CLI.MovieDatabaseFetch.Service;


import CLI.MovieDatabaseFetch.models.RequestAPIModel;
import CLI.MovieDatabaseFetch.models.Result;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class getTitleService {


    public RestTemplate restTemplate = new RestTemplate();

    @Value("${spring.TMDB.apiKey}")
    private String apiKey;

    private String baseUrl = "https://api.themoviedb.org/3/discover/movie";

    private ResponseEntity<RequestAPIModel> apiResponse(String requestUrl) {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer "+apiKey);
        headers.set("accept", "application/json");
        HttpEntity<String> headerEntity = new HttpEntity<>(headers);
        String url = baseUrl + requestUrl;
        return restTemplate.exchange(url, HttpMethod.GET, headerEntity, RequestAPIModel.class);
    }




    public void getPopularTitle(){
        String url = "?include_adult=false&include_video=false&language=en-US&page=1&sort_by=popularity.desc";
        ResponseEntity<RequestAPIModel> responseEntity = apiResponse(url);
        if(responseEntity.getBody() != null && responseEntity.getBody().getAllResults() != null){
            for(Result result : responseEntity.getBody().getAllResults()){
                System.out.println(result.getMovietitle());
            }
        }
    }

    public void getNowPlayingTitle(){

        LocalDateTime now = LocalDateTime.now();
        LocalDateTime tenDaysAgo = now.minusDays(10);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String maxDate = now.format(formatter);
        String minDate = tenDaysAgo.format(formatter);

        String url = "?include_adult=false&include_video=false&language=en-US&page=1&sort_by=popularity.desc&with_release_type=2|3&release_date.gte=" +minDate+ "&release_date.lte=" + maxDate;

        ResponseEntity<RequestAPIModel> responseEntity = apiResponse(url);
        if(responseEntity.getBody() != null && responseEntity.getBody().getAllResults() != null){
            for(Result result : responseEntity.getBody().getAllResults()){
                System.out.println(result.getMovietitle());
            }
        }


    }

    public void getTopRatedTitle(){
        String url = "?include_adult=false&include_video=false&language=en-US&page=1&sort_by=vote_average.desc&without_genres=99,10755&vote_count.gte=200";
        ResponseEntity<RequestAPIModel> responseEntity=  apiResponse(url);
        if(responseEntity.getBody() != null && responseEntity.getBody().getAllResults() != null){
            for(Result result : responseEntity.getBody().getAllResults()){
                System.out.println(result.getMovietitle());
            }
        }
    }

    public void getUpcomingTitle(){
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime monthAfter = now.plusDays(30);
        LocalDateTime threeMonthAfter = now.plusDays(90);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String maxDate = threeMonthAfter.format(formatter);
        String minDate = monthAfter.format(formatter);
        String url = "?include_adult=false&include_video=false&language=en-US&page=1&sort_by=popularity.desc&with_release_type=2|3&release_date.gte=" + minDate +"&release_date.lte=" +maxDate;


        ResponseEntity<RequestAPIModel> responseEntity = apiResponse(url);
        if(responseEntity.getBody() != null && responseEntity.getBody().getAllResults() != null){
            for(Result result : responseEntity.getBody().getAllResults()){
                System.out.println(result.getMovietitle());
            }
        }

    }


}
