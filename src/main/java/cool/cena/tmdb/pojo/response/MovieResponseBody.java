package cool.cena.tmdb.pojo.response;

import java.util.ArrayList;
import java.util.List;

import cool.cena.tmdb.pojo.servicedto.MovieServiceDTO;
import cool.cena.tmdb.pojo.servicedto.MovieServiceDTO.MovieServiceDTOActor;
import cool.cena.tmdb.pojo.servicedto.MovieServiceDTO.MovieServiceDTOProductionCompany;

public class MovieResponseBody {

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
    private List<String> genres;
    private List<String> productionCountries;
    private List<String> directors;
    private List<MovieResponseBodyProductionCompany> productionCompanies = new ArrayList<>();
    private List<String> writers;
    private int runtime;
    private List<MovieResponseBodyActor> cast = new ArrayList<>();
    private String backdropPath;
    private String posterPath;

    public MovieResponseBody(MovieServiceDTO movie) {
        this.id = movie.getId();
        this.imdbId = movie.getImdbId();
        this.releaseDate = movie.getReleaseDate();
        this.voteAverage = movie.getVoteAverage();
        this.voteCount = movie.getVoteCount();
        this.certification = movie.getCertification();
        this.overview = movie.getOverview();
        this.title = movie.getTitle();
        this.originalTitle = movie.getOriginalTitle();
        this.tagline = movie.getTagline();
        this.genres = movie.getGenres();
        this.productionCountries = movie.getProductionCountries();
        this.directors = movie.getDirectors();
        for (MovieServiceDTOProductionCompany company : movie.getProductionCompanies()) {
            this.productionCompanies
                    .add(new MovieResponseBodyProductionCompany(company.getName(), company.getLogoPath()));
        }

        this.writers = movie.getWriters();
        this.runtime = movie.getRuntime();
        for (MovieServiceDTOActor actor : movie.getCast()) {
            this.cast.add(new MovieResponseBodyActor(actor.getName(), actor.getCharacter(), actor.getProfilePath(),
                    actor.getOrder()));
        }
        this.backdropPath = movie.getBackdropPath();
        this.posterPath = movie.getPosterPath();
    }

    public MovieResponseBody(long id, String imdbId, String releaseDate, double voteAverage, int voteCount,
            String certification, String overview, String title, String originalTitle, String tagline,
            List<String> genres, List<String> productionCountries, List<String> directors,
            List<MovieResponseBodyProductionCompany> productionCompanies, List<String> writers, int runtime,
            List<MovieResponseBodyActor> cast, String backdropPath, String posterPath) {
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

    public void setId(long id) {
        this.id = id;
    }

    public String getImdbId() {
        return imdbId;
    }

    public void setImdbId(String imdbId) {
        this.imdbId = imdbId;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public double getVoteAverage() {
        return voteAverage;
    }

    public void setVoteAverage(double voteAverage) {
        this.voteAverage = voteAverage;
    }

    public int getVoteCount() {
        return voteCount;
    }

    public void setVoteCount(int voteCount) {
        this.voteCount = voteCount;
    }

    public String getCertification() {
        return certification;
    }

    public void setCertification(String certification) {
        this.certification = certification;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getOriginalTitle() {
        return originalTitle;
    }

    public void setOriginalTitle(String originalTitle) {
        this.originalTitle = originalTitle;
    }

    public String getTagline() {
        return tagline;
    }

    public void setTagline(String tagline) {
        this.tagline = tagline;
    }

    public List<String> getGenres() {
        return genres;
    }

    public void setGenres(List<String> genres) {
        this.genres = genres;
    }

    public List<String> getProductionCountries() {
        return productionCountries;
    }

    public void setProductionCountries(List<String> productionCountries) {
        this.productionCountries = productionCountries;
    }

    public List<String> getDirectors() {
        return directors;
    }

    public void setDirectors(List<String> directors) {
        this.directors = directors;
    }

    public List<MovieResponseBodyProductionCompany> getProductionCompanies() {
        return productionCompanies;
    }

    public void setProductionCompanies(List<MovieResponseBodyProductionCompany> productionCompanies) {
        this.productionCompanies = productionCompanies;
    }

    public List<String> getWriters() {
        return writers;
    }

    public void setWriters(List<String> writers) {
        this.writers = writers;
    }

    public int getRuntime() {
        return runtime;
    }

    public void setRuntime(int runtime) {
        this.runtime = runtime;
    }

    public List<MovieResponseBodyActor> getCast() {
        return cast;
    }

    public void setCast(List<MovieResponseBodyActor> cast) {
        this.cast = cast;
    }

    public String getBackdropPath() {
        return backdropPath;
    }

    public void setBackdropPath(String backdropPath) {
        this.backdropPath = backdropPath;
    }

    public String getPosterPath() {
        return posterPath;
    }

    public void setPosterPath(String posterPath) {
        this.posterPath = posterPath;
    }

    public static class MovieResponseBodyProductionCompany {

        private String name, logoPath;

        public MovieResponseBodyProductionCompany(String name, String logoPath) {
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

    public static class MovieResponseBodyActor {

        private String name, character, profilePath;
        private int order;

        public MovieResponseBodyActor(String name, String character, String profilePath, int order) {
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
