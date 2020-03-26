package pl.mczepan.mgrapp.controller.jwt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;


import pl.mczepan.mgrapp.config.JwtTokenUtil;
import pl.mczepan.mgrapp.model.jwt.JwtRequest;
import pl.mczepan.mgrapp.model.jwt.JwtResponse;
import pl.mczepan.mgrapp.model.token.MailToken;
import pl.mczepan.mgrapp.model.user.dao.DAOUser;
import pl.mczepan.mgrapp.model.user.dto.UserDTO;
import pl.mczepan.mgrapp.repository.TokenRepo;
import pl.mczepan.mgrapp.repository.UserRepo;
import pl.mczepan.mgrapp.service.JwtUserDetailsService;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping(value = "/api/login")
public class JwtAuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private JwtUserDetailsService userDetailsService;

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private TokenRepo tokenRepo;

    @RequestMapping(value = "/authenticate", method = RequestMethod.POST)
    public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) throws Exception {

        authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());

        final UserDetails userDetails = userDetailsService
                .loadUserByUsername(authenticationRequest.getUsername());

        final String token = jwtTokenUtil.generateToken(userDetails);

        return ResponseEntity.ok(new JwtResponse(token));
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ResponseEntity<UserDTO> saveUser(@RequestBody UserDTO user) throws Exception {
        DAOUser daoUser = userDetailsService.save(user);
        UserDTO userDTO = new UserDTO();
        userDTO.setEmail(daoUser.getEmail());
        userDTO.setPassword(daoUser.getPassword());
        userDTO.setUsername(daoUser.getUsername());
        userDTO.setEnabled(daoUser.isEnabled());
        return ResponseEntity.ok(userDTO);
    }


    @RequestMapping(value = "/token", method = RequestMethod.GET)
    public String tokenVerification(@RequestParam String value) {
       MailToken byValue = tokenRepo.findByValue(value);

       DAOUser user = byValue.getUser();
       user.setEnabled(true);

        userRepo.save(user);
        return "authenticate";
    }

    private void authenticate(String username, String password) throws Exception {
        try {
            if(!userRepo.findByUsername(username).isEnabled()) {
                throw new DisabledException("USER_DISABLED");
            }
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (DisabledException e) {
            throw new Exception("USER_DISABLED", e);
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }
    }

}