package vn.com.devmaster.services.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import vn.com.devmaster.services.domain.Building;
import vn.com.devmaster.services.domain.User;
import vn.com.devmaster.services.domain.Vehicle;
import vn.com.devmaster.services.repository.BuildingRepository;
import vn.com.devmaster.services.repository.UserRepository;
import vn.com.devmaster.services.repository.VehicleRepository;
import vn.com.devmaster.services.service.dto.VehicleDTO;
import vn.com.devmaster.services.service.mapper.VehicleMapper;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class VehicleService {
    private final UserRepository userRepository;
    private final VehicleRepository vehicleRepository;
    private final VehicleMapper vehicleMapper;

    private final BuildingRepository buildingRepository;

    @Transactional
    public void create(VehicleDTO vehicleDTO){
        Vehicle vehicle = vehicleMapper.toEntity(vehicleDTO);
        Building building = buildingRepository.findById(vehicleDTO.getBuildingId()).orElse(null);
        if (building == null) throw new RuntimeException("Không tìm thấy building");
        vehicle.setBuildingId(building);
        vehicleRepository.save(vehicle);
    }

    @Transactional
    public void update(Long id, VehicleDTO vehicleDTO){
        Vehicle vehicle = vehicleMapper.toEntity(vehicleDTO);
        vehicle.setId(id);
        vehicle.setStatus(vehicle.getStatus());
        vehicleRepository.save(vehicle);
    }

    @Transactional
    public void changeStatus(Long id){
        Optional<Vehicle> optionalVehicle = vehicleRepository.findById(id);
        Vehicle vehicle = optionalVehicle.get();
        vehicle.setStatus(!vehicle.getStatus());
        vehicleRepository.save(vehicle);
    }

}
