package cool.cena.tmdb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cool.cena.tmdb.pojo.response.TvSeriesResponseBody;
import cool.cena.tmdb.pojo.servicedto.TvSeriesServiceDTO;
import cool.cena.tmdb.service.TvSeriesService;

@RestController
@RequestMapping("/tvseries")
public class TVSeriesController {

    @Autowired
    private TvSeriesService tvSeriesService;

    @GetMapping
    public ResponseEntity<TvSeriesResponseBody> getTVSeriesInfo(String title, int year, int season, int episode) {

        TvSeriesServiceDTO tvSeriesServiceDTO = tvSeriesService.getTvSeriesInfo(title, year, season, episode);

        return ResponseEntity.ok(new TvSeriesResponseBody(tvSeriesServiceDTO));

    }

    // @GetMapping
    // public ResponseEntity<String> getTVSeriesInfo(String title, int year, int season, int episode) {

    //     }
    
}
