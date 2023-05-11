package vn.com.devmaster.services.service.mapper;

import org.springframework.stereotype.Component;
import vn.com.devmaster.services.domain.VehicleHistory;
import vn.com.devmaster.services.service.dto.VehicleHistoryDTO;

import java.util.Collection;
import java.util.stream.Collectors;
@Component
public class VehicleHistoryMapper implements EntityMapper<VehicleHistoryDTO, VehicleHistory> {
    @Override
    public VehicleHistoryDTO toDto(VehicleHistory entity) {
        VehicleHistoryDTO dto = new VehicleHistoryDTO();
        dto.setAccount(entity.getAccount());
        dto.setNameAccount(entity.getNameAccount());
        dto.setLicensePlate(entity.getLicensePlate());
        dto.setAutomaker(entity.getAutomaker());
        dto.setColor(entity.getColor());
        dto.setTicket(entity.getTicket());
        return dto;
    }

    @Override
    public VehicleHistory toEntity(VehicleHistoryDTO dto) {
        VehicleHistory entity = new VehicleHistory();
        entity.setAccount(dto.getAccount());
        entity.setNameAccount(dto.getNameAccount());
        entity.setLicensePlate(dto.getLicensePlate());
        entity.setAutomaker(dto.getAutomaker());
        entity.setColor(dto.getColor());
        entity.setTicket(dto.getTicket());
        return entity;
    }

    @Override
    public Collection<VehicleHistoryDTO> toDto(Collection<VehicleHistory> entity) {
        return entity.stream().map(this::toDto).collect(Collectors.toList());
    }

    @Override
    public Collection<VehicleHistory> toEntity(Collection<VehicleHistoryDTO> dto) {
        return null;
    }
}
