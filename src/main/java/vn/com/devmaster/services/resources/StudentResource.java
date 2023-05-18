package vn.com.devmaster.services.resources;

import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import vn.com.devmaster.services.service.StudentService;
import vn.com.devmaster.services.service.dto.StudentDTO;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/sinhvien")
@RequiredArgsConstructor
public class StudentResource {
    private final StudentService studentService;

    @PreAuthorize("hasAuthority('ADMIN' or 'PROTECTOR' or 'STUDENT')")
    @PostMapping("/create")
    public void createStudent(@RequestBody StudentDTO studentDTO){
        studentService.create(studentDTO);
    }

    @PreAuthorize("hasAuthority('ADMIN' or 'PROTECTOR' or 'STUDENT')")
    @PostMapping("/update")
    public void updateStudent(@RequestParam("id") Long id, @RequestBody StudentDTO studentDTO){
        studentService.update(id, studentDTO);
    }
}
