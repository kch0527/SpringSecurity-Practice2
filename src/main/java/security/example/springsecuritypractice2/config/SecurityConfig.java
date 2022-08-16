package security.example.springsecuritypractice2.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
public class SecurityConfig{

    @Bean
    protected SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        //폼 로그인 기능, 베이직 인증 비활성화
        http.formLogin().disable()
                .httpBasic().disable();

        //csrf 방지 지원 기능 비활성화, rest api를 사용할 거기 때문
        http.csrf().disable();

        //세션 생성 정책 설정
        http.sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        return http.build();
    }
}
