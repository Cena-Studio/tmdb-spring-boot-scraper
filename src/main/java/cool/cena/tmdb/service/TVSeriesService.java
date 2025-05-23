package cool.cena.tmdb.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import cool.cena.tmdb.helper.TMDbAPIAccessor;
import cool.cena.tmdb.helper.TMDbConstraint;
import cool.cena.tmdb.pojo.servicedto.TvSeriesServiceDTO;
import cool.cena.tmdb.pojo.tmdbresponse.EpisodeDetailsResponseBody;
import cool.cena.tmdb.pojo.tmdbresponse.SearchTVSeriesResponseBody;
import cool.cena.tmdb.pojo.tmdbresponse.SearchTVSeriesResponseBody.SearchTVSeriesResponseBodyResult;
import cool.cena.tmdb.pojo.tmdbresponse.TvSeriesDetailsResponseBody;
import cool.cena.tmdb.pojo.tmdbresponse.EpisodeDetailsResponseBody.EpisodeDetailsResponseBodyActor;
import cool.cena.tmdb.pojo.tmdbresponse.EpisodeDetailsResponseBody.EpisodeDetailsResponseBodyWorker;
import cool.cena.tmdb.pojo.tmdbresponse.TvSeriesDetailsResponseBody.TVSeriesDetailsResponseBodyCreator;
import cool.cena.tmdb.pojo.tmdbresponse.TvSeriesDetailsResponseBody.TVSeriesDetailsResponseBodyCredit;
import cool.cena.tmdb.pojo.tmdbresponse.TvSeriesDetailsResponseBody.TVSeriesDetailsResponseBodyCreditActor;
import cool.cena.tmdb.pojo.tmdbresponse.TvSeriesDetailsResponseBody.TVSeriesDetailsResponseBodyCreditWorker;
import cool.cena.tmdb.pojo.tmdbresponse.TvSeriesDetailsResponseBody.TVSeriesDetailsResponseBodyNetwork;
import cool.cena.tmdb.pojo.tmdbresponse.TvSeriesDetailsResponseBody.TVSeriesDetailsResponseBodyProductionCompany;
import cool.cena.tmdb.pojo.tmdbresponse.TvSeriesDetailsResponseBody.TVSeriesDetailsResponseBodySeason;

@Service
public class TvSeriesService {

    public TvSeriesServiceDTO getTvSeriesInfo(String title, int year, int seasonSize, int episodeSize) {

        SearchTVSeriesResponseBody searchResults = TMDbAPIAccessor.searchTVSeries(title, year);
        if (searchResults != null) {
            for (SearchTVSeriesResponseBodyResult searchResult : searchResults.getResults()) {
                TvSeriesDetailsResponseBody tvSeries = TMDbAPIAccessor.getTvSeriesDetails(searchResult.getId());
                if (
                    tvSeries.getNumberOfSeasons() == seasonSize &&
                    tvSeries.getNumberOfEpisodes() == episodeSize
                ) {
                    this.downloadBackdropImgFile(tvSeries.getBackdropPath());
                    this.downloadPosterImgFile(tvSeries.getPosterPath());
                    for (TVSeriesDetailsResponseBodyCreator creator : tvSeries.getCreatedBy()) {
                        this.downloadProfileImgFile(creator.getProfilePath());
                    }
                    for (TVSeriesDetailsResponseBodyNetwork network : tvSeries.getNetworks()) {
                        this.downloadLogoImgFile(network.getLogoPath());
                    }
                    for (TVSeriesDetailsResponseBodyProductionCompany company : tvSeries.getProductionCompanies()) {
                        this.downloadLogoImgFile(company.getLogoPath());
                    }
                    List<EpisodeDetailsResponseBody> episodes = new ArrayList<>();
                    long tvSeriesId = tvSeries.getId();
                    for (TVSeriesDetailsResponseBodySeason season : tvSeries.getSeasons()) {
                        this.downloadPosterImgFile(season.getPosterPath());

                        for (int i = 1; i <= season.getEpisodeCount(); i++) {
                            EpisodeDetailsResponseBody episode = TMDbAPIAccessor.getEpisodeDetails(tvSeriesId, season.getSeasonNumber(), i);

                            this.downloadStillImgFile(episode.getStillPath());
                            for (EpisodeDetailsResponseBodyActor actor : episode.getGuestStars()) {
                                this.downloadProfileImgFile(actor.getProfilePath());
                            }
                            for (EpisodeDetailsResponseBodyWorker worker : episode.getCrew()) {
                                this.downloadProfileImgFile(worker.getProfilePath());
                            }

                            episodes.add(episode);
                        }
                    }
                    TVSeriesDetailsResponseBodyCredit credit = tvSeries.getCredits();
                    for (TVSeriesDetailsResponseBodyCreditActor actor : credit.getCast()) {
                        this.downloadProfileImgFile(actor.getProfilePath());
                    }
                    for (TVSeriesDetailsResponseBodyCreditWorker worker : credit.getCrew()) {
                        this.downloadProfileImgFile(worker.getProfilePath());
                    }

                    return new TvSeriesServiceDTO(tvSeries, episodes);           
                }
            }
        }

        return null;
        
    }

    /**
     * @param backdropPath a string that contains a "/" and the file name. E.g. "/abcdefgh.jpg".
     */
    private void downloadBackdropImgFile(String backdropPath) {
        this.downloadImgFile(TMDbConstraint.TMDB_BACKDROP_IMG_PATH, backdropPath);
    }

    /**
     * @param posterPath a string that contains a "/" and the file name. E.g. "/abcdefgh.jpg".
     */
    private void downloadPosterImgFile(String posterPath) {
        this.downloadImgFile(TMDbConstraint.TMDB_POSTER_IMG_PATH, posterPath);
    }

    /**
     * @param profilePath a string that contains a "/" and the file name. E.g. "/abcdefgh.jpg".
     */
    private void downloadProfileImgFile(String profilePath) {
        this.downloadImgFile(TMDbConstraint.TMDB_PROFILE_IMG_PATH, profilePath);
    }

    /**
     * @param logoPath a string that contains a "/" and the file name. E.g. "/abcdefgh.jpg".
     */
    private void downloadLogoImgFile(String logoPath) {
        this.downloadImgFile(TMDbConstraint.TMDB_LOGO_IMG_PATH, logoPath);
    }

    /**
     * @param stillPath a string that contains a "/" and the file name. E.g. "/abcdefgh.jpg".
     */
    private void downloadStillImgFile(String stillPath) {
        this.downloadImgFile(TMDbConstraint.TMDB_STILL_IMG_PATH, stillPath);
    }

    /**
     * Download the image if it does not exist.
     * @param tmdbImgPath the prefix of the url
     * @param filePath a string that contains a "/" and the file name. E.g. "/abcdefgh.jpg".
     */
    private void downloadImgFile(String tmdbImgPath, String filePath) {
        if (filePath == null || filePath.isEmpty()) {
            return;
        }

        File imgFile = new File(TMDbConstraint.IMG_FILE_DIR + filePath);
        if (!imgFile.exists()) {
            String url = tmdbImgPath + filePath;
            byte[] imgData = TMDbAPIAccessor.downloadFileAsBytes(url);

            try (FileOutputStream fos = new FileOutputStream(imgFile)) {
                fos.write(imgData);
                System.out.println("文件写入成功！路径: " + imgFile.getAbsolutePath());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

}
