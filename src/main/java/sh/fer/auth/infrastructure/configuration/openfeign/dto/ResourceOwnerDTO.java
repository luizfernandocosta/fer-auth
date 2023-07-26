package sh.fer.auth.infrastructure.configuration.openfeign.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResourceOwnerDTO {

    @JsonProperty(value = "grant_type", required = true)
    private String grantType;

    @JsonProperty(value = "client_id", required = true)
    private String clientId;

    @JsonProperty(value = "client_secret", required = true)
    private String clientSecret;

    @JsonProperty("audience")
    private String audience;

    @JsonProperty(value = "username", required = true)
    private String username;

    @JsonProperty(value = "password", required = true)
    private String password;

    @JsonProperty(value = "scope", defaultValue = "offline_access")
    private String scope;

    @JsonProperty("realm")
    private String realm;

}
