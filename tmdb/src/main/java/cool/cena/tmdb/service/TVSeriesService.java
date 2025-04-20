package cool.cena.tmdb.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import cool.cena.tmdb.helper.TMDbAPIAccessor;
import cool.cena.tmdb.pojo.servicedto.TVSeriesServiceDTO;
import cool.cena.tmdb.pojo.tmdbresponse.TVSeriesDetailsResponseBody;

@Service
public class TVSeriesService {

    public TVSeriesServiceDTO getTvSeriesInfo(String title, int year, int season, int episode) {
        TVSeriesDetailsResponseBody tvSeriesDetailsResponseBody = TMDbAPIAccessor.requestTVSeries(title, year, season, episode);
        return new TVSeriesServiceDTO(tvSeriesDetailsResponseBody);
    }

}
