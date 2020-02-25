package pl.mczepan.mgrapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import pl.mczepan.mgrapp.model.Sport;
import pl.mczepan.mgrapp.model.SportType;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/api/sport")
public class SportController {

    @Autowired
    RestTemplate restTemplate;

    @GetMapping()
    public List<Sport> getSportTypes() {

        SportType sport = restTemplate.getForObject("https://www.thesportsdb.com/api/v1/json/1/all_sports.php", SportType.class);

        return sport.getSports()
                .parallelStream()
                .collect(Collectors.toList());
    }
}
