package vn.com.devmaster.services.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import vn.com.devmaster.services.domain.Building;
import vn.com.devmaster.services.domain.Khoa;
import vn.com.devmaster.services.repository.BuildingRepository;
import vn.com.devmaster.services.repository.KhoaRepository;
import vn.com.devmaster.services.service.dto.KhoaDTO;
import vn.com.devmaster.services.service.mapper.KhoaMapper;

@Service
@RequiredArgsConstructor
@Transactional
public class KhoaService {
    private final KhoaRepository khoaRepository;
    private final KhoaMapper khoaMapper;
    private final BuildingRepository buildingRepository;

    @Transactional
    public void create(KhoaDTO khoaDTO){
        Khoa khoa = khoaMapper.toEntity(khoaDTO);
        Building building = buildingRepository.findById(khoaDTO.getBuildingId()).orElse(null);
        if (building == null) throw new RuntimeException("Không tìm thấy building");
        khoa.setBuildingId(building);
        khoaRepository.save(khoa);
    }

    @Transactional
    public void update(Long id, KhoaDTO khoaDTO){
        Khoa khoa = khoaMapper.toEntity(khoaDTO);
        khoa.setId(id);
        khoaRepository.save(khoa);
    }

}
