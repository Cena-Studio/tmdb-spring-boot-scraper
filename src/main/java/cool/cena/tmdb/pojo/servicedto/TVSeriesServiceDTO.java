package cool.cena.tmdb.pojo.servicedto;

import java.util.ArrayList;
import java.util.List;

import cool.cena.tmdb.helper.TMDbConstraint;
import cool.cena.tmdb.pojo.tmdbresponse.EpisodeDetailsResponseBody;
import cool.cena.tmdb.pojo.tmdbresponse.TvSeriesDetailsResponseBody;
import cool.cena.tmdb.pojo.tmdbresponse.EpisodeDetailsResponseBody.EpisodeDetailsResponseBodyActor;
import cool.cena.tmdb.pojo.tmdbresponse.EpisodeDetailsResponseBody.EpisodeDetailsResponseBodyWorker;
import cool.cena.tmdb.pojo.tmdbresponse.TvSeriesDetailsResponseBody.TVSeriesDetailsResponseBodyContentRatingResult;
import cool.cena.tmdb.pojo.tmdbresponse.TvSeriesDetailsResponseBody.TVSeriesDetailsResponseBodyCreator;
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
    private List<TvSeriesServiceDTOActor> cast = new ArrayList<>();
    private List<TvSeriesServiceDTOSeason> seasons = new ArrayList<>();
    private String backdropPath;
    private String posterPath;
    private List<TvSeriesServiceDTOEpisode> episodes = new ArrayList<>();

    public TvSeriesServiceDTO(
        TvSeriesDetailsResponseBody tvSeries,
        List<EpisodeDetailsResponseBody> episodes 
    ) {
        this.id = tvSeries.getId();
        this.firstAirDate = excludeEmpty(tvSeries.getFirstAirDate());
        this.voteAverage = tvSeries.getVoteAverage();
        this.voteCount = tvSeries.getVoteCount();
        this.contentRating = getContentRating(tvSeries.getContentRatings().getResults());
        this.overview = excludeEmpty(tvSeries.getOverview());
        this.name = excludeEmpty(tvSeries.getName());
        this.originalName = excludeEmpty(tvSeries.getOriginalName());
        if (this.name == null) {
            this.name = this.originalName;
        }
        this.tagline = excludeEmpty(tvSeries.getTagline());
        for (TVSeriesDetailsResponseBodyGenre genre : tvSeries.getGenres()) {
            this.genres.add(genre.getName());
        }
        for (TVSeriesDetailsResponseBodyProductionCountry country : tvSeries.getProductionCountries()) {
            this.productionCountries.add(country.getIso31661());
        }
        for (TVSeriesDetailsResponseBodyCreditWorker worker : tvSeries.getCredits().getCrew()) {
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
        String globalCreator = getGlobalCreator(tvSeries.getCreatedBy());
        if (this.directors.isEmpty() && globalCreator != null) {
            this.directors.add(globalCreator);
        }
        if (this.writers.isEmpty() && globalCreator != null) {
            this.writers.add(globalCreator);
        }
        for (TVSeriesDetailsResponseBodyProductionCompany company : tvSeries.getProductionCompanies()) {
            String companyName = excludeEmpty(company.getName());
            if (companyName != null) {
                String companyLogoPath = excludeEmpty(company.getLogoPath()) == null ? TMDbConstraint.DEFAULT_LOGO_IMG_FILE_PATH : TMDbConstraint.IMG_FILE_PATH + company.getLogoPath();
                this.productionCompanies.add(new TVSeriesServiceDTOProductionCompany(excludeEmpty(company.getName()), companyLogoPath));
            }
        }
        for (TVSeriesDetailsResponseBodyCreditActor actor : tvSeries.getCredits().getCast()) {
            String actorName = excludeEmpty(actor.getName());
            if (actorName == null) {
                actorName = excludeEmpty(actor.getOriginalName());
            }
            if (actorName != null) {
                String actorCharacter = excludeEmpty(actor.getOriginalName()) == null ? "未知" : actor.getOriginalName();
                String actorProfilePath = excludeEmpty(actor.getProfilePath()) == null ? getDefaultActorProfilePath(actor.getGender()) : TMDbConstraint.IMG_FILE_PATH + actor.getProfilePath();
                this.cast.add(new TvSeriesServiceDTOActor(actorName, actorCharacter, actorProfilePath, actor.getOrder()));
            }
           
        }
        for (TVSeriesDetailsResponseBodySeason season : tvSeries.getSeasons()) {
            String seasonName = excludeEmpty(season.getName()) == null ? "第" + season.getSeasonNumber() + "季" : season.getName();
            String seasonPosterPath = excludeEmpty(season.getPosterPath()) == null ? TMDbConstraint.DEFAULT_POSTER_IMG_FILE_PATH : TMDbConstraint.IMG_FILE_PATH + season.getPosterPath();
            this.seasons.add(new TvSeriesServiceDTOSeason(season.getSeasonNumber(), seasonName, seasonPosterPath));
        }
        this.backdropPath = excludeEmpty(tvSeries.getBackdropPath()) == null ? TMDbConstraint.DEFAULT_BACKDROP_IMG_FILE_PATH : TMDbConstraint.IMG_FILE_PATH + tvSeries.getBackdropPath();
        this.posterPath = excludeEmpty(tvSeries.getPosterPath()) == null ? TMDbConstraint.DEFAULT_POSTER_IMG_FILE_PATH : TMDbConstraint.IMG_FILE_PATH + tvSeries.getPosterPath();
        for (EpisodeDetailsResponseBody episode : episodes) {
        
            String episodeStillPath = excludeEmpty(episode.getStillPath()) == null ? TMDbConstraint.DEFAULT_STILL_IMG_FILE_PATH : TMDbConstraint.IMG_FILE_PATH + episode.getStillPath();
            List<String> episodeDirectors = new ArrayList<>();
            List<String> episodeWriters = new ArrayList<>();
            List<TvSeriesServiceDTOActor> episodeCast = new ArrayList<>();

            for (EpisodeDetailsResponseBodyWorker worker : episode.getCrew()) {
                String workerName = excludeEmpty(worker.getName());
                if (workerName == null) {
                    workerName = excludeEmpty(worker.getOriginalName());
                }
                String job = worker.getJob().toLowerCase();
                if (job.contains("director") && workerName != null) {
                    episodeDirectors.add(workerName);
                } else if (job.contains("screenplay") && workerName != null) { 
                    episodeWriters.add(workerName);
                }
            }
            if (episodeDirectors.isEmpty()) {
                episodeDirectors = this.directors;
            }
            if (episodeWriters.isEmpty()) {
                episodeWriters = this.writers;
            }

            for (EpisodeDetailsResponseBodyActor actor : episode.getGuestStars()) {
                String episodeActorName = excludeEmpty(actor.getName());
                if (episodeActorName == null) {
                    episodeActorName = excludeEmpty(actor.getOriginalName());
                }
                if (episodeActorName != null) {
                    String episodeActorCharacter = excludeEmpty(actor.getCharacter()) == null ? "未知" : actor.getCharacter();
                    String episodeActorProfilePath = excludeEmpty(actor.getProfilePath()) == null ? getDefaultActorProfilePath(actor.getGender()) : TMDbConstraint.IMG_FILE_PATH + actor.getProfilePath();
                    episodeCast.add(new TvSeriesServiceDTOActor(episodeActorName, episodeActorCharacter, episodeActorProfilePath, actor.getOrder()));
                }
               
            }

            this.episodes.add(new TvSeriesServiceDTOEpisode(
                excludeEmpty(episode.getName()),
                excludeEmpty(episode.getOverview()),
                excludeEmpty(episode.getAirDate()),
                episodeStillPath,
                episode.getId(),
                episode.getRuntime(),
                episode.getSeasonNumber(),
                episode.getEpisodeNumber(),
                episode.getVoteCount(),
                episode.getVoteAverage(),
                episodeDirectors,
                episodeWriters,
                episodeCast
            ));
        }
    }

    private String excludeEmpty (String str) {
        if (str == null || str.isEmpty()) {
            return null;
        }
        return str;
    }

    private <T> List<T> excludeEmpty (List<T> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        return list;
    }

    private String getContentRating(List<TVSeriesDetailsResponseBodyContentRatingResult> contentRatingResults) {
        for (TVSeriesDetailsResponseBodyContentRatingResult contentRatingResult : contentRatingResults) {
            if (contentRatingResult.getIso31661().equals("US")) {
                return contentRatingResult.getRating();
            }
        }
        return "G";
    }

    private String getGlobalCreator(List<TVSeriesDetailsResponseBodyCreator> creators) {
        creators = excludeEmpty(creators);
        if (creators != null) {
            for(TVSeriesDetailsResponseBodyCreator creator : creators) {
                String creatorName = excludeEmpty(creator.getName());
                if (creatorName != null) {
                    return creatorName;
                }
            }
        }
        return null;
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
        List<TVSeriesServiceDTOProductionCompany> productionCompanies, List<String> writers, List<TvSeriesServiceDTOActor> cast,
        List<TvSeriesServiceDTOSeason> seasons
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

    public List<TvSeriesServiceDTOActor> getCast() {
        return cast;
    }

    public List<TvSeriesServiceDTOSeason> getSeasons() {
        return seasons;
    }

    public String getBackdropPath() {
        return backdropPath;
    }

    public String getPosterPath() {
        return posterPath;
    }

    public List<TvSeriesServiceDTOEpisode> getEpisodes() {
        return episodes;
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

    public static class TvSeriesServiceDTOActor {

        private String name, character, profilePath;
        private int order;

        public TvSeriesServiceDTOActor(String name, String character, String profilePath, int order) {
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

    public static class TvSeriesServiceDTOSeason {

        private int seasonNumber;
        private String name, posterPath;

        public TvSeriesServiceDTOSeason(int seasonNumber, String name, String posterPath) {
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

    public static class TvSeriesServiceDTOEpisode {

        private String name, overview, airDate, stillPath;
        private long id;
        private int runtime, seasonNumber, episodeNumber, voteCount;
        private double voteAverage;
        private List<String> directors;
        private List<String> writers;
        private List<TvSeriesServiceDTOActor> cast;

        public TvSeriesServiceDTOEpisode(String name, String overview, String airDate, String stillPath, long id,
                int runtime, int seasonNumber, int episodeNumber, int voteCount, double voteAverage,
                List<String> directors, List<String> writers, List<TvSeriesServiceDTOActor> cast) {
            this.name = name;
            this.overview = overview;
            this.airDate = airDate;
            this.stillPath = stillPath;
            this.id = id;
            this.runtime = runtime;
            this.seasonNumber = seasonNumber;
            this.episodeNumber = episodeNumber;
            this.voteCount = voteCount;
            this.voteAverage = voteAverage;
            this.directors = directors;
            this.writers = writers;
            this.cast = cast;
        }

        public String getName() {
            return name;
        }

        public String getOverview() {
            return overview;
        }

        public String getAirDate() {
            return airDate;
        }

        public String getStillPath() {
            return stillPath;
        }

        public long getId() {
            return id;
        }

        public int getRuntime() {
            return runtime;
        }

        public int getSeasonNumber() {
            return seasonNumber;
        }

        public int getEpisodeNumber() {
            return episodeNumber;
        }

        public int getVoteCount() {
            return voteCount;
        }

        public double getVoteAverage() {
            return voteAverage;
        }

        public List<String> getDirectors() {
            return directors;
        }

        public List<String> getWriters() {
            return writers;
        }

        public List<TvSeriesServiceDTOActor> getCast() {
            return cast;
        }        

    }

}
