package cool.cena.tmdb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cool.cena.tmdb.pojo.response.TVSeriesResponseBody;
import cool.cena.tmdb.pojo.servicedto.EpisodeServiceDTO;
import cool.cena.tmdb.pojo.servicedto.TvSeriesServiceDTO;
import cool.cena.tmdb.service.EpisodeService;

@RestController
@RequestMapping("/tvseries")
public class EpisodeController {

    @Autowired
    private EpisodeService episodeService;

    @GetMapping
    public ResponseEntity<TVSeriesResponseBody> getEpisodeInfo(String title, int year, int seasonSize, int season, int episodeSize, int episode) {

        EpisodeServiceDTO episodeServiceDTO = episodeService.getEpisodeInfo(title, year, seasonSize, season, episodeSize, episode);

        return ResponseEntity.ok(new TVSeriesResponseBody(null));

    }
    
}
