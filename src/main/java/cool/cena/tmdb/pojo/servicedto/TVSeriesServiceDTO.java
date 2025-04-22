package cool.cena.tmdb.pojo.servicedto;

import java.util.ArrayList;
import java.util.List;

import cool.cena.tmdb.helper.TMDbConstraint;
import cool.cena.tmdb.pojo.tmdbresponse.TvSeriesDetailsResponseBody;
import cool.cena.tmdb.pojo.tmdbresponse.TvSeriesDetailsResponseBody.TVSeriesDetailsResponseBodyContentRatingResult;
import cool.cena.tmdb.pojo.tmdbresponse.TvSeriesDetailsResponseBody.TVSeriesDetailsResponseBodyCreditActor;
import cool.cena.tmdb.pojo.tmdbresponse.TvSeriesDetailsResponseBody.TVSeriesDetailsResponseBodyCreditWorker;
import cool.cena.tmdb.pojo.tmdbresponse.TvSeriesDetailsResponseBody.TVSeriesDetailsResponseBodyGenre;
import cool.cena.tmdb.pojo.tmdbresponse.TvSeriesDetailsResponseBody.TVSeriesDetailsResponseBodyProductionCompany;
import cool.cena.tmdb.pojo.tmdbresponse.TvSeriesDetailsResponseBody.TVSeriesDetailsResponseBodyProductionCountry;
import cool.cena.tmdb.pojo.tmdbresponse.TvSeriesDetailsResponseBody.TVSeriesDetailsResponseBodySeason;

public class TvSeriesServiceDTO {

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
    private List<String> genres = new ArrayList<>();
    private List<String> productionCountries = new ArrayList<>();
    private List<String> directors = new ArrayList<>();
    private List<TVSeriesServiceDTOProductionCompany> productionCompanies = new ArrayList<>();
    private List<String> writers = new ArrayList<>();
    private List<TVSeriesServiceDTOActor> cast = new ArrayList<>();
    private List<TVSeriesServiceDTOSeason> seasons = new ArrayList<>();
    private String backdropPath;
    private String posterPath;

    public TvSeriesServiceDTO(TvSeriesDetailsResponseBody tvSeriesDetailsResponseBody) {
        this.id = tvSeriesDetailsResponseBody.getId();
        this.firstAirDate = tvSeriesDetailsResponseBody.getFirstAirDate();
        this.voteAverage = tvSeriesDetailsResponseBody.getVoteAverage();
        this.voteCount = tvSeriesDetailsResponseBody.getVoteCount();
        this.contentRating = getContentRating(tvSeriesDetailsResponseBody.getContentRatings().getResults());
        this.overview = tvSeriesDetailsResponseBody.getOverview();
        this.name = tvSeriesDetailsResponseBody.getName();
        this.originalName = tvSeriesDetailsResponseBody.getOriginalName();
        this.tagline = tvSeriesDetailsResponseBody.getTagline();
        for (TVSeriesDetailsResponseBodyGenre genre : tvSeriesDetailsResponseBody.getGenres()) {
            this.genres.add(genre.getName());
        }
        for (TVSeriesDetailsResponseBodyProductionCountry country : tvSeriesDetailsResponseBody.getProductionCountries()) {
            this.productionCountries.add(country.getIso31661());
        }
        for (TVSeriesDetailsResponseBodyCreditWorker worker : tvSeriesDetailsResponseBody.getCredits().getCrew()) {
            String job = worker.getJob().toLowerCase();
            if (job.contains("director")) {
                this.directors.add(worker.getName());
            } else if (job.contains("screenplay")) {
                this.writers.add(worker.getName());
            }
        }
        if (directors.size() == 0) {
            try {
                directors.add(tvSeriesDetailsResponseBody.getCreatedBy().get(0).getName());
            } catch (IndexOutOfBoundsException e) {
                e.printStackTrace();
            }
        }
        if (writers.size() == 0) {
            try {
                writers.add(tvSeriesDetailsResponseBody.getCreatedBy().get(0).getName());
            } catch (IndexOutOfBoundsException e) {
                e.printStackTrace();
            }
        }
        for (TVSeriesDetailsResponseBodyProductionCompany company : tvSeriesDetailsResponseBody.getProductionCompanies()) {
            String companyLogoPath = company.getLogoPath() == null ? TMDbConstraint.DEFAULT_LOGO_IMG_FILE_PATH : TMDbConstraint.IMG_FILE_PATH + company.getLogoPath();
            productionCompanies.add(new TVSeriesServiceDTOProductionCompany(company.getName(), companyLogoPath));
        }
        for (TVSeriesDetailsResponseBodyCreditActor actor : tvSeriesDetailsResponseBody.getCredits().getCast()) {
            String actorProfilePath = actor.getProfilePath() == null ? getDefaultActorProfilePath(actor.getGender()) : TMDbConstraint.IMG_FILE_PATH + actor.getProfilePath();
            cast.add(new TVSeriesServiceDTOActor(actor.getName(), actor.getCharacter(), actorProfilePath, actor.getOrder()));
        }
        for (TVSeriesDetailsResponseBodySeason season : tvSeriesDetailsResponseBody.getSeasons()) {
            String seasonPosterPath = season.getPosterPath() == null ? TMDbConstraint.DEFAULT_POSTER_IMG_FILE_PATH : TMDbConstraint.IMG_FILE_PATH + season.getPosterPath();
            seasons.add(new TVSeriesServiceDTOSeason(season.getSeasonNumber(), season.getName(), seasonPosterPath));
        }
        this.backdropPath = tvSeriesDetailsResponseBody.getBackdropPath() == null ? TMDbConstraint.DEFAULT_BACKDROP_IMG_FILE_PATH : TMDbConstraint.IMG_FILE_PATH + tvSeriesDetailsResponseBody.getBackdropPath();
        this.posterPath = tvSeriesDetailsResponseBody.getPosterPath() == null ? TMDbConstraint.DEFAULT_POSTER_IMG_FILE_PATH : TMDbConstraint.IMG_FILE_PATH + tvSeriesDetailsResponseBody.getPosterPath();
    }

    private String getContentRating(List<TVSeriesDetailsResponseBodyContentRatingResult> contentRatingResults) {
        for (TVSeriesDetailsResponseBodyContentRatingResult contentRatingResult : contentRatingResults) {
            if (contentRatingResult.getIso31661().equals("US")) {
                return contentRatingResult.getRating();
            }
        }
        return "G";
    }

    private String getDefaultActorProfilePath(int gender) {
        if (gender == 1) {
            return TMDbConstraint.DEFAULT_FEMALE_PROFILE_IMG_FILE_PATH;
        }
        return TMDbConstraint.DEFAULT_MALE_PROFILE_IMG_FILE_PATH;
    }

    public TvSeriesServiceDTO(
        long uniqueID, String firstAirDate, double voteAverage, int voteCount, String contentRating,
        String overview, String name, String originalName, String tagline, String status,
        List<String> genres, List<String> productionCountries, List<String> directors,
        List<TVSeriesServiceDTOProductionCompany> productionCompanies, List<String> writers, List<TVSeriesServiceDTOActor> cast,
        List<TVSeriesServiceDTOSeason> seasons
    ) {
        this.id = uniqueID;
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
    }

    public long getId() {
        return id;
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

    public List<TVSeriesServiceDTOProductionCompany> getProductionCompanies() {
        return productionCompanies;
    }

    public List<String> getWriters() {
        return writers;
    }

    public List<TVSeriesServiceDTOActor> getCast() {
        return cast;
    }

    public List<TVSeriesServiceDTOSeason> getSeasons() {
        return seasons;
    }

    public String getBackdropPath() {
        return backdropPath;
    }

    public String getPosterPath() {
        return posterPath;
    }

    public static class TVSeriesServiceDTOProductionCompany {

        private String name, logoPath;

        public TVSeriesServiceDTOProductionCompany(String name, String logoPath) {
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
        private String name, posterPath;

        public TVSeriesServiceDTOSeason(int seasonNumber, String name, String posterPath) {
            this.seasonNumber = seasonNumber;
            this.name = name;
            this.posterPath = posterPath;
        }

        public int getSeasonNumber() {
            return seasonNumber;
        }

        public String getName() {
            return name;
        }

        public String getPosterPath() {
            return posterPath;
        }

    }

}
