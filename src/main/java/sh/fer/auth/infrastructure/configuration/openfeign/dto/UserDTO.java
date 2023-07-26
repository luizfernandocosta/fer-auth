package sh.fer.auth.infrastructure.configuration.openfeign.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {

    @JsonProperty("email")
    private String email;

    @JsonProperty("phone_number")
    private String phoneNumber;

    @JsonProperty("user_metadata")
    private Map<String, Object> userMetadata;

    @JsonProperty("blocked")
    private boolean blocked;

    @JsonProperty("email_verified")
    private boolean emailVerified;

    @JsonProperty("phone_verified")
    private boolean phoneVerified;

    @JsonProperty("app_metadata")
    private Map<String, Object> appMetadata;

    @JsonProperty("given_name")
    private String givenName;

    @JsonProperty("family_name")
    private String familyName;

    @JsonProperty("name")
    private String name;

    @JsonProperty("nickname")
    private String nickname;

    @JsonProperty("picture")
    private String picture;

    @JsonProperty("user_id")
    private String userId;

    @JsonProperty("connection")
    private String connection;

    @JsonProperty("password")
    private String password;

    @JsonProperty("verify_email")
    private boolean verifyEmail;

    @JsonProperty("username")
    private String username;

}
