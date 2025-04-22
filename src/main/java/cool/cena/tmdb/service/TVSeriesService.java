package cool.cena.tmdb.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.springframework.stereotype.Service;

import cool.cena.tmdb.helper.TMDbAPIAccessor;
import cool.cena.tmdb.helper.TMDbConstraint;
import cool.cena.tmdb.pojo.servicedto.TvSeriesServiceDTO;
import cool.cena.tmdb.pojo.tmdbresponse.SearchTVSeriesResponseBody;
import cool.cena.tmdb.pojo.tmdbresponse.SearchTVSeriesResponseBody.SearchTVSeriesResponseBodyResult;
import cool.cena.tmdb.pojo.tmdbresponse.TvSeriesDetailsResponseBody;
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

        SearchTVSeriesResponseBody searchTVSeriesResponseBody = TMDbAPIAccessor.searchTVSeries(title, year);
        if (searchTVSeriesResponseBody != null) {
            for (SearchTVSeriesResponseBodyResult result : searchTVSeriesResponseBody.getResults()) {
                TvSeriesDetailsResponseBody tvSeriesDetailsResponseBody = TMDbAPIAccessor.getTvSeriesDetails(result.getId());
                if (
                    tvSeriesDetailsResponseBody.getNumberOfSeasons() == seasonSize &&
                    tvSeriesDetailsResponseBody.getNumberOfEpisodes() == episodeSize
                ) {
                    this.downloadBackdropImgFile(tvSeriesDetailsResponseBody.getBackdropPath());
                    this.downloadPosterImgFile(tvSeriesDetailsResponseBody.getPosterPath());
                    for (TVSeriesDetailsResponseBodyCreator creator : tvSeriesDetailsResponseBody.getCreatedBy()) {
                        this.downloadProfileImgFile(creator.getProfilePath());
                    }
                    for (TVSeriesDetailsResponseBodyNetwork network : tvSeriesDetailsResponseBody.getNetworks()) {
                        this.downloadLogoImgFile(network.getLogoPath());
                    }
                    for (TVSeriesDetailsResponseBodyProductionCompany company : tvSeriesDetailsResponseBody.getProductionCompanies()) {
                        this.downloadLogoImgFile(company.getLogoPath());
                    }
                    for (TVSeriesDetailsResponseBodySeason season : tvSeriesDetailsResponseBody.getSeasons()) {
                        this.downloadPosterImgFile(season.getPosterPath());
                    }
                    TVSeriesDetailsResponseBodyCredit credit = tvSeriesDetailsResponseBody.getCredits();
                    for (TVSeriesDetailsResponseBodyCreditActor actor : credit.getCast()) {
                        this.downloadProfileImgFile(actor.getProfilePath());
                    }
                    for (TVSeriesDetailsResponseBodyCreditWorker worker : credit.getCrew()) {
                        this.downloadProfileImgFile(worker.getProfilePath());
                    }

                    return new TvSeriesServiceDTO(tvSeriesDetailsResponseBody);           
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
     * Download the image if it does not exist.
     * @param tmdbImgPath the prifix of the url
     * @param filePath a string that contains a "/" and the file name. E.g. "/abcdefgh.jpg".
     */
    private void downloadImgFile(String tmdbImgPath, String filePath) {
        if (filePath == null) {
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
