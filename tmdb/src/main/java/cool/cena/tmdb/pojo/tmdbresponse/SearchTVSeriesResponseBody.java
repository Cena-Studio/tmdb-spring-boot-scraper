package cool.cena.tmdb.pojo.tmdbresponse;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SearchTVSeriesResponseBody {
    private int page;
    private List<SearchTVSeriesResponseBodyResult> results;
    @JsonProperty("total_pages")
    private int totalPages;
    @JsonProperty("total_results")
    private int totalResults;

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public List<SearchTVSeriesResponseBodyResult> getResults() {
        return results;
    }

    public void setResults(List<SearchTVSeriesResponseBodyResult> results) {
        this.results = results;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public int getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(int totalResults) {
        this.totalResults = totalResults;
    }

    public static class SearchTVSeriesResponseBodyResult {

        private String overview, name;
        private long id;
        private double popularity;
        private boolean adult;
        @JsonProperty("backdrop_path")
        private String backdropPath;
        @JsonProperty("genre_ids")
        private List<Integer> genreIDs;
        @JsonProperty("origin_country")
        private List<String> originCountry;
        @JsonProperty("original_language")
        private String originalLanguage;
        @JsonProperty("original_name")
        private String originalName;
        @JsonProperty("poster_path")
        private String posterPath;
        @JsonProperty("first_air_date")
        private String firstAirDate;
        @JsonProperty("vote_average")
        private double voteAverage;
        @JsonProperty("vote_count")
        private int voteCount;

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

        public boolean isAdult() {
            return adult;
        }

        public void setAdult(boolean adult) {
            this.adult = adult;
        }

        public String getBackdropPath() {
            return backdropPath;
        }

        public void setBackdropPath(String backdropPath) {
            this.backdropPath = backdropPath;
        }

        public List<Integer> getGenreIDs() {
            return genreIDs;
        }

        public void setGenreIDs(List<Integer> genreIDs) {
            this.genreIDs = genreIDs;
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

    }
}
