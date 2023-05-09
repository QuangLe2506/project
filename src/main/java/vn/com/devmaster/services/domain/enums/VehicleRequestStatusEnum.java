package vn.com.devmaster.services.domain.enums;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum VehicleRequestStatusEnum {
    APPROVED("Duyệt"),
    REJECT("Từ chối"),
    PENDING("Đang chờ");

    private String name;
}
