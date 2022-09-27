package security.example.springsecuritypractice2.controller;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import security.example.springsecuritypractice2.config.JwtConfig;
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

    @GetMapping("/profiles")
    public ResponseEntity<String> getProfiles(@RequestHeader(name = "Authorization") String header) {

        String token = header.substring(7);
        byte[] signingKey = JwtConfig.JWT_SECRET.getBytes();

        Jws<Claims> parsedToken = Jwts.parserBuilder()
                .setSigningKey(signingKey)
                .build()
                .parseClaimsJws(token);

        return new ResponseEntity<String>(parsedToken.toString(), HttpStatus.OK);
    }
}
