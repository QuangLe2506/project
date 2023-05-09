package vn.com.devmaster.services.resources;

import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import vn.com.devmaster.services.service.VehicleService;
import vn.com.devmaster.services.service.dto.VehicleDTO;

@RestController
@RequestMapping("/api/vehicle")
@RequiredArgsConstructor
public class VehicleResource {
    private final VehicleService vehicleService;

    @PreAuthorize("hasAuthority('ADMIN' or 'PROTECTOR')")
    @PostMapping("/create")
    public void createVehicle(@RequestBody VehicleDTO vehicleDTO){
        vehicleService.create(vehicleDTO);
    }

    @PreAuthorize("hasAuthority('ADMIN' or 'PROTECTOR')")
    @PostMapping("/update")
    public void update(@RequestParam("id") Long id, @RequestBody VehicleDTO vehicleDTO){
        vehicleService.update(id, vehicleDTO);
    }

    @PreAuthorize("hasAuthority('ADMIN' or 'PROTECTOR')")
    @PostMapping("/changeStatus")
    public void changeStatus(@RequestParam("id") Long id){
        vehicleService.changeStatus(id);
    }
}
