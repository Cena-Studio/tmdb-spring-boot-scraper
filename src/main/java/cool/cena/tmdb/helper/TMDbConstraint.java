package cool.cena.tmdb.helper;

import java.nio.file.Paths;

public class TMDbConstraint {
    
    public static final String IMG_FILE_DIR = Paths.get("files", "images").toAbsolutePath().toString();
    public static final String IMG_FILE_PATH = "/files/images";
    public static final String TMDB_BACKDROP_IMG_PATH = "https://image.tmdb.org/t/p/w1280";
    public static final String TMDB_LOGO_IMG_PATH = "https://image.tmdb.org/t/p/w300";
    public static final String TMDB_POSTER_IMG_PATH = "https://image.tmdb.org/t/p/w780";
    public static final String TMDB_PROFILE_IMG_PATH = "https://image.tmdb.org/t/p/h632";
    public static final String TMDB_STILL_IMG_PATH = "https://image.tmdb.org/t/p/w300";

}
