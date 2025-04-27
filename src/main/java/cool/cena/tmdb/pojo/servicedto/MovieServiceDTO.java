package cool.cena.tmdb.pojo.servicedto;

import java.util.ArrayList;
import java.util.List;

import cool.cena.tmdb.helper.TMDbConstraint;
import cool.cena.tmdb.pojo.tmdbresponse.MovieDetailsResponseBody;
import cool.cena.tmdb.pojo.tmdbresponse.MovieDetailsResponseBody.MovieDetailsResponseBodyCreditActor;
import cool.cena.tmdb.pojo.tmdbresponse.MovieDetailsResponseBody.MovieDetailsResponseBodyCreditWorker;
import cool.cena.tmdb.pojo.tmdbresponse.MovieDetailsResponseBody.MovieDetailsResponseBodyGenre;
import cool.cena.tmdb.pojo.tmdbresponse.MovieDetailsResponseBody.MovieDetailsResponseBodyProductionCompany;
import cool.cena.tmdb.pojo.tmdbresponse.MovieDetailsResponseBody.MovieDetailsResponseBodyProductionCountry;
import cool.cena.tmdb.pojo.tmdbresponse.MovieDetailsResponseBody.MovieDetailsResponseBodyReleaseDatesResult;

public class MovieServiceDTO {

    private long id;
    private String imdbId;
    private String releaseDate;
    private double voteAverage;
    private int voteCount;
    private String certification;
    private String overview;
    private String title;
    private String originalTitle;
    private String tagline;
    private List<String> genres = new ArrayList<>();
    private List<String> productionCountries = new ArrayList<>();
    private List<String> directors = new ArrayList<>();
    private List<MovieServiceDTOProductionCompany> productionCompanies = new ArrayList<>();
    private List<String> writers = new ArrayList<>();
    private int runtime;
    private List<MovieServiceDTOActor> cast = new ArrayList<>();
    private String backdropPath;
    private String posterPath;

    public MovieServiceDTO(MovieDetailsResponseBody movie) {
        this.id = movie.getId();
        this.imdbId = excludeEmpty(movie.getImdbId());
        this.releaseDate = excludeEmpty(movie.getReleaseDate());
        this.voteAverage = movie.getVoteAverage();
        this.voteCount = movie.getVoteCount();
        this.certification = getCertification(movie.getReleaseDates().getResults());
        this.overview = excludeEmpty(movie.getOverview());
        this.title = excludeEmpty(movie.getTitle());
        this.originalTitle = excludeEmpty(movie.getOriginalTitle());
        if (this.title == null) {
            this.title = this.originalTitle;
        }
        this.tagline = excludeEmpty(movie.getTagline());
        for (MovieDetailsResponseBodyGenre genre : movie.getGenres()) {
            this.genres.add(genre.getName());
        }
        for (MovieDetailsResponseBodyProductionCountry country : movie.getProductionCountries()) {
            this.productionCountries.add(country.getIso31661());
        }
        for (MovieDetailsResponseBodyCreditWorker worker : movie.getCredits().getCrew()) {
            String workerName = excludeEmpty(worker.getName());
            if (workerName == null) {
                workerName = excludeEmpty(worker.getOriginalName());
            }
            String job = worker.getJob().toLowerCase();
            if (job.contains("director") && workerName != null) {
                this.directors.add(workerName);
            } else if (job.contains("screenplay") && workerName != null) {
                this.writers.add(workerName);
            }
        }
        for (MovieDetailsResponseBodyProductionCompany company : movie.getProductionCompanies()) {
            String companyName = excludeEmpty(company.getName());
            if (companyName != null) {
                String companyLogoPath = excludeEmpty(company.getLogoPath()) == null
                        ? TMDbConstraint.DEFAULT_LOGO_IMG_FILE_PATH
                        : TMDbConstraint.IMG_FILE_PATH + company.getLogoPath();
                this.productionCompanies
                        .add(new MovieServiceDTOProductionCompany(excludeEmpty(company.getName()), companyLogoPath));
            }
        }
        this.runtime = movie.getRuntime();
        for (MovieDetailsResponseBodyCreditActor actor : movie.getCredits().getCast()) {
            String actorName = excludeEmpty(actor.getName());
            if (actorName == null) {
                actorName = excludeEmpty(actor.getOriginalName());
            }
            if (actorName != null) {
                String actorCharacter = excludeEmpty(actor.getOriginalName()) == null ? "未知" : actor.getOriginalName();
                String actorProfilePath = excludeEmpty(actor.getProfilePath()) == null
                        ? getDefaultActorProfilePath(actor.getGender())
                        : TMDbConstraint.IMG_FILE_PATH + actor.getProfilePath();
                this.cast.add(
                        new MovieServiceDTOActor(actorName, actorCharacter, actorProfilePath, actor.getOrder()));
            }

        }

        this.backdropPath = excludeEmpty(movie.getBackdropPath()) == null
                ? TMDbConstraint.DEFAULT_BACKDROP_IMG_FILE_PATH
                : TMDbConstraint.IMG_FILE_PATH + movie.getBackdropPath();
        this.posterPath = excludeEmpty(movie.getPosterPath()) == null ? TMDbConstraint.DEFAULT_POSTER_IMG_FILE_PATH
                : TMDbConstraint.IMG_FILE_PATH + movie.getPosterPath();
    }

    

    public MovieServiceDTO(long id, String imdbId, String releaseDate, double voteAverage, int voteCount,
            String certification, String overview, String title, String originalTitle, String tagline,
            List<String> genres, List<String> productionCountries, List<String> directors,
            List<MovieServiceDTOProductionCompany> productionCompanies, List<String> writers, int runtime,
            List<MovieServiceDTOActor> cast, String backdropPath, String posterPath) {
        this.id = id;
        this.imdbId = imdbId;
        this.releaseDate = releaseDate;
        this.voteAverage = voteAverage;
        this.voteCount = voteCount;
        this.certification = certification;
        this.overview = overview;
        this.title = title;
        this.originalTitle = originalTitle;
        this.tagline = tagline;
        this.genres = genres;
        this.productionCountries = productionCountries;
        this.directors = directors;
        this.productionCompanies = productionCompanies;
        this.writers = writers;
        this.runtime = runtime;
        this.cast = cast;
        this.backdropPath = backdropPath;
        this.posterPath = posterPath;
    }



    public long getId() {
        return id;
    }

    public String getImdbId() {
        return imdbId;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public double getVoteAverage() {
        return voteAverage;
    }

    public int getVoteCount() {
        return voteCount;
    }

    public String getCertification() {
        return certification;
    }

    public String getOverview() {
        return overview;
    }

    public String getTitle() {
        return title;
    }

    public String getOriginalTitle() {
        return originalTitle;
    }

    public String getTagline() {
        return tagline;
    }

    public List<String> getGenres() {
        return genres;
    }

    public List<String> getProductionCountries() {
        return productionCountries;
    }

    public List<String> getDirectors() {
        return directors;
    }

    public List<MovieServiceDTOProductionCompany> getProductionCompanies() {
        return productionCompanies;
    }

    public List<String> getWriters() {
        return writers;
    }

    public int getRuntime() {
        return runtime;
    }

    public List<MovieServiceDTOActor> getCast() {
        return cast;
    }

    public String getBackdropPath() {
        return backdropPath;
    }

    public String getPosterPath() {
        return posterPath;
    }

    private String excludeEmpty(String str) {
        if (str == null || str.isEmpty()) {
            return null;
        }
        return str;
    }

    private String getCertification(List<MovieDetailsResponseBodyReleaseDatesResult> results) {
        for (MovieDetailsResponseBodyReleaseDatesResult result : results) {
            if (result.getIso31661().equals("US")) {
                String certification = excludeEmpty(result.getReleaseDates().getLast().getCertification());
                if (certification != null) {
                    return certification;
                }
            }
        }
        return "PG-13";
    }

    private String getDefaultActorProfilePath(int gender) {
        if (gender == 1) {
            return TMDbConstraint.DEFAULT_FEMALE_PROFILE_IMG_FILE_PATH;
        }
        return TMDbConstraint.DEFAULT_MALE_PROFILE_IMG_FILE_PATH;
    }

    public static class MovieServiceDTOProductionCompany {

        private String name, logoPath;

        public MovieServiceDTOProductionCompany(String name, String logoPath) {
            this.name = name;
            this.logoPath = logoPath;
        }

        public String getName() {
            return name;
        }

        public String getLogoPath() {
            return logoPath;
        }

    }

    public static class MovieServiceDTOActor {

        private String name, character, profilePath;
        private int order;

        public MovieServiceDTOActor(String name, String character, String profilePath, int order) {
            this.name = name;
            this.character = character;
            this.profilePath = profilePath;
            this.order = order;
        }

        public String getName() {
            return name;
        }

        public String getCharacter() {
            return character;
        }

        public String getProfilePath() {
            return profilePath;
        }

        public int getOrder() {
            return order;
        }

    }

}
