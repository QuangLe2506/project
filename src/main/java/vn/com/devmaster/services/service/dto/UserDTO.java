package vn.com.devmaster.services.service.dto;

import lombok.Data;
import vn.com.devmaster.services.domain.enums.RoleEnum;

@Data
public class UserDTO {
    String fullName;
    String account;
    String email;
    RoleEnum role;
    Long buildingId;
}
