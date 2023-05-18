package vn.com.devmaster.services.service.dto;

import lombok.Data;
import vn.com.devmaster.services.domain.Building;


@Data
public class KhoaDTO {
    private String tenKhoa;
    private String maKhoa;
    private Long buildingId;
}
