package vn.com.devmaster.services.service.dto;

import lombok.Data;


@Data
public class VehicleHistoryDTO {
    private Long vehicleId;
    private String account;
    private String nameAccount;
    private Long vehicleTypeId;
    private String licensePlate;
    private String automaker;
    private String color;
    private String ticket;
    private Integer status;
    private Long buildingId;
    private String updatedReason;
}
