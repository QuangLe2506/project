package vn.com.devmaster.services.service.dto;

import lombok.Data;
import vn.com.devmaster.services.domain.VehicleRequest;
import vn.com.devmaster.services.domain.VehicleType;
@Data
public class VehicleDTO {
    private Long id;
    private String account;
    private String nameAccount;
    private String licensePlate;
    private String automaker;
    private String color;
    private String ticket;
    private Boolean status;
    private String updatedReason;
    private VehicleType vehicleType;
    private Long buildingId;
    private VehicleRequest vehicleRequest;
}
