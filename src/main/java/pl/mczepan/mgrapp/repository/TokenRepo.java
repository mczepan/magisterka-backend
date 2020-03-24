package pl.mczepan.mgrapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.mczepan.mgrapp.model.token.MailToken;

public interface TokenRepo extends JpaRepository<MailToken, Long> {

    MailToken findByValue(String value);


}
