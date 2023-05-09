package vn.com.devmaster.services.service.mapper;

import org.springframework.stereotype.Component;
import vn.com.devmaster.services.domain.Vehicle;
import vn.com.devmaster.services.service.dto.VehicleDTO;

import java.util.Collection;
import java.util.stream.Collectors;

@Component
public class VehicleMapper implements EntityMapper<VehicleDTO, Vehicle> {

    @Override
    public VehicleDTO toDto(Vehicle entity) {
        VehicleDTO dto = new VehicleDTO();
        dto.setAccount(entity.getAccount());
        dto.setNameAccount(entity.getNameAccount());
        dto.setLicensePlate(entity.getLicensePlate());
        dto.setAutomaker(entity.getAutomaker());
        dto.setColor(entity.getColor());
        dto.setTicket(entity.getTicket());
        return dto;
    }

    @Override
    public Vehicle toEntity(VehicleDTO dto) {
        Vehicle entity = new Vehicle();
        entity.setAccount(dto.getAccount());
        entity.setNameAccount(dto.getNameAccount());
        entity.setLicensePlate(dto.getLicensePlate());
        entity.setAutomaker(dto.getAutomaker());
        entity.setColor(dto.getColor());
        entity.setTicket(dto.getTicket());
        return entity;
    }

    @Override
    public Collection<VehicleDTO> toDto(Collection<Vehicle> entity) {
        return entity.stream().map(this::toDto).collect(Collectors.toList());
    }

    @Override
    public Collection<Vehicle> toEntity(Collection<VehicleDTO> dto) {
        return null;
    }
}
