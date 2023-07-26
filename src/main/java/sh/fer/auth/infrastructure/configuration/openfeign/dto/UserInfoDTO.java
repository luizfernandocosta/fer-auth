package sh.fer.auth.infrastructure.configuration.openfeign.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserInfoDTO {

    @JsonProperty("sub")
    private String sub;

    @JsonProperty("name")
    private String name;

    @JsonProperty("given_name")
    private String givenName;

    @JsonProperty("family_name")
    private String familyName;

    @JsonProperty("middle_name")
    private String middleName;

    @JsonProperty("nickname")
    private String nickname;

    @JsonProperty("preferred_username")
    private String preferredUsername;

    @JsonProperty("profile")
    private String profile;

    @JsonProperty("picture")
    private String picture;

    @JsonProperty("website")
    private String website;

    @JsonProperty("email")
    private String email;

    @JsonProperty("email_verified")
    private boolean emailVerified;

    @JsonProperty("gender")
    private String gender;

    @JsonProperty("birthdate")
    private String birthdate;

    @JsonProperty("zoneinfo")
    private String zoneinfo;

    @JsonProperty("locale")
    private String locale;

    @JsonProperty("phone_number")
    private String phoneNumber;

    @JsonProperty("phone_number_verified")
    private boolean phoneNumberVerified;

    @JsonProperty("address")
    private List<String> address;

    @JsonProperty("updated_at")
    private String updatedAt;

}
