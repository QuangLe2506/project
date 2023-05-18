package vn.com.devmaster.services.service.dto;

import lombok.Data;
import vn.com.devmaster.services.domain.Khoa;



@Data
public class StudentDTO {
    private String code;
    private String firstName;
    private String lastName;
    private String date;
    private String address;
    private String gender;
    private Long khoaId;
    private Long buildingId;
}
