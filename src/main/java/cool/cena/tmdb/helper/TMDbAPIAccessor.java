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

import cool.cena.tmdb.pojo.tmdbresponse.EpisodeDetailsResponseBody;
import cool.cena.tmdb.pojo.tmdbresponse.SearchTVSeriesResponseBody;
import cool.cena.tmdb.pojo.tmdbresponse.TvSeriesDetailsResponseBody;

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
                    return lineElements[1];
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
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

    public static TvSeriesDetailsResponseBody getTvSeriesDetails(long id) {
        String url = UriComponentsBuilder.fromUriString( "https://api.themoviedb.org/3/tv/" + id)
            .queryParam("append_to_response", "content_ratings,credits")
            .queryParam("language", "zh-CN")
            .encode()
            .toUriString();
        HttpEntity<String> requestEntity = new HttpEntity<>(HTTP_JSON_HEADERS);
        ResponseEntity<TvSeriesDetailsResponseBody> responseEntity = restTemplate.exchange(
            url,
            HttpMethod.GET,
            requestEntity,
            TvSeriesDetailsResponseBody.class
        );
        return responseEntity.getBody();
    }

    public static EpisodeDetailsResponseBody getEpisodeDetails(long tvSeriesId, int season, int episode) {
        String url = UriComponentsBuilder.fromUriString( "https://api.themoviedb.org/3/tv/" + tvSeriesId + "/season/" + season + "/episode/" + episode)
            .queryParam("language", "zh-CN")
            .encode()
            .toUriString();
        HttpEntity<String> requestEntity = new HttpEntity<>(HTTP_JSON_HEADERS);
        ResponseEntity<EpisodeDetailsResponseBody> responseEntity = restTemplate.exchange(
            url,
            HttpMethod.GET,
            requestEntity,
            EpisodeDetailsResponseBody.class
        );
        return responseEntity.getBody();
    }

    public static byte[] downloadFileAsBytes(String url) {
        ResponseEntity<byte[]> responseEntity =  restTemplate.getForEntity(url, byte[].class);
        return responseEntity.getBody();
    }

}
