package security.example.springsecuritypractice2.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import security.example.springsecuritypractice2.domain.AuthenticationRequest;
import security.example.springsecuritypractice2.service.JwtService;
import security.example.springsecuritypractice2.service.RoleService;

import java.util.ArrayList;
import java.util.List;

@RestController
@Slf4j
@RequiredArgsConstructor
public class LoginController {

    private final JwtService jwtService;
    private final RoleService roleService;

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody AuthenticationRequest authenticationRequest){

        String username = authenticationRequest.getUsername();
        String password = authenticationRequest.getPassword();

        log.info("username =" + username + "password =" + password);

        List<String> roles = roleService.addRoleType();

        String token = jwtService.issue(username, password, roles);
        log.info("token: " + token);

        return new ResponseEntity<>(token, HttpStatus.OK);
    }
}
