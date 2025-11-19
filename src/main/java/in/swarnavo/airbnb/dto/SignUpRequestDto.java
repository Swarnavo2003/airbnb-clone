package in.swarnavo.airbnb.dto;

import in.swarnavo.airbnb.entity.enums.Role;
import lombok.Data;

@Data
public class SignUpRequestDto {
    private Long id;
    private String email;
    private String password;
    private String name;
    private Role role;
}
