package pl.mczepan.mgrapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import pl.mczepan.mgrapp.model.Sport;
import pl.mczepan.mgrapp.model.SportType;
import pl.mczepan.mgrapp.model.league.League;
import pl.mczepan.mgrapp.model.league.LeagueList;
import pl.mczepan.mgrapp.model.league.country.CountryLeague;
import pl.mczepan.mgrapp.model.league.country.CountryLeagueList;
import pl.mczepan.mgrapp.model.league.table.Table;
import pl.mczepan.mgrapp.model.league.table.TableLeagueList;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/api/sport")
public class SportController {

    @Autowired
    RestTemplate restTemplate;

    @GetMapping("/types")
    public List<Sport> getAllSports() {
        SportType sport = restTemplate.getForObject("https://www.thesportsdb.com/api/v1/json/1/all_sports.php", SportType.class);

        return sport.getSports()
                .parallelStream()
                .collect(Collectors.toList());
    }

    @GetMapping("/leagues")
    public List<League> getAllLeagues() {
        return restTemplate.getForObject("https://www.thesportsdb.com/api/v1/json/1/all_leagues.php", LeagueList.class).getLeagues();
    }

    @GetMapping("/leagues/{country}")
    public List<CountryLeague> getAllCountryLeagues(@PathVariable String country) {
        return restTemplate.getForObject("https://www.thesportsdb.com/api/v1/json/1/search_all_leagues.php?c="
        +country, CountryLeagueList.class).getCountryLeagues();
    }

    @GetMapping("/league/table/{leagueTableId}")
    public List<Table> getLeagueTable(@PathVariable Long leagueTableId) {
        return restTemplate.getForObject("https://www.thesportsdb.com/api/v1/json/1/lookuptable.php?" +
                "l=" + leagueTableId
                +"&s=1920", TableLeagueList.class).getTable();
    }
}
