package pl.mczepan.mgrapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import pl.mczepan.mgrapp.model.basketball.Basketball;
import pl.mczepan.mgrapp.model.live.basketball.BasketballGame;
import pl.mczepan.mgrapp.model.live.basketball.LiveBasketball;
import pl.mczepan.mgrapp.model.live.basketball.boxscore.BasicGameData;
import pl.mczepan.mgrapp.model.live.basketball.boxscore.BasketballBoxscore;
import pl.mczepan.mgrapp.model.live.cricket.Cricket;
import pl.mczepan.mgrapp.model.live.cricket.CricketMatch;
import pl.mczepan.mgrapp.model.live.cricket.detail.CricketDetail;

import pl.mczepan.mgrapp.model.live.football.FootballMatch;
import pl.mczepan.mgrapp.service.BasketballService;

import java.util.List;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping(value = "/api/live")
public class LiveController {

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    BasketballService basketballService;

    @Value("${api.football.key}")
    private String apiFootballKey;


    @Value("${api.cricket.key}")
    private String apiCricketKey;

    @GetMapping("/basketball")
    public LiveBasketball getBasketballLiveResult() {

        String currentScoreboard = restTemplate.getForObject("http://data.nba.net/10s/prod/v1/today.json", Basketball.class).getLinks().getCurrentScoreboard();
        List<BasketballGame> games = restTemplate.getForObject("http://data.nba.net/10s" + currentScoreboard, LiveBasketball.class).getBasketballGames();

        LiveBasketball liveBasketball = new LiveBasketball();
        liveBasketball.setBasketballGames(games);

        liveBasketball.setBasketballGames(basketballService.setBasketballLogo(liveBasketball.getBasketballGames()));
        return liveBasketball;
    }

    @GetMapping("/basketball/{gameDate}/{gameId}")
    public BasketballBoxscore getBasketballGameDetail(@PathVariable String gameDate,
                                                      @PathVariable String gameId) {
        BasicGameData basicGameData = restTemplate.getForObject("http://data.nba.net/prod/v1/"+
                gameDate + "/" + gameId + "_boxscore.json", BasketballBoxscore.class).getBasicGameData();

        BasketballBoxscore basketballBoxscore = new BasketballBoxscore();

        basketballBoxscore.setBasicGameData(basketballService.setBasketballLogoDetailsInfo(basicGameData));
        return basketballBoxscore;
    }

    @GetMapping("/football")
    public

    FootballMatch getFootballLiveResult() {

        return restTemplate.getForObject("https://www.thesportsdb.com/api/v1/json/" + apiFootballKey + "/latestsoccer.php", FootballMatch.class);
    }

    /*
    @GetMapping("football/{gameId}")
    public MatchDetail getFootballDetail(@PathVariable Long gameId) {
        MatchDetail matchDetail = restTemplate.getForObject("https://livescore-api.com/api-client/scores/events.json" +
                "?key=" + apiFootballKey
                + "&secret=" + apiFootballSecret
                + "&id=" + gameId, MatchDetail.class);

        return matchDetail;
    }*/

    @GetMapping("cricket")
    public List<CricketMatch> getCricketGames() {
        return restTemplate.getForObject("https://cricapi.com/api/matches?apikey="
                + apiCricketKey, Cricket.class).getCricketMatches();
    }

    @GetMapping("cricket/{gameId}")
    public CricketDetail getCricketDetail(@PathVariable Long gameId) {
        return restTemplate.getForObject("https://cricapi.com/api/cricketScore"
                +"?apikey="+apiCricketKey
                +"&unique_id="+gameId,CricketDetail.class);
    }
}
