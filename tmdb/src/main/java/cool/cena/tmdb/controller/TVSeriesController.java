package cool.cena.tmdb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cool.cena.tmdb.pojo.response.TVSeriesResponseBody;
import cool.cena.tmdb.pojo.servicedto.TVSeriesServiceDTO;
import cool.cena.tmdb.service.TVSeriesService;

@RestController
@RequestMapping("/tvseries")
public class TVSeriesController {

    @Autowired
    private TVSeriesService tvSeriesService;

    @GetMapping
    public ResponseEntity<TVSeriesResponseBody> getTVSeriesInfo(String title, int year, int season, int episode) {

        tvSeriesService.getTvSeriesInfo(title, year, season, episode);

        return ResponseEntity.ok(new TVSeriesResponseBody());

    }
    
}
