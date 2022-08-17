package security.example.springsecuritypractice2.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class AuthenticationRequest {

    private String username;
    private String password;
}
