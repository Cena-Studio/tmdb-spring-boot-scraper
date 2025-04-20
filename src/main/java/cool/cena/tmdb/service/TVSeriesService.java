package cool.cena.tmdb.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import cool.cena.tmdb.helper.TMDbAPIAccessor;
import cool.cena.tmdb.helper.TMDbConstraint;
import cool.cena.tmdb.pojo.servicedto.TVSeriesServiceDTO;
import cool.cena.tmdb.pojo.tmdbresponse.TVSeriesDetailsResponseBody;
import cool.cena.tmdb.pojo.tmdbresponse.TVSeriesDetailsResponseBody.TVSeriesDetailsResponseBodyCreator;
import cool.cena.tmdb.pojo.tmdbresponse.TVSeriesDetailsResponseBody.TVSeriesDetailsResponseBodyCredit;
import cool.cena.tmdb.pojo.tmdbresponse.TVSeriesDetailsResponseBody.TVSeriesDetailsResponseBodyCreditActor;
import cool.cena.tmdb.pojo.tmdbresponse.TVSeriesDetailsResponseBody.TVSeriesDetailsResponseBodyCreditWorker;
import cool.cena.tmdb.pojo.tmdbresponse.TVSeriesDetailsResponseBody.TVSeriesDetailsResponseBodyNetwork;
import cool.cena.tmdb.pojo.tmdbresponse.TVSeriesDetailsResponseBody.TVSeriesDetailsResponseBodyProductionCompany;
import cool.cena.tmdb.pojo.tmdbresponse.TVSeriesDetailsResponseBody.TVSeriesDetailsResponseBodySeason;

@Service
public class TVSeriesService {

    public TVSeriesServiceDTO getTvSeriesInfo(String title, int year, int seasonSize, int episodeSize) {
        
        TVSeriesDetailsResponseBody tvSeriesDetailsResponseBody = TMDbAPIAccessor.requestTVSeries(title, year, seasonSize, episodeSize);
        
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

        return new TVSeriesServiceDTO(tvSeriesDetailsResponseBody);
        
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
