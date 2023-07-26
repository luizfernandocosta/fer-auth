package sh.fer.auth.infrastructure.configuration.security;

import org.springframework.core.convert.converter.Converter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.server.resource.authentication.JwtGrantedAuthoritiesConverter;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class CombineJwtAuthenticationConverter implements Converter<Jwt, Collection<GrantedAuthority>> {

    private final JwtGrantedAuthoritiesConverter permissionConverter;
    private final JwtGrantedAuthoritiesConverter scopeConverter;

    public CombineJwtAuthenticationConverter() {
        this.permissionConverter = new JwtGrantedAuthoritiesConverter();
        this.permissionConverter.setAuthorityPrefix("PERMISSION_");
        this.permissionConverter.setAuthoritiesClaimName("permissions");

        this.scopeConverter = new JwtGrantedAuthoritiesConverter();
        this.scopeConverter.setAuthorityPrefix("SCOPE_");
        this.scopeConverter.setAuthoritiesClaimName("scope");
    }

    @Override
    public Collection<GrantedAuthority> convert(Jwt jwt) {
        List<GrantedAuthority> authorities = this.permissionConverter.convert(jwt).stream()
                .collect(Collectors.toList());
        authorities.addAll(this.scopeConverter.convert(jwt));
        return authorities;
    }

}


