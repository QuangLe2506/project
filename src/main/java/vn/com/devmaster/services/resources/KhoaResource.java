package vn.com.devmaster.services.resources;

import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import vn.com.devmaster.services.service.KhoaService;
import vn.com.devmaster.services.service.dto.KhoaDTO;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/khoas")
@RequiredArgsConstructor
public class KhoaResource {
    private final KhoaService khoaService;

    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping("/create")
    public void createKhoa(@RequestBody KhoaDTO khoaDTO){
        khoaService.create(khoaDTO);
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping("/update")
    public void updateKhoa(@RequestParam("id") Long id, @RequestBody KhoaDTO khoaDTO){
        khoaService.update(id, khoaDTO);
    }
}
