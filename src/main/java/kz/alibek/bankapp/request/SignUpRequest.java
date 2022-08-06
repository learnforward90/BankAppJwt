package kz.alibek.bankapp.request;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.Set;

@Data
public class SignUpRequest {
    @NotBlank @Email
    private String email;
    @NotBlank
    private String password;
    private Set<String> roles;
}
