package vn.com.devmaster.services.service.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class BuildingDTO {
    private Long id;

    @NotBlank(message = "Code không thể để trống")
    private String code;

    private String name;

    private String address;

    private Double area;

    private Boolean status;

    private String location;
}
