package pl.mczepan.mgrapp.service;

import org.springframework.stereotype.Service;
import pl.mczepan.mgrapp.model.live.basketball.BasketballGame;
import pl.mczepan.mgrapp.model.live.basketball.boxscore.BasicGameData;
import pl.mczepan.mgrapp.model.live.basketball.boxscore.HTeamScore;

import java.util.List;

@Service
public class BasketballService {

    private String baseNBALogoPath = "assets/logo/basketball/";

    public List<BasketballGame> setBasketballLogo(List<BasketballGame> basketballList) {

        for (BasketballGame tmpBasketballGame : basketballList) {
            tmpBasketballGame.getHTeam().setLogo(baseNBALogoPath + tmpBasketballGame.getHTeam().getTriCode()+".png");
            tmpBasketballGame.getVTeam().setLogo(baseNBALogoPath + tmpBasketballGame.getVTeam().getTriCode()+".png");
        }

        return basketballList;
    }


    public BasicGameData setBasketballLogoDetailsInfo(BasicGameData basicGameData) {
        basicGameData.getHTeamScore().setLogoPath(baseNBALogoPath + basicGameData.getHTeamScore().getTriCode()+".png");
        basicGameData.getVTeamScore().setLogoPath(baseNBALogoPath + basicGameData.getVTeamScore().getTriCode()+".png");

        return basicGameData;
    }
}
