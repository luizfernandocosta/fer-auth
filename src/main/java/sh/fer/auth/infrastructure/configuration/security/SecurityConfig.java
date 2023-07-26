package sh.fer.auth.infrastructure.configuration.security;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationConverter;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Value("${auth0.audience}")
    private String audience;

    @Value("${spring.security.oauth2.resourceserver.jwt.issuer-uri}")
    private String issuer;

    @Bean
    public JwtAuthenticationConverter permissionsAuthenticationConverter() {
        JwtAuthenticationConverter converter = new JwtAuthenticationConverter();
        converter.setJwtGrantedAuthoritiesConverter(new CombineJwtAuthenticationConverter());
        return converter;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http
            .csrf(csrf -> csrf.disable())
            .authorizeHttpRequests(
                    auth -> auth.requestMatchers("/api/token").permitAll()
                                .requestMatchers("/api/userinfo").hasAuthority("PERMISSION_read:event")
            )
            .cors((cors) -> cors.disable())
            .oauth2ResourceServer(oauth2 -> oauth2.jwt(jwt -> {
//                jwt.decoder(jwtDecoder());
            }));

        return http.build();
    }

//    @Bean
//    JwtDecoder jwtDecoder() {
//
//        NimbusJwtDecoder jwtDecoder = (NimbusJwtDecoder) JwtDecoders.fromOidcIssuerLocation(issuer);
//
//        OAuth2TokenValidator<Jwt> audienceValidator = new AudienceValidator(audience);
//        OAuth2TokenValidator<Jwt> withIssuer = JwtValidators.createDefaultWithIssuer(issuer);
//        OAuth2TokenValidator<Jwt> withAudience = new DelegatingOAuth2TokenValidator<>(withIssuer, audienceValidator);
//
//        jwtDecoder.setJwtValidator(withAudience);
//
//        return jwtDecoder;
//    }


}
