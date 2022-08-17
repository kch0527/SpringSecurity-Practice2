package security.example.springsecuritypractice2.service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import security.example.springsecuritypractice2.config.JwtConfig;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class JwtService {

    public String issue(String username, String password, List<String> roles){
        byte[] signingKey = JwtConfig.JWT_SECRET.getBytes();

        String token = Jwts.builder()
                .signWith(Keys.hmacShaKeyFor(signingKey), SignatureAlgorithm.HS512)
                .setHeaderParam("typ", JwtConfig.TOKEN_TYPE)
                .setIssuer(JwtConfig.TOKEN_ISSUER)
                .setAudience(JwtConfig.TOKEN_AUDIENCE)
                .setSubject(username)
                .setExpiration(new Date(System.currentTimeMillis() + 864000000))
                .claim("rol", roles)
                .compact();

        return token;
    }
}
