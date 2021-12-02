package mk.ukim.finki.bazi.is_fagus.model.dto;

import lombok.Data;
import mk.ukim.finki.bazi.is_fagus.model.enumerations.Role;

@Data
public class UserDetailsDto {

    private Long id;
    private String name;
    private String surname;
    private String username;
    private Role role;

    public UserDetailsDto(Long id,String name, String surname, String username, Role role) {
        this.id=id;
        this.name = name;
        this.surname = surname;
        this.username = username;
        this.role = role;
    }

    public UserDetailsDto() {
    }
}
