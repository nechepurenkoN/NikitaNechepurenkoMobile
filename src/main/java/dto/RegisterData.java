package dto;

import lombok.Value;

@Value
public class RegisterData {
    String email;
    String username;
    String password;
    String passwordConfirmed;
    Boolean isAgreed;
}
