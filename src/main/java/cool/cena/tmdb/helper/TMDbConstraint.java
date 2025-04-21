package cool.cena.tmdb.helper;

import java.nio.file.Paths;

public class TMDbConstraint {
    
    public static final String FILE_DIR = Paths.get("files").toAbsolutePath().toString();
    public static final String IMG_FILE_DIR = Paths.get("files", "images").toAbsolutePath().toString();
    public static final String IMG_FILE_PATH = "/files/images";
    public static final String DEFAULT_LOGO_IMG_FILE_PATH = IMG_FILE_PATH + "/defaultlogo.png";
    public static final String DEFAULT_MALE_PROFILE_IMG_FILE_PATH = IMG_FILE_PATH + "/defaultprofilemale.jpg";
    public static final String DEFAULT_FEMALE_PROFILE_IMG_FILE_PATH = IMG_FILE_PATH + "/defaultprofilefemale.jpg";
    public static final String DEFAULT_POSTER_IMG_FILE_PATH = IMG_FILE_PATH + "/defaultposter.jpg";
    public static final String DEFAULT_BACKDROP_IMG_FILE_PATH = IMG_FILE_PATH + "/defaultbackdrop.jpg";
    public static final String TMDB_BACKDROP_IMG_PATH = "https://image.tmdb.org/t/p/w1280";
    public static final String TMDB_LOGO_IMG_PATH = "https://image.tmdb.org/t/p/w300";
    public static final String TMDB_POSTER_IMG_PATH = "https://image.tmdb.org/t/p/w780";
    public static final String TMDB_PROFILE_IMG_PATH = "https://image.tmdb.org/t/p/h632";
    public static final String TMDB_STILL_IMG_PATH = "https://image.tmdb.org/t/p/w300";

}
