package pl.mczepan.mgrapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pl.mczepan.mgrapp.model.token.MailToken;
import pl.mczepan.mgrapp.model.user.dao.DAOUser;
import pl.mczepan.mgrapp.model.user.dto.UserDTO;
import pl.mczepan.mgrapp.repository.TokenRepo;
import pl.mczepan.mgrapp.repository.UserRepo;
import pl.mczepan.mgrapp.service.mail.MailService;

import javax.mail.MessagingException;
import java.util.ArrayList;
import java.util.UUID;

@Service
public class JwtUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private TokenRepo tokenRepo;

    @Autowired
    private MailService mailService;

    @Autowired
    private PasswordEncoder bcryptEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        DAOUser user = userRepo.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
                new ArrayList<>());
    }

    public DAOUser save(UserDTO user) {
        DAOUser newUser = new DAOUser();
        newUser.setUsername(user.getUsername());
        newUser.setEnable(false);
        newUser.setPassword(bcryptEncoder.encode(user.getPassword()));
        newUser.setEmail(user.getEmail());

        DAOUser appUser = userRepo.save(newUser);
        sendToken(appUser);
        return appUser;
    }

    private void sendToken(DAOUser appUser) {
        String tokenValue = UUID.randomUUID().toString();

        MailToken token = new MailToken();
        token.setValue(tokenValue);
        token.setUser(appUser);
        tokenRepo.save(token);

        String url = "http://localhost:8080/api/login/token?value=" + tokenValue;

        try {
            mailService.sendMail(appUser.getEmail(),"Account Verification",url,false);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }


}