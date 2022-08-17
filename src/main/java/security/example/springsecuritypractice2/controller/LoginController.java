package security.example.springsecuritypractice2.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import security.example.springsecuritypractice2.domain.AuthenticationRequest;

@RestController
@Slf4j
public class LoginController {

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody AuthenticationRequest authenticationRequest){

        String username = authenticationRequest.getUsername();
        String password = authenticationRequest.getPassword();

        log.info("username =" + username + "password =" + password);

        String token = username + "_ROLE_USER";
        log.info("token: " + token);

        return new ResponseEntity<>(token, HttpStatus.OK);
    }
}
