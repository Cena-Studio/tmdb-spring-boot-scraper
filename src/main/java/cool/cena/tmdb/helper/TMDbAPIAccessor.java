package cool.cena.tmdb.helper;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import cool.cena.tmdb.pojo.tmdbresponse.SearchTVSeriesResponseBody;
import cool.cena.tmdb.pojo.tmdbresponse.TVSeriesDetailsResponseBody;
import cool.cena.tmdb.pojo.tmdbresponse.SearchTVSeriesResponseBody.SearchTVSeriesResponseBodyResult;

public class TMDbAPIAccessor {
    
    private static final String accessToken = getAccessToken();
    private static final HttpHeaders HTTP_JSON_HEADERS = initHTTPJSONHeaders();
    private static final RestTemplate restTemplate = new RestTemplate();
    // private static final ObjectMapper objectMapper = new ObjectMapper();

    private static String getAccessToken() {
        try (
            FileReader fr = new FileReader(TMDbConstraint.FILE_DIR + "/config.csv");
            Scanner fs = new Scanner(fr)
        ) {
            while (fs.hasNextLine()) {
                String[] lineElements = fs.nextLine().split(",", -1);
                if (lineElements[0].equals("accessToken")) {
                    System.out.println("access token fetched: " + lineElements[1]);
                    return lineElements[1];
                }
            }
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return null;
    }

    private static HttpHeaders initHTTPJSONHeaders() {
        HttpHeaders HTTP_JSON_HEADERS = new HttpHeaders();
        HTTP_JSON_HEADERS.set("accept", "application/json");
        HTTP_JSON_HEADERS.set("Authorization", "Bearer " + accessToken);
        return HTTP_JSON_HEADERS;
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

    public static byte[] downloadFileAsBytes(String url) {
        ResponseEntity<byte[]> responseEntity =  restTemplate.getForEntity(url, byte[].class);
        return responseEntity.getBody();
    }

}
