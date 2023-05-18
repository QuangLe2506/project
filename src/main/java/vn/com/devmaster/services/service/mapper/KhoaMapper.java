package vn.com.devmaster.services.service.mapper;

import org.springframework.stereotype.Component;
import vn.com.devmaster.services.domain.Khoa;
import vn.com.devmaster.services.service.dto.KhoaDTO;

import java.util.Collection;
import java.util.stream.Collectors;
@Component
public class KhoaMapper implements EntityMapper<KhoaDTO, Khoa> {
    @Override
    public KhoaDTO toDto(Khoa entity) {
        KhoaDTO dto = new KhoaDTO();
        dto.setTenKhoa(entity.getTenKhoa());
        dto.setMaKhoa(entity.getMaKhoa());
        return dto;
    }

    @Override
    public Khoa toEntity(KhoaDTO dto) {
        Khoa entity = new Khoa();
        entity.setTenKhoa(dto.getTenKhoa());
        entity.setMaKhoa(dto.getMaKhoa());
        return entity;
    }

    @Override
    public Collection<KhoaDTO> toDto(Collection<Khoa> entity) {
        return entity.stream().map(this::toDto).collect(Collectors.toList());
    }

    @Override
    public Collection<Khoa> toEntity(Collection<KhoaDTO> dto) {
        return null;
    }
}
