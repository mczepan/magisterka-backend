package pl.mczepan.mgrapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import pl.mczepan.mgrapp.model.user.dao.DAOTeam;
import pl.mczepan.mgrapp.model.user.dao.DAOUser;

import javax.transaction.Transactional;
import java.util.List;

public interface TeamRepo extends JpaRepository<DAOTeam, Long> {
    @Modifying
    @Transactional
    @Query("delete from DAOTeam u where u.teamId = ?1 and u.user = ?2")
    void deleteByTeamId(String teamId, DAOUser user);
}
