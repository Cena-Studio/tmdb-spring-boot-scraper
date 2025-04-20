package cool.cena.tmdb.helper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.fasterxml.jackson.databind.ObjectMapper;

import cool.cena.tmdb.pojo.tmdbresponse.SearchTVSeriesResponseBody;
import cool.cena.tmdb.pojo.tmdbresponse.TVSeriesDetailsResponseBody;
import cool.cena.tmdb.pojo.tmdbresponse.SearchTVSeriesResponseBody.SearchTVSeriesResponseBodyResult;

public class TMDbAPIAccessor {
    
    private static final HttpHeaders HTTP_JSON_HEADERS = new HttpHeaders();
    private static final RestTemplate restTemplate = new RestTemplate();
    private static final String accessToken = "eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiIzMWQwYmQyMDg4MmFkYzc1NjYxZmNkZDc5YjM0MGRkNiIsIm5iZiI6MTc0NDg4MjgzNC43NTQsInN1YiI6IjY4MDBjYzkyYWFjZjdjZmIyNjlhMTlmNSIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.QD7vFp48otJCq7jgfOFHq1xYBtxOZXWpwGYlN1uS70A";
    // private static final ObjectMapper objectMapper = new ObjectMapper();

    static {
        HTTP_JSON_HEADERS.set("accept", "application/json");
        HTTP_JSON_HEADERS.set("Authorization", "Bearer " + accessToken);
    }

    public static TVSeriesDetailsResponseBody requestTVSeries(String title, int year, int season, int episode) {
        SearchTVSeriesResponseBody searchTVSeriesResponseBody = searchTVSeries(title, year);
        if (searchTVSeriesResponseBody != null) {
            for (SearchTVSeriesResponseBodyResult result : searchTVSeriesResponseBody.getResults()) {
                TVSeriesDetailsResponseBody tvSeriesDetailsResponseBody = getTVSeriesDetails(result.getId());
                if (
                    tvSeriesDetailsResponseBody.getNumberOfSeasons() == season &&
                    tvSeriesDetailsResponseBody.getNumberOfEpisodes() == episode
                ) {
                    return tvSeriesDetailsResponseBody;
                }
            }
        }
        return null;
    }

    public static SearchTVSeriesResponseBody searchTVSeries(String title, int year) {
        String url = UriComponentsBuilder.fromUriString( "https://api.themoviedb.org/3/search/tv")
            .queryParam("query", title)
            .queryParam("language", "zh-CN")
            .queryParam("first_air_date_year", year)
            .encode()
            .toUriString();
        HttpEntity<String> requestEntity = new HttpEntity<>(HTTP_JSON_HEADERS);
        ResponseEntity<SearchTVSeriesResponseBody> responseEntity = restTemplate.exchange(
            url,
            HttpMethod.GET,
            requestEntity,
            SearchTVSeriesResponseBody.class
        );
        return responseEntity.getBody();
    }

    public static TVSeriesDetailsResponseBody getTVSeriesDetails(long id) {
        String url = UriComponentsBuilder.fromUriString( "https://api.themoviedb.org/3/tv/" + id)
            .queryParam("append_to_response", "content_ratings,credits")
            .queryParam("language", "zh-CN")
            .encode()
            .toUriString();
        HttpEntity<String> requestEntity = new HttpEntity<>(HTTP_JSON_HEADERS);
        ResponseEntity<TVSeriesDetailsResponseBody> responseEntity = restTemplate.exchange(
            url,
            HttpMethod.GET,
            requestEntity,
            TVSeriesDetailsResponseBody.class
        );
        return responseEntity.getBody();
    }

}
