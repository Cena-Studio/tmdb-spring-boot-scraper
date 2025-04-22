package cool.cena.tmdb.pojo.response;

import java.util.ArrayList;
import java.util.List;

import cool.cena.tmdb.pojo.servicedto.TvSeriesServiceDTO;
import cool.cena.tmdb.pojo.servicedto.TvSeriesServiceDTO.TvSeriesServiceDTOActor;
import cool.cena.tmdb.pojo.servicedto.TvSeriesServiceDTO.TvSeriesServiceDTOEpisode;
import cool.cena.tmdb.pojo.servicedto.TvSeriesServiceDTO.TVSeriesServiceDTOProductionCompany;
import cool.cena.tmdb.pojo.servicedto.TvSeriesServiceDTO.TvSeriesServiceDTOSeason;

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
    private List<TvSeriesResponseBodyProductionCompany> productionCompanies = new ArrayList<>();
    private List<String> writers;
    private List<TvSeriesResponseBodyActor> cast = new ArrayList<>();
    private List<TvSeriesResponseBodySeason> seasons = new ArrayList<>();
    private String backdropPath;
    private String posterPath;
    private List<TvSeriesResponseBodyEpisode> episodes = new ArrayList<>();

    public TVSeriesResponseBody(TvSeriesServiceDTO tvSeries) {
        this.id = tvSeries.getId();
        this.firstAirDate = tvSeries.getFirstAirDate();
        this.voteAverage = tvSeries.getVoteAverage();
        this.voteCount = tvSeries.getVoteCount();
        this.contentRating = tvSeries.getContentRating();
        this.overview = tvSeries.getOverview();
        this.name = tvSeries.getName();
        this.originalName = tvSeries.getOriginalName();
        this.tagline = tvSeries.getTagline();
        this.status = tvSeries.getStatus();
        this.genres = tvSeries.getGenres();
        this.productionCountries = tvSeries.getProductionCountries();
        this.directors = tvSeries.getDirectors();
        this.writers = tvSeries.getWriters();
        for (TVSeriesServiceDTOProductionCompany company : tvSeries.getProductionCompanies()) {
            this.productionCompanies
                    .add(new TvSeriesResponseBodyProductionCompany(company.getName(), company.getLogoPath()));
        }
        for (TvSeriesServiceDTOActor actor : tvSeries.getCast()) {
            this.cast.add(new TvSeriesResponseBodyActor(actor.getName(), actor.getCharacter(), actor.getProfilePath(),
                    actor.getOrder()));
        }
        for (TvSeriesServiceDTOSeason season : tvSeries.getSeasons()) {
            this.seasons.add(
                    new TvSeriesResponseBodySeason(season.getSeasonNumber(), season.getName(), season.getPosterPath()));
        }
        this.backdropPath = tvSeries.getBackdropPath();
        this.posterPath = tvSeries.getPosterPath();
        for (TvSeriesServiceDTOEpisode episode : tvSeries.getEpisodes()) {
            this.episodes.add(new TvSeriesResponseBodyEpisode(episode.getSeasonNumber(), episode.getEpisodeNumber(), episode.getAirDate()));
        }
    }

    public TVSeriesResponseBody(long id, String firstAirDate, double voteAverage, int voteCount, String contentRating,
            String overview, String name, String originalName, String tagline, String status, List<String> genres,
            List<String> productionCountries, List<String> directors,
            List<TvSeriesResponseBodyProductionCompany> productionCompanies, List<String> writers,
            List<TvSeriesResponseBodyActor> cast, List<TvSeriesResponseBodySeason> seasons, String backdropPath,
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

    public List<TvSeriesResponseBodyProductionCompany> getProductionCompanies() {
        return productionCompanies;
    }

    public void setProductionCompanies(List<TvSeriesResponseBodyProductionCompany> productionCompanies) {
        this.productionCompanies = productionCompanies;
    }

    public List<String> getWriters() {
        return writers;
    }

    public void setWriters(List<String> writers) {
        this.writers = writers;
    }

    public List<TvSeriesResponseBodyActor> getCast() {
        return cast;
    }

    public void setCast(List<TvSeriesResponseBodyActor> cast) {
        this.cast = cast;
    }

    public List<TvSeriesResponseBodySeason> getSeasons() {
        return seasons;
    }

    public void setSeasons(List<TvSeriesResponseBodySeason> seasons) {
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

    public List<TvSeriesResponseBodyEpisode> getEpisodes() {
        return episodes;
    }

    public void setEpisodes(List<TvSeriesResponseBodyEpisode> episodes) {
        this.episodes = episodes;
    }

    public static class TvSeriesResponseBodyProductionCompany {

        private String name, logoPath;

        public TvSeriesResponseBodyProductionCompany(String name, String logoPath) {
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

    public static class TvSeriesResponseBodyActor {

        private String name, character, profilePath;
        private int order;

        public TvSeriesResponseBodyActor(String name, String character, String profilePath, int order) {
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

    public static class TvSeriesResponseBodySeason {

        private int seasonNumber;
        private String name, posterPath;

        public TvSeriesResponseBodySeason(int seasonNumber, String name, String posterPath) {
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

    public static class TvSeriesResponseBodyEpisode {

        private int seasonNumber, episodeNumber;
        private String airDate;

        public TvSeriesResponseBodyEpisode(int seasonNumber, int episodeNumber, String airDate) {
            this.seasonNumber = seasonNumber;
            this.episodeNumber = episodeNumber;
            this.airDate = airDate;
        }

        public int getSeasonNumber() {
            return seasonNumber;
        }

        public void setSeasonNumber(int seasonNumber) {
            this.seasonNumber = seasonNumber;
        }

        public int getEpisodeNumber() {
            return episodeNumber;
        }

        public void setEpisodeNumber(int episodeNumber) {
            this.episodeNumber = episodeNumber;
        }

        public String getAirDate() {
            return airDate;
        }

        public void setAirDate(String airDate) {
            this.airDate = airDate;
        }

    }

}
