package pl.mczepan.mgrapp.controller;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import pl.mczepan.mgrapp.model.basketball.Basketball;
import pl.mczepan.mgrapp.model.live.basketball.Game;
import pl.mczepan.mgrapp.model.live.basketball.LiveBasketball;
import pl.mczepan.mgrapp.model.live.football.Data;
import pl.mczepan.mgrapp.model.live.football.LiveFootball;
import pl.mczepan.mgrapp.model.live.football.Match;
import pl.mczepan.mgrapp.model.live.football.detail.MatchDetail;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
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

    @GetMapping("/basketball")
    public List<Game> getBasketballLiveResult() {

        String currentScoreboard = restTemplate.getForObject("http://data.nba.net/10s/prod/v1/today.json", Basketball.class).getLinks().getCurrentScoreboard();
        List<Game> games = restTemplate.getForObject("http://data.nba.net/10s" + currentScoreboard, LiveBasketball.class).getGames();

        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date();

        for (Game game : games) {
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

    @GetMapping("/football/{gameId}")
    public MatchDetail getFootballGameDetails(@PathVariable String gameId) {

        InputStreamReader reader = null;
        try {
            URL url = new URL("https://livescore-api.com/api-client/scores/live.json?key=" + apiFootballKey
                    + "&secret=" + apiFootballSecret
                    + "&id=" + gameId);
            reader = new InputStreamReader(url.openStream());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        MatchDetail matchDetail = new Gson().fromJson(reader,MatchDetail.class);
        return matchDetail;
    }
}
