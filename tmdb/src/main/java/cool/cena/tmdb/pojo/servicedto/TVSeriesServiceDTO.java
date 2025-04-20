package cool.cena.tmdb.pojo.servicedto;

import java.util.List;

import cool.cena.tmdb.pojo.tmdbresponse.TVSeriesDetailsResponseBody;

public class TVSeriesServiceDTO {

    private long uniqueID;
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
    private List<String> productionCompanies;
    private List<String> writers;
    private int duration;
    private List<TVSeriesServiceDTOActor> cast;
    private List<TVSeriesServiceDTOSeason> seasons;

    public TVSeriesServiceDTO(
        TVSeriesDetailsResponseBody tvSeriesDetailsResponseBody
        // artworkPaths
    ) {

    }

    public TVSeriesServiceDTO(long uniqueID, String firstAirDate, double voteAverage, int voteCount,
            String contentRating, String overview, String name, String originalName, String tagline, String status,
            List<String> genres, List<String> productionCountries, List<String> directors,
            List<String> productionCompanies, List<String> writers, int duration, List<TVSeriesServiceDTOActor> cast,
            List<TVSeriesServiceDTOSeason> seasons) {
        this.uniqueID = uniqueID;
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
        this.duration = duration;
        this.cast = cast;
        this.seasons = seasons;
    }

    public long getUniqueID() {
        return uniqueID;
    }

    public String getFirstAirDate() {
        return firstAirDate;
    }

    public double getVoteAverage() {
        return voteAverage;
    }

    public int getVoteCount() {
        return voteCount;
    }

    public String getContentRating() {
        return contentRating;
    }

    public String getOverview() {
        return overview;
    }

    public String getName() {
        return name;
    }

    public String getOriginalName() {
        return originalName;
    }

    public String getTagline() {
        return tagline;
    }

    public String getStatus() {
        return status;
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

    public List<String> getProductionCompanies() {
        return productionCompanies;
    }

    public List<String> getWriters() {
        return writers;
    }

    public int getDuration() {
        return duration;
    }

    public List<TVSeriesServiceDTOActor> getCast() {
        return cast;
    }

    public List<TVSeriesServiceDTOSeason> getSeasons() {
        return seasons;
    }

    public static class TVSeriesServiceDTOActor {

        private String name, character, profilePath;
        private int order;

        public TVSeriesServiceDTOActor(String name, String character, String profilePath, int order) {
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

    public static class TVSeriesServiceDTOSeason {

        private int seasonNumber;
        private String name;

        public TVSeriesServiceDTOSeason(int seasonNumber, String name) {
            this.seasonNumber = seasonNumber;
            this.name = name;
        }

        public int getSeasonNumber() {
            return seasonNumber;
        }

        public String getName() {
            return name;
        }

    }

}
