package pl.mczepan.mgrapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import pl.mczepan.mgrapp.model.Sport;
import pl.mczepan.mgrapp.model.SportType;
import pl.mczepan.mgrapp.model.league.League;
import pl.mczepan.mgrapp.model.league.LeagueList;
import pl.mczepan.mgrapp.model.league.country.CountryLeague;
import pl.mczepan.mgrapp.model.league.country.CountryLeagueList;
import pl.mczepan.mgrapp.model.league.table.Table;
import pl.mczepan.mgrapp.model.league.table.TableLeagueList;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping(value = "/api/sport")
public class SportController {

    @Autowired
    RestTemplate restTemplate;

    @GetMapping("/types")
    public SportType getAllSports() {
        SportType sport = restTemplate.getForObject("https://www.thesportsdb.com/api/v1/json/1/all_sports.php", SportType.class);

        List<Sport> sportTypes = sport.getSports()
                                    .parallelStream()
                                    .collect(Collectors.toList());

        for(Sport tmpSport: sportTypes) {
            if(tmpSport.getStrSport().equals("Cricket") ||
               tmpSport.getStrSport().equals("Soccer") ||
               tmpSport.getStrSport().equals("Basketball")) {
                tmpSport.setProvideLiveResult(true);
            } else {
                tmpSport.setProvideLiveResult(false);
            }
        }

        sport.setSports(sportTypes);
        return sport;
    }

    @GetMapping("/types/{sportType}")
    public Sport getSportType(@PathVariable String sportType){
        SportType sport = restTemplate.getForObject("https://www.thesportsdb.com/api/v1/json/1/all_sports.php", SportType.class);

        List<Sport> sportTypes = sport.getSports()
                .parallelStream()
                .collect(Collectors.toList());

        for(Sport tmpSport: sportTypes) {
            if(tmpSport.getStrSport().equals("Cricket") ||
                    tmpSport.getStrSport().equals("Soccer") ||
                    tmpSport.getStrSport().equals("Basketball")) {
                tmpSport.setProvideLiveResult(true);
            } else {
                tmpSport.setProvideLiveResult(false);
            }
        }

        sport.setSports(sportTypes);

        Sport tmpSport =  sport.getSports()
                            .stream()
                            .filter(type -> type.getStrSport().equals(sportType))
                            .findFirst()
                            .get();
        return tmpSport;
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
