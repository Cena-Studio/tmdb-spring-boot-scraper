package cool.cena.tmdb.pojo.tmdbresponse;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class EpisodeDetailsResponseBody {

    private String name, overview;
    private long id;
    private int runtime;
    private List<EpisodeDetailsResponseBodyCreditWorker> crew;
    @JsonProperty("air_date")
    private String airDate;
    @JsonProperty("episode_number")
    private int episodeNumber;
    @JsonProperty("guest_stars")
    private List<EpisodeDetailsResponseBodyCreditActor> guestStars;
    @JsonProperty("production_code")
    private String productionCode;
    @JsonProperty("season_number")
    private int seasonNumber;
    @JsonProperty("still_path")
    private String stillPath;
    @JsonProperty("vote_average")
    private double voteAverage;
    @JsonProperty("vote_count")
    private int voteCount;

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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getRuntime() {
        return runtime;
    }

    public void setRuntime(int runtime) {
        this.runtime = runtime;
    }

    public List<EpisodeDetailsResponseBodyCreditWorker> getCrew() {
        return crew;
    }

    public void setCrew(List<EpisodeDetailsResponseBodyCreditWorker> crew) {
        this.crew = crew;
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

    public List<EpisodeDetailsResponseBodyCreditActor> getGuestStars() {
        return guestStars;
    }

    public void setGuestStars(List<EpisodeDetailsResponseBodyCreditActor> guestStars) {
        this.guestStars = guestStars;
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

    public String getStillPath() {
        return stillPath;
    }

    public void setStillPath(String stillPath) {
        this.stillPath = stillPath;
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

    public static class EpisodeDetailsResponseBodyCreditWorker {

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

    public static class EpisodeDetailsResponseBodyCreditActor {

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

}