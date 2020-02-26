package pl.mczepan.mgrapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import pl.mczepan.mgrapp.model.basketball.Basketball;
import pl.mczepan.mgrapp.model.live.basketball.BasketballGame;
import pl.mczepan.mgrapp.model.live.basketball.LiveBasketball;
import pl.mczepan.mgrapp.model.live.cricket.Cricket;
import pl.mczepan.mgrapp.model.live.cricket.CricketMatch;
import pl.mczepan.mgrapp.model.live.cricket.detail.CricketDetail;
import pl.mczepan.mgrapp.model.live.football.Data;
import pl.mczepan.mgrapp.model.live.football.LiveFootball;
import pl.mczepan.mgrapp.model.live.football.Match;
import pl.mczepan.mgrapp.model.live.football.detail.MatchDetail;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(value = "/api/live")
public class LiveController {

    @Autowired
    RestTemplate restTemplate;

    @Value("${api.football.key}")
    private String apiFootballKey;

    @Value("${api.football.secret}")
    private String apiFootballSecret;

    @Value("${api.cricket.key}")
    private String apiCricketKey;

    @GetMapping("/basketball")
    public List<BasketballGame> getBasketballLiveResult() {

        String currentScoreboard = restTemplate.getForObject("http://data.nba.net/10s/prod/v1/today.json", Basketball.class).getLinks().getCurrentScoreboard();
        List<BasketballGame> games = restTemplate.getForObject("http://data.nba.net/10s" + currentScoreboard, LiveBasketball.class).getBasketballGames();

        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date();

        for (BasketballGame game : games) {
            game.setDate(formatter.format(date));
        }
        return games;
    }

    @GetMapping("/football")
    public List<Match> getFootballLiveResult() {

        Data data = restTemplate.getForObject("https://livescore-api.com/api-client/scores/live.json?key=" + apiFootballKey
                + "&secret=" + apiFootballSecret, LiveFootball.class).getData();

        return data.getMatch();
    }

    @GetMapping("football/{gameId}")
    public MatchDetail getFootballDetail(@PathVariable Long gameId) {
        MatchDetail matchDetail = restTemplate.getForObject("https://livescore-api.com/api-client/scores/events.json" +
                "?key=" + apiFootballKey
                + "&secret=" + apiFootballSecret
                + "&id=" + gameId, MatchDetail.class);

        return matchDetail;
    }

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
