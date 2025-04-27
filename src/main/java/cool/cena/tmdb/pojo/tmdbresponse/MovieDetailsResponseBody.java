package cool.cena.tmdb.pojo.tmdbresponse;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MovieDetailsResponseBody {

    private boolean adult, video;
    private long budget, id, revenue;
    private String homepage, overview, title, status, tagline;
    private int runtime;
    private double popularity;
    private List<MovieDetailsResponseBodyGenre> genres;
    @JsonProperty("backdrop_path")
    private String backdropPath;
    @JsonProperty("belongs_to_collection")
    private String belongsToCollection;
    @JsonProperty("imdb_id")
    private String imdbId;
    @JsonProperty("original_language")
    private String originalLanguage;
    @JsonProperty("original_title")
    private String originalTitle;
    @JsonProperty("poster_path")
    private String posterPath;
    @JsonProperty("production_companies")
    private List<MovieDetailsResponseBodyProductionCompany> productionCompanies;
    @JsonProperty("production_countries")
    private List<MovieDetailsResponseBodyProductionCountry> productionCountries;
    @JsonProperty("release_date")
    private String releaseDate;
    @JsonProperty("spoken_languages")
    private List<MovieDetailsResponseBodySpokenLanguage> spokenLanguages;
    @JsonProperty("vote_average")
    private double voteAverage;
    @JsonProperty("vote_count")
    private int voteCount;
    @JsonProperty("release_dates")
    private MovieDetailsResponseBodyReleaseDates releaseDates;
    private MovieDetailsResponseBodyCredit credits;

    public boolean isAdult() {
        return adult;
    }

    public void setAdult(boolean adult) {
        this.adult = adult;
    }

    public boolean isVideo() {
        return video;
    }

    public void setVideo(boolean video) {
        this.video = video;
    }

    public long getBudget() {
        return budget;
    }

    public void setBudget(long budget) {
        this.budget = budget;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getRevenue() {
        return revenue;
    }

    public void setRevenue(long revenue) {
        this.revenue = revenue;
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public int getRuntime() {
        return runtime;
    }

    public void setRuntime(int runtime) {
        this.runtime = runtime;
    }

    public double getPopularity() {
        return popularity;
    }

    public void setPopularity(double popularity) {
        this.popularity = popularity;
    }

    public List<MovieDetailsResponseBodyGenre> getGenres() {
        return genres;
    }

    public void setGenres(List<MovieDetailsResponseBodyGenre> genres) {
        this.genres = genres;
    }

    public String getBackdropPath() {
        return backdropPath;
    }

    public void setBackdropPath(String backdropPath) {
        this.backdropPath = backdropPath;
    }

    public String getBelongsToCollection() {
        return belongsToCollection;
    }

    public void setBelongsToCollection(String belongsToCollection) {
        this.belongsToCollection = belongsToCollection;
    }

    public String getImdbId() {
        return imdbId;
    }

    public void setImdbId(String imdbId) {
        this.imdbId = imdbId;
    }

    public String getOriginalLanguage() {
        return originalLanguage;
    }

    public void setOriginalLanguage(String originalLanguage) {
        this.originalLanguage = originalLanguage;
    }

    public String getOriginalTitle() {
        return originalTitle;
    }

    public void setOriginalTitle(String originalTitle) {
        this.originalTitle = originalTitle;
    }

    public String getPosterPath() {
        return posterPath;
    }

    public void setPosterPath(String posterPath) {
        this.posterPath = posterPath;
    }

    public List<MovieDetailsResponseBodyProductionCompany> getProductionCompanies() {
        return productionCompanies;
    }

    public void setProductionCompanies(List<MovieDetailsResponseBodyProductionCompany> productionCompanies) {
        this.productionCompanies = productionCompanies;
    }

    public List<MovieDetailsResponseBodyProductionCountry> getProductionCountries() {
        return productionCountries;
    }

    public void setProductionCountries(List<MovieDetailsResponseBodyProductionCountry> productionCountries) {
        this.productionCountries = productionCountries;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public List<MovieDetailsResponseBodySpokenLanguage> getSpokenLanguages() {
        return spokenLanguages;
    }

    public void setSpokenLanguages(List<MovieDetailsResponseBodySpokenLanguage> spokenLanguages) {
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

    public MovieDetailsResponseBodyReleaseDates getReleaseDates() {
        return releaseDates;
    }

    public void setReleaseDates(MovieDetailsResponseBodyReleaseDates releaseDates) {
        this.releaseDates = releaseDates;
    }

    public MovieDetailsResponseBodyCredit getCredits() {
        return credits;
    }

    public void setCredits(MovieDetailsResponseBodyCredit credits) {
        this.credits = credits;
    }

    public static class MovieDetailsResponseBodyGenre {

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

    public static class MovieDetailsResponseBodyLastAir {

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

    public static class MovieDetailsResponseBodyNetwork {

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

    public static class MovieDetailsResponseBodyProductionCompany {

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

    public static class MovieDetailsResponseBodyProductionCountry {

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

    public static class MovieDetailsResponseBodySeason {

        private long id;
        private String name, overview;
        @JsonProperty("air_date")
        private String airDate;
        @JsonProperty("episode_count")
        private int episodeCount;
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

        public int getEpisodeCount() {
            return episodeCount;
        }

        public void setEpisodeCount(int episodeCount) {
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

    public static class MovieDetailsResponseBodySpokenLanguage {

        private String name;
        @JsonProperty("english_name")
        private String englishName;
        @JsonProperty("iso_639_1")
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

    public static class MovieDetailsResponseBodyReleaseDates {

        private List<MovieDetailsResponseBodyReleaseDatesResult> results;

        public List<MovieDetailsResponseBodyReleaseDatesResult> getResults() {
            return results;
        }

        public void setResults(List<MovieDetailsResponseBodyReleaseDatesResult> results) {
            this.results = results;
        }

    }

    public static class MovieDetailsResponseBodyReleaseDatesResult {

        @JsonProperty("iso_3166_1")
        private String iso31661;
        @JsonProperty("release_dates")
        private List<MovieDetailsResponseBodyReleaseDate> releaseDates;
        public String getIso31661() {
            return iso31661;
        }
        public void setIso31661(String iso31661) {
            this.iso31661 = iso31661;
        }
        public List<MovieDetailsResponseBodyReleaseDate> getReleaseDates() {
            return releaseDates;
        }
        public void setReleaseDates(List<MovieDetailsResponseBodyReleaseDate> releaseDates) {
            this.releaseDates = releaseDates;
        }

    }

    public static class MovieDetailsResponseBodyReleaseDate {

        private String certification, note;
        private List<String> descriptors;
        private int type;
        @JsonProperty("iso_639_1")
        private String iso6391;
        @JsonProperty("release_date")
        private String releaseDate;
        public String getCertification() {
            return certification;
        }
        public void setCertification(String certification) {
            this.certification = certification;
        }
        public String getNote() {
            return note;
        }
        public void setNote(String note) {
            this.note = note;
        }
        public List<String> getDescriptors() {
            return descriptors;
        }
        public void setDescriptors(List<String> descriptors) {
            this.descriptors = descriptors;
        }
        public int getType() {
            return type;
        }
        public void setType(int type) {
            this.type = type;
        }
        public String getIso6391() {
            return iso6391;
        }
        public void setIso6391(String iso6391) {
            this.iso6391 = iso6391;
        }
        public String getReleaseDate() {
            return releaseDate;
        }
        public void setReleaseDate(String releaseDate) {
            this.releaseDate = releaseDate;
        }
        
        

    }

    public static class MovieDetailsResponseBodyCredit {

        private List<MovieDetailsResponseBodyCreditActor> cast;
        private List<MovieDetailsResponseBodyCreditWorker> crew;

        public List<MovieDetailsResponseBodyCreditActor> getCast() {
            return cast;
        }

        public void setCast(List<MovieDetailsResponseBodyCreditActor> cast) {
            this.cast = cast;
        }

        public List<MovieDetailsResponseBodyCreditWorker> getCrew() {
            return crew;
        }

        public void setCrew(List<MovieDetailsResponseBodyCreditWorker> crew) {
            this.crew = crew;
        }

    }

    public static class MovieDetailsResponseBodyCreditActor {

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
        @JsonProperty("cast_id")
        private String castId;
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

        public String getCastId() {
            return castId;
        }

        public void setCastId(String castId) {
            this.castId = castId;
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

    public static class MovieDetailsResponseBodyCreditWorker {

        private boolean adult;
        private int gender;
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
        private String creditId;

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

        public String getCreditId() {
            return creditId;
        }

        public void setCreditId(String creditID) {
            this.creditId = creditID;
        }

    }

}