package cool.cena.tmdb.pojo.response;

import java.util.ArrayList;
import java.util.List;

import cool.cena.tmdb.pojo.servicedto.TvSeriesServiceDTO;
import cool.cena.tmdb.pojo.servicedto.TvSeriesServiceDTO.TVSeriesServiceDTOActor;
import cool.cena.tmdb.pojo.servicedto.TvSeriesServiceDTO.TVSeriesServiceDTOProductionCompany;
import cool.cena.tmdb.pojo.servicedto.TvSeriesServiceDTO.TVSeriesServiceDTOSeason;

public class TVSeriesResponseBody {

    private long id;
    private String firstAirDate;
    private double voteAverage;
    private int voteCount;
    private String contentRating;
    private String overview;
    private String name;
    private String originalName;
    private String tagline;
    private String status;
    private List<String> genres;
    private List<String> productionCountries;
    private List<String> directors;
    private List<TVSeriesResponseBodyProductionCompany> productionCompanies = new ArrayList<>();
    private List<String> writers;
    private List<TVSeriesResponseBodyActor> cast = new ArrayList<>();
    private List<TVSeriesResponseBodySeason> seasons = new ArrayList<>();
    private String backdropPath;
    private String posterPath;

    public TVSeriesResponseBody(TvSeriesServiceDTO tvSeriesServiceDTO) {
        this.id = tvSeriesServiceDTO.getId();
        this.firstAirDate = tvSeriesServiceDTO.getFirstAirDate();
        this.voteAverage = tvSeriesServiceDTO.getVoteAverage();
        this.voteCount = tvSeriesServiceDTO.getVoteCount();
        this.contentRating = tvSeriesServiceDTO.getContentRating();
        this.overview = tvSeriesServiceDTO.getOverview();
        this.name = tvSeriesServiceDTO.getName();
        this.originalName = tvSeriesServiceDTO.getOriginalName();
        this.tagline = tvSeriesServiceDTO.getTagline();
        this.status = tvSeriesServiceDTO.getStatus();
        this.genres = tvSeriesServiceDTO.getGenres();
        this.productionCountries = tvSeriesServiceDTO.getProductionCountries();
        this.directors = tvSeriesServiceDTO.getDirectors();
        this.writers = tvSeriesServiceDTO.getWriters();
        for (TVSeriesServiceDTOProductionCompany company : tvSeriesServiceDTO.getProductionCompanies()) {
            this.productionCompanies
                    .add(new TVSeriesResponseBodyProductionCompany(company.getName(), company.getLogoPath()));
        }
        for (TVSeriesServiceDTOActor actor : tvSeriesServiceDTO.getCast()) {
            this.cast.add(new TVSeriesResponseBodyActor(actor.getName(), actor.getCharacter(), actor.getProfilePath(),
                    actor.getOrder()));
        }
        for (TVSeriesServiceDTOSeason season : tvSeriesServiceDTO.getSeasons()) {
            this.seasons.add(
                    new TVSeriesResponseBodySeason(season.getSeasonNumber(), season.getName(), season.getPosterPath()));
        }
        this.backdropPath = tvSeriesServiceDTO.getBackdropPath();
        this.posterPath = tvSeriesServiceDTO.getPosterPath();
    }

    public TVSeriesResponseBody(long id, String firstAirDate, double voteAverage, int voteCount, String contentRating,
            String overview, String name, String originalName, String tagline, String status, List<String> genres,
            List<String> productionCountries, List<String> directors,
            List<TVSeriesResponseBodyProductionCompany> productionCompanies, List<String> writers,
            List<TVSeriesResponseBodyActor> cast, List<TVSeriesResponseBodySeason> seasons, String backdropPath,
            String posterPath) {
        this.id = id;
        this.firstAirDate = firstAirDate;
        this.voteAverage = voteAverage;
        this.voteCount = voteCount;
        this.contentRating = contentRating;
        this.overview = overview;
        this.name = name;
        this.originalName = originalName;
        this.tagline = tagline;
        this.status = status;
        this.genres = genres;
        this.productionCountries = productionCountries;
        this.directors = directors;
        this.productionCompanies = productionCompanies;
        this.writers = writers;
        this.cast = cast;
        this.seasons = seasons;
        this.backdropPath = backdropPath;
        this.posterPath = posterPath;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstAirDate() {
        return firstAirDate;
    }

    public void setFirstAirDate(String firstAirDate) {
        this.firstAirDate = firstAirDate;
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

    public String getContentRating() {
        return contentRating;
    }

    public void setContentRating(String contentRating) {
        this.contentRating = contentRating;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOriginalName() {
        return originalName;
    }

    public void setOriginalName(String originalName) {
        this.originalName = originalName;
    }

    public String getTagline() {
        return tagline;
    }

    public void setTagline(String tagline) {
        this.tagline = tagline;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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

    public List<TVSeriesResponseBodyProductionCompany> getProductionCompanies() {
        return productionCompanies;
    }

    public void setProductionCompanies(List<TVSeriesResponseBodyProductionCompany> productionCompanies) {
        this.productionCompanies = productionCompanies;
    }

    public List<String> getWriters() {
        return writers;
    }

    public void setWriters(List<String> writers) {
        this.writers = writers;
    }

    public List<TVSeriesResponseBodyActor> getCast() {
        return cast;
    }

    public void setCast(List<TVSeriesResponseBodyActor> cast) {
        this.cast = cast;
    }

    public List<TVSeriesResponseBodySeason> getSeasons() {
        return seasons;
    }

    public void setSeasons(List<TVSeriesResponseBodySeason> seasons) {
        this.seasons = seasons;
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

    public static class TVSeriesResponseBodyProductionCompany {

        private String name, logoPath;

        public TVSeriesResponseBodyProductionCompany(String name, String logoPath) {
            this.name = name;
            this.logoPath = logoPath;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getLogoPath() {
            return logoPath;
        }

        public void setLogoPath(String logoPath) {
            this.logoPath = logoPath;
        }

    }

    public static class TVSeriesResponseBodyActor {

        private String name, character, profilePath;
        private int order;

        public TVSeriesResponseBodyActor(String name, String character, String profilePath, int order) {
            this.name = name;
            this.character = character;
            this.profilePath = profilePath;
            this.order = order;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getCharacter() {
            return character;
        }

        public void setCharacter(String character) {
            this.character = character;
        }

        public String getProfilePath() {
            return profilePath;
        }

        public void setProfilePath(String profilePath) {
            this.profilePath = profilePath;
        }

        public int getOrder() {
            return order;
        }

        public void setOrder(int order) {
            this.order = order;
        }

    }

    public static class TVSeriesResponseBodySeason {

        private int seasonNumber;
        private String name, posterPath;

        public TVSeriesResponseBodySeason(int seasonNumber, String name, String posterPath) {
            this.seasonNumber = seasonNumber;
            this.name = name;
            this.posterPath = posterPath;
        }

        public int getSeasonNumber() {
            return seasonNumber;
        }

        public void setSeasonNumber(int seasonNumber) {
            this.seasonNumber = seasonNumber;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getPosterPath() {
            return posterPath;
        }

        public void setPosterPath(String posterPath) {
            this.posterPath = posterPath;
        }

    }

}
