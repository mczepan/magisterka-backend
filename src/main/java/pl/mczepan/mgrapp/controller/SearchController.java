package pl.mczepan.mgrapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import pl.mczepan.mgrapp.model.search.player.Player;
import pl.mczepan.mgrapp.model.search.player.SearchPlayerList;
import pl.mczepan.mgrapp.model.search.team.SearchTeamList;
import pl.mczepan.mgrapp.model.search.team.Team;

import java.util.List;

@RestController
@RequestMapping(value = "/api/search")
public class SearchController {

    @Autowired
    RestTemplate restTemplate;

    @GetMapping("/team/{teamName}")
    public List<Team> getTeamByName(@PathVariable String teamName) {
        return restTemplate.getForObject("https://www.thesportsdb.com/api/v1/json/1/searchteams.php?" +
                "t=" + teamName, SearchTeamList.class).getTeams();
    }

    @GetMapping("/player/{player}")
    public List<Player> getPlayerByName(@PathVariable String player) {
        return restTemplate.getForObject("https://www.thesportsdb.com/api/v1/json/1/searchplayers.php?" +
                        "p=" + player,SearchPlayerList.class).getPlayer();
    }
}
