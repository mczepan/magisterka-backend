package pl.mczepan.mgrapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.mczepan.mgrapp.model.search.team.Team;
import pl.mczepan.mgrapp.model.user.FavouriteTeam.FavTeam;
import pl.mczepan.mgrapp.service.UserService;

import java.security.Principal;
import java.util.List;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping(value = "/api/user")
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "teams", method = RequestMethod.GET)
    public List<Team> getFavTeams(Principal principal) {
        return userService.getFavTeams(principal);
    }

    @RequestMapping(value = "team/{teamId}", method = RequestMethod.DELETE)
    public List<Team> deleteTeam(@PathVariable String teamId, Principal principal) {
        return userService.deleteFavTeam(teamId, principal);
    }

    @RequestMapping(value = "team/{teamId}", method = RequestMethod.POST)
    public List<Team> addTeam(@PathVariable String teamId, Principal principal) {
        userService.addTeam(teamId, principal);
        return userService.getFavTeams(principal);
    }

    @RequestMapping(value = "team/{teamId}", method = RequestMethod.GET)
    public FavTeam getTeam(@PathVariable String teamId) {
        return userService.getTeam(teamId);
    }


}
