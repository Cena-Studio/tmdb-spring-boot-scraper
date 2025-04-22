package cool.cena.tmdb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cool.cena.tmdb.pojo.response.TVSeriesResponseBody;
import cool.cena.tmdb.pojo.servicedto.TvSeriesServiceDTO;
import cool.cena.tmdb.service.TvSeriesService;

@RestController
@RequestMapping("/tvseries")
public class TVSeriesController {

    @Autowired
    private TvSeriesService tvSeriesService;

    @GetMapping
    public ResponseEntity<TVSeriesResponseBody> getTVSeriesInfo(String title, int year, int season, int episode) {

        TvSeriesServiceDTO tvSeriesServiceDTO = tvSeriesService.getTvSeriesInfo(title, year, season, episode);

        return ResponseEntity.ok(new TVSeriesResponseBody(tvSeriesServiceDTO));

    }

    // @GetMapping
    // public ResponseEntity<String> getTVSeriesInfo(String title, int year, int season, int episode) {

    //     return ResponseEntity.ok("{\"id\":70626,\"firstAirDate\":\"2017-06-10\",\"voteAverage\":8.303,\"voteCount\":175,\"contentRating\":\"TV-MA\",\"overview\":\"曹承佑扮演了出生时就拥有非凡的头脑，但因为一场童年时期的脑手术而丧失所有情感感知能力，仅凭理性判断失误的冷漠检察官黄始木。在充斥着不正之风的监察厅里，黄时牧就是一股清流。突然有一天一具尸体出现在他眼前，一桩桩连环杀人案不断发生，一场不知道谁才是真兇的追击战正式展开。这是一部讲述失去感情的检察官黄始木与正义的警察韩汝真一同揭开检察厅内部秘密，捕捉真正罪犯的故事。\",\"name\":\"秘密森林\",\"originalName\":\"비밀의 숲\",\"tagline\":\"\",\"status\":null,\"genres\":[\"犯罪\",\"剧情\",\"悬疑\"],\"productionCountries\":[\"KR\"],\"directors\":[\"朴铉锡\",\"柳济元\"],\"productionCompanies\":[{\"name\":\"Studio Dragon\",\"logoPath\":\"/files/images/vzzqRwqTin3iAAMw2JlrmVPNnPa.png\"},{\"name\":\"IOK Company\",\"logoPath\":\"/files/images/aVGd9Vd0XQ4wcaTz7DSsrJK5Ncs.png\"},{\"name\":\"Signal Entertainment Group\",\"logoPath\":\"/files/images/defaultlogo.png\"},{\"name\":\"Ace Factory\",\"logoPath\":\"/files/images/r4UEn43JfLh9Wu326leJh2UVL6J.png\"},{\"name\":\"CJ ENM\",\"logoPath\":\"/files/images/dP3usmr6di1jMPH738rvbxdkmSQ.png\"}],\"writers\":[\"李秀妍\"],\"cast\":[{\"name\":\"曹承佑\",\"character\":\"Hwang Si-mok\",\"profilePath\":\"/files/images/agXysHUmaUdHrEQAZ2ZMvMR5oCU.jpg\",\"order\":0},{\"name\":\"裴斗娜\",\"character\":\"Han Yeo-jin\",\"profilePath\":\"/files/images/owMv65TuU4thBBJCpv3uWr1bWfc.jpg\",\"order\":1},{\"name\":\"李浚赫\",\"character\":\"Seo Dong-jae\",\"profilePath\":\"/files/images/hf3Yt9m9SE8I8uaoefDaYdBxwqh.jpg\",\"order\":2},{\"name\":\"全慧珍\",\"character\":\"Choi Bit\",\"profilePath\":\"/files/images/7PliJIOzUei41vyE9FaIWvFMNzC.jpg\",\"order\":3},{\"name\":\"崔武成\",\"character\":\"Woo Tae-ha\",\"profilePath\":\"/files/images/pcbn8YaW0iOR5jpV0aC7jwzDtAj.jpg\",\"order\":4},{\"name\":\"尹世雅\",\"character\":\"Lee Yeon-jae\",\"profilePath\":\"/files/images/dPQ005nG45oB1PCtXktv4osML3t.jpg\",\"order\":5},{\"name\":\"朴成根\",\"character\":\"Kang Won-chul\",\"profilePath\":\"/files/images/ovefjGfX76VY5NbsakwMqVHgn71.jpg\",\"order\":6},{\"name\":\"全培秀\",\"character\":\"Choi Yun-soo\",\"profilePath\":\"/files/images/7EhOO3xFN5FvEJwl0b0Eudab5bI.jpg\",\"order\":7},{\"name\":\"崔载雄\",\"character\":\"Jang Geon\",\"profilePath\":\"/files/images/mqCh3H7zVz1KGLN2PWBhDFgpCXO.jpg\",\"order\":9},{\"name\":\"李海英\",\"character\":\"Shin Jae-yong\",\"profilePath\":\"/files/images/pN1iaIOP2MBhIhqli6u08Gehuut.jpg\",\"order\":9},{\"name\":\"宋智浩\",\"character\":\"Park Sun-chang\",\"profilePath\":\"/files/images/4WdiiekN9gG6g5jTeprXX3wQHc5.jpg\",\"order\":11},{\"name\":\"金荣在\",\"character\":\"Kim Sa-hyun\",\"profilePath\":\"/files/images/wSgDPw6fSGgrwJLO0QaITbS758L.jpg\",\"order\":11},{\"name\":\"金学顺\",\"character\":\"Oh Ju-seon\",\"profilePath\":\"/files/images/4SKruoQKCk3k0umArclsDftwuTM.jpg\",\"order\":13},{\"name\":\"郑成日\",\"character\":\"Managing Director Park\",\"profilePath\":\"/files/images/cP0vEFV5aL8D9mntwlFWP5pcTQo.jpg\",\"order\":14},{\"name\":\"尹太仁\",\"character\":\"Seo Sang-won\",\"profilePath\":\"/files/images/6I5c2wNJ0v8O7CZp6nC77UGHqxm.jpg\",\"order\":20}],\"seasons\":[{\"seasonNumber\":0,\"name\":\"特别篇\",\"posterPath\":\"/files/images/defaultposter.jpg\"},{\"seasonNumber\":1,\"name\":\"第 1 季\",\"posterPath\":\"/files/images/9srrXhYj0BxKpOGEBDZLV1wpZg7.jpg\"},{\"seasonNumber\":2,\"name\":\"第 2 季\",\"posterPath\":\"/files/images/ddjPs7Pxm8bO5TPd7ICnQNVToMJ.jpg\"}],\"backdropPath\":\"/files/images/wwNasWOG4HlH9R6F8ybPJETTPO7.jpg\",\"posterPath\":\"/files/images/9srrXhYj0BxKpOGEBDZLV1wpZg7.jpg\"}");
    // }
    
}
