package cool.cena.tmdb.pojo.tmdbresponse;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SearchMovieResponseBody {
    private int page;
    private List<SearchMovieResponseBodyResult> results;
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

    public List<SearchMovieResponseBodyResult> getResults() {
        return results;
    }

    public void setResults(List<SearchMovieResponseBodyResult> results) {
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

    public static class SearchMovieResponseBodyResult {

        private String overview, title;
        private long id;
        private double popularity;
        private boolean adult, video;
        @JsonProperty("backdrop_path")
        private String backdropPath;
        @JsonProperty("genre_ids")
        private List<Integer> genreIDs;
        @JsonProperty("original_language")
        private String originalLanguage;
        @JsonProperty("original_title")
        private String originalTitle;
        @JsonProperty("poster_path")
        private String posterPath;
        @JsonProperty("release_date")
        private String releaseDate;
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

        public String getTitle() {
            return title;
        }

        public void setTitle(String name) {
            this.title = name;
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

        public String getOriginalLanguage() {
            return originalLanguage;
        }

        public void setOriginalLanguage(String originalLanguage) {
            this.originalLanguage = originalLanguage;
        }

        public String getOriginalTitle() {
            return originalTitle;
        }

        public void setOriginalTitle(String originalName) {
            this.originalTitle = originalName;
        }

        public String getPosterPath() {
            return posterPath;
        }

        public void setPosterPath(String posterPath) {
            this.posterPath = posterPath;
        }

        public String getReleaseDate() {
            return releaseDate;
        }

        public void setReleaseDate(String firstAirDate) {
            this.releaseDate = firstAirDate;
        }

        public boolean isVideo() {
            return video;
        }

        public void setVideo(boolean video) {
            this.video = video;
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
