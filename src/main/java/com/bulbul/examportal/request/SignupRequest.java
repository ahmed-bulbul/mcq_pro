package com.bulbul.examportal.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SignupRequest {

    @NotBlank(message = "username not be blank")
    private String username;

    @NotBlank
    @Email
    private String email;

    private Set<String> role;

    @Size(message = "password size must be 5 to 14", min = 4,max = 14)
    @NotBlank
    private String password;

}
