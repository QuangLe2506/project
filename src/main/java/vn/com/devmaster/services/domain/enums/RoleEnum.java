package vn.com.devmaster.services.domain.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum RoleEnum {
    ADMIN("admin hệ thống"),
    PROTECTOR("Quản lý bãi xe theo trường"),
    STUDENT("Lớp trưởng các lớp");

    private final String name;
}
