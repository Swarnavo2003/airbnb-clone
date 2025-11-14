package in.swarnavo.airbnb.dto;

import in.swarnavo.airbnb.entity.User;
import in.swarnavo.airbnb.entity.enums.Gender;
import lombok.Data;

@Data
public class GuestDto {
    private Long id;
    private User user;
    private String name;
    private Gender gender;
    private Integer age;
}
