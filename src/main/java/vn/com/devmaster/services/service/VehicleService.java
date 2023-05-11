package vn.com.devmaster.services.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import vn.com.devmaster.services.domain.Building;
import vn.com.devmaster.services.domain.User;
import vn.com.devmaster.services.domain.Vehicle;
import vn.com.devmaster.services.domain.VehicleHistory;
import vn.com.devmaster.services.repository.BuildingRepository;
import vn.com.devmaster.services.repository.UserRepository;
import vn.com.devmaster.services.repository.VehicleHistoryRepository;
import vn.com.devmaster.services.repository.VehicleRepository;
import vn.com.devmaster.services.service.dto.VehicleDTO;
import vn.com.devmaster.services.service.dto.VehicleHistoryDTO;
import vn.com.devmaster.services.service.mapper.VehicleHistoryMapper;
import vn.com.devmaster.services.service.mapper.VehicleMapper;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class VehicleService {
    private final UserRepository userRepository;
    private final VehicleRepository vehicleRepository;
    private final VehicleMapper vehicleMapper;
    private final VehicleHistoryMapper vehicleHistoryMapper;
    private final VehicleHistoryRepository vehicleHistoryRepository;
    private final BuildingRepository buildingRepository;

    @Transactional
    public void create(VehicleDTO vehicleDTO, VehicleHistoryDTO vehicleHistoryDTO){
        Vehicle vehicle = vehicleMapper.toEntity(vehicleDTO);
        VehicleHistory vehicleHistory = vehicleHistoryMapper.toEntity(vehicleHistoryDTO);
        Building building = buildingRepository.findById(vehicleDTO.getBuildingId()).orElse(null);
        if (building == null) throw new RuntimeException("Không tìm thấy building");
        vehicle.setBuildingId(building);
        vehicleHistory.setBuildingId(building.getId());
        vehicleRepository.save(vehicle);
        vehicleHistoryRepository.save(vehicleHistory);
    }

    @Transactional
    public void update(Long id, VehicleDTO vehicleDTO, VehicleHistoryDTO vehicleHistoryDTO){
        Vehicle vehicle = vehicleMapper.toEntity(vehicleDTO);
        VehicleHistory vehicleHistory = vehicleHistoryMapper.toEntity(vehicleHistoryDTO);
        vehicle.setId(id);
        vehicleHistory.setId(id);
        vehicle.setStatus(vehicle.getStatus());
        vehicleHistory.setStatus(vehicleHistory.getStatus());
        vehicleRepository.save(vehicle);
        vehicleHistoryRepository.save(vehicleHistory);
    }

    @Transactional
    public void changeStatus(Long id){
        Optional<Vehicle> optionalVehicle = vehicleRepository.findById(id);
        Optional<VehicleHistory> optionalVehicleHistory = vehicleHistoryRepository.findById(id);
        Vehicle vehicle = optionalVehicle.get();
        VehicleHistory vehicleHistory = optionalVehicleHistory.get();
        vehicle.setStatus(!vehicle.getStatus());
        vehicleHistory.setStatus(!vehicleHistory.getStatus());
        vehicleRepository.save(vehicle);
        vehicleHistoryRepository.save(vehicleHistory);
    }

}
