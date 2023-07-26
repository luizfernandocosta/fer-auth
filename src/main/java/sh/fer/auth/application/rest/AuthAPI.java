package sh.fer.auth.application.rest;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import sh.fer.auth.application.rest.dto.TokenRequestDTO;
import sh.fer.auth.application.rest.dto.TokenResponseDTO;
import sh.fer.auth.application.rest.dto.UserInfoResponseDTO;

public interface AuthAPI {

    @PostMapping(value = "/token", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<TokenResponseDTO> getTokenFromAuth0(@RequestBody TokenRequestDTO tokenRequest);

    @GetMapping(value = "/userinfo", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<UserInfoResponseDTO> getUserInfo(@RequestHeader("Authorization") String token);

}
