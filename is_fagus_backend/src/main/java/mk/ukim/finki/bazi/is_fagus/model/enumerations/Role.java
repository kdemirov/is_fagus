package mk.ukim.finki.bazi.is_fagus.model.enumerations;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {
    ROLE_USER,ROLE_DIRECTOR,ROLE_MANAGER,ROLE_CHIEF,ROLE_WAREHOUSEMAN,
    ROLE_CLIENT;

    @Override
    public String getAuthority() {
        return name();
    }
}
