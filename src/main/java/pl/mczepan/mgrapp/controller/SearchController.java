package pl.mczepan.mgrapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import pl.mczepan.mgrapp.model.search.player.SearchPlayerList;
import pl.mczepan.mgrapp.model.search.team.SearchTeamList;


@RestController
@RequestMapping(value = "/api/search")
public class SearchController {

    @Autowired
    RestTemplate restTemplate;

    @CrossOrigin("http://localhost:4200")
    @GetMapping("/team/{teamName}")
    public SearchTeamList getTeamByName(@PathVariable String teamName) {
        return restTemplate.getForObject("https://www.thesportsdb.com/api/v1/json/1/searchteams.php?" +
                "t=" + teamName, SearchTeamList.class);
    }

    @CrossOrigin("http://localhost:4200")
    @GetMapping("/player/{player}")
    public SearchPlayerList getPlayerByName(@PathVariable String player) {
        return restTemplate.getForObject("https://www.thesportsdb.com/api/v1/json/1/searchplayers.php?" +
                        "p=" + player,SearchPlayerList.class);
    }
}
