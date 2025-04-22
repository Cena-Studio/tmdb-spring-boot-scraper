package cool.cena.tmdb.pojo.servicedto;

import java.util.ArrayList;
import java.util.List;

import cool.cena.tmdb.helper.TMDbConstraint;
import cool.cena.tmdb.pojo.tmdbresponse.EpisodeDetailsResponseBody;

public class EpisodeServiceDTO {

    private long id;
    private String airDate;
    private int episodeNumber;
    private int seasonNumber;

    public EpisodeServiceDTO(EpisodeDetailsResponseBody episodeDetailsResponseBody) {

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

}
