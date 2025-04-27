package cool.cena.tmdb.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.springframework.stereotype.Service;

import cool.cena.tmdb.helper.TMDbAPIAccessor;
import cool.cena.tmdb.helper.TMDbConstraint;
import cool.cena.tmdb.pojo.servicedto.MovieServiceDTO;
import cool.cena.tmdb.pojo.tmdbresponse.SearchMovieResponseBody;
import cool.cena.tmdb.pojo.tmdbresponse.MovieDetailsResponseBody;
import cool.cena.tmdb.pojo.tmdbresponse.MovieDetailsResponseBody.MovieDetailsResponseBodyCredit;
import cool.cena.tmdb.pojo.tmdbresponse.MovieDetailsResponseBody.MovieDetailsResponseBodyCreditActor;
import cool.cena.tmdb.pojo.tmdbresponse.MovieDetailsResponseBody.MovieDetailsResponseBodyCreditWorker;
import cool.cena.tmdb.pojo.tmdbresponse.MovieDetailsResponseBody.MovieDetailsResponseBodyProductionCompany;

@Service
public class MovieService {

    public MovieServiceDTO getMovieInfo (String title, int year) {

        SearchMovieResponseBody searchResults = TMDbAPIAccessor.searchMovie(title, year);
        if (searchResults != null && !searchResults.getResults().isEmpty()) {
            MovieDetailsResponseBody movie = TMDbAPIAccessor.getMovieDetails(searchResults.getResults().getFirst().getId());

            this.downloadBackdropImgFile(movie.getBackdropPath());
            this.downloadPosterImgFile(movie.getPosterPath());
            for (MovieDetailsResponseBodyProductionCompany company : movie.getProductionCompanies()) {
                this.downloadLogoImgFile(company.getLogoPath());
            }
            MovieDetailsResponseBodyCredit credit = movie.getCredits();
            for (MovieDetailsResponseBodyCreditActor actor : credit.getCast()) {
                this.downloadProfileImgFile(actor.getProfilePath());
            }
            for (MovieDetailsResponseBodyCreditWorker worker : credit.getCrew()) {
                this.downloadProfileImgFile(worker.getProfilePath());
            }

            return new MovieServiceDTO(movie);

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
