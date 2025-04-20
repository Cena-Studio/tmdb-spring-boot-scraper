package cool.cena.tmdb.pojo.tmdbresponse;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TVSeriesDetailsResponseBody {

    private boolean adult;
    private String homepage, overview, name, status, tagline, type;
    private long id;
    private double popularity;
    private List<String> languages;
    private List<TVSeriesDetailsResponseBodyGenre> genres;
    private List<TVSeriesDetailsResponseBodyNetwork> networks;
    private List<TVSeriesDetailsResponseBodySeason> seasons;
    @JsonProperty("backdrop_path")
    private String backdropPath;
    @JsonProperty("created_by")
    private List<TVSeriesDetailsResponseBodyCreator> createdBy;
    @JsonProperty("episode_run_time")
    private List<Integer> episodeRunTime;
    @JsonProperty("first_air_date")
    private String firstAirDate;
    @JsonProperty("inProduction")
    private boolean in_production;
    @JsonProperty("last_air_date")
    private String lastAirDate;
    @JsonProperty("last_episode_to_air")
    private TVSeriesDetailsResponseBodyLastAir lastEpisodeToAir;
    @JsonProperty("next_episode_to_air")
    private String nextEpisodeToAir;
    @JsonProperty("number_of_episodes")
    private int numberOfEpisodes;
    @JsonProperty("number_of_seasons")
    private int numberOfSeasons;
    @JsonProperty("origin_country")
    private List<String> originCountry;
    @JsonProperty("original_language")
    private String originalLanguage;
    @JsonProperty("original_name")
    private String originalName;
    @JsonProperty("poster_path")
    private String posterPath;
    @JsonProperty("production_companies")
    private List<TVSeriesDetailsResponseBodyProductionCompany> productionCompanies;
    @JsonProperty("production_countries")
    private List<TVSeriesDetailsResponseBodyProductionCountry> productionCountries;
    @JsonProperty("spoken_languages")
    private List<TVSeriesDetailsResponseBodySpokenLanguage> spokenLanguages;
    @JsonProperty("vote_average")
    private double voteAverage;
    @JsonProperty("vote_count")
    private int voteCount;
    @JsonProperty("content_ratings")
    private TVSeriesDetailsResponseBodyContentRating contentRatings;
    private TVSeriesDetailsResponseBodyCredit credits;

    public boolean isAdult() {
        return adult;
    }

    public void setAdult(boolean adult) {
        this.adult = adult;
    }

    public String getHomepage() {
        return homepage;
    }

    public void setHomepage(String homepage) {
        this.homepage = homepage;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTagline() {
        return tagline;
    }

    public void setTagline(String tagline) {
        this.tagline = tagline;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getPopularity() {
        return popularity;
    }

    public void setPopularity(double popularity) {
        this.popularity = popularity;
    }

    public List<String> getLanguages() {
        return languages;
    }

    public void setLanguages(List<String> languages) {
        this.languages = languages;
    }

    public List<TVSeriesDetailsResponseBodyGenre> getGenres() {
        return genres;
    }

    public void setGenres(List<TVSeriesDetailsResponseBodyGenre> genres) {
        this.genres = genres;
    }

    public List<TVSeriesDetailsResponseBodyNetwork> getNetworks() {
        return networks;
    }

    public void setNetworks(List<TVSeriesDetailsResponseBodyNetwork> networks) {
        this.networks = networks;
    }

    public List<TVSeriesDetailsResponseBodySeason> getSeasons() {
        return seasons;
    }

    public void setSeasons(List<TVSeriesDetailsResponseBodySeason> seasons) {
        this.seasons = seasons;
    }

    public String getBackdropPath() {
        return backdropPath;
    }

    public void setBackdropPath(String backdropPath) {
        this.backdropPath = backdropPath;
    }

    public List<TVSeriesDetailsResponseBodyCreator> getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(List<TVSeriesDetailsResponseBodyCreator> createdBy) {
        this.createdBy = createdBy;
    }

    public List<Integer> getEpisodeRunTime() {
        return episodeRunTime;
    }

    public void setEpisodeRunTime(List<Integer> episodeRunTime) {
        this.episodeRunTime = episodeRunTime;
    }

    public String getFirstAirDate() {
        return firstAirDate;
    }

    public void setFirstAirDate(String firstAirDate) {
        this.firstAirDate = firstAirDate;
    }

    public boolean isIn_production() {
        return in_production;
    }

    public void setIn_production(boolean in_production) {
        this.in_production = in_production;
    }

    public String getLastAirDate() {
        return lastAirDate;
    }

    public void setLastAirDate(String lastAirDate) {
        this.lastAirDate = lastAirDate;
    }

    public TVSeriesDetailsResponseBodyLastAir getLastEpisodeToAir() {
        return lastEpisodeToAir;
    }

    public void setLastEpisodeToAir(TVSeriesDetailsResponseBodyLastAir lastEpisodeToAir) {
        this.lastEpisodeToAir = lastEpisodeToAir;
    }

    public String getNextEpisodeToAir() {
        return nextEpisodeToAir;
    }

    public void setNextEpisodeToAir(String nextEpisodeToAir) {
        this.nextEpisodeToAir = nextEpisodeToAir;
    }

    public int getNumberOfEpisodes() {
        return numberOfEpisodes;
    }

    public void setNumberOfEpisodes(int numberOfEpisodes) {
        this.numberOfEpisodes = numberOfEpisodes;
    }

    public int getNumberOfSeasons() {
        return numberOfSeasons;
    }

    public void setNumberOfSeasons(int numberOfSeasons) {
        this.numberOfSeasons = numberOfSeasons;
    }

    public List<String> getOriginCountry() {
        return originCountry;
    }

    public void setOriginCountry(List<String> originCountry) {
        this.originCountry = originCountry;
    }

    public String getOriginalLanguage() {
        return originalLanguage;
    }

    public void setOriginalLanguage(String originalLanguage) {
        this.originalLanguage = originalLanguage;
    }

    public String getOriginalName() {
        return originalName;
    }

    public void setOriginalName(String originalName) {
        this.originalName = originalName;
    }

    public String getPosterPath() {
        return posterPath;
    }

    public void setPosterPath(String posterPath) {
        this.posterPath = posterPath;
    }

    public List<TVSeriesDetailsResponseBodyProductionCompany> getProductionCompanies() {
        return productionCompanies;
    }

    public void setProductionCompanies(List<TVSeriesDetailsResponseBodyProductionCompany> productionCompanies) {
        this.productionCompanies = productionCompanies;
    }

    public List<TVSeriesDetailsResponseBodyProductionCountry> getProductionCountries() {
        return productionCountries;
    }

    public void setProductionCountries(List<TVSeriesDetailsResponseBodyProductionCountry> productionCountries) {
        this.productionCountries = productionCountries;
    }

    public List<TVSeriesDetailsResponseBodySpokenLanguage> getSpokenLanguages() {
        return spokenLanguages;
    }

    public void setSpokenLanguages(List<TVSeriesDetailsResponseBodySpokenLanguage> spokenLanguages) {
        this.spokenLanguages = spokenLanguages;
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

    public TVSeriesDetailsResponseBodyContentRating getContentRatings() {
        return contentRatings;
    }

    public void setContentRatings(TVSeriesDetailsResponseBodyContentRating contentRatings) {
        this.contentRatings = contentRatings;
    }

    public TVSeriesDetailsResponseBodyCredit getCredits() {
        return credits;
    }

    public void setCredits(TVSeriesDetailsResponseBodyCredit credits) {
        this.credits = credits;
    }

    public static class TVSeriesDetailsResponseBodyCreator {

        private long id;
        private int gender;
        private String name;
        @JsonProperty("credit_id")
        private String creditId;
        @JsonProperty("profile_path")
        private String profilePath;

        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }

        public int getGender() {
            return gender;
        }

        public void setGender(int gender) {
            this.gender = gender;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getCreditId() {
            return creditId;
        }

        public void setCreditId(String creditId) {
            this.creditId = creditId;
        }

        public String getProfilePath() {
            return profilePath;
        }

        public void setProfilePath(String profilePath) {
            this.profilePath = profilePath;
        }

    }

    public static class TVSeriesDetailsResponseBodyGenre {

        private int id;
        private String name;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

    }

    public static class TVSeriesDetailsResponseBodyLastAir {

        private int id, runtime;
        private String name, overview;
        @JsonProperty("vode_average")
        private double voteAverage;
        @JsonProperty("vote_count")
        private int voteCount;
        @JsonProperty("air_date")
        private String airDate;
        @JsonProperty("episode_number")
        private int episodeNumber;
        @JsonProperty("production_code")
        private String productionCode;
        @JsonProperty("season_number")
        private int seasonNumber;
        @JsonProperty("show_id")
        private long showID;
        @JsonProperty("still_path")
        private String stillPath;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getRuntime() {
            return runtime;
        }

        public void setRuntime(int runtime) {
            this.runtime = runtime;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getOverview() {
            return overview;
        }

        public void setOverview(String overview) {
            this.overview = overview;
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

        public String getAirDate() {
            return airDate;
        }

        public void setAirDate(String airDate) {
            this.airDate = airDate;
        }

        public int getEpisodeNumber() {
            return episodeNumber;
        }

        public void setEpisodeNumber(int episodeNumber) {
            this.episodeNumber = episodeNumber;
        }

        public String getProductionCode() {
            return productionCode;
        }

        public void setProductionCode(String productionCode) {
            this.productionCode = productionCode;
        }

        public int getSeasonNumber() {
            return seasonNumber;
        }

        public void setSeasonNumber(int seasonNumber) {
            this.seasonNumber = seasonNumber;
        }

        public long getShowID() {
            return showID;
        }

        public void setShowID(long showID) {
            this.showID = showID;
        }

        public String getStillPath() {
            return stillPath;
        }

        public void setStillPath(String stillPath) {
            this.stillPath = stillPath;
        }

    }

    public static class TVSeriesDetailsResponseBodyNetwork {

        private long id;
        private String name;
        @JsonProperty("logo_path")
        private String logoPath;
        @JsonProperty("origin_country")
        private String originCountry;

        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
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

        public String getOriginCountry() {
            return originCountry;
        }

        public void setOriginCountry(String originCountry) {
            this.originCountry = originCountry;
        }

    }

    public static class TVSeriesDetailsResponseBodyProductionCompany {

        private long id;
        private String name;
        @JsonProperty("logo_path")
        private String logoPath;
        @JsonProperty("origin_country")
        private String originCountry;

        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
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

        public String getOriginCountry() {
            return originCountry;
        }

        public void setOriginCountry(String originCountry) {
            this.originCountry = originCountry;
        }

    }

    public static class TVSeriesDetailsResponseBodyProductionCountry {

        private String name;
        @JsonProperty("iso_3166_1")
        private String iso31661;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getIso31661() {
            return iso31661;
        }

        public void setIso31661(String iso31661) {
            this.iso31661 = iso31661;
        }

    }

    public static class TVSeriesDetailsResponseBodySeason {

        private long id;
        private String name, overview;
        @JsonProperty("air_date")
        private String airDate;
        @JsonProperty("episode_count")
        private String episodeCount;
        @JsonProperty("poster_path")
        private String posterPath;
        @JsonProperty("season_number")
        private int seasonNumber;
        @JsonProperty("vote_average")
        private double voteAverage;

        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getOverview() {
            return overview;
        }

        public void setOverview(String overview) {
            this.overview = overview;
        }

        public String getAirDate() {
            return airDate;
        }

        public void setAirDate(String airDate) {
            this.airDate = airDate;
        }

        public String getEpisodeCount() {
            return episodeCount;
        }

        public void setEpisodeCount(String episodeCount) {
            this.episodeCount = episodeCount;
        }

        public String getPosterPath() {
            return posterPath;
        }

        public void setPosterPath(String posterPath) {
            this.posterPath = posterPath;
        }

        public int getSeasonNumber() {
            return seasonNumber;
        }

        public void setSeasonNumber(int seasonNumber) {
            this.seasonNumber = seasonNumber;
        }

        public double getVoteAverage() {
            return voteAverage;
        }

        public void setVoteAverage(double voteAverage) {
            this.voteAverage = voteAverage;
        }

    }

    public static class TVSeriesDetailsResponseBodySpokenLanguage {

        private String name;
        @JsonProperty("english_name")
        private String englishName;
        @JsonProperty("iso_630_1")
        private String iso6391;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getEnglishName() {
            return englishName;
        }

        public void setEnglishName(String englishName) {
            this.englishName = englishName;
        }

        public String getIso6391() {
            return iso6391;
        }

        public void setIso6391(String iso6391) {
            this.iso6391 = iso6391;
        }

    }

    public static class TVSeriesDetailsResponseBodyContentRating {

        private List<TVSeriesDetailsResponseBodyContentRatingResult> results;

        public List<TVSeriesDetailsResponseBodyContentRatingResult> getResults() {
            return results;
        }

        public void setResults(List<TVSeriesDetailsResponseBodyContentRatingResult> results) {
            this.results = results;
        }

    }

    public static class TVSeriesDetailsResponseBodyContentRatingResult {

        private List<String> descriptors;
        @JsonProperty("iso_3166_1")
        private String iso31661;
        private String rating;

        public List<String> getDescriptors() {
            return descriptors;
        }
        public void setDescriptors(List<String> descriptors) {
            this.descriptors = descriptors;
        }
        public String getIso31661() {
            return iso31661;
        }
        public void setIso31661(String iso31661) {
            this.iso31661 = iso31661;
        }
        public String getRating() {
            return rating;
        }
        public void setRating(String rating) {
            this.rating = rating;
        }
        
    }

    public static class TVSeriesDetailsResponseBodyCredit {

        private List<TVSeriesDetailsResponseBodyCreditActor> cast;
        private List<TVSeriesDetailsResponseBodyCreditWorker> crew;

        public List<TVSeriesDetailsResponseBodyCreditActor> getCast() {
            return cast;
        }
        public void setCast(List<TVSeriesDetailsResponseBodyCreditActor> cast) {
            this.cast = cast;
        }
        public List<TVSeriesDetailsResponseBodyCreditWorker> getCrew() {
            return crew;
        }
        public void setCrew(List<TVSeriesDetailsResponseBodyCreditWorker> crew) {
            this.crew = crew;
        }
    
    }

    public static class TVSeriesDetailsResponseBodyCreditActor {

        private boolean adult;
        private int gender, order;
        private long id;
        private String name, character;
        private double popularity;
        @JsonProperty("known_for_department")
        private String knownForDepartment;
        @JsonProperty("original_name")
        private String originalName;
        @JsonProperty("profile_path")
        private String profilePath;
        @JsonProperty("credit_id")
        private String creditID;

        public boolean isAdult() {
            return adult;
        }
        public void setAdult(boolean adult) {
            this.adult = adult;
        }
        public int getGender() {
            return gender;
        }
        public void setGender(int gender) {
            this.gender = gender;
        }
        public int getOrder() {
            return order;
        }
        public void setOrder(int order) {
            this.order = order;
        }
        public long getId() {
            return id;
        }
        public void setId(long id) {
            this.id = id;
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
        public double getPopularity() {
            return popularity;
        }
        public void setPopularity(double popularity) {
            this.popularity = popularity;
        }
        public String getKnownForDepartment() {
            return knownForDepartment;
        }
        public void setKnownForDepartment(String knownForDepartment) {
            this.knownForDepartment = knownForDepartment;
        }
        public String getOriginalName() {
            return originalName;
        }
        public void setOriginalName(String originalName) {
            this.originalName = originalName;
        }
        public String getProfilePath() {
            return profilePath;
        }
        public void setProfilePath(String profilePath) {
            this.profilePath = profilePath;
        }
        public String getCreditID() {
            return creditID;
        }
        public void setCreditID(String creditID) {
            this.creditID = creditID;
        }

        
    }

    public static class TVSeriesDetailsResponseBodyCreditWorker {

        private boolean adult;
        private int gender, order;
        private long id;
        private String name, department, job;
        private double popularity;
        @JsonProperty("known_for_department")
        private String knownForDepartment;
        @JsonProperty("original_name")
        private String originalName;
        @JsonProperty("profile_path")
        private String profilePath;
        @JsonProperty("credit_id")
        private String creditID;

        public boolean isAdult() {
            return adult;
        }
        public void setAdult(boolean adult) {
            this.adult = adult;
        }
        public int getGender() {
            return gender;
        }
        public void setGender(int gender) {
            this.gender = gender;
        }
        public int getOrder() {
            return order;
        }
        public void setOrder(int order) {
            this.order = order;
        }
        public long getId() {
            return id;
        }
        public void setId(long id) {
            this.id = id;
        }
        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }
        public String getDepartment() {
            return department;
        }
        public void setDepartment(String department) {
            this.department = department;
        }
        public String getJob() {
            return job;
        }
        public void setJob(String job) {
            this.job = job;
        }
        public double getPopularity() {
            return popularity;
        }
        public void setPopularity(double popularity) {
            this.popularity = popularity;
        }
        public String getKnownForDepartment() {
            return knownForDepartment;
        }
        public void setKnownForDepartment(String knownForDepartment) {
            this.knownForDepartment = knownForDepartment;
        }
        public String getOriginalName() {
            return originalName;
        }
        public void setOriginalName(String originalName) {
            this.originalName = originalName;
        }
        public String getProfilePath() {
            return profilePath;
        }
        public void setProfilePath(String profilePath) {
            this.profilePath = profilePath;
        }
        public String getCreditID() {
            return creditID;
        }
        public void setCreditID(String creditID) {
            this.creditID = creditID;
        }

    }

}