package sh.fer.auth.infrastructure.configuration.openfeign;

import feign.Headers;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import sh.fer.auth.infrastructure.configuration.openfeign.dto.ResourceOwnerDTO;
import sh.fer.auth.infrastructure.configuration.openfeign.dto.TokenDTO;
import sh.fer.auth.infrastructure.configuration.openfeign.dto.UserInfoDTO;

@FeignClient(value = "auth0client", url = "${auth0.url}")
public interface Auth0Client {

    @GetMapping(value = "/userinfo",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    UserInfoDTO getUserInfo(@RequestHeader("Authorization") String token);

    @PostMapping(value = "/oauth/token", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @Headers("Content-Type: application/json")
    TokenDTO getToken(@RequestBody ResourceOwnerDTO params);

}
