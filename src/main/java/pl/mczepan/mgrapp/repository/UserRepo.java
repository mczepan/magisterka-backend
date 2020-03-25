package pl.mczepan.mgrapp.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.mczepan.mgrapp.model.user.dao.DAOUser;

@Repository
public interface UserRepo extends CrudRepository<DAOUser, Integer> {
    DAOUser findByUsername(String username);

    DAOUser findByEmail(String email);
}