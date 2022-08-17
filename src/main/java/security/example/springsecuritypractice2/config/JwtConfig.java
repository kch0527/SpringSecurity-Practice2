package security.example.springsecuritypractice2.config;

public class JwtConfig {

    public static final String JWT_SECRET = "secretKey";

    public static final String TOKEN_HEADER = "Authorization";
    public static final String TOKEN_PREFIX = "Bearer";
    public static final String TOKEN_TYPE = "JWT"; //토큰 타입
    public static final String TOKEN_ISSUER = "chan"; //토큰발급자
    public static final String TOKEN_AUDIENCE = "chan";
}
