package sh.fer.auth.application.rest;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.*;
import sh.fer.auth.application.rest.dto.TokenRequestDTO;
import sh.fer.auth.application.rest.dto.TokenResponseDTO;
import sh.fer.auth.application.rest.dto.UserInfoResponseDTO;
import sh.fer.auth.infrastructure.configuration.openfeign.dto.ResourceOwnerDTO;
import sh.fer.auth.infrastructure.configuration.openfeign.Auth0Client;

@RestController
@RequestMapping(path = "api", produces = MediaType.APPLICATION_JSON_VALUE)
@CrossOrigin(origins = "*")
public class AuthController implements AuthAPI {

    @Autowired
    Auth0Client auth0Client;

    @GetMapping("/auth")
    public String getPrincipalInfo() {

        var token = getToken();

//        Collection<String> authorities = principal.getAuthorities()
//                .stream()
//                .map(GrantedAuthority::getAuthority)
//                .collect(Collectors.toList());
//
//        Map<String,Object> info = new HashMap<>();
//        info.put("name", principal.getName());
//        info.put("authorities", authorities);
//        info.put("tokenAttributes", principal.getTokenAttributes());
//        info.put("permissions", principal.getTokenAttributes().get("permissions"));

        return token;
    }

    @Override
    public ResponseEntity<TokenResponseDTO> getTokenFromAuth0(TokenRequestDTO tokenRequest) {

        ModelMapper modelMapper = new ModelMapper();

        var token = this.auth0Client.getToken(modelMapper.map(tokenRequest, ResourceOwnerDTO.class));

        return ResponseEntity.ok(modelMapper.map(token, TokenResponseDTO.class));
    }

    @Override
    public ResponseEntity<UserInfoResponseDTO> getUserInfo(String token) {

        ModelMapper modelMapper = new ModelMapper();

        var userInfo = this.auth0Client.getUserInfo("Bearer " + token);

        return ResponseEntity.ok(modelMapper.map(userInfo, UserInfoResponseDTO.class));

    }

    public static String getToken() {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        Jwt jwt = (Jwt) authentication.getCredentials();

        return jwt.getTokenValue();

    }

}
